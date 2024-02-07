package app.gui;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.mongo.MongoSession;

public class Launcher {
	public static void main(String[] args) {
		App.main(args);

//		Bson filtro =Filters.and(Filters.regex("HomeTeam", ".*Val.*"), Filters.eq("AwayTeam", "Real Betis"), Filters.eq("Season", "2019/2020"));
		// Bson filtro =Filters.and(Filters.regex("HomeTeam", ".*Val.*"),
		// Filters.eq("AwayTeam", "Real Betis"), Filters.gt("AR", 0));

	}
}
