package com.jod.qa.pagesAction;

import com.jod.qa.pageObject.LoginPageObject;
import org.openqa.selenium.support.PageFactory;


public class LoginPageAction extends LoginPageObject {

    LoginPageObject loginpage = PageFactory.initElements(driver, LoginPageObject.class);
    public String validatecurreturl ()
    {
        //driver.getCurrentUrl();
        return driver.getCurrentUrl();
    }
    public void enterUserName (String uname)
    {
        username.sendKeys(uname);
    }

    public void enterPassword (String pwd)
    {
        password.sendKeys(pwd);
    }

    public void clickonLoginButton()
    {
        login_button.click();
    }

    /*public HomePageObject login (String uname, String pwd)
    {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        login_button.click();
        return new HomePageObject()   ;
    }
    public void login (String uname, String pwd)
    {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        login_button.click();
        //return new HomePageObject()   ;
    }*/

    public String velidatePageTitle()
    {
      return driver.getTitle();
    }

}
