package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Combobox extends Application {
	int i=1;
     ComboBox<String> cb1=new ComboBox();
     ComboBox<String> cb2=new ComboBox();
     Pane pane=new Pane();
     String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/desease1";	
			Connection conn=null;
			Statement stmt=null;
     public void start(Stage stage){
    	 cb1.relocate(200, 200);
    	 cb1.setPrefSize(80, 20);
    	 cb2.relocate(200, 300);
    	 cb2.setPrefSize(80, 20);
    	 pane.setPrefSize(600, 600);
   // cb1.getItems().addAll("A","B","C","D","E");
   // cb2.getItems().addAll("f","g","h");
	try{
		Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(DB_URL,"root","");
		System.out.println("Successfully connected");
		stmt=conn.createStatement();
		String query="select DISTINCT  symptom2 from firsttb ";
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()){
			
			String s=rset.getString(i);
			cb1.getItems().addAll(s);
			cb2.getItems().addAll(s);
		}i++;
	}catch(Exception e){
		
		e.printStackTrace();
	}
    		Scene scene=new Scene(pane);
    		stage.setScene(scene);
    		stage.show();
    		pane.getChildren().addAll(cb1,cb2);
     }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
