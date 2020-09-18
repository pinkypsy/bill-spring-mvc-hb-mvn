package ua.alvin.controller;

import ua.alvin.util.MonsterBill;
import ua.alvin.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillsController {

    final TableService resultBillTableService;

    final TableService countedBillTableService;

    private String message = " ";

    static {
        System.out.println(new MonsterBill().getColdWaterTariff());
    }

    @Autowired
    public BillsController(@Qualifier(value = "countedBillTableService") TableService countedBillTableService,
                           @Qualifier(value = "resultBillTableService") TableService resultBillTableService) {
        this.countedBillTableService = countedBillTableService;
        this.resultBillTableService = resultBillTableService;
    }


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
            System.out.println("resultBillTableService " + resultBillTableService);
            resultBillTableService.save(monsterBill.initializeAndReturnResultBillTable(countedBillTableService));
        } catch (Exception e) {
            e.printStackTrace();
        }


        message = "Indications has been successfully saved!";


        return "redirect:/bill/addIndicationsForm";
    }


}
