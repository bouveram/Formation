package com.m2i.formation.media.entities;
import java.util.ArrayList;
import java.util.List;

/**
 * Class gérant un panier
 * @author adminlocal
 *
 */
public class Cart implements IEntity {

	private List<Media> medias = new ArrayList<Media>();
	private int id;
	
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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
