package ua.alvin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import ua.alvin.entity.*;
import ua.alvin.util.BillsHub;
import ua.alvin.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.alvin.util.ResultBillCalculator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillsController {

    private final TableService resultBillTableService;
    private final TableService countedBillTableService;
    private final TableService tariffsTableService;
    private final TableService fixedBillTableService;

    private TariffsTable tariffsTable;
    private TariffsTable countedBillTable;

    private final ResultBillCalculator resultBillCalculator;

    @Autowired
    public BillsController(@Qualifier(value = "countedBillTableService") TableService countedBillTableService,
                           @Qualifier(value = "resultBillTableService") TableService resultBillTableService,
                           @Qualifier(value = "fixedBillTableService") TableService fixedBillTableService,
                           @Qualifier(value = "tariffsTableService") TableService tariffsTableService,
                           @Qualifier(value = "resultBillCalculator") ResultBillCalculator resultBillCalculator) {
        // this.countedBillTableService = countedBillTableService;
        this.resultBillTableService = resultBillTableService;
        this.countedBillTableService = countedBillTableService;
        this.tariffsTableService = tariffsTableService;
        this.fixedBillTableService = fixedBillTableService;
        this.resultBillCalculator = resultBillCalculator;

        System.out.println("CONSTRUCTOR: resultBillTableService " + resultBillTableService);
//        System.out.println("CONSTRUCTOR: getResultBillTableService " + getResultBillTableService);

    }

    @PostConstruct
    public void initTables() {

        TariffsTable previousMonthTariff = (TariffsTable) tariffsTableService.getBillByID(tariffsTableService.getLastInsertedID());

        tariffsTable = new TariffsTable();
        tariffsTable.setColdWaterTariff(previousMonthTariff.getColdWaterTariff());
        tariffsTable.setElectricityTariffDelimiter(previousMonthTariff.getElectricityTariffDelimiter());
        tariffsTable.setElectricityBeforeDelimiterTariff(previousMonthTariff.getElectricityBeforeDelimiterTariff());
        tariffsTable.setElectricityAfterDelimiterTariff(previousMonthTariff.getElectricityAfterDelimiterTariff());
        System.out.println("BEAN CONSTRUCTED");

    }

    @PreDestroy
    public void closeSession() {
        System.out.println("BEAN DESTROYED");
    }

    @RequestMapping("/showResultTable")
    public String showResultTable(Model model) {

        List<? extends BillTable> resultBillTableList = resultBillTableService.getAllRowsFromTable();
        System.out.println("resultBillTableList in showResultTable " + resultBillTableList);

        model.addAttribute("resultBillTableList", resultBillTableList);

        return "show-result-table";
    }


    @RequestMapping("/addIndicationsForm")
    public String addIndications(Model model) {

        ResultBillTable resultBillTable = new ResultBillTable();

//        resultBillTable.setTariffsTable(new TariffsTable());
        resultBillTable.setTariffsTable(tariffsTable);
        resultBillTable.setFixedBillTable(new FixedBillTable());
        resultBillTable.setCountedBillTable(new CountedBillTable());


        model.addAttribute("resultBillTable", resultBillTable);


        return "fill-bill-form";
    }

    //@Autowired
    @RequestMapping("/saveBill")
    public String saveBill(
            @ModelAttribute("resultBillTable") ResultBillTable resultBillTable) {

        System.out.println("resultBillTable ELECTRICITY " + resultBillTable.getCountedBillTable().getElectricity());
        System.out.println("resultBillTable COUNTED TABLE " + resultBillTable.getCountedBillTable());

        resultBillTable = resultBillCalculator.calculateAndUpdateResultBillTable(resultBillTable);

        resultBillTableService.save(resultBillTable);

        return "redirect:/bill/showResultTable";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("billId") int billId, Model model) {

//        CountedBillTable countedBillTable = (CountedBillTable) countedBillTableService.getBillByID(billId);
//
//        FixedBillTable fixedBillTable = (FixedBillTable) fixedBillTableService.getBillByID(billId);
//
//        TariffsTable tariffsTable = (TariffsTable) tariffsTableService.getBillByID(billId);

        ResultBillTable resultBillTable = (ResultBillTable) resultBillTableService.getBillByID(billId);

        ResultBillTable previousResultBillTable = (ResultBillTable) resultBillTableService.getBillByID(billId - 1);

        String usagePeriodMessage;

        if (previousResultBillTable != null){
            usagePeriodMessage = "From " + previousResultBillTable.getFormattedFillingDate() + " to " + resultBillTable.getFormattedFillingDate();
        }else usagePeriodMessage = "Total";

//        System.out.println("countedBillTable " + countedBillTable);
//        System.out.println("fixedBillTable " + fixedBillTable);
//        System.out.println("tariffsTable " + tariffsTable);
//        System.out.println("resultBillTable " + resultBillTable);

//        model.addAttribute("countedBillTable", countedBillTable);
//        model.addAttribute("fixedBillTable", fixedBillTable);
//        model.addAttribute("tariffsTable", tariffsTable);
        model.addAttribute("resultBillTable", resultBillTable);
        model.addAttribute("previousResultBillTable", previousResultBillTable);
        model.addAttribute("usagePeriodMessage", usagePeriodMessage);

        return "show-bill";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("billId") int billId, Model model) {
//        FIX-ME
        return "fill-bill-form";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("billId") int billId) {
        //        FIX-ME
        return "redirect:/bill/addIndicationsForm";
    }


}
//    @RequestMapping("/test")
//    public String test(Model model) {
//
//        ResultBillTable resultBillTable = new ResultBillTable();
//
//        resultBillTable.setTariffsTable(new TariffsTable());
//        resultBillTable.setFixedBillTable(new FixedBillTable());
//        resultBillTable.setCountedBillTable(new CountedBillTable());
//
////        resultBillTable.getCountedBillTable().setElectricity(999);
//
//        model.addAttribute("resultBillTable", resultBillTable);
//
//        return "test";
//    }