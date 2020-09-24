package ua.alvin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.service.TableService;

import java.util.HashMap;
import java.util.Map;

public class MessagePreparator {



    private Map<String, String> informationMessages = new HashMap<>();
    private Map<String, String> alertMessages = new HashMap<>();
    private Map<String, String> questionMessages = new HashMap<>();
    private Map<String, String> formFillMessages = new HashMap<>();


    private TariffsTable tariffsTable;
    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private ResultBillTable resultBillTable;



    public static String usagePeriod(ResultBillTable resultBillTable, ResultBillTable previousResultBillTable){

        String usagePeriodMessage;

        if (previousResultBillTable != null){
            usagePeriodMessage = "From " + previousResultBillTable.getFormattedFillingDate() + " to " + resultBillTable.getFormattedFillingDate();
        }else usagePeriodMessage = "Total";

        return usagePeriodMessage;
    }


    public Map<String, String> getFormFillMessages() {
        return formFillMessages;
    }

    public void setFormFillMessages(Map<String, String> formFillMessages) {
        this.formFillMessages = formFillMessages;
    }
}
