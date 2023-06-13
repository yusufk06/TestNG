package tests.day10_TestNGFrameworks;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
/*
    TestNG test methodlarini calistirirken standart olarak harf siralamasina bakar
    ancak testNG siralamayi bizim kontrol etmemize olanak saglar
    istedigimiz test methoduna istedigimiz onceligi priority ile tanimlayabiliriz
    Selenium test methodlarini priority si kucukten buyuge olacak sekilde calistirir
    priority degeri ayni olan test methodlari harf sirasina gore calisir

    priority degeri yazilmazsa default olarak priority=0 kabul edilir

 */
    @Test(priority = 50)
    public void amazonTesti(){
        //Amazon anasayfaya gidip, amazona gittigimizi test edelim
        Driver.getDriver().get("https://amazon.com");
        // url amazon iceriyor mu test edelim
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }

    @Test(priority = 20)
    public void wiseTesti(){
        //Wisequarter anasayfaya gidip, wiseq gittigimizi test edelim
        Driver.getDriver().get("https://wisequarter.com");
        // url wisequarter iceriyor mu test edelim
        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }


    @Test(priority = 30)
    public void youtubeTesti(){
        //Youtube anasayfaya gidip, youtube gittigimizi test edelim
        Driver.getDriver().get("https://youtube.com");
        // url youtube iceriyor mu test edelim
        String expectedIcerik="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
}
