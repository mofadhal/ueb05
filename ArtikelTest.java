

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArtikelTest.
 *
 * @author  (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (24.11.2020)
 */
public class ArtikelTest  {
    @Test
    public void testValidArtikel(){
        Artikel x = new Artikel(1111,"almanari");
        assertNotNull(x);
        assertEquals(1111 , x.getArtikelNr());
        assertEquals("almanari" , x.getArt());
    }
    
    @Test
    public void testValidArtikel_2(){
        Artikel x = new Artikel(2345,"almanari");
        assertNotNull(x);
        assertEquals(2345 , x.getArtikelNr());
        assertEquals("almanari" , x.getArt());
        assertEquals( 0 , x.getBestand());

    }
    
    @Test
    public void testSubMenge(){
        Artikel x = new Artikel(1111,"almanari", 100);
        x.bucheAbgang(20);
        assertEquals(80 , x.getBestand());
        x.bucheAbgang(10);
        assertEquals(70 , x.getBestand());
    }
    
    @Test
    public void testAddMenge(){
        Artikel x = new Artikel(1111,"almanari", 10);
        x.bucheZugang(20);
        assertEquals(30 , x.getBestand());
        x.bucheZugang(10);
        assertEquals(40 , x.getBestand());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArt(){
        Artikel x = new Artikel(1111,null, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testemptyArt(){
        Artikel x = new Artikel(1111,"", 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullArt(){
        Artikel x = new Artikel(1111,"mo", 10);
        x.setArt(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetemptyArt(){
        Artikel x = new Artikel(1111,"mo", 10);
        x.setArt("");

    }
    
    @Test
    public void testSetArt(){
        Artikel x = new Artikel(1111,"mo", 10);
        x.setArt("almanari");
        assertEquals ("almanari" , x.getArt());

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigeArtikelNr_1(){
        Artikel x = new Artikel(-9987,"dsfds", 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigeArtikelNr_2(){
        Artikel x = new Artikel(999,"dsfds", 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigePreis(){
        Artikel x = new Artikel(9997,"dsfds", 10,-1);
    }
        
     @Test(expected = IllegalArgumentException.class)
    public void testUngueltigeArtikelNr_3(){
        Artikel x = new Artikel(99999,"dsfds", 10);
        assertEquals (99999, x.getArtikelNr());
    }
    
    @Test
    public void testUngueltigeArtikelNr_4(){
        Artikel x = new Artikel(1000,"dsfds", 10);
        assertEquals (1000 , x.getArtikelNr());
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigeArtikelNr_5(){
        Artikel x = new Artikel(10000,"dsfds", 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigebestand(){
        Artikel x = new Artikel(1234,"dsfds", -10);
    }
    
    @Test
    public void testgueltigebestand(){
        Artikel x = new Artikel(1234,"dsfds", 3);
    }
    
    @Test
    public void testgueltigePreis(){
        Artikel x = new Artikel(1234,"dsfds", 3,20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUngueltigeSetbestand(){
        Artikel x = new Artikel(1234,"dsfds", 10);
        x.setBestand(-1);
    }
    
    @Test
    public void testgueltigeSetbestand(){
        Artikel x = new Artikel(1234,"dsfds", 10);
        x.setBestand(1);
    }
   @Test
    public void testgueltigeSetPreis(){
        Artikel x = new Artikel(1234,"dsfds", 10,20);
        x.setPreis(5);
    }
   public void testUngueltigeSetPreis(){
        Artikel x = new Artikel(1234,"dsfds", 10,12);
        x.setBestand(-1);
   }
}
