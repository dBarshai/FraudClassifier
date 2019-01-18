package logics;

import models.PurchaseRecord;

public interface Logic {
    boolean isPattern(PurchaseRecord purchaseRecord,String toCheck,String value);
}
