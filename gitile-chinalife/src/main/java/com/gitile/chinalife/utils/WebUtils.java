package com.gitile.chinalife.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);
	
	public static final String DEFAULT_CHARSET = "GBK";
	
	/**
	 * 执行HTTP POST请求。
	 * @param url
	 * @param content
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String urlStr, String xmlString, int connectTimeout,int readTimeout) {
		try {
			URL url = new URL(urlStr);
			URLConnection con = url.openConnection();
			con.setConnectTimeout(connectTimeout);
			con.setReadTimeout(readTimeout);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
			out.write(xmlString);
			out.flush();
			out.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), DEFAULT_CHARSET));
			String line = "";
			StringBuilder resultStr = new StringBuilder();
			for (line = br.readLine(); line != null; line =br.readLine()) {
				resultStr.append(line);
			}
			return resultStr.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 获取回调接口XML内容
	 * @param request
	 * @return
	 */
	public static String getHttpServletRequestString(HttpServletRequest request) {
		StringBuilder resultStr = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), WebUtils.DEFAULT_CHARSET));
			String line = "";
			for (line = br.readLine(); line != null; line = br.readLine()) {
				resultStr.append(line);
			}
			return resultStr.toString();
		} catch (Exception e) {
			return null;
		}
	}

}
