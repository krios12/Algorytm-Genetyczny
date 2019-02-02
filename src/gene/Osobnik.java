
package gene;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dawid
 */
public class Osobnik implements Comparator<Osobnik>{
   public List<String> napis;
   public List<Integer> liczby;
   public List<String> Cel;
   public char tmp;
   public String tmp2;
   public String tmpCel; 
   public int wspolczynnik;
  
  
   public Osobnik() // BEZPARAMETROWY
   {
       
   }
   
   public Osobnik(String Cel) // DO TWORZENIA PIERWSZYCH OBIEKTOW
   {
       this.wspolczynnik=0;
       this.tmpCel = Cel;
       this.napis = new  ArrayList<>();
       this.liczby = new ArrayList<>();
       this.Cel = new ArrayList<>();
       for(int i=97; i<=122;i++)
       {
           liczby.add(i);
       }
       for(int i = 0; i<Cel.length();i++)
       {    
           tmp= Cel.charAt(i);
           tmp2=String.valueOf(tmp);
           this.Cel.add(tmp2);     
       }
       genNap();
       ustalWspolczynnik();  
    } 
   
   public Osobnik(Osobnik os1, Osobnik os2) // DO TWORZENIA NASTĘPNYCH POKOLEŃ
   {
        this.wspolczynnik=0;
        Cel = new  ArrayList<>();
        napis = new  ArrayList<>();
        liczby = new ArrayList<>();
        this.Cel=os1.Cel;
        for(int i=97; i<=122;i++)
        {
           liczby.add(i);
        }
        for(int i=26; i<os1.liczby.size();i++)
        {
           liczby.add(os1.liczby.get(i));
        }
        for(int i=26; i<os2.liczby.size();i++)
        {
           liczby.add(os2.liczby.get(i));
        }
        if(liczby.size()>=100)
        {
            for(int i=50;i<77;i++)
            {
                liczby.remove(i);
            }    
        } 
        genNap();
        ustalWspolczynnik();  
   }
   
   private void genNap()  // GENEROWANIE NAPISU 
   {
       for(int i=0; i<Cel.size();i++)
       {
           napis.add(genLit());
       }       
   }
  
   private String genLit() // GENEROWANIE LITERY
   {
       Random rn = new Random();
       int range = liczby.size();
       int randomNum =  rn.nextInt(range); 
       int randomId = liczby.get(randomNum);
       return Character.toString ((char) randomId);
   }
    

   private void ustalWspolczynnik()  //SPRAWDZANIE ZGODNOSCI NAPISU
   {
       for(int i=0;i<napis.size();i++)
       {
           if(napis.get(i).equals(Cel.get(i)))
           {
               this.wspolczynnik++;
           }           
       }
   }
   
   public String getNapis() //GETTER
   {
       String s="";
       for(int i=0;i<napis.size();i++)
       {
           s+=napis.get(i);
       }
       return s;
   }
   
   @Override
   public int compare(Osobnik obj1, Osobnik obj2)  // COMPARATOR PO WSPÓŁCZYNNIKACH 
   {
        return obj2.wspolczynnik- obj1.wspolczynnik; 
   }


}

