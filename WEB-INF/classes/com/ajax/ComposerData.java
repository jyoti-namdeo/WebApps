package com.ajax;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

public class ComposerData {
    
    private HashMap composers = new HashMap();
    

    public HashMap getComposers() {
        return composers;
    }
    
    public ComposerData() {
		//Pizza
		try{
		MongoClient mongo = new MongoClient("localhost", 27017);
						// if database doesn't exists, MongoDB will create it for you
						DB db = mongo.getDB("PizzaParty");
						DBCollection myReviews = db.getCollection("Pizza");
						DBCursor cursor = myReviews.find();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				int id = obj.getInt("id"); 
				String idMap = String.valueOf(id);
				String name = obj.getString("name"); 
				String desc = obj.getString("desc"); 
				String imageSrc = obj.getString("image");
				int price = obj.getInt("price");
				String priceMap = String.valueOf(price);
				composers.put(idMap, new Composer(idMap, name, priceMap, desc));		
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		//Bread
			try{
		MongoClient mongo = new MongoClient("localhost", 27017);
						// if database doesn't exists, MongoDB will create it for you
						DB db = mongo.getDB("PizzaParty");
						DBCollection myReviews = db.getCollection("Bread");
						DBCursor cursor = myReviews.find();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				int id = obj.getInt("id"); 
				String idMap = String.valueOf(id);
				String name = obj.getString("name"); 
				String desc = obj.getString("desc"); 
				String imageSrc = obj.getString("image");
				int price = obj.getInt("price");
				String priceMap = String.valueOf(price);
				composers.put(idMap, new Composer(idMap, name, priceMap, desc));		
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//Deserts
			try{
		MongoClient mongo = new MongoClient("localhost", 27017);
						// if database doesn't exists, MongoDB will create it for you
						DB db = mongo.getDB("PizzaParty");
						DBCollection myReviews = db.getCollection("Deserts");
						DBCursor cursor = myReviews.find();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				int id = obj.getInt("id"); 
				String idMap = String.valueOf(id);
				String name = obj.getString("name"); 
				String desc = obj.getString("desc"); 
				String imageSrc = obj.getString("image");
				int price = obj.getInt("price");
				String priceMap = String.valueOf(price);
				composers.put(idMap, new Composer(idMap, name, priceMap, desc));		
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Drinks
			try{
		MongoClient mongo = new MongoClient("localhost", 27017);
						// if database doesn't exists, MongoDB will create it for you
						DB db = mongo.getDB("PizzaParty");
						DBCollection myReviews = db.getCollection("Drinks");
						DBCursor cursor = myReviews.find();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				int id = obj.getInt("id"); 
				String idMap = String.valueOf(id);
				String name = obj.getString("name"); 
				String desc = obj.getString("desc"); 
				String imageSrc = obj.getString("image");
				int price = obj.getInt("price");
				String priceMap = String.valueOf(price);
				composers.put(idMap, new Composer(idMap, name, priceMap, desc));		
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
      
    }

}
