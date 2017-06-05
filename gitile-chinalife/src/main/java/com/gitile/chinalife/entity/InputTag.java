package com.gitile.chinalife.entity;

/**
 * ������Ҫ�������Ϣ
 *
 */
public class InputTag {
	
	private String type;// �ؼ�����
	private String key;// �ؼ�����
	private String label;// �ؼ���ʾ��
	private String value;// �ؼ�Ĭ��ֵ
	private String premium;// �ؼ�����(�ײ��еĿؼ�����Ҫ���ֵ����λ����)
	private String disable;// �ؼ��Ƿ�ɱ༭(0�ɱ༭��1���ɱ༭)
	private String dataUrl;// �ؼ���ʼ��Url��ַ����ʱδ���ţ�
	private String data;// �ؼ��ĳ�ʼ����������(�ṹ��key1:value1;key2:value2��һ�㳣���������ؼ�)
	private String check;// �ؼ�����У�����(һ��Ϊ������ʽ����ʱδ���ţ�)
	private String checkUrl;// �ؼ�����У�������ַ(ͬdataUrlһ�������ؼ������е�ֵͬ���չ�˾�����ҵ�񳡾����ʱ���ͱ���ʵʱ�����������չ�˾�жϲ�����ʽ������ʱδ���ţ�)
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getDisable() {
		return disable;
	}
	public void setDisable(String disable) {
		this.disable = disable;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getCheckUrl() {
		return checkUrl;
	}
	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
