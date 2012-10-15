package com.services.resturants.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;

@Entity(value="MenuItem", noClassnameStored=true)
public class MenuItem {
	
	@Id
    private ObjectId id;
	
	
	//To make this field unique use the following annotation.
	//@Indexed(value=IndexDirection.ASC, unique=true, dropDups=true)
	@Indexed
	private String itemName = "";
	
	private String itemDescription = "";
	private Double itemPrice = 0.00;
	
	public MenuItem() {
		//Default empty constructors
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public ObjectId getId() {
		return id;
	}


}
