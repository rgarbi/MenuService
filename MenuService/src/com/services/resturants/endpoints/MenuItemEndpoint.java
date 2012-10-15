package com.services.resturants.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.services.resturants.broker.DataBroker;
import com.services.resturants.domain.MenuItem;
import com.services.resturants.serialization.Serializer;

@Path("/menuitem")
public class MenuItemEndpoint {
	
	@GET
	@Produces("text/json")
	public String getAllMenuItems(){
		List<MenuItem> menuItems = DataBroker.getAllDomainObjects(MenuItem.class);
		return Serializer.serializeToJSON(menuItems);
	}
	
	@POST
	@Produces("text/json")
	@Consumes("text/json")
	public String postMenuItem(String json) {
		MenuItem createItem = (MenuItem) Serializer.serializeFromJson(json, MenuItem.class);
		DataBroker.storeDomainObject(createItem);
		
		return createItem.getId().toString();
		
	}
}
