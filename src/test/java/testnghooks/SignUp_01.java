package testnghooks;

import org.testng.annotations.*;

public class SignUp_01 {

    @BeforeSuite
    public void signupBeforeSuite() {
        System.out.println("Signup_01 BeforeSuite");
    }

    @BeforeTest
    public void signupBeforeTest() {
        System.out.println("!___ Signup_01 BeforeTest");
    }

    @BeforeClass
    public void signupBeforeClass(){
        System.out.println("!_____ Signup_01 BeforeClass");
    }

    @AfterSuite
    public void signupAfterSuite() {
        System.out.println("Signup_01 AfterSuite");
    }

    @AfterTest
    public void signupAfterTest() {
        System.out.println("!___ Signup_01 AfterTest");
    }

    @AfterClass
    public void signupAfterClass(){
        System.out.println("!_____ Signup_01 AfterClass");
    }

    @Test
    public void signupWithCorrectCreds(){
        System.out.println("!_______ This is Signup_01");
    }

}
