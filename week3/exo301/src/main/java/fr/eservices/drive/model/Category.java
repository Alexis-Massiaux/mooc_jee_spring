package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	private long id;
	private String name;
	private int orderIdx;
	
	@Id
	@GeneratedValue
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public int getOrderIdx() {
		return this.orderIdx;
	}
	public void setOrderIxd(int orderIdx) {
		this.orderIdx = orderIdx;
	}

}
