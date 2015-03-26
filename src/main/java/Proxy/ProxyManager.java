/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import HarArchive.HarManager;
import java.net.UnknownHostException;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author konst
 */
public class ProxyManager {

    private ProxyServer proxy;

    public ProxyManager() {

    }

    public void startProxy(int port) throws Exception {
        proxy = new ProxyServer(port);
        proxy.start();
        proxy.setCaptureHeaders(true);
    }

    public void stopProxy() throws Exception {
        proxy.stop();
    }

    public Capabilities setCapabilities() throws UnknownHostException {

        Proxy selenProxy = proxy.seleniumProxy();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, selenProxy);

        return capabilities;
    }

    public void createHar(String harName) {
        proxy.newHar(harName);
    }

    public HarManager getHar() {
        Har har = proxy.getHar();
        return new HarManager(har);
    }
    
    public void deleteHar(){
        proxy.cleanup();
    }

}
