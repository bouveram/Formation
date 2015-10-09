package com.m2i.formation.media;

//Une class Abstract ne peut heriter que d'une classe abstract
public abstract class Item implements IItem {

	private double price;
	private int id;
	private String name;
	
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#getPrice()
	 */
	@Override
	public double getPrice() {
		return price;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#setPrice(double)
	 */
	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.IItem#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	
}
