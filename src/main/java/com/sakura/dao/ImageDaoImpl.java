package com.sakura.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sakura.entity.Image;

public class ImageDaoImpl implements ImageDao {
	
	private HibernateTemplate hibernateTemplate;

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Image image) {
		hibernateTemplate.save(image);
	}

	public Image view(Long id) {
		return hibernateTemplate.get(Image.class, id);
	}
	
}
