package com.sakura.dao;

import com.sakura.entity.Image;

public interface ImageDao {

	void save(Image image);

	Image view(Long id);

}
