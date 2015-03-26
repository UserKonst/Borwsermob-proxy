/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HarArchive;

import java.util.ArrayList;
import java.util.List;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarLog;
import net.lightbody.bmp.core.har.HarRequest;

/**
 *
 * @author konst
 */
public class HarManager {

    HarLog log;

    public HarManager(Har har) {
        log = har.getLog();
    }

    public int getAllRequests() {

        List<HarEntry> entries = log.getEntries();
        List<String> list = new ArrayList<>();
        
        for (HarEntry entry : entries) {
            HarRequest req = entry.getRequest();
            
            String url = req.getUrl();
            list.add(url);
            System.out.println(url);
            
            
            
        }
        
        System.out.println("ent size: " + entries.size());
        System.out.println("url size: ");
        return list.size();
    }

}
