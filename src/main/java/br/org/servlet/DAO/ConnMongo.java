package br.org.servlet.DAO;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnMongo {
	
	private static MongoClient mongoClient = null;

	public static MongoDatabase getConnection() {
		
		
		MongoDatabase mongoDatabase = null;
		try {
			MongoClientURI connectionString = new MongoClientURI(
				"mongodb+srv://asampaio:as132476@cluster0-og6yt.mongodb.net/MongoDb?retryWrites=true");
		mongoClient = new MongoClient(connectionString);		
		mongoDatabase = mongoClient.getDatabase("MongoDb");
		
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return mongoDatabase;
	}	
	
	public static void closeDB() {

		mongoClient.close();

	}

}
