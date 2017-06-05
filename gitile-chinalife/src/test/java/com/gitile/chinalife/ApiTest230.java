package com.gitile.chinalife;

import com.gitile.chinalife.utils.WebUtils;

public class ApiTest230 extends BaseTest{
	
	public static void main(String[] args) {
		String result = WebUtils.doPost("http://api.changxingbang.com:8080/car/chinalife230?data=<?xml version='1.0' encoding='GBK'?><PackageList xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'><Package><Header><Version>2</Version><InsureType>100</InsureType><RequestType>230</RequestType><SessionId>150915_093300_726FA662_14A_80101</SessionId><SendTime>2015-09-15 10:45:50</SendTime><SellerId>20</SellerId><Status>100</Status><ErrorMessage /></Header><Response><Order><TBOrderId>3376311089148</TBOrderId><Premium>530000</Premium><PayNo>3376311089148</PayNo><SubOrderList><SubOrder type='biz'><TBOrderId>3376311089149</TBOrderId><ItemId>92156550730007</ItemId><Premium>500000</Premium><ProposalNo>905072015140100001124</ProposalNo><PolicyNo>8828900000144889</PolicyNo></SubOrder><SubOrder type='force'><TBOrderId>3376311089139</TBOrderId><ItemId>92156550730007</ItemId><Premium>30000</Premium><ProposalNo>905102015140100002511</ProposalNo><PolicyNo>8828900000144889</PolicyNo></SubOrder></SubOrderList></Order></Response></Package></PackageList>","", 0, 0);
		System.out.println(result);
	}

}
