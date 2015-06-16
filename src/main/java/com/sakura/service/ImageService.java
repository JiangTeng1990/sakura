package com.sakura.service;

import com.sakura.entity.Image;

public interface ImageService {

	void save(Image image);
	
	Image view(Long id);

}
