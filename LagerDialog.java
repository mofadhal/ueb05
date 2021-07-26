import java.util.InputMismatchException;
import java.util.*;

public class LagerDialog {
    private Lager lager1 = null;
    private Scanner input = new Scanner(System.in);

   // private static final int LEGE_AN_ARTIKEL = 1;
    private static final int ENTFERNE_ARTIKEL = 1;
    private static final int BUCHE_ZUGANG = 2;
    private static final int BUCHE_ABGANG = 3;
    private static final int AENDERE_PREIS_ALLER_ARTIKEL = 4;
    private static final int GET_ARTIKEL = 5;
    private static final int GET_ARTIKEL_ANZAHL = 6;
    private static final int GET_LAGER_GROESSE = 7;
    private static final int creat_lager = 8;
    private static final int ENDE = 0;

    private int einlesenFunktion() {
        int funktion;
        System.out.print(//LEGE_AN_ARTIKEL + ": legeAnArtikel; " +
                ENTFERNE_ARTIKEL + ": entferneArtikel; " +
                BUCHE_ZUGANG + ": bucheZugang; " +
                BUCHE_ABGANG + ": bucheAbgang; " +
                AENDERE_PREIS_ALLER_ARTIKEL + ":aenderePreisAllerArtikel; " +"\n"+
                GET_ARTIKEL + ":getArtikel; " +
                GET_ARTIKEL_ANZAHL + ":getArtikelAnzahl; " +
                GET_LAGER_GROESSE + ":getLagerGroesse; " +
                creat_lager + ":Creat neu lager " +
                ENDE + ": beenden -> ");
        funktion = input.nextInt();
        input.nextLine();
        return funktion;

    }

    private int einleseMenge() {
        int menge = 0;
        System.out.print("Menge: ");
        try {
            menge = input.nextInt();
        } catch (Exception e) {
            System.out.println(e.toString());
            input.nextLine();
        }
        return menge;
    }

    private String einleseArt() {
        String art;
        System.out.println("Neuer Art: ");
        art = input.nextLine();
        return art;
    }

    private int einleseBestand() {
        int bestand;
        System.out.println("Neuer Bestand: ");
        bestand = input.nextInt();
        return bestand;
    }

    private double einlesePreis() {
        double preis = 0;
        System.out.println("Neuer Preis: ");
        try {
            preis = input.nextDouble();
        } catch (Exception e) {
            System.out.println(e);
            input.nextLine();
        }
        return preis;

    }

    private void ENTFERNE_ARTIKEL_f(int artieklNr) {
        if (lager1 == null) {
            System.out.println("bitte erst lege einen Lager an");
        }
        try {
            lager1.entferneArtikel(artieklNr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int einlesen_artikel() {
        System.out.println("geben Sie den artikelNr ein :\n");
        int temp = 0;
        try {
            temp = input.nextInt();
        } catch (Exception e) {
            System.out.println(e);
            input.nextLine();
        }
        return temp;
    }

    private int einlesen_index() {
        int temp = 0;
        try {
            temp = input.nextInt();
        } catch (Exception e) {
            System.out.println(e);
            input.nextLine();
        }
        return temp;
    }

    private void ausfuehrenfunktion(int funktion) {
       int menge;
       int artikelNr;
       switch (funktion) {
            case ENTFERNE_ARTIKEL:
                artikelNr = einlesen_artikel();
                ENTFERNE_ARTIKEL_f(artikelNr);
                break;
            case creat_lager:
                System.out.println("bitte geben Sie der Groeße der lage ein: ");
                artikelNr = einlesen_index();
                ENTFERNE_ARTIKEL_f(artikelNr);
                break;

            case BUCHE_ZUGANG:
                artikelNr = einlesen_artikel();
                menge = einleseMenge();
                zubuch_im_lager(artikelNr, menge);

                break;

            case BUCHE_ABGANG:
                artikelNr = einlesen_artikel();
                menge = einleseMenge();
                abbuch_im_lager(artikelNr, menge);
                break;

            case AENDERE_PREIS_ALLER_ARTIKEL:
                double preis_prozent = einlesePreis();
                try {
                    lager1.aenderePreisAllerArtikel(preis_prozent);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case GET_ARTIKEL:
                System.out.println("geben Sie den artikel index ein :\n");
                artikelNr = einlesen_index();
                try {
                    lager1.getArtikel(artikelNr);
                } catch (NullPointerException e) {
                    System.out.println("bitte legen Sie erst einen Lager an");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case GET_ARTIKEL_ANZAHL:
                try {
                    System.out.println(lager1.getArtikelAnzahl());
                } catch (NullPointerException e) {
                    System.out.println("bitte legen Sie erst einen Lager an");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case GET_LAGER_GROESSE:
                try {
                    lager1.getLagerGroesse();
                } catch (NullPointerException e) {
                    System.out.println("bitte legen Sie erst einen Lager an");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            
            // Benutzer zur Eingabe eines Artikels auffordern (j)
            // Einlesen der Artikel Attribute: Artikelnummer, Bezeichnung, Bestand und Preis (x)
            // Aufrufen des Artikel Konstruktors mit den 4 eingelesenen Werten (x)
            // Mitgabe des neuangelegten Artikels in das Lager (legeAnArtikel) (j)
                
            /** case LEGE_AN_ARTIKEL:
                 System.out.println("geben Sie einen artikel ein");
                Artikel artikel = null;
                try{
                    artikel = nex
                    lager1.legeAnArtikel(artikel);
                }catch (Exception e){
                    System.out.println(e);
                    input.nextLine();
                }
                **/
            case ENDE:
                System.out.println("Programmende");
                break;

            default:
                System.out.println("Falsche Funktion");
        }
        System.out.println(lager1);

    }

    private void abbuch_im_lager(int artikelNr, int menge) {
        if (lager1 == null) {
            System.out.println("bitte erst einen Lager anlegen");
            return;
        }
        try {
            lager1.bucheAbgang(artikelNr, menge);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void zubuch_im_lager(int artikelNr, int menge) {
        if (lager1 == null) {
            System.out.println("bitte erst einen Lager anlegen");
            return;
        }
        try {
            lager1.bucheZugang(artikelNr, menge);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void start() {
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenfunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println("Ausnahme gefangen:  " + e);
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
                input.next();
            } catch (Exception e) {
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }


        }

    }


    public static void main(String[] args) {
        LagerDialog x = new LagerDialog();
        x.start();
    }
}
