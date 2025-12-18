package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringJoiner;

public class StartFA
{
   final static int NUMBER_OF_STEPS = 250000;

   public static void main(String[] args)
   {
      SFA sfa = new SFA();

      ArrayList<String> amountLsinSZ = new ArrayList<>();
      for (int i = 0; i < NUMBER_OF_STEPS; i++)
      {
         sfa.step();
         amountLsinSZ.add(sfa.getWalksetBn().getN() + "_" + sfa.getWalksetCPn()
               .getAmountofLinSZ(sfa.getWalksetBn().getN()));
         if(i%100==0)
         {
            System.out.println(i);
         }
      }

      File file = new File("stabilityzone_L_250000.csv");

      try (FileOutputStream stream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(stream,
                  StandardCharsets.UTF_8);)
      {
         StringJoiner joiner = new StringJoiner("\n");

         for (String entry : amountLsinSZ)
         {
            String[] both = entry.split("_");
            joiner.add(both[0] + "\t" + both[1]);
         }

         writer.write(joiner.toString());
         writer.flush();
         writer.close();
      }
      catch (UnsupportedEncodingException e)
      {
         e.printStackTrace();
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
