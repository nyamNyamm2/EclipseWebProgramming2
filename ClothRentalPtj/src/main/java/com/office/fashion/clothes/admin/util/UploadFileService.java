package com.office.fashion.clothes.admin.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

	public String upload(MultipartFile file) {
			
		boolean result = false;
		
		// File 저장
		String fileOriName = file.getOriginalFilename();
		String fileExtension = 
				fileOriName.substring(fileOriName.lastIndexOf("."), fileOriName.length());
		String uploadDir = "C:\\fasion\\upload\\";
		
		UUID uuid = UUID.randomUUID();
		String uniqueName = uuid.toString().replaceAll("-", "");
		
		File saveFile = new File(uploadDir + "\\" + uniqueName + fileExtension);
		
		if (!saveFile.exists())
			saveFile.mkdirs();
		
		try {
			file.transferTo(saveFile);
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if (result) {
			System.out.println("[UploadFileService] 파일 업로드 성공");
			return uniqueName + fileExtension;
			
		} else {
			System.out.println("[UploadFileService] 파일 업로드 실패");
			return null;
			
		}
		
		
	}
	
}
