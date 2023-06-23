package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configReaderKullanimi {


    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Test datasi olarak verilen kelime icin arama yapin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);


        //arama sonuclarinin arattigimiz test datasini icerdigini test edin
        String expectedIcerik = ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi=amazonPage.aramaSonuc.getText();
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
