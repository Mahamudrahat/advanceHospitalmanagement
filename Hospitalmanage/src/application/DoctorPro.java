package application;



import java.sql.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DoctorPro extends Application{
	Button b=new Button("রোগ সনাক্ত করন");
	Button b2=new Button("খাদ্য তালিকা");
	Button b3=new Button("আদর্শ ওজন তালিকা");
	Button b4=new Button("রোগ বিবরণ");
	Stage window;
	Scene scene,scene2,scene3,scene4;
	ComboBox<String> cb=new ComboBox<>();
	ComboBox<String> cb2=new ComboBox<>();
	ComboBox<String> cb3=new ComboBox<>();
	ComboBox<String> cb4=new ComboBox<>();
	ComboBox<String> cb5=new ComboBox<>();
	ComboBox<String> cb6=new ComboBox<>();
	Connection connection;
	Statement statement;
	int j=1;
	VBox vb=new VBox();
	VBox vb2=new VBox();
	TextField t=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	TextField t4=new TextField();
	TextField t5=new TextField();
	TextField t6=new TextField();
	TextField t7=new TextField();
	
	public void start(Stage stage){
		initializeDB();
		window=stage;
		Pane pane=new Pane();
		
		cb.getStyleClass().add("cbox");
		cb2.getStyleClass().add("cbox");
		cb3.getStyleClass().add("cbox");
		cb4.getStyleClass().add("cbox");
		cb5.getStyleClass().add("cbox");
		cb6.getStyleClass().add("cbox");
		
		//TextField t=new TextField();
		
		vb.getChildren().addAll(b,b2,b3,b4);
		pane.setPrefSize(900, 550);
		pane.setStyle("-fx-backround-color:null");
		pane.getChildren().addAll(vb);
		vb.getStyleClass().add("vbox");
		vb.relocate(10, 25);
		b.getStyleClass().add("btnn");
		b2.getStyleClass().add("btnn");
		b3.getStyleClass().add("btnn");
		b4.getStyleClass().add("btnn");
		scene=new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(scene);
		window.show();
		try{
			String sql="select * from symptom";
			ResultSet rset=statement.executeQuery(sql);
			while(rset.next()){
				String s=rset.getString(j);
				cb.getItems().add(s);
				cb2.getItems().add(s);
				cb3.getItems().add(s);
				cb4.getItems().add(s);
				cb5.getItems().add(s);
				cb6.getItems().add(s);
				t.setText(s);
			}
		}catch(Exception e){
			
		}
		b.setOnMouseClicked(e ->{
			disease d=new disease();
			d.disease();
			//if(e.getClickCount()==1){
			
			
		});
		
		b2.setOnAction(e ->{
			pane.getChildren().remove(vb2);
		});
	}

	private void initializeDB() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/cse?useUnicode=yes&characterEncoding=UTF-8","root","");
			statement=connection.createStatement();
	}
	catch(Exception ex){
		ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	public class disease extends Button{
		
		public void disease(){
			Pane pane=new Pane();
			pane.setPrefSize(400, 500);
			pane.getChildren().add(cb);
			cb.relocate(50, 50);
			cb2.relocate(50, 100);
			cb3.relocate(50, 150);
			cb4.relocate(50, 200);
			cb5.relocate(50, 250);
			cb6.relocate(50, 300);
			Stage stage=new Stage();
			scene2=new Scene(pane);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene2);
			stage.show();
			cb.setOnAction(ex ->{
				if(cb.getValue().equals("নাই")){
					System.exit(0);
				}else{
					pane.getChildren().add(cb2);
					cb2.setOnAction(ex2 ->{
						if(cb2.getValue().equals("নাই")){
							
						}else{
							pane.getChildren().add(cb3);
							cb3.setOnAction(ex3 ->{
								if(cb3.getValue().equals("নাই")){
									twos t=new twos();
									t.twos();
									System.out.print("go to two");
								}else{
									pane.getChildren().add(cb4);
									cb4.setOnAction(ex4 ->{
										if(cb4.getValue().equals("নাই")){
											System.exit(0);
										}else{
											pane.getChildren().add(cb5);
											cb5.setOnAction(ex5 ->{
												if(cb5.getValue().equals("নাই")){
													System.exit(0);
												}else{
													pane.getChildren().add(cb6);
													cb6.setOnAction(ex6 ->{
														if(cb6.getValue().equals("নাই")){
															System.exit(0);
														}else{
															
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
			});
		}
	}
	
	public class twos extends Button{
		Button b=new Button("Show");
		Label l=new Label();
		public void twos(){
			initializeDB();
			Pane pane=new Pane();
			pane.getChildren().addAll(l);
			l.relocate(50, 100);
			l.setStyle("-fx-font-size:20px");
			t.relocate(100, 150);
			t2.relocate(100, 200);
			t3.relocate(100, 250);
			Stage stage=new Stage();
			scene3=new Scene(pane,300,400);
			stage.setScene(scene3);
			stage.show();
			
				t.setText(cb.getValue());
				t2.setText(cb2.getValue());
				t3.setText(cb3.getValue());
				try{
					String sql="select disease_name from disease where (symptom='"+t.getText()+"' OR symptom='"+t2.getText()+"' OR symptom='"+t3.getText()+"' ) AND (symptom2='"+t.getText()+"' OR symptom2='"+t2.getText()+"' OR symptom2='"+t3.getText()+"') AND (symptom3='"+t.getText()+"' OR symptom3='"+t2.getText()+"' OR symptom3='"+t3.getText()+"')";
					ResultSet rset=statement.executeQuery(sql);
					System.out.print("check");
					while(rset.next()){
						
						l.setText("রোগের নাম : "+rset.getString(1));
						
					}
				}catch(Exception ex){
					System.out.print("Problem");
				}
			
			
			
			
		}
	}

}
