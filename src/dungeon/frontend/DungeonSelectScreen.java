package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//@Override
//public void start(Stage primaryStage) throws IOException {
//  primaryStage.setTitle("Dungeon");
//
//  DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");
//
//  DungeonController controller = dungeonLoader.loadController();
//
//  FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
//  loader.setController(controller);
//  Parent root = loader.load();
//  Scene scene = new Scene(root);
//  root.requestFocus();
//  
//  primaryStage.setScene(scene);
//  primaryStage.show();
//
//}

public class DungeonSelectScreen {
	private Stage stage;
	private String title;
	private Scene scene;
	private DungeonSelectController controller;
	private DungeonApplication dungeonApplication;
	
	public DungeonSelectScreen (Stage stage) throws IOException {
		this.stage = stage;
		this.title = "Level Selection";
		this.controller = new DungeonSelectController(stage, this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("someformof.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		this.scene = new Scene(root);

	}

	public void start() {
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public DungeonSelectController getController() {
		return this.controller;
	}

}
