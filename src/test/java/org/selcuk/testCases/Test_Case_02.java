package org.selcuk.testCases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.selcuk.helpers.JsonReadHelper;
import org.selcuk.pageObjects.HomePage;
import org.selcuk.pageObjects.LoginSignupPage;
import org.selcuk.testCases.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("User")
public class Test_Case_02 extends TestBase {
    @Test(description = "Test case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with correct email and password")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible""")
    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
        Test_Case_01.verifyThatHomePageIsVisibleSuccessfully();
        verifyLoginToYourAccountIsVisible();
        verifyThatLoggedInAsUsernameIsVisible();


    }
    @Step("Verify 'Login to your account' is visible")
    public static void verifyLoginToYourAccountIsVisible(){
        String loginToYourAccountText = new HomePage(getDriver())
                .signupLoginClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText,"Login to your account","Verify 'Login to your account' is visible");
    }
    @Step("Verify that 'Logged in as username' is visible")
    public static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException {
        String username = new LoginSignupPage(getDriver())
                .fillCorrectLogin(JsonReadHelper.existingUser("email"),JsonReadHelper.existingUser("password"))
                .getUsername()
                .getText();
        Assert.assertEquals(username,JsonReadHelper.existingUser("name"),"Verify that 'Logged in as username' is visible");

    }




}
