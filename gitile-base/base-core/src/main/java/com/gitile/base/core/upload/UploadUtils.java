package com.gitile.base.core.upload;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.gitile.base.utils.file.FileUtils;
import com.gitile.base.utils.lang.DateUtils;

/**
 * 文件操作工具类
 *
 */
public class UploadUtils {

	/**
	 * 文件上传(单个)
	 * 
	 * @param uploadPath
	 * @param myFile
	 * @param subPath
	 * @param id
	 * @return
	 */
	public static String uploadImgFile(String uploadPath, String subPath, MultipartFile myFile, Long id) {
		String filePath = null;
		String realUploadPath = uploadPath + "/" + subPath;
		File uploadPathFile = new File(realUploadPath);
		if (!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		if (null != myFile && !myFile.isEmpty()) {
			try {
				String fileName = myFile.getOriginalFilename();
				String saveFileName = fileName.subSequence(0,
						fileName.lastIndexOf("."))
						+ "_"
						+ DateUtils.dateToString(new Date(), 3)
						+ new Random().nextInt(100)
						+ id.toString()
						+ fileName.substring(fileName.lastIndexOf("."));
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myFile.getInputStream(),
						new File(realUploadPath, saveFileName));
				filePath = subPath + "/" + saveFileName;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
}
