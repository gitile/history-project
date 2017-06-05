package com.gitile.chinalife;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitile.chinalife.utils.StringUtils;

public class getCityCodeTest {
	
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.chinalife.com.cn/online/saleNewCar/carProposalfindSelectAreaInFo.do?channel=%27web%27").timeout(50000).ignoreContentType(true).get();
		if (doc != null) {
			String jsoupString = doc.text();
			JSONObject json = JSON.parseObject(jsoupString);
			JSONArray list = json.getJSONArray("allarea");
			Map<String, String> shen = new HashMap<String, String>();
			for(int i = 0; i < list.size();i++){
				JSONObject obj = (JSONObject)list.get(i);
				String addressName = obj.getString("addressName");// 城市name
				String deptID = obj.getString("deptID").substring(1);// 城市code
				String parentid = obj.getString("parentid").substring(1);// 省code
				String shortAddress = obj.getString("shortAddress");// 车辆号
				String provincename = obj.getString("provincename");// 省
				String hasShen = shen.get(parentid);
				if(StringUtils.isEmpty(hasShen)) {
					// 打印所有省插入语句
					shen.put(parentid, parentid);
					System.out.println("INSERT INTO car_area(code, name, short_name, parent_code) VALUES ("+parentid+", '"+provincename+"', null, 0);");
				}
				// 打印所有城市插入语句
				System.out.println("INSERT INTO car_area(code, name, short_name, parent_code) VALUES ("+deptID+", '"+addressName+"', '"+shortAddress+"', "+parentid+");");
			}
		}
	}
	

}
