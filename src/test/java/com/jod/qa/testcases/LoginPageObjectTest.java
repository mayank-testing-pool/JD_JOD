package com.jod.qa.testcases;

import com.jod.qa.base.TestBase;
import com.jod.qa.config.Browser_Configuration;
import com.jod.qa.pageObject.HomePageObject;
import com.jod.qa.pagesAction.LoginPageAction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageObjectTest extends TestBase {
    LoginPageAction loginpageaction;
    HomePageObject homepage;
    //LoginPageObject loginpageaction;

    public LoginPageObjectTest()
    {super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        loginpageaction = new LoginPageAction();
        homepage = new HomePageObject();
        //loginpageaction = new LoginPageObject();
    }

    @Test
    public void login() throws InterruptedException {
        /*String current_url = loginpageaction.validatecurreturl();
        try {
            Assert.assertEquals(current_url, Browser_Configuration.Cert_URL);
        } catch (AssertionError e) {
            e.printStackTrace();
        }*/
        loginpageaction.enterUserName(Browser_Configuration.User_name);
        loginpageaction.enterPassword(Browser_Configuration.Password);
        loginpageaction.clickonLoginButton();
        //homepage = loginpageaction.login(Browser_Configuration.User_name,Browser_Configuration.Password);
        //loginpageaction.login(Browser_Configuration.User_name,Browser_Configuration.Password);
        Thread.sleep(3000);
        String current_title = loginpageaction.velidatePageTitle();
        try{
            Assert.assertEquals(current_title,Browser_Configuration.Page_title_after_login);
        }
        catch (AssertionError e)
        {
            e.printStackTrace();
        }



    }
}
