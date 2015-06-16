package com.sakura.service;

import com.sakura.dao.ImageDao;
import com.sakura.entity.Image;

public class ImageServiceImpl implements ImageService {
	
	private ImageDao imageDao;

	
	/**
	 * @param imageDao the imageDao to set
	 */
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}


	public void save(Image image) {
		imageDao.save(image);
	}


	public Image view(Long id) {
		return imageDao.view(id);
	}
	
}
