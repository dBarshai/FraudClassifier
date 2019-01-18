package logics;

import models.PurchaseRecord;

public class TotalPriceLogic implements Logic {

    @Override
    public boolean isPattern(PurchaseRecord purchaseRecord, String toCheck, String value) {

        boolean ans = false;
        long total_price = purchaseRecord.getTotal_price();

        if(toCheck.equals("grater_than")){
            ans = total_price > Integer.parseInt(value);

        }

        return ans;
    }
}
