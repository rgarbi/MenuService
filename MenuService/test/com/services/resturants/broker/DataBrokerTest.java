package com.services.resturants.broker;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.services.resturants.domain.MenuItem;
import com.services.resturants.test.BaseTest;

public class DataBrokerTest extends BaseTest {
	
	@After
	public void cleanUp() {
		super.cleanUp();
	}

	@Test
	public void storeDomainObjectTest() {
		MenuItem domainObj = new MenuItem();
		domainObj.setItemDescription("Sounds good!");
		domainObj.setItemName("Some Food");
		domainObj.setItemPrice(9.99);
		
		DataBroker.storeDomainObject(domainObj);
		
		allCreatedIds.add(domainObj.getId());
		System.out.println(domainObj.getId());
		
	}
	
	@Test
	public void getDomainObjectTest() {
		MenuItem domainObj = new MenuItem();
		domainObj.setItemDescription("Sounds good!");
		domainObj.setItemName("Some Food");
		domainObj.setItemPrice(9.99);
		DataBroker.storeDomainObject(domainObj);
		allCreatedIds.add(domainObj.getId());
		System.out.println(domainObj.getId());
		
		MenuItem myFoundItem = (MenuItem) DataBroker.getDomainObject(MenuItem.class, "itemName", "Some Food");
		
		System.out.println(myFoundItem.getItemName());
		System.out.println(myFoundItem.getItemPrice());	
	}
	
	@Test
	public void getAllDomainObjectsTest() {
		MenuItem domainObj = new MenuItem();
		domainObj.setItemDescription("Sounds good!");
		domainObj.setItemName("Some Food");
		domainObj.setItemPrice(9.99);
		DataBroker.storeDomainObject(domainObj);
		System.out.println(domainObj.getId());
		allCreatedIds.add(domainObj.getId());
		
		List<MenuItem> allItems = DataBroker.getAllDomainObjects(MenuItem.class);
		System.out.println(allItems.size());
		
		for(MenuItem mi : allItems){
			System.out.println(mi.getItemDescription());
			System.out.println(mi.getItemName());
			System.out.println(mi.getItemPrice());
			System.out.println(mi.getId());
		}
		
	}
	
	@Test
	public void deleteDomainObjectTest() {
		MenuItem domainObj = new MenuItem();
		domainObj.setItemDescription("Sounds good!");
		domainObj.setItemName("Some Food");
		domainObj.setItemPrice(9.99);
		DataBroker.storeDomainObject(domainObj);
		System.out.println(domainObj.getId());
		
		List<MenuItem> allItems = DataBroker.getAllDomainObjects(MenuItem.class);
		System.out.println(allItems.size());
		
		DataBroker.deleteDomainObject(MenuItem.class, "itemName", "Some Food");
		
		allItems = DataBroker.getAllDomainObjects(MenuItem.class);
		System.out.println(allItems.size());	
	}
	
	@Test
	public void updateDomainObjectTest() {
		MenuItem domainObj = new MenuItem();
		domainObj.setItemDescription("Sounds good!");
		domainObj.setItemName("Some Food");
		domainObj.setItemPrice(9.99);
		DataBroker.storeDomainObject(domainObj);
		System.out.println(domainObj.getId());
		allCreatedIds.add(domainObj.getId());
		DataBroker.updateDomainObject(MenuItem.class, "itemName", "Some better food name", domainObj.getId());
		
		MenuItem updated = (MenuItem) DataBroker.getDomainObject(MenuItem.class, "itemName", "Some better food name");
		allCreatedIds.add(updated.getId());
		Assert.assertEquals("Some better food name", updated.getItemName());

		
	}
	
	
	
	

}
