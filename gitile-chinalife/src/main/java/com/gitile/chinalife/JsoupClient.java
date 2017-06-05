package com.gitile.chinalife;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsoupClient {
	
	public static String getCarModels(String dataUrl, String searchKey) throws IOException {
		dataUrl = dataUrl + "&page=1&pageSize=100000&callback=category&searchCode=" + searchKey;
		System.out.println(dataUrl);
		Document doc = Jsoup.connect(dataUrl).timeout(50000).ignoreContentType(true).get();
		if (doc != null) {
			return doc.text();
		}
		return null;
	}
	
	public static String getCarModelsString(String dataUrl, String searchKey) {
		try {
			String jsoupString = JsoupClient.getCarModels(dataUrl, searchKey);
			if(jsoupString.startsWith("category(")&&jsoupString.endsWith(")")) {
				jsoupString = jsoupString.substring(9);
				jsoupString = jsoupString.substring(0, jsoupString.length()-1);
				JSONObject json = JSON.parseObject(jsoupString);
				int count = json.getInteger("counter");
				JSONArray list = json.getJSONArray("rows");
				if(list!=null&&count>0) {
					StringBuilder result = new StringBuilder();
					for(int i = 0; i < list.size();i++){
						JSONObject obj = (JSONObject)list.get(i);
						String key = obj.getString("key");
						String value = obj.getString("value");
						result.append(value+":"+key+";");
					}
					return result.toString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}