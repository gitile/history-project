package com.gitile.chinalife.response;

import com.gitile.chinalife.entity.Order;


public class Response115 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// �˱�ͨ�� 
	public final static String CODE_300 = "300";// �ܱ�
	public final static String CODE_400 = "400";// ʧ��
	public final static String CODE_500 = "500";// �˱���

	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
