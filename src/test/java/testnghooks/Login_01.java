package testnghooks;

import org.testng.annotations.*;

public class Login_01 {

    @BeforeSuite
    public void loginBeforeSuite() {
        System.out.println("Login_01 BeforeSuite");
    }

    @BeforeTest
    public void loginBeforeTest() {
        System.out.println("!___ Login_01 BeforeTest");
    }

    @BeforeClass
    public void loginBeforeClass(){
        System.out.println("!_____ Login_01 BeforeClass");
    }

    @AfterSuite
    public void loginAfterSuite() {
        System.out.println("Login_01 AfterSuite");
    }

    @AfterTest
    public void loginAfterTest() {
        System.out.println("!___ Login_01 AfterTest");
    }

    @AfterClass
    public void loginAfterClass(){
        System.out.println("!_____ Login_01 AfterClass");
    }

    @BeforeMethod
    public void loginBeforeMethod(){
        System.out.println("!_______ This is BeforeMethod Login 01");
    }

    @AfterMethod
    public void loginAfterMethod(){
        System.out.println("!_______ This is AfterMethod Login 01");
    }


    @Test
    public void loginWithCorrectCreds(){
        System.out.println("!_______ This is Login 01");
    }

    @Test
    public void loginWithIncorrectCreds(){
        System.out.println("!_______ This is Login 01 - IncorrectCreds");
    }

}
