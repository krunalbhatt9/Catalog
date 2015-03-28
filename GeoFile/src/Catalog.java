import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Catalog extends JFrame {
public Catalog() {
	   setTitle("Janagrah");
	   setSize(600,400);
	   setLocationRelativeTo(null);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   JButton button1 = new JButton("button1");
       button1.addActionListener(this);
       add(button1);

	    }

public static void main(String[] args) {
Catalog ex = new Catalog();
ex.setVisible(true);

String title=null;
String desc=null;
String add=null;
double lat=0.0,lon=0.0;

		 try{   
			 // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "Catalog" );
			 System.out.println("Connect to database successfully");
			 DBCollection coll = db.createCollection("27032015", new BasicDBObject());
	         System.out.println("Collection created successfully");
	         
	         BasicDBObject doc = new BasicDBObject("title", title).
	                 append("description", desc).
	                 append("latitude",lat).
	                 append("longitude",lon).
	                 append("address",add);
	       
	      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
	}

}
