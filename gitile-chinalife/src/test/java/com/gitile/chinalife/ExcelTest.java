package com.gitile.chinalife;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import com.gitile.chinalife.utils.StringUtils;

public class ExcelTest {
	
	public   static   void  main(String args[])  {
        try {
            // ���ļ�
           Workbook book  =  Workbook.getWorkbook(new File("D:\\dinglikeji\\gitile-chinalife\\src\\test\\resources\\car.xls"));
           // ��õ�һ�����������
          Sheet sheet  =  book.getSheet( 0 );
          int rows = sheet.getRows();//��  
          for(int i = 1; i < rows; i++){
        	  // ���ƺ���
        	  String carNo = sheet.getCell(9, i).getContents().trim();
        	  // ����
        	  String ownerName = sheet.getCell(6, i).getContents().trim();
        	  // ���֤��
        	  String idNo = sheet.getCell(4, i).getContents().trim();
        	  // �Ǽ�����
        	  String djDate = sheet.getCell(5, i).getContents().trim();
        	  // Ʒ���ͺ�
        	  String pinpai = sheet.getCell(10, i).getContents().trim();
        	  String xinghao = sheet.getCell(7, i).getContents().trim();
        	  // �������ͺ�
        	  String fadongji = sheet.getCell(1, i).getContents().trim()+sheet.getCell(2, i).getContents().trim();
        	  // ���ܺ�
        	  String chejia = sheet.getCell(3, i).getContents().trim();
        	  // �绰
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
		// �Ǽ����ڴ���
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
