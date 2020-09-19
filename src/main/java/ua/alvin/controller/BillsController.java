package ua.alvin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.util.MonsterBill;
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

    final TableService tableService;
    //    final TableService countedBillTableService;
    final MonsterBill monsterBill;
    private String message = " ";


    @Autowired
    public BillsController(/*@Qualifier(value = "countedBillTableService") TableService countedBillTableService,*/
            @Qualifier(value = "resultBillTableService") TableService tableService,
            @Qualifier(value = "monsterBill") MonsterBill monsterBill) {
        // this.countedBillTableService = countedBillTableService;
        this.tableService = tableService;
        this.monsterBill = monsterBill;
    }

    @RequestMapping("/showResultTable")
    public String showResultTable(Model model) {

        List<ResultBillTable> resultBillTableList = tableService.showResultBillTable();

        model.addAttribute("resultBillTableList", resultBillTableList);

        return "showResultTable";
    }

    @RequestMapping("/addIndicationsForm")
    public String addIndications(Model model) {

        System.out.println(monsterBill.getColdWaterTariff());
//        model.addAttribute("monsterBill", new MonsterBill());
        model.addAttribute("monsterBill", monsterBill);



      /*  model.addAttribute("tariffsTable", new TariffsTable());
        model.addAttribute("countedBillTable", new CountedBillTable());
        model.addAttribute("fixedBillTable", new FixedBillTable());*/
//        model.addAttribute("message", message);

        message = " ";

        return "save-bill-form";
    }


    @RequestMapping("/saveBill")
    public String saveBill(
            @ModelAttribute("monsterBill") MonsterBill monsterBill) {


        try {
            System.out.println("resultBillTableService " + tableService);
            tableService.save(monsterBill.initializeAndReturnResultBillTable(tableService));
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = "Indications has been successfully saved!";

        return "redirect:/bill/showResultTable";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("billid") int billId, Model model){

        List<CountedBillTable> countedBillTableList = tableService.showCountedBillTable();
        List<FixedBillTable> fixedBillTableList = tableService.showFixedBillTable();
        List<TariffsTable> tariffsBillTableList = tableService.showTariffsTable();
        List<ResultBillTable> resultBillTableList = tableService.showResultBillTable();


        model.addAttribute("countedBillTableList", countedBillTableList);
        model.addAttribute("fixedBillTableList", fixedBillTableList);
        model.addAttribute("tariffsTableList", tariffsBillTableList);
        model.addAttribute("resultBillTableList", resultBillTableList);

        return "show-bill-form";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("billid") int billId, Model model) {
//        FIX-ME
        return "save-bill-form";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("billId") int billId) {
        //        FIX-ME
        return "redirect:/bill/addIndicationsForm";
    }


}
