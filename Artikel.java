/**
 *
** Eine Klasse zur Verwaltung eines Artikels
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (17.11.2020)
 */
public class Artikel 
{
    
    public static final int MIN_BESTAND = 0 ;
    public static final int MIN_ARTIKELNR=1000 ;
    public static final int MAX_ARTIKELNR = 10000;
    
    // instance variables  attribute - replace the example below with your own
    private int artikelNr;
    private String art ;
    private int bestand;
    private double preis;
    /**
     * Konstruktoren: um Objekte anlegen zu können.
     * 
     * @param  artikelNr  --> eine 4-stellige positive Zahl ist
     * @param  art        --> String, der dei Art der Artikeln beschreibt darf nicht leer sein 
     * @param  bestand    --> muss >=  0 sein
     */
   public Artikel (int artikelNr , String art, int bestand ){
      if ( art == null || art.trim().isEmpty() ){
          throw new IllegalArgumentException("Art darf nicht leer sein");
      }
      if  (artikelNr < MIN_ARTIKELNR || artikelNr >= MAX_ARTIKELNR){
      //if  (artikelNr < 1000 || artikelNr >= 10000){
        throw new IllegalArgumentException("ArtikelNr muss 4-stellig positiv sein");
      }  
      if  (bestand < MIN_BESTAND){
        throw new IllegalArgumentException("Bestand muss >= 0 sein");
      }
      this.artikelNr = artikelNr; 
      this.art =art;
      this.bestand = bestand;
   }
   
   public Artikel (int artikelNr , String art, int bestand , double preis){
      if ( art == null || art.trim().isEmpty() ){
          throw new IllegalArgumentException("Art darf nicht leer sein");
      }
      if  (artikelNr < MIN_ARTIKELNR || artikelNr >= MAX_ARTIKELNR){
      //if  (artikelNr < 1000 || artikelNr >= 10000){
        throw new IllegalArgumentException("ArtikelNr muss 4-stellig positiv sein");
      }  
      if  (bestand < MIN_BESTAND){
        throw new IllegalArgumentException("Bestand muss >= 0 sein");
      }
      if (preis <= 0){
          throw new IllegalArgumentException("Preis muss grosser als 0 sein");
      }
      this.artikelNr = artikelNr; 
      this.art =art;
      this.bestand = bestand;
      this.preis= preis;
   }
   
   
   /**
     * Konstruktoren: um Objekte anlegen zu können.
     * 
     * @param  artikelNr  --> eine 4-stellige positive Zahl ist
     * @param  art        --> String, der dei Art der Artikeln beschreibt darf nicht leer sein 
     */
    public Artikel (int artikelNr , String art ){
       this( artikelNr, art, MIN_BESTAND );
    }
    
    public Artikel (int artikelNr , String art ,double preis){
       this( artikelNr, art, MIN_BESTAND , preis);
    }

    /** Warum macht ein Standardkonstruktor keinen Sinn? 
    ** Ein Standardkonstruktor macht keinen Sinn , weil es nicht initialisiert ist   
    */    

     /***
     * 
     * @param diese Funktion erhöht den Bestand um eine bestimmte Menge
     */
   
     public void bucheZugang (int zugang){
         if(zugang < MIN_BESTAND) throw new IllegalArgumentException("zugang muss >= 0 sein ");
            bestand += zugang; 
    }
   
    /***
     * @param diese Funktion vermindert den Bestand um eine bestimmte Menge
     */
    public void bucheAbgang (int menge) {
        if ( menge < MIN_BESTAND ){
            throw new IllegalArgumentException("Menge muss < 0 sein");
        }  
        if ( menge > bestand){
            throw new IllegalArgumentException("Bestand ist kleiner wie die abzubuchende Menge");
        }  
        bestand -= menge;
    }
   
    /**
     * eine Methode, um ein Artikel-Objekt als Zeichenkette aufzubereiten 
     */
    public String toString(){
            return  "ArtikelNr: " + artikelNr +
                    " Bezeichnung: "+ art +
                    " Bestand: "+bestand +
                    " Preis: "+preis;
                }

    /**
    *  Methode gibt die Artikelnummer zurück
    * 
    */ 
    public int getArtikelNr(){
        return artikelNr;
    }

    /**
     * Diese Methode gibt die Artikelart zurück 
     */
    public String getArt (){
        return art;
    }

     /**
     * Diese Methode gibt den aktuellen Bestand zurück
     */
    public int getBestand (){
         return bestand;
        }
  
     /**
     * Art ändern 
     * Prüfen ob Art nicht null und nicht leer ist 
     */
    public void setArt (String neuArt){
    if (neuArt == null || neuArt.isEmpty() ){
        throw new IllegalArgumentException("Art darf nicht leer sein");

    }else{
             art = neuArt;
        }
    }

     /**
     * prüfen ob Bestand kleiner als 0 ist
     */
    public void setBestand (int neuBestand){
    if(neuBestand < MIN_BESTAND) throw new IllegalArgumentException("Bestand muss >= 0 sein ");

        bestand = neuBestand;
    
    }

    public void aenderePreis(double prozent){
    
    }
    
    public void aenderePreis(int preis){
    
    }
    
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if (preis <= 0){
            throw new IllegalArgumentException("Preis muss grosser als 0 sein");
        }
        this.preis = preis;
    }
}
