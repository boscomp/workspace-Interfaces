package app.mongo;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoSession {
	private static String USER = "ceuadmin";
	private static String PASS = "ceuadmin";
	private static String SERVER = "cluster0.fafezuh.mongodb.net";
	private static String DATABASE = "appInterface";
	private static MongoDatabase database;

	public static MongoClient getMongoClient() {
		String connectionString = "mongodb+srv://"+USER+":"+PASS+"@" + SERVER + "/?retryWrites=true&w=majority";
		ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString)).serverApi(serverApi).build();
		// Create a new client and connect to the server
		MongoClient mongoClient = MongoClients.create(settings);

		// Send a ping to confirm a successful connection
		database = mongoClient.getDatabase("admin");
		database.runCommand(new Document("ping", 1));
		System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
		return mongoClient;
	}
	
}
