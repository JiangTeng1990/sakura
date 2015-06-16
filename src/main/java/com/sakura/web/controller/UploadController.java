package com.sakura.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sakura.entity.Image;
import com.sakura.service.ImageService;

@Controller
public class UploadController {
	
	private String upload_path = "/pictures/";
	private String download_path = "pictures/";

	@Autowired
	private ImageService imageService;
	
	/**
	 * Prepare to upload file
	 * @return
	 */
	@RequestMapping("/upload-image")
	public ModelAndView upload() {
		ModelAndView modelAndView = new ModelAndView("upload/upload-file");
		
		return modelAndView;
	}
	
	/**
	 * Do upload a file
	 * @return
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value = "/upload-image", method = RequestMethod.POST)
	public ModelAndView onUpload(HttpServletRequest request, @RequestParam(value = "filea") MultipartFile file) throws IOException, NoSuchAlgorithmException {
		ModelAndView modelAndView = new ModelAndView("upload/upload-file");
		
		String originName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		String filePath = upload_path + generateFilePath();
		String fileName = generateFileName(originName);
		writeFile(bytes, filePath, fileName);
		
		Image image = new Image(originName, fileName, filePath);
		imageService.save(image);
		modelAndView.addObject("message", "Ìí¼Ó³É¹¦");
		return modelAndView;
	}
	
	@RequestMapping("/download-images/{id}")
	public ModelAndView download(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("download/view-image");
		Image image = imageService.view(id);
		modelAndView.addObject("image", image);
		return modelAndView;
	}
	
	
	
	public String generateFilePath() {
		char[] dirs = {'p', 'i', 'c', 't', 'u', 'r', 'e', 's'};
		Random random = new Random();
		return dirs[random.nextInt(8)] + "/" + dirs[random.nextInt(8)] + "/";
	}
	
	public String generateFileName(String oldName) throws NoSuchAlgorithmException {
		String newName = "";
		MessageDigest MD5 = MessageDigest.getInstance("MD5");
		byte[] bytes = MD5.digest(oldName.getBytes());
		return newName + System.currentTimeMillis() + bytes.hashCode() + oldName.substring(oldName.lastIndexOf("."));
	}
	
	public void writeFile(byte[] bytes, String filePath, String fileName) throws IOException {
		if(!new File("webapp" + filePath).exists()) {
			new File("webapp" + filePath).mkdirs();
		}
		
		FileOutputStream out = new FileOutputStream(new File("webapp" + filePath + fileName));
		out.write(bytes);
		out.flush();
		out.close();
	}
	
}
