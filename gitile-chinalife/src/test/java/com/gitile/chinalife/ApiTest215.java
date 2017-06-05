package com.gitile.chinalife;

import com.gitile.chinalife.utils.WebUtils;

public class ApiTest215 extends BaseTest{
	
	public static void main(String[] args) {
		String result = WebUtils.doPost("http://localhost:8081/car/chinalife215", "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"yes\"?><PackageList xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Package><Header><Version>2</Version><RequestType>215</RequestType><InsureType>100</InsureType><SessionId>33763110891482088102118850914</SessionId><SellerId>2051078519</SellerId><SendTime>2013-06-02 10:28:42</SendTime><Status>100</Status><ErrorMessage><![CDATA[]]></ErrorMessage></Header>    <Response><Order><TBOrderId>3376311089148</TBOrderId><Premium>530000</Premium><PayNo>3376311089148</PayNo><SubOrderList><SubOrder type=\"biz\"><TBOrderId>3376311089149</TBOrderId><ItemId>92156550730007</ItemId><Premium>500000</Premium><ProposalNo>8828900000144888</ProposalNo></SubOrder><SubOrder type=\"force\"><TBOrderId>3376311089139</TBOrderId><ItemId>92156550730007</ItemId><Premium>30000</Premium><ProposalNo>8828900000144888</ProposalNo> </SubOrder></SubOrderList></Order></Response><Sign><![CDATA[b8dYyA4a_pIdkXU5HHhcuTI5vlV-SsE_Nv5CDTki0ZwDPfxTc9RuCCwgwJBqS5lQw8ZLsBlCxaRg-YhTSFiNpzqLA4H928JbPbwlxINpOOsrigR84FkoUB2GxYMTY7sZNH4Yy-I5A2Zu0W6pDe5U6blGa3ZwHVkZsdYDA2e5Mts]]></Sign></Package></PackageList>", 0, 0);
		System.out.println(result);
	}

}
