


import java.util.*;
/**
 * Write a description of class ArtikelTesten here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArtikelDialog
{
    // instance variables - replace the example below with your own
    private static final int ANLEGEN = 1;
    private static final int ZUBUCHEN = 2;
    private static final int ABBUCHEN = 3;
    private static final int SET_BESTAND = 4;
    private static final int SET_ART =5;
    private static final int SET_PREIS =6;
    private static final int ENDE = 0;
    private Artikel artikel1;
    private Scanner input = new Scanner(System.in);
     
    /**
     * Constructor for objects of class ArtikelTesten
     */
    private int einlesenFunktion(){
          System.out.print(ANLEGEN +" anlegen;\n"+
                          ZUBUCHEN +" zubuchen;\n"+
                          ABBUCHEN +" abbuchen;\n"+
                          SET_BESTAND +" set-bestand;\n"+
                          SET_ART +" set-art;\n"+
                          SET_PREIS +" set-preis;\n"+
                          ENDE +" beenden ->\n");
           return input.nextInt();
    }
    
    private Artikel ArtikelAnlegenEinlesen(){
           int artikelNr;
           String art;
           int bestand;
           int menge;
           double preis;
           System.out.print("Artikelnummer [muss genau eine vierstellige zahl] :");
           artikelNr = input.nextInt();
           System.out.print("Art: ");
           art = input.next();
           System.out.print("Bestand [muss groeßer gleich null sein]: ");
           bestand = input.nextInt();
           System.out.print("Preis [muss groeßer als null sein]: ");
           preis = input.nextDouble();
           artikel1 = new Artikel (artikelNr,art,bestand,preis);
           return artikel1;
    }
    
    private int ZubuchenEinlesen(){
           int zumenge;
           System.out.print("Menge: [muss groeßer gleich null sein]:");
           zumenge = input.nextInt();
      
           return zumenge;
    }
    
    private int AbbuchenEinlesen(){
           int abmenge;
           System.out.print("Menge: [muss groeßer gleich null sein]:");
           abmenge = input.nextInt();
           return abmenge;
    }
    
    private String SetArtEinlesen(){
           String art;
           System.out.print("Art: ");
           art = input.nextLine();
           return art;
    }
    
    private int SetBestandEinlesen(){
           int bestand;
           System.out.print("Bestand: ");
           bestand = input.nextInt();        
           return bestand;
    }
    
    private double SetPreisEinlesen(){
           double preis;
           System.out.print("preis: ");
           preis = input.nextInt();        
           return preis;
    }
    
    private void ausfuehrenFunktion(int funktion){
       
        if(funktion == ANLEGEN){
           artikel1 = ArtikelAnlegenEinlesen();
        }else if(funktion == ZUBUCHEN){
           artikel1.bucheZugang(ZubuchenEinlesen());
        }else if(funktion == ABBUCHEN){
           artikel1.bucheAbgang(AbbuchenEinlesen());
        }else if(funktion == SET_BESTAND){
           artikel1.setBestand(SetBestandEinlesen());
        }else if(funktion == SET_ART){
          artikel1.setArt(SetArtEinlesen());
        }else if(funktion == SET_PREIS){
          artikel1.setPreis(SetPreisEinlesen());
        }else if(funktion == ENDE){
            System.out.println("Programmende");
        }else{
            System.out.println("Falsche Funktion");
      }
           System.out.println(artikel1);

    }
    
    public void start(){
         artikel1 = null;
         int funktion = -1;
    
      while(funktion != ENDE){
        try{
            funktion = einlesenFunktion();
            ausfuehrenFunktion(funktion);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }catch(InputMismatchException e){
            System.out.println(e);
            input.nextLine();
        }catch(Exception e){
            System.out.println("Ausnahme gefangen: "+e);
            e.printStackTrace(System.out);
        }
      }
    }
   
    public static void main (String[] args){
    new ArtikelDialog().start();
    }
}
