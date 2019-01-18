import com.fasterxml.jackson.databind.ObjectMapper;
import logics.Logic;
import models.PurchaseRecord;
import util.LogicFactory;
import util.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class Process {
    public static void main(String [ ] args) throws IOException {

        int numOfFrauds = 0;
        int total = 0;

        final ZipFile file = new ZipFile( "./src/main/resources/sample.zip" );
        try
        {
            final Enumeration<? extends ZipEntry> entries = file.entries();
            while ( entries.hasMoreElements() )
            {
                total ++;
                final ZipEntry z_entry = entries.nextElement();

                boolean isFraud = false;

                ObjectMapper mapper = new ObjectMapper();
                PurchaseRecord pr = mapper.readValue(file.getInputStream(z_entry),PurchaseRecord.class);

                ArrayList<Boolean> operands = new ArrayList<>();
                String logicType;
                String [] m_val;
                String toCheck;
                String value;
                boolean operand;

                for (Map.Entry<String, String> entry : Util.Analyst_Strategy.entrySet()) {
                    logicType = entry.getKey();
                    if(!logicType.equals("@")){ //ignore operator

                        m_val = entry.getValue().split("-");
                        toCheck = m_val[0];
                        value = m_val[1];

                        Logic logic = LogicFactory.getLogic(logicType);
                        operand = logic.isPattern(pr,toCheck,value);
                        operands.add(operand);
                    }
                }

                String operator = Util.Analyst_Strategy.get("@");

                if(operands.size() == 1){
                    isFraud = operands.get(0);
                }

                if(operands.size() == 2){ //perform operator
                    if(operator.equals("or")){
                        isFraud = (operands.get(0)) || (operands.get(1));
                    }
                    else if(operator.equals("and")){
                        isFraud = (operands.get(0)) && (operands.get(1));
                    }
                }

                if(isFraud){
                    numOfFrauds ++;
                }

            }
        }
        finally
        {
            file.close();
        }


        System.out.println("Total files: " + total);
        System.out.println("There are " + numOfFrauds + " frauds!");


    }

    private static int readInputStream( final InputStream is ) throws IOException {
        final byte[] buf = new byte[ 8192 ];
        int read = 0;
        int cntRead;
        while ( ( cntRead = is.read( buf, 0, buf.length ) ) >=0  )
        {
            read += cntRead;
        }
        return read;
    }
}
