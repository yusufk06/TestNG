package tests.day10_TestNGFrameworks;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {
    /*
    Smoke Test
    Regression Test
    EndToEnd (E2E)

        Test Suite: Birden fazla Test in bir amac icin bir araya getirilmesidir

    Test : Bir amac icin bir araya getirilmis test methodlari ,classlari ve/veya packageleri iceri


    Test Hiyerarsisi:
    -Suite
    -Test
    -groups,packages,classes,methods


     */
    @BeforeSuite
    public void  beforeSuite(){
        System.out.println("Before suite");

    }

    @BeforeTest
    public void  beforeTest(){
        System.out.println("Before test");

    }

    @BeforeTest
    public void  beforeClass(){
        System.out.println("before class");

    }

    @BeforeTest
    public void  beforeMethod(){

        System.out.println("before method" );
    }

    @Test
    public void  test01(){
        System.out.println("test01");

    }
    @Test
    public void  test02(){
        System.out.println("test02");

    }
    @Test
    public void  test03(){
        System.out.println("test03");

    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterClass (groups = "smoke")
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
