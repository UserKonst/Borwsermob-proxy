/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Proxy.ProxyManager;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author konst
 */
public class SetUpTest {

    public SetUpTest() {
    }

    public static WebDriver driver;
    public static ProxyManager proxyManager;
    public static Capabilities caps;

    @BeforeTest(alwaysRun = true)
    public void before() throws InterruptedException, Exception {
        System.out.println("BEFORE");

        proxyManager = new ProxyManager();
        proxyManager.startProxy(4444);
        caps = proxyManager.setCapabilities();

//        File file = new File("E:\\ffprofile");
//        FirefoxProfile profile = new FirefoxProfile(file);
        driver = new FirefoxDriver(caps);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver = new HtmlUnitDriver();
//        System.out.println("dirver in before: " + getDriver());
//        driver.get("http://www.ranorex.com/web-testing-examples/vip/");

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Capabilities getCaps() {
        return caps;
    }

    public static ProxyManager getProxyManager() {
        return proxyManager;
    }

    @AfterTest(alwaysRun = true)
    public void after() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
        proxyManager.stopProxy();
        System.out.println("AFTER");
    }

}
