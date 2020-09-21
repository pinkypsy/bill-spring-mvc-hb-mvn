package ua.alvin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.util.BillsHub;
import ua.alvin.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillsController {

    private final TableService resultBillTableService;
    private final TableService countedBillTableService;
    private final TableService tariffsTableService;
    private final TableService fixedBillTableService;

    final BillsHub billsHub;
    private String message = " ";


    @Autowired
    public BillsController(@Qualifier(value = "countedBillTableService") TableService countedBillTableService,
                           @Qualifier(value = "resultBillTableService") TableService resultBillTableService,
                           @Qualifier(value = "fixedBillTableService") TableService fixedBillTableService,
                           @Qualifier(value = "tariffsTableService") TableService tariffsTableService,
                           @Qualifier(value = "billsHub") BillsHub billsHub) {
        // this.countedBillTableService = countedBillTableService;
        this.resultBillTableService = resultBillTableService;
        this.countedBillTableService = countedBillTableService;
        this.tariffsTableService = tariffsTableService;
        this.fixedBillTableService = fixedBillTableService;
        this.billsHub = billsHub;
    }

    @RequestMapping("/showResultTable")
    public String showResultTable(Model model) {

        List<?> resultBillTableList = resultBillTableService.getAllRowsFromTable();
        List<?> countedBillTableList = countedBillTableService.getAllRowsFromTable();
//        List<?> resultBillTableList = countedBillTableService.getAllRowsFromTable();
        System.out.println("countedBillTableList in showResultTable " + countedBillTableList);
        System.out.println("resultBillTableList in showResultTable " + resultBillTableList);

        model.addAttribute("resultBillTableList", resultBillTableList);

        return "show-result-table";
    }


    @RequestMapping("/addIndicationsForm")
    public String addIndications(Model model) {

        System.out.println(billsHub.getColdWaterTariff());
//        model.addAttribute("monsterBill", new MonsterBill());
        model.addAttribute("billsHub", billsHub);



      /*  model.addAttribute("tariffsTable", new TariffsTable());
        model.addAttribute("countedBillTable", new CountedBillTable());
        model.addAttribute("fixedBillTable", new FixedBillTable());*/
//        model.addAttribute("message", message);

        message = " ";

        return "save-bill-form";
    }


    @RequestMapping("/saveBill")
    public String saveBill(
            @ModelAttribute("monsterBill") BillsHub billsHub) {

        try {
            System.out.println("resultBillTableService in saveBill Controller" + resultBillTableService);

            resultBillTableService.save(
                    billsHub.initializeAndReturnResultBillTable(
                    Arrays.asList(
                            countedBillTableService,fixedBillTableService,
                            tariffsTableService, resultBillTableService)
                    )
            );


        } catch (Exception e) {
            e.printStackTrace();
        }

        message = "Indications has been successfully saved!";

        return "redirect:/bill/showResultTable";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("billId") int billId, Model model) {

        CountedBillTable countedBillTable =
                (CountedBillTable) countedBillTableService.getBillByID(billId);

        FixedBillTable fixedBillTable = (FixedBillTable) fixedBillTableService.getBillByID(billId);

        TariffsTable tariffsTable = (TariffsTable) tariffsTableService.getBillByID(billId);

        ResultBillTable resultBillTable = (ResultBillTable) resultBillTableService.getBillByID(billId);

        System.out.println("countedBillTable " + countedBillTable);
        System.out.println("fixedBillTable " + fixedBillTable);
        System.out.println("tariffsTable " + tariffsTable);
        System.out.println("resultBillTable " + resultBillTable);

        model.addAttribute("countedBillTable", countedBillTable);
        model.addAttribute("fixedBillTable", fixedBillTable);
        model.addAttribute("tariffsTable", tariffsTable);
        model.addAttribute("resultBillTable", resultBillTable);

        return "show-bill-form";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("billId") int billId, Model model) {
//        FIX-ME
        return "save-bill-form";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("billId") int billId) {
        //        FIX-ME
        return "redirect:/bill/addIndicationsForm";
    }


}
