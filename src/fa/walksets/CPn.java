package fa.walksets;

import java.util.Arrays;
import java.util.LinkedList;

import enums.Symbol;

public class CPn implements Walkset
{
   private LinkedList<Symbol> list = new LinkedList<>();
   
   public CPn()
   {
      list.add(Symbol.L);
   }
   
   public void fractalProcedureMove(int n)
   {
      Symbol element = list.pollFirst();
      if(n < 19)
      {
         list.add(element);
      }
   }
   
   public void fractalProcedureCopy(int n)
   {
      LinkedList<Symbol> copiedList = new LinkedList<>();
      
      for(int i = 0; i < n; i++)
      {
         for(Symbol element : list)
         {
            copiedList.add(element);
         }
      }
      
      list = copiedList;
   }
   
   public void fractalProcedureChange(int n)
   {
      LinkedList<Symbol> copy = new LinkedList<>();
      for(Symbol element: list)
      {
         copy.add(element);
      }

      /**
       * This reference implementation of change uses only counting, no division is necessary. 2025-12-07
       */
      for(int i = n-1; i < copy.size(); i += n )
      {
         if(list.get(i).equals(Symbol.L))
         {
            list.set(i, Symbol.M);
         }
      }
   }
   
   public Symbol getLeftmostElement()
   {
      return list.getFirst();
   }

   @Override
   public String toString()
   {
      return "CPn = < " + Arrays.toString(list.toArray()) + " >";
   }
   
   public int getSize()
   {
      return list.size();
   }
   
   public int getAmountofLinSZ(int n)
   {
      int result = 0;
      
      for(int i = 0; i < n-1; i++)
      {
         if(list.get(i).equals(Symbol.L))
         {
            result++;
         }
      }
      
      return result;
   }
}
