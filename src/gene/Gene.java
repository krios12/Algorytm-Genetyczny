package gene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dawid
 */
public class Gene {

  
    public static void main(String[] args) {

       List<Osobnik> populacja= new ArrayList<>(); // ZAWIERA 100 OSOBNIKOW
       String cel = "wyraz";
       boolean end = false;
       
       for(int i=0;i<100;i++)
       {
           populacja.add(new Osobnik(cel));     
       }
     
       
      while(end == false)
      {
        Collections.sort(populacja, new Osobnik()); // WYBIERAM 10 NAJBARDZIEJ PODBNYCH DO CELU
       
        for(int i=99;i>=10;i--) // RESZTĘ USUWAM 
        {
            populacja.remove(i);
        }
       
        for(int i=0;i<10;i++) // I ROBIĘ NA ICH PODSTAWIE KOLEJNE POKOLENIE
        {
             for(int j=0;j<10;j++)
             {
                 populacja.add(new Osobnik(populacja.get(i),populacja.get(j)));
             }
         }
       
       for(int i=0;i<10;i++) // USUWAM JESZCZE STARYCH RODZICOW
       {
           populacja.remove(i);
       } 
       System.out.println(populacja.get(0).getNapis());
       for(int i=0;i<100;i++) 
       {
           if(populacja.get(i).getNapis().equals(cel))  
           {
               end = true;
               System.out.println(populacja.get(i).getNapis());
           }
       }
          
          
      }
       

        

       
        
        
        
        
        
        
        
    }      
}
    
