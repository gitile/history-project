package com.gitile.chinalife;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import com.gitile.chinalife.utils.StringUtils;

public class ExcelTest {
	
	public   static   void  main(String args[])  {
        try {
            // 打开文件
           Workbook book  =  Workbook.getWorkbook(new File("D:\\dinglikeji\\gitile-chinalife\\src\\test\\resources\\car.xls"));
           // 获得第一个工作表对象
          Sheet sheet  =  book.getSheet( 0 );
          int rows = sheet.getRows();//行  
          for(int i = 1; i < rows; i++){
        	  // 车牌号码
        	  String carNo = sheet.getCell(9, i).getContents().trim();
        	  // 车主
        	  String ownerName = sheet.getCell(6, i).getContents().trim();
        	  // 身份证号
        	  String idNo = sheet.getCell(4, i).getContents().trim();
        	  // 登记日期
        	  String djDate = sheet.getCell(5, i).getContents().trim();
        	  // 品牌型号
        	  String pinpai = sheet.getCell(10, i).getContents().trim();
        	  String xinghao = sheet.getCell(7, i).getContents().trim();
        	  // 发动机型号
        	  String fadongji = sheet.getCell(1, i).getContents().trim()+sheet.getCell(2, i).getContents().trim();
        	  // 车架号
        	  String chejia = sheet.getCell(3, i).getContents().trim();
        	  // 电话
        	  String mobile = sheet.getCell(12, i).getContents().trim(); 
        	  buildSql(carNo, ownerName, idNo, djDate, pinpai+xinghao, fadongji, chejia, mobile);
          }
          book.close();
       }   catch  (Exception e)  {
           e.printStackTrace();
       }
   }

	private static void buildSql(String carNo, String ownerName, String idNo,
			String djDate, String pinpaixinghao, String fadongji, String chejia,
			String mobile) {
		// 登记日期处理
		if(StringUtils.isNotEmpty(djDate)) {
			djDate = djDate.substring(0, 10);
		}
		String sql = "insert INTO car_vehicleinfo("
				+ "uid,license_no,vehicle_code,vehicle_frame_no,engine_no,first_register_date,run_card_certificate_date,"
				+ "owner_name,owner_id_no,owner_mobile,owner_email,delete_state,created_time) values ("
				+"10,'"+carNo+"','"+pinpaixinghao+"','"+chejia+"','"+fadongji+"','"+djDate+"','"+djDate+"','"
				+ownerName+"','"+idNo+"','"+mobile+"','xtotly@gmail.com', 0, now()"
				+ ");";
		System.out.println(sql);
	}

}
