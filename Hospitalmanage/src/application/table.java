package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//from w  w  w . j  av  a2  s.c o m
public class table extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    TableView table = new TableView();
    table.setEditable(true);

    TableColumn firstNameCol = new TableColumn("First Name");
    TableColumn lastNameCol = new TableColumn("Last Name");
    TableColumn emailCol = new TableColumn("Email");
            
    table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
    //emailCol.setVisible(false);

    StackPane root = new StackPane();
    root.getChildren().add(table);
    primaryStage.setScene(new Scene(root, 250, 250));
    primaryStage.show();
  }
}
