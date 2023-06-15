package tests.day10_TestNGFrameworks;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {
        /*
        priority oncelik belirlerama testleri birbirine baglamaz
         eger bir test method unun calismasi baska bir test methoduna bagli ise
         bu durumde dependOnMethods kullanmak daha guzel olur

         dependsOnMethod ile baska bir method a bagli olan methodu bagimsiz valistirmak istersek
         once bagli oldugu methodu calistiri, sonra kendisi calisir
         Ancak bu 2 method icin gecerlidir 3 method calistirmaz

         dependsOnMethods bir siralama yontemi degildir
         sira bagli olan bir methoda geldiginde oncelikle bagli oldgu methodun calismasini ve passed olmasini bekler
         eger bagli olunan method failed olursa
         bagli olan method calistirilmaz ignore edilir
         */
    // 3 test methodu olusturun
    //1. amazona gidip amazona gittigimizi test edin
    //2. Nutella aratip, sonucun Nutella icerdigini test edin
    //3.ilk urune click yapip, urun isminin Nutella icerdigini test edin
    AmazonPage amazonPage=new AmazonPage();
    @Test(priority = 1)
    public void amazonTesti(){
        Driver.getDriver().get("https://amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }

    @Test(priority = 2)
    public void nutellaTesit(){
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonuc.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }

    @Test(priority = 3)
    public void ilkUrunTesti(){
      amazonPage.ilkUrun.click();

      String expectedIcerik="Nutella";
      String actualUrunIsmi=amazonPage.ilkUrunIsimElementi.getText();

      Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
