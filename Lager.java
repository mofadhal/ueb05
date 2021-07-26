
/**
 *
 ** Eine Klasse zur Verwaltung eines Artikels
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (05.01.2021)
 */
public class  Lager
{
    private Artikel artikelTab [];
    private int anzArtikel;

   public Lager (int maxAnzArtikel) {
        artikelTab = new Artikel[maxAnzArtikel];
        for (int i = 0 ; i < maxAnzArtikel ; i++){
            artikelTab[i] = null;
        }
        anzArtikel = 0;
   }
    public Lager () {
        artikelTab = new Artikel[10];
        for (int i = 0 ; i < 10 ; i++){
            artikelTab[i] = null;
        }
        anzArtikel = 0;
   }

    /**
     * Lager_Objekt als Zeichenkette aufbereiten
     *
     * @return Zeichenkette
     */
   private  int get_index_artikel (int artikelNr){
       for (int i = 0 ; i < anzArtikel ; i++){
           if(artikelTab[i].getArtikelNr() == artikelNr){
               return i;
           }
       }
       return -1;
   }
    /**
     * Methode zum legen neuen Artikel
     *
     *
     *
     */
   public void legeAnArtikel(Artikel artikel){
       if(anzArtikel >= artikelTab.length || artikel == null){
           throw new IllegalAccessError("Der lager ist Voll");
       }
       artikelTab[anzArtikel] = artikel;
       anzArtikel++;
   }
    /**
     * Entferne eines Artikel aus dem Lager
     *
     * @param artikelNr zu uebergebende Artikelnummer
     */
   public void entferneArtikel(int artikelNr){
       int i = get_index_artikel(artikelNr);
    if(i > anzArtikel   || i >= artikelTab.length || i == -1){
        throw new IllegalAccessError("Es ist nicht verfuegbar");
    }
    for ( ; i < anzArtikel ; i++){
        artikelTab[i] = artikelTab[i+1];
    }
    artikelTab[anzArtikel--] = null;
   }

    /**
     * Zugang buchen für einen Artikel
     *
     * @param artikelNr   zu uebergebende Artikelnummer
     * @param menge       zu buchende Menge > 0
     */
   public void bucheZugang(int artikelNr, int menge){
    int artikel_index = get_index_artikel(artikelNr);
    if (artikel_index == -1) {
        throw new IllegalAccessError("Es ist nicht verfuegbar");
    }
    artikelTab[artikel_index].bucheZugang(menge);
   }

    /**
     * Abgang buchen für einen Artikel
     *
     * @param artikelNr   zu uebergebende Artikelnummer
     * @param menge       zu buchende Menge > 0
     */
   public void bucheAbgang(int artikelNr, int menge){
       int artikel_index = get_index_artikel(artikelNr);
       if (artikel_index == -1) {
           throw new IllegalAccessError("Es ist nicht verfuegbar");
       }
       artikelTab[artikel_index].bucheAbgang(menge);
   }

    /**
     * Methode zum Ermitteln eines Artikels an einer bestimmten Stelle im Lager
     *
     *
     * @return  index
     */
   public Artikel getArtikel(int index){
      if (index < 0 || index >= anzArtikel){
          throw new IllegalAccessError("Diese Index ist nicht verfuegbar");
      }
       return artikelTab[index];
   }

    /**
     *Preis für alle Artikel um einen bestimmten Protzentsatz verändern
     *
     * @param prozent
     */
   public void  aenderePreisAllerArtikel(double prozent){

       for (int i=0 ; i <anzArtikel ; i++){
           double prise = artikelTab[i].getPreis();
           double neu_preis = prise + prise * prozent ;
           artikelTab[i].setPreis(neu_preis);

       }
   }
   public String toString(){
       StringBuilder temp = new StringBuilder("Grosse der Lager: " + artikelTab.length +
               " Anzahl der Artikel:" + anzArtikel);
       for (int i = 0 ; i < anzArtikel ; i++){
           temp.append("\n").append(i).append(".\t");
           temp.append(artikelTab[i].toString());
       }
       return temp.toString();
   }
    /**
     * Die aktuelle Anzahl der Artikel im Lager
     */
   public int getArtikelAnzahl(){
       return anzArtikel;
   }
    /**
     * Die Anzahl der Artikel, die ins Lager gelegte werden können
     *
     */
   public int getLagerGroesse(){
       return artikelTab.length;
   }
    

}
