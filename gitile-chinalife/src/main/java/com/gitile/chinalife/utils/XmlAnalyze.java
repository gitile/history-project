package com.gitile.chinalife.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.gitile.chinalife.entity.InputTag;

/**
 * Xml解析文档
 */
public class XmlAnalyze {
	
	/**
	 * 数据集解析
	 * @param tags
	 * @return
	 */
	public static List<InputTag> analyzeAdditionalTags(Element tags) {
		List<InputTag> listTags = new ArrayList<InputTag>();
		for(Iterator<?> it=tags.elementIterator();it.hasNext();){
	        Element element = (Element) it.next();
	        InputTag tag = XmlAnalyze.analyzeAdditionalTag(element);
	        listTags.add(tag);
		}
		return listTags;
	}
	
	/**
	 * 数据项解析
	 */
	public static InputTag analyzeAdditionalTag(Element tags) {
		InputTag tag = new InputTag();
		for(Iterator<?> it=tags.elementIterator();it.hasNext();){
	        Element element = (Element) it.next();
	        String name = element.attribute("name").getText();
	        String value = element.getText();
	        tag = setInputTagAttribute(tag, name, value);
		}
		return tag;
	}
	private static InputTag setInputTagAttribute(InputTag tag, String name, String value) {
		switch (name) {
		case "label":
			tag.setLabel(value);
			break;
		case "type":
			tag.setType(value);
			break;
		case "key":
			tag.setKey(value);
			break;
		case "value":
			tag.setValue(value);
			break;
		case "premium":
			tag.setPremium(value);
			break;
		case "disable":
			tag.setDisable(value);
			break;
		case "data":
			tag.setData(value);
			break;
		case "dataUrl":
			tag.setDataUrl(value);
		case "check":
			tag.setCheck(value);
		case "checkUrl":
			tag.setCheckUrl(value);
			break;
		default:
			break;
		}
		return tag;
	}
	
	/**
	 * 将车主信息中有值的字段转化成request中条件
	 * @param inputs
	 * @param owner
	 * @return
	 */
	public static Element toRequestXml(Element inputs, Object object) {
		if(object!=null) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					Method m = (Method) object.getClass().getMethod("get" + getMethodName(field.getName()));
					String value = (String) m.invoke(object);
					if(StringUtils.isNotEmpty(value)) {
						inputs.addElement("Input").addAttribute("name", field.getName()).setText(value);
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return inputs;
	}
	
	 /**
	  *  把一个字符串的第一个字母大写、效率是最高的、
	  * @param fildeName
	  * @return
	  * @throws Exception
	  */
	 private static String getMethodName(String fildeName) throws Exception{
	  byte[] items = fildeName.getBytes();
	  items[0] = (byte) ((char) items[0] - 'a' + 'A');
	  return new String(items);
	 }
	 
	 

	
}
