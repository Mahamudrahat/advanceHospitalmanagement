package application;

import java.sql.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Array1 extends Button{
	Button b=new Button("Next");
	Button b2=new Button("Next");
	Button b3=new Button("Next");
	Button b4=new Button("Next");
	Button b5=new Button("Next");
	Button b6=new Button("Next");
	TextField t=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	TextField t4=new TextField();
	TextField t5=new TextField();
	TextField t6=new TextField();
	Connection connection;
	Statement statement;
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/desease1";	
	 public void JDBC(){
	//public void start(Stage stage) {
		initializeDB();
		Pane pane=new Pane();
		Scene scene=new Scene(pane,850,650);
		//pane.setPrefSize(300, 500);
		pane.getChildren().addAll(t,b);
		t.relocate(40, 50);
		b.relocate(210, 50);
		t2.relocate(40, 100);
		b2.relocate(210, 100);
		t3.relocate(40, 150);
		b3.relocate(210, 150);
		t4.relocate(40, 200);
		b4.relocate(210, 200);
		t5.relocate(40, 250);
		b5.relocate(210, 250);
		t6.relocate(40, 300);
		b6.relocate(210, 300);
		//Scene scene=new Scene(pane);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
		b.setOnAction(e ->{
			if(t.getText().equals("no")){
				System.exit(0);
			}else{
				b.setDisable(true);
				pane.getChildren().addAll(t2,b2);
				b2.setOnAction(ex ->{
					if(t2.getText().equals("no")){
						System.exit(0);
					}else{
						b2.setDisable(true);
						pane.getChildren().addAll(t3,b3);
						b3.setOnAction(ey ->{
							if(t3.getText().equals("no")){
								two t=new two();
								t.two();
								System.out.print("go to two");
							}else{
								b3.setDisable(true);
								pane.getChildren().addAll(t4,b4);
								b4.setOnAction(ez ->{
									if(t4.getText().equals("no")){
										
										three t1=new three();
										t1.three();

										//System.exit(0);
									}
									else{
										b4.setDisable(true);
										pane.getChildren().addAll(t5,b5);
										b5.setOnAction(ez1 ->{
											if(t5.getText().equals("no")){
												
												four t2=new four();
												t2.four();

												//System.exit(0);
											}
											else{
												b5.setDisable(true);
											//	pane.getChildren().addAll(t6,b6);
												//if(t6.getText().equals("no")){
													//System.exit(0);
												//}
											}
										});
									}
								});
							}
						});
					}
				});
			}
		});
		
	}

	public void initializeDB() {
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

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}*/
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
				String sql="SELECT firsttb.Desease FROM firsttb WHERE (symptom1='"+t.getText()+"' OR symptom1='"+t2.getText()+"' ) AND (symptom2='"+t.getText()+"' OR symptom2='"+t2.getText()+"' ) AND (symptom3='"+t3.getText()+"') ";
				ResultSet rset=statement.executeQuery(sql);
				while(rset.next()){
					l.setText(rset.getString(1));
					//System.out.println("Disease Name : "+s);
				}
			}catch(Exception e){
				
			}
		}
	}

	public class three extends Button{
		Label l=new Label("Disease Name: ");
		public void three(){
			initializeDB();
			Pane pane=new Pane();
			pane.setPrefSize(200, 300);
			pane.getChildren().add(l);
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			stage.setScene(scene);
			stage.show();
			
			try{
				String sql="SELECT firsttb.Desease FROM firsttb WHERE (symptom1='"+t.getText()+"' OR symptom1='"+t2.getText()+"'OR symptom1='"+t3.getText()+"' ) AND (symptom2='"+t.getText()+"' OR symptom2='"+t2.getText()+"' OR symptom2='"+t3.getText()+"' ) AND (symptom3='"+t.getText()+"' OR symptom3='"+t2.getText()+"' OR symptom3='"+t3.getText()+"' ) AND (symptom4='"+t4.getText()+"') "; 
				ResultSet rset=statement.executeQuery(sql);
				while(rset.next()){
					l.setText(rset.getString(1));
					//System.out.println("Disease Name : "+s);
				}
			}catch(Exception e){
				
			}
		}
	}
	public class four extends Button{
		Label l=new Label("Disease Name: ");
		public void four(){
			initializeDB();
			Pane pane=new Pane();
			pane.setPrefSize(200, 300);
			pane.getChildren().add(l);
			Stage stage=new Stage();
			Scene scene=new Scene(pane);
			stage.setScene(scene);
			stage.show();
			
			try{
				String sql="SELECT firsttb.Desease FROM firsttb WHERE (symptom1='"+t.getText()+"' OR symptom1='"+t2.getText()+"'OR symptom1='"+t3.getText()+"' OR symptom1='"+t4.getText()+"' ) AND (symptom2='"+t.getText()+"' OR symptom2='"+t2.getText()+"' OR symptom2='"+t3.getText()+"' OR symptom2='"+t3.getText()+"' ) AND (symptom3='"+t.getText()+"' OR symptom3='"+t2.getText()+"' OR symptom3='"+t3.getText()+"' OR symptom3='"+t4.getText()+"' ) AND (symptom4='"+t.getText()+"' OR symptom4='"+t2.getText()+"'OR symptom4='"+t3.getText()+"' OR symptom4='"+t4.getText()+"' ) AND (symptom5='"+t5.getText()+"') "; 
				ResultSet rset=statement.executeQuery(sql);
				while(rset.next()){
					l.setText(rset.getString(1));
					//System.out.println("Disease Name : "+s);
				}
			}catch(Exception e){
				
			}
		}
	}

}

