package main.ua.alvin.controller;

import main.ua.alvin.entity.*;
import main.ua.alvin.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Qualifier(value = "resultBillTableService")
    @Autowired
    TableService tableService;

    private String message = " ";


//    @RequestMapping("/addIndicationsForm")
//    public String addIndications(Model model) {
//
//        model.addAttribute("tariffsTable", new TariffsTable());
//        model.addAttribute("countedBillTable", new CountedBillTable());
//        model.addAttribute("fixedBillTable", new FixedBillTable());
//        model.addAttribute("message", message);
//
//        message = " ";
//
//        return "bill-form";
//    }

    @RequestMapping("/addIndicationsForm")
    public String addIndications(Model model) {

        model.addAttribute("monsterBill", new MonsterBill());



      /*  model.addAttribute("tariffsTable", new TariffsTable());
        model.addAttribute("countedBillTable", new CountedBillTable());
        model.addAttribute("fixedBillTable", new FixedBillTable());*/
        model.addAttribute("message", message);

        message = " ";

        return "bill-form";
    }


    @RequestMapping("/saveTariffs")
    public String saveTariffs(
            @ModelAttribute("monsterBill") MonsterBill monsterBill) {


//        monsterBill.computeResultBill();

        try {
            tableService.save(monsterBill.initializeAndReturnResultBillTable());
        } catch (Exception e) {
            e.printStackTrace();
        }


        message = "Indications has been successfully saved!";


        return "redirect:/bill/addIndicationsForm";
    }


}
