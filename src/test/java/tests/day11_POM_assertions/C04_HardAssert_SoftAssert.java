package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {

    @Test
    public void hardAssertionTesti(){
        Assert.assertTrue(5>8);

        Assert.assertFalse(8==8);

        Assert.assertEquals(5,9);

        Assert.assertNotEquals(6,6);
    }

    @Test
    public void softAssertionTesti(){
        /*
        JUnit deki Assert class'i TestNG de de vardir
        ancak bir test methodunda birden fazla failed olan assertion varsa
        ilk failed olan assertion da calismayi durdurup exception firlattigindan
        tum hatayi bir defada gorup hepsini duzeltme sansimiz olmaz

        TestNG bunun icin bir alternatif olusturmus
        Bu alternatifte Assert classinda ki static methodlari kullanmak yerine
        SoftAssert class indan bir obje olusturup
        o obje uzerinden istedigimiz testleri yapiyoruz
       softassert objesi ile yapilan assertionlar failed olsa da testimiz calismaya devam eder

       Ancak testlerin sonucunu gormek istedigimizde
       softassert.assertAll() ile tum yaptigi testleri raporlamasini soyleyebiliriz

       assertAll() methodunun calistigi satirda
       exception olabilir
         */
        SoftAssert softAssert= new SoftAssert();


        softAssert.assertTrue(5>8,"true testi failed ");

        softAssert.assertFalse(8==8,"false testi failed ");

        softAssert.assertEquals(5,9,"equlas testi failed ");

        softAssert.assertNotEquals(6,6,"not equals testi failed ");



        softAssert.assertAll();
    }
}
