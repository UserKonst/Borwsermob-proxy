/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import HarArchive.HarManager;
import Proxy.ProxyManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static tests.SetUpTest.driver;

/**
 *
 * @author konst
 */
@Test
public class ProxyTest {

    public ProxyTest() {

    }

    public WebDriver driver;
    public ProxyManager proxyManager;
    public Capabilities caps;

    @BeforeClass
    public void setup() {
        driver = SetUpTest.getDriver();
        proxyManager = SetUpTest.getProxyManager();
        caps = SetUpTest.getCaps();
    }

    @Test(priority = 1)
    public void test() throws InterruptedException {
        proxyManager.createHar("test");
        driver.get("http://www.ranorex.com/web-testing-examples/vip/");
        Thread.sleep(1000);
        HarManager harManager = proxyManager.getHar();

        System.out.println(harManager.getAllRequests());

        proxyManager.deleteHar();
    }

    @Test(priority = 2)
    public void test2() throws InterruptedException {

        driver = new FirefoxDriver(caps);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        proxyManager.createHar("test");
        driver.get("http://www.ranorex.com/web-testing-examples/vip/");
        Thread.sleep(1000);
        HarManager harManager = proxyManager.getHar();

        System.out.println(harManager.getAllRequests());

        proxyManager.deleteHar();

    }

}
