package application;
import java.sql.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pc extends Application {
	Button b=new Button("press");
	TextField t=new TextField();
	Text t1=new Text("Fat");
	Text t2=new Text("Protein");
	Text t3=new Text("Carbohydrates");
	Text t4=new Text("Sodium");
	Text t5=new Text("Calcium");
	Text t6=new Text("VitaminA");
	Text t7=new Text("VitaminB");
	Text t8=new Text("Fiber");
	Text t9=new Text("Iron");
	Connection connection;
	Statement statement;
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 String DB_URL="jdbc:mysql://localhost/desease1";
	 ObservableList<Data> answer = FXCollections.observableArrayList();
	public void start(Stage stage){
		initializeDB();
		Pane pane=new Pane();
		PieChart piechart=new PieChart();
		pane.setPrefSize(600,500);
		t.relocate(40, 50);
		b.relocate(210, 50);
        piechart.relocate(100, 80);
		pane.getChildren().addAll(t,b);
		Scene scene=new Scene(pane);
		stage.setScene(scene);
		stage.show();
		b.setOnAction(e->{
			try{
				String sql="SELECT fat,protein,carbohydrates,sodium,calcium,vitaminA,vitaminC,fiber,iron FROM dietchart where calories='"+t.getText()+"'  ";
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next()){
					answer.addAll(new PieChart.Data(t1.getText(),rs.getDouble(1)),new PieChart.Data(t2.getText(),rs.getDouble(2)),new PieChart.Data(t3.getText(),rs.getDouble(3)),new PieChart.Data(t4.getText(),rs.getDouble(4)),new PieChart.Data(t5.getText(),rs.getDouble(5)),new PieChart.Data(t6.getText(),rs.getDouble(6)),new PieChart.Data(t7.getText(),rs.getDouble(7)),
							new PieChart.Data(t8.getText(),rs.getDouble(8)),new PieChart.Data(t9.getText(),rs.getDouble(9)));
					//System.out.println("Disease Name : "+s);
					piechart.getData().addAll(answer);
					pane.getChildren().add(piechart);
					System.out.println("Successfully ");
				}
			}catch(Exception e1){
				
			}
		});
		
		
	}
	private void initializeDB() {
		try{
			Class.forName(JDBC_DRIVER);
			connection=DriverManager.getConnection(DB_URL,"root","");
			System.out.println("Successfully connected");
			statement=connection.createStatement();
			//Class.forName("com.mysql.jdbc.Driver");
			//connection=DriverManager.getConnection("jdbc:mysql://localhost/desease1"," ","");
		   //statement=connection.createStatement();		
	}catch(Exception ex){
		ex.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}

