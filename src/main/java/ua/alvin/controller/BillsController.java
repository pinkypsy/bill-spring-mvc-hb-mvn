package ua.alvin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.util.BillsHub;
import ua.alvin.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillsController {

    final TableService resultBillTableService;
    final TableService countedBillTableService;

    final BillsHub billsHub;
    private String message = " ";


    @Autowired
    public BillsController(@Qualifier(value = "countedBillTableService") TableService countedBillTableService,
                           @Qualifier(value = "resultBillTableService") TableService resultBillTableService,
                           @Qualifier(value = "billsHub") BillsHub billsHub) {
        // this.countedBillTableService = countedBillTableService;
        this.resultBillTableService = resultBillTableService;
        this.countedBillTableService = countedBillTableService;
        this.billsHub = billsHub;
    }

    @RequestMapping("/showResultTable")
    public String showResultTable(Model model) {

        List<?> resultBillTableList = resultBillTableService.getAllRowsFromTable();

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
            System.out.println("resultBillTableService " + resultBillTableService);
            resultBillTableService.save(billsHub.initializeAndReturnResultBillTable(resultBillTableService));
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = "Indications has been successfully saved!";

        return "redirect:/bill/showResultTable";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("billId") int billId, Model model) {

        CountedBillTable countedBillTable = (CountedBillTable) countedBillTableService.showBillTable(billId);
//        FixedBillTable fixedBillTable = tableService.showFixedBillTable(billId);
//        TariffsTable tariffsBillTable = tableService.showTariffsTable(billId);
        ResultBillTable resultBillTable = (ResultBillTable) resultBillTableService.showBillTable(billId);

        System.out.println(countedBillTable);
        System.out.println(resultBillTable);
//        System.out.println(fixedBillTable);
//        System.out.println(tariffsBillTable);

        model.addAttribute("countedBillTable", countedBillTable);
//        model.addAttribute("fixedBillTable", fixedBillTable);
//        model.addAttribute("tariffsTable", tariffsBillTable);
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
