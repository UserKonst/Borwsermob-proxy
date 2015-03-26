/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author konst
 */
public class BrowserEntity {
    
   private Capabilities capabilities;
   private FirefoxProfile profile;
   private FirefoxBinary ffbinary;

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public FirefoxProfile getProfile() {
        return profile;
    }

    public void setProfile(FirefoxProfile profile) {
        this.profile = profile;
    }

    public FirefoxBinary getFfbinary() {
        return ffbinary;
    }

    public void setFfbinary(FirefoxBinary ffbinary) {
        this.ffbinary = ffbinary;
    }
    
}
