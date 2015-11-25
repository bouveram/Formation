package com.m2i.formation.repositories;

import java.util.List;

import com.m2i.formation.media.entities.Media;

public class MediaRepository extends AbstractRepository<Media> {
	
	public List<Media> getByPrice(double price){
		return super.getByJPQL("select e from Media e where e.price <= " + price);
	}
	
	public List<Media> getByTitle(String title){
		return super.getByWhere("e.title = " + title);
	}
	
}
