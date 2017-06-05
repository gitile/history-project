package com.gitile.chinalife.response;

import com.gitile.chinalife.entity.Order;


public class Response115 extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public final static String CODE_100 = "100";// 核保通过 
	public final static String CODE_300 = "300";// 拒保
	public final static String CODE_400 = "400";// 失败
	public final static String CODE_500 = "500";// 核保中

	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
