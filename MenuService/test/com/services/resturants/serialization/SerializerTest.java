package com.services.resturants.serialization;

import org.junit.Assert;
import org.junit.Test;

import com.services.resturants.domain.MenuItem;

public class SerializerTest {

	@Test
	public void serializeToJSONTest() {
		MenuItem myItem = new MenuItem();
		myItem.setItemDescription("Sounds Good!");
		myItem.setItemName("A Name");
		myItem.setItemPrice(12.22);
		
		String returnVal = Serializer.serializeToJSON(myItem);
		
		System.out.println(returnVal);
		
	}
	
	@Test
	public void serializeFromJsonTest() {
		MenuItem myItem = new MenuItem();
		myItem.setItemDescription("Sounds Good!");
		myItem.setItemName("A Name");
		myItem.setItemPrice(12.22);
		
		String returnVal = Serializer.serializeToJSON(myItem);
		System.out.println(returnVal);
		
		MenuItem retItem = (MenuItem) Serializer.serializeFromJson(returnVal, MenuItem.class);
		
		System.out.println(retItem.getItemDescription());
		System.out.println(retItem.getItemName());
		System.out.println(retItem.getItemPrice());
		
		Assert.assertEquals(myItem.getItemName(), retItem.getItemName());
		Assert.assertEquals(myItem.getItemDescription(), retItem.getItemDescription());
		Assert.assertEquals(myItem.getItemPrice(), retItem.getItemPrice());
	}

}
