package com.mongo;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * @author Farrukh
 *
 */

public class Mongo_Insert_Find_1 {

	public static void main(String[] args) {
		MongoClient mongo = new MongoClient();
		MongoDatabase db = mongo.getDatabase("mongojava");
		MongoCollection<Document> mongocollection = db.getCollection("mongocollection");
		
		Document person = new Document("name","Lee")
				.append("age", 30)
				.append("address", new Document("house",21).append("road", 03).append("sector", "Uttara 12"));
		
		mongocollection.insertOne(person);  // Inserting single document
		
		Document farrukh = new Document("name","Farrukh")
				.append("age", 30)
				.append("address", new Document("house",21).append("road", 03).append("sector", "Uttara 12"));
		
		Document jason = new Document("name","Jason")
				.append("age", 30)
				.append("address", new Document("house",21).append("road", 03).append("sector", "Uttara 12"));
		
		mongocollection.insertMany(asList(farrukh,jason));  // Inserting many documents as list
		
		
		Document firstPeople = mongocollection.find().first(); // get one document from DB
		System.out.println(firstPeople);
		
		
		List<Document> peoples = mongocollection.find().into(new ArrayList<Document>()); // get all documents from DB
		
		for( Document people: peoples)
		{
			System.out.println(people);
		}
		
		
		mongo.close();
		
		
	}

}
