package util;

import logics.*;

public class LogicFactory {

    private static Logic emailLogic = new EmailLogic();
    private static Logic totalPriceLogic = new TotalPriceLogic();

    public static Logic getLogic(String logicType){

        switch (logicType){
            case "email":
                return emailLogic;
            case "total_price":
                return totalPriceLogic;
            default:
                break;
        }

        return null;
    }
}
