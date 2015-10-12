package com.m2i.formation.media;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Media> medias = new ArrayList<Media>();
	
	public List<Media> getMedias() {
		return medias;
	}
	
	public double getVATPrice() {
		double price = 0.0;
		for(Media m : medias){
			price += m.getVATPrice();
		}
		return price;
	}
	
}
