package com.services.resturants.broker;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;
import com.services.resturants.database.DBConnectionManager;

public class DataBroker {
	
	public static boolean storeDomainObject(Object domainObj){
		
		Datastore dbConn = DBConnectionManager.getDbConnection();
		
		dbConn.save(domainObj);
		
		return true;
	}
	
	public static <T> List<T> getAllDomainObjects(Class<T> clazz) {
		Datastore dbConn = DBConnectionManager.getDbConnection();
		
		List<T> allObjects = dbConn.find(clazz).asList();
		
		return allObjects;
		
	}
	
	public static <T> Object getDomainObject(Class<T> clazz, String fieldToSearch, String searchValue){
		
		Datastore dbConn = DBConnectionManager.getDbConnection();
		
		return (clazz.cast(dbConn.find(clazz, fieldToSearch, searchValue).get()));
		
	}
	
	public static <T> Object getDomainObjectById(Class<T> clazz, String objectId){
		
		Datastore dbConn = DBConnectionManager.getDbConnection();
		
		return (clazz.cast(dbConn.find(clazz, Mapper.ID_KEY, new ObjectId(objectId)).get()));
		
	}
	
	public static boolean deleteDomainObject(Class<?> clazz, String field, Object criteria){
		Datastore dbConn = DBConnectionManager.getDbConnection();
		dbConn.delete(dbConn.createQuery(clazz).filter(field, criteria));
		
		return true;
	}
	
	/**
	 * In order to update you must first get the object out of the DB. You will need the ID to update.
	 * @param clazz - The class of the Domain Object you are updating
	 * @param fieldToUpdate - The field you wish to update on the Domain Object
	 * @param value - The value you wish to set
	 * @param domainUid - The UID of the object!
	 * @return Did the update succeed?
	 */
	public static <T> boolean updateDomainObject(Class<T> clazz, String fieldToUpdate, String value, ObjectId domainUid) {
		Datastore dbConn = DBConnectionManager.getDbConnection();
		UpdateOperations<T> ops;
		
		Query<T> updateQuery = dbConn.createQuery(clazz).field(Mapper.ID_KEY).equal(domainUid);
		ops = dbConn.createUpdateOperations(clazz).set(fieldToUpdate, value);
		dbConn.update(updateQuery, ops);
		return true;
	}
	
	
}
