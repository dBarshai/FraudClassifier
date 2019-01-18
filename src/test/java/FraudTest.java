import com.fasterxml.jackson.databind.ObjectMapper;
import logics.Logic;
import models.PurchaseRecord;
import org.junit.Assert;
import org.junit.Test;
import util.LogicFactory;

import java.io.File;
import java.io.IOException;

public class FraudTest {


    @Test
    public void gmailTest() throws IOException {
        Logic l = LogicFactory.getLogic("email");
        ObjectMapper mapper = new ObjectMapper();

        PurchaseRecord pr = mapper.readValue(new File("./src/test/java/1.json"),PurchaseRecord.class);
        Assert.assertEquals(false,  l.isPattern(pr,"domain","gmail"));

        pr = mapper.readValue(new File("./src/test/java/2.json"),PurchaseRecord.class);
        Assert.assertEquals(true,  l.isPattern(pr,"domain","gmail"));

    }
}
