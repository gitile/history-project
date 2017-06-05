package com.gitile.desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpPostTest {
	void testPost(String urlStr) {  
        try {  
            URL url = new URL(urlStr);  
            URLConnection con = url.openConnection();  
            con.setDoOutput(true);  
            con.setRequestProperty("Pragma:", "no-cache");  
            con.setRequestProperty("Cache-Control", "no-cache");  
            con.setRequestProperty("Content-Type", "text/xml");  
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());      
            String xmlInfo = getXmlInfo();
            out.write(DefaultThirdSigner.sign(xmlInfo.getBytes("GBK"), DefaultThirdSigner.getPrivateKey()));  
            out.flush();  
            out.close();  
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String line = "";  
            for (line = br.readLine(); line != null; line = br.readLine()) {  
                System.out.println(line);  
            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
  
    private String getXmlInfo() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("<PackageList>");  
        sb.append("<Package><Header><Version>2</Version><RequestType>100</RequestType><InsureType>100</InsureType><NeedType>no</NeedType><SessionId>20150318100709</SessionId>"
				+"<SellerId>15</SellerId><SendTime>2013-06-02 10:28:42</SendTime><Status>100</Status><ErrorMessage><![CDATA[]]></ErrorMessage></Header>"
			+"<Request><InputsList><Inputs type=\"vehicleInfo\"><Input name=\"licenseNo\">粤B54S02</Input>"
			+"<Input name=\"cityCode\">440300</Input><Input name=\"noLicenseFlag\">0</Input><Input name=\"idNo\">0206</Input><Input name=\"idNoType\">09</Input></Inputs>"
			+"</InputsList></Request>"
			+"<Sign><![CDATA[b8dYyA4a_pIdkXU5HHhcuTI5vlV-SsE_Nv5CDTki0ZwDPfxTc9RuCCwgwJBqS5lQw8ZLsBlCxaRg-YhTSFiNpzqLA4H928JbPbwlxINpOOsrigR84FkoUB2GxYMTY7sZNH4Yy-I5A2Zu0W6pDe5U6blGa3ZwHVkZsdYDA2e5Mts]]></Sign>"
		+"</Package>");
        return sb.toString();  
    }  
  
    public static void main(String[] args) {  
        String url = "http://m.chinalife.com.cn/online12/thirdPartyCar/carProposalthirdPartyCarQueryInfo.do";  
        new HttpPostTest().testPost(url);  
    }  
	
	
}
