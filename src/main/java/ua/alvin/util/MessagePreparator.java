package ua.alvin.util;

import ua.alvin.entity.*;

import java.util.HashMap;
import java.util.Map;

public class MessagePreparator {

    private static Map<String, String> detailsMessages = new HashMap<>();

    private static Map<String, String> addIndicationMessages = new HashMap<>();

    private TariffsTable tariffsTable;
    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private ResultBillTable resultBillTable;

    public static Map<String, String> detailsMessages(ResultBillTable resultBillTable,
                                                      ResultBillTable previousResultBillTable,
                                                      TariffsTable tariffsTableByID) {

        String usagePeriodMessage;
        String delimiterValue;

        if (previousResultBillTable != null) {
            usagePeriodMessage = "From " + previousResultBillTable.getFormattedFillingDate() + " to " + resultBillTable.getFormattedFillingDate();
        } else usagePeriodMessage = "Total";

        delimiterValue = String.valueOf(tariffsTableByID.getElectricityTariffDelimiter());

        System.out.println(delimiterValue);

        detailsMessages.put("usagePeriodMessage", usagePeriodMessage);
        detailsMessages.put("delimiterValue", delimiterValue);

        return detailsMessages;
    }

 /*   public static Map<String, String> addIndicationMessages(TariffsTable previousMonthTariff) {

        String delimiterValue;

        if (previousMonthTariff != null) {
            delimiterValue = String.valueOf(previousMonthTariff.getElectricityTariffDelimiter()) + " kWh";
        } else {
            delimiterValue = "Tariff Delimiter";
        }

        addIndicationMessages.put("delimiterValue", delimiterValue);

        return addIndicationMessages;

    }*/
}
