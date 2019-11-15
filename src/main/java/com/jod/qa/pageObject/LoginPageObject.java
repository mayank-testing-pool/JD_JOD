package com.jod.qa.pageObject;

import bsh.This;
import com.jod.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends TestBase {

    @FindBy (how=How.ID,using = "userName1")
    protected WebElement username;

    @FindBy (how = How.ID, using = "password1")
    protected WebElement password;

    @FindBy (how = How.XPATH,using = "//input[contains(@value, 'Sign In')]")
    protected WebElement login_button;

    public LoginPageObject() {
        PageFactory.initElements(driver, this);
    }


    //LoginPageObject loginpage = PageFactory.initElements(driver,LoginPageObject.class);
    /*public String validatecurreturl ()
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

    public String velidatePageTitle()
    {
        return driver.getTitle();
    }*/


}
