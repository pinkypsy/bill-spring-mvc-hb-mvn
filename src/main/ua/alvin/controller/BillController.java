package main.ua.alvin.controller;

import main.ua.alvin.entity.*;
import main.ua.alvin.service.CountedBillTableService;
import main.ua.alvin.service.TableService;
import main.ua.alvin.service.TariffsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Qualifier(value = "resultBillTableService")
    @Autowired
    TableService tableService;

    private String message = " ";


    @GetMapping("/checkPage")
    public String checkPage() {
//        System.out.println(tableService);
//        tableService = context.getBean("tariffsTableService", TariffsTableService.class);

//        context.close();
        return "check";
    }

    @RequestMapping("/addIndicationsForm")
//    public String addIndications(Model model) {
    public String addIndications(Model model) {

        model.addAttribute("tariffsTable", new TariffsTable());
        model.addAttribute("countedBillTable", new CountedBillTable());
        model.addAttribute("fixedBillTable", new FixedBillTable());
        model.addAttribute("message", message);

        message = " ";
        
        return "bill-form";
    }

    @RequestMapping("/saveTariffs")
    public String saveTariffs(
            @ModelAttribute("tariffsTable") TariffsTable tariffsTable,
            @ModelAttribute("countedBillTable") CountedBillTable countedBillTable,
            @ModelAttribute("fixedBillTable") FixedBillTable fixedBillTable/*,
            @RequestParam("bill_Id") int id*/) {

        ResultBillTable resultBillTable = new ResultBillTable();

        tableService.save(countedBillTable);

        System.out.println("getGarbageRemovalPrice " + fixedBillTable.getGarbageRemovalPrice());

//        resultBillTable.setCountedBillTable(countedBillTable);
        resultBillTable.setFixedBillTable(fixedBillTable);
        resultBillTable.setTariffsTable(tariffsTable);

        resultBillTable.computeResult(resultBillTable, countedBillTable, tableService/*,id*/);


      /*  tableService =  new TariffsTableService();

        tableService.save(tariffsTable);

        tableService = new CountedBillTableService();

        tableService.save(countedBillTable);*/


        message = "Indications is successfully saved!";


        return "redirect:/bill/addIndicationsForm";
    }


//    @RequestMapping("/saveIndicationsCounted")



//
//    @RequestMapping("/saveFixedValues")

}
