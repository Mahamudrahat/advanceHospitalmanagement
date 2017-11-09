package application;


import java.sql.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
public  class bangla extends Application{
	Button b=new Button("এ");
	TextField t=new TextField();
	Connection connection;
	Statement statement;

	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/cse?useUnicode=yes&characterEncoding=UTF-8";
	public void start(Stage stage) {
		initializeDB();
		Pane pane=new Pane();
		pane.setPrefSize(300, 500);
		t.relocate(40, 50);
		b.relocate(210, 50);
	     
		Font banglaFont=new Font("Siyam Rupali ANSI.ttf",12);
		b.setFont(banglaFont);
		pane.getChildren().addAll(t,b);
		//pane.getChildren().add(b);
		b.setOnAction(e->{
			two t=new two();
			t.two();
		});
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		stage.show();

	
	}
private void initializeDB() {
		// TODO Auto-generated method stub
	try{
	
		Class.forName(JDBC_DRIVER);
		connection=DriverManager.getConnection(DB_URL,"root","");
		System.out.println("Successfully connected");
		statement=connection.createStatement();
		//Class.forName("com.mysql.jdbc.Driver");
		//connection=DriverManager.getConnection("jdbc:mysql://localhost/desease1"," ","");
	   //statement=connection.createStatement();		
}
catch(Exception ex){
	ex.printStackTrace();
	}
	
	}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	launch(args);

}
public class two extends Button{
	Label l=new Label("Disease Name: ");
	public void two(){
		initializeDB();
		Pane pane=new Pane();
		pane.setPrefSize(200, 300);
		pane.getChildren().add(l);
		Stage stage=new Stage();
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		stage.show();
		try{
		String sql1="SELECT student.name FROM student where dept='"+t.getText()+"'";
		ResultSet rs=statement.executeQuery(sql1);
		System.out.println(" your desease :   ");
		if(rs.next()){
			//String name=rs.getString(1);
		
			l.setText(rs.getString(1));
		}

		rs.close();
		}catch(SQLException se){
			//Handle error for jdbc
			se.printStackTrace();
		} 
}

	}
}
