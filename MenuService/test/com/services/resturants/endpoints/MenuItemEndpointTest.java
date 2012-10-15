package com.services.resturants.endpoints;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.services.resturants.broker.DataBroker;
import com.services.resturants.domain.MenuItem;
import com.services.resturants.test.BaseTest;

public class MenuItemEndpointTest extends BaseTest {
	
	@After
	public void cleanUp() {
		super.cleanUp();
	}

	@Test
	public void getAllMenuItemsTest() {
		
		MenuItem newItem = new MenuItem();
		newItem.setItemDescription("A Description");
		newItem.setItemName("A name");
		newItem.setItemPrice(9999.99);
		
		DataBroker.storeDomainObject(newItem);
		super.allCreatedIds.add(newItem.getId());
		
		MenuItemEndpoint menuItem = new MenuItemEndpoint();
		String json = menuItem.getAllMenuItems();
		
		System.out.println(json);
		
		Assert.assertEquals("", json);
	}
	
	@Test
	public void postItemTest(){
		String json = "{\"itemName\":\"A name\",\"itemDescription\":\"A Description\",\"itemPrice\":9999.99}";
		
		MenuItemEndpoint menuItem = new MenuItemEndpoint();
		String id = menuItem.postMenuItem(json);
		
		System.out.println(id);
		
		ObjectId objId = new ObjectId(id);
		super.allCreatedIds.add(objId);
		
	}

}
