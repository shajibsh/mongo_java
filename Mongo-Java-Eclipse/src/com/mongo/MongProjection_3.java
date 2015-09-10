package com.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongProjection_3 {
	
	public static void main(String[] args) {
		MongoClient mongo = new MongoClient();
		MongoDatabase db = mongo.getDatabase("mongojava");
		MongoCollection<Document> mongocollection = db.getCollection("mongocollection");
		
		
		//Bson nameFilter = Filters.eq("name", "Lee"); // With filer class
		Bson nameFilter = Filters.and(Filters.eq("name", "Farrukh"),Filters.gt("age", 29)); // multiple conditions
		
		
		Bson projection = new Document("age",0);
		
		
				
		List<Document> peoples = mongocollection.find(nameFilter)
												.projection(projection)
												.into(new ArrayList<Document>());
		
		
		
		System.out.println(mongocollection.count(nameFilter));  // See how many docs matched
		
		for(Document people : peoples) // Iterate all the docs 
		{
			System.out.println(people);
		}
		
		mongo.close();
		
	}
		

}



