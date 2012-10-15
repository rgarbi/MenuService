package com.services.resturants.database;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.services.resturants.domain.MenuItem;

public class DBConnectionManager {
	
	
	private static String mongoHost = "localhost";
	private static int mongoPort = 27017;
	private static Mongo myMongoConn = null;
	private static String dbName = "resturantDB";
	
	private static Morphia morphia = null;
	private static Datastore ds = null;
	
	public static Datastore getDbConnection() {
		
		if(myMongoConn == null){
			try
			{
				myMongoConn = new Mongo( mongoHost , mongoPort );
				myMongoConn.setWriteConcern(WriteConcern.SAFE);
				
				morphia = new Morphia();
				morphia.map(MenuItem.class);
				
				ds = morphia.createDatastore(myMongoConn, dbName);
				ds.ensureIndexes();
				
				return ds;
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return ds;
		}
	}

}
