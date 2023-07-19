package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {
    SoftAssert softAssert= new SoftAssert();
    AmazonPage amazonPage=new AmazonPage();
    @Test(groups = "smoke")
    public void amazonTesti(){
        /*
        Genel olarak
        test edin denilirse hard assert
        dogrulayin(verify) denilirse soft assert kastedilir
         */

        //amazon anasayfaya gidip, dogru sayfaya gittigimizi DOGRULAYIN (verify)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"amazona gittigi dogrulanmiyor");
        // Nutella icin arama yapip, sonuclarin nutella icerdigini dogrulayin
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        expectedIcerik="Nutella";
        String actualAramaSonucYazisi=amazonPage.aramaSonuc.getText();
        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"sonuclar nutella icermiyor");

        // ilk urune tiklayip, urun isminde Nutella gectigini dogrulayin
        amazonPage.ilkUrun.click();
        expectedIcerik="Nutella";
        String actualIlkUrunIsim=amazonPage.ilkUrunIsimElementi.getText();
        softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik),"ilk urun ismi nutella icermiyor");


        softAssert.assertAll();
        Driver.closeDriver();
    }
}
