package br.org.servlet.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import br.org.servlet.model.Empresa;



public class EmpresaDAO {
	
	private static MongoCollection<Document> collection;
	private static int mumeroSequencial = 1;

	static {
		new ConnMongo();
		collection = ConnMongo.getConnection().getCollection("empresa");
	}

	public static void add(Empresa empresa) {

		empresa.setId(collection.count() + 1);
		Gson gson = new Gson();
		String json = gson.toJson(empresa);

		Document document = new Document().parse(json);
		collection.insertOne(document);
		//ConnMongo.closeDB();

	}

	public static List<Empresa> list() {

		FindIterable<Document> cursor = collection.find();
		// Getting the iterator
		Iterator iterator = cursor.iterator();

		List<Empresa> empresas = new ArrayList<Empresa>();
		
		while (iterator.hasNext()) {
			Document document = (org.bson.Document) iterator.next();
			Gson gson = new Gson();
           
			Empresa empresa = new Empresa(); 
			empresa = gson.fromJson(document.toJson(), Empresa.class);
            empresas.add(empresa); 
			
			//System.out.println(fromJson);
		}
		//ConnMongo.closeDB();
		return empresas;
		

	}

	public static void del(Long id) {

		collection.deleteOne(Filters.eq("id", id));
		System.out.println("Document deleted successfully...");
		//ConnMongo.closeDB();

	}

	public void findById(Long id) {
		BasicDBObject query = new BasicDBObject("id", id);

		FindIterable<Document> iterDoc = collection.find(query);
		// Getting the iterator
		Iterator iterator = iterDoc.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		//ConnMongo.closeDB();
	}
	

}
