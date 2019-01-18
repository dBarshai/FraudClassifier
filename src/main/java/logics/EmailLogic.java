package logics;

import models.PurchaseRecord;
import util.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailLogic implements Logic {

    public boolean isPattern(PurchaseRecord purchaseRecord,String toCheck,String value) {

        boolean ans = false;
        String email = purchaseRecord.getEmail().toLowerCase();

        if(toCheck.equals("domain")){
            value = Util.domainToSuffix.get(value);
            Pattern p = Pattern.compile(value +  "$");
            Matcher m = p.matcher(email);
            ans = m.find();
        }

        return ans;
    }
}
