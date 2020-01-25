package ru.stqa.pft.soap;

import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoapTest {
    @Test
    public void TestMyIp(){
       String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("83.172.21.1");
        Assert.assertTrue(geoIP.contains("RU"));
    }

//    @Test
//    public void WrongIpTest(){
//        String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("83.172.21.x");
//        Assert.assertTrue(geoIP.contains("RU"));
//
//    }
}
