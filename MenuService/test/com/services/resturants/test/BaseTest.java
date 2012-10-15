package com.services.resturants.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;


import com.google.code.morphia.mapping.Mapper;
import com.services.resturants.broker.DataBroker;
import com.services.resturants.domain.MenuItem;

public class BaseTest {
	
	protected List<ObjectId> allCreatedIds = new ArrayList<ObjectId>();
	
	public void cleanUp() {
		
		System.out.println("Number of Objects to clean up ->" + allCreatedIds.size());
		
		for(ObjectId id : allCreatedIds) {
			DataBroker.deleteDomainObject(MenuItem.class, Mapper.ID_KEY, id);
		}
		
		List<MenuItem> allItems = DataBroker.getAllDomainObjects(MenuItem.class);
		System.out.println(allItems.size());
	}

}
