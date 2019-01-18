package util;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static final Map<String, String> domainToSuffix = initDomainToSuffix();
    public static final Map<String, String> Analyst_Strategy = initAnalystStrategy();


    private static Map<String, String> initAnalystStrategy(){
        Map<String, String> Analyst_Strategy = new HashMap<>();
        Analyst_Strategy.put("total_price","grater_than-100");
        Analyst_Strategy.put("email","domain-gmail");
        Analyst_Strategy.put("@","or");   //lets say @ means logic operator

        return Analyst_Strategy;
    }

    private static Map<String, String> initDomainToSuffix(){
        Map<String, String> domainToSuffix = new HashMap<>();
        domainToSuffix.put("gmail","gmail.com");
        domainToSuffix.put("hotmail","hotmail.com");

        return domainToSuffix;
    }
}
