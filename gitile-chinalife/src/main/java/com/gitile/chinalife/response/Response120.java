package com.gitile.chinalife.response;

import com.gitile.chinalife.entity.Order;


public class Response120 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// ֧�����ͨ��
	public final static String CODE_400 = "400";// ֧�����ʧ��

	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
