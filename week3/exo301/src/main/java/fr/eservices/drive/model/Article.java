package fr.eservices.drive.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Article {
	
	private long id;
	private char[] ean13;
	private int price;
	private double vat;
	private String name;
	private String img;
	@ManyToMany
	private List<Category> categories;

	@Id
	@GeneratedValue
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public char[] getEan13() {
		return ean13;
	}
	public void setEan13(char[] ean13) {
		this.ean13 = ean13;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
