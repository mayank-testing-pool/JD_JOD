package com.jod.qa.base;

import com.jod.qa.config.Browser_Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.jod.qa.utils.TestUtils.IMPLECIT_WAIT;
import static com.jod.qa.utils.TestUtils.PAGE_LOAD_TIMEOUT;
import static com.jod.qa.config.Browser_Configuration.*;


public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    /*private static String cert = "cert";
    private static String prod = "prod";
    private static String qa = "qa";*/
    static String url = null;
    static String user_path = System.getProperty("user.dir");

    public TestBase()
    {
        try
        {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(user_path+"\\src\\main\\java\\com\\jod\\qa\\config\\config.properties");
            prop.load(fis);
         }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization ()
    {
        String browser_name = prop.getProperty("Browser").toLowerCase();

        if (Browser.equals("Chrome"))
        //if (browser_name.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", user_path +"\\support\\chromedriver_2.41.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
        }
        else if (Browser.equals("Firefox"))
        //else if  (browser_name.equals("firefox"))
        {
            System.setProperty("webdriver.geckodrier.driver",user_path+"\\support\\geckodriver_0.23.exe");
            driver = new FirefoxDriver();
        }
        else if (Browser.equals("Internet Explorer"))
        //else if (browser_name.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver",user_path+"\\support\\IEDriverServer.exe");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLECIT_WAIT,TimeUnit.SECONDS);
        //String env = prop.getProperty("Environment").toLowerCase();
        switch (Browser_Configuration.Environment.toLowerCase())
        {
            case "cert":
                url =Cert_URL;
                break;
            case "prod":
                url = Prod_URL;
                break;
            case "qa":
                url = QA_URL;
                break;
            default:
                System.out.println("Please specify environment");
        }

       /*if (env.equals("prod"))
        {
            url = prop.getProperty("Prod_URL");
            //driver.get(url);
        }
        else if (env.equals("cert"))
        {
            url = prop.getProperty("Cert_URL");
            //driver.get(url);
        }
        else if (env.equals("qa"))
        {
            url = prop.getProperty("QA_URL");
            //driver.get(url);
        }*/
        driver.get(url);

    }
}
