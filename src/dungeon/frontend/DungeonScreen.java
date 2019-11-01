package dungeon.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonScreen {
	
	private Stage stage;
    private String title;
    private DungeonController controller;
    private Scene scene;
    private String stageName;
    
    public DungeonScreen(Stage stage, String name) throws IOException {
    	this.stage = stage;
    	this.title = "Dungeon Screen";
    	this.stageName = name; 
    
    	DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(stageName);  	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
    	loader.setController(controller);
    	Parent root = loader.load();
        scene = new Scene(root);
        root.requestFocus();
        this.controller.setDungeonScreen(this);
    }
    
    public void start() {
    	stage.setTitle(title);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public DungeonController getController() {
    	return this.controller;
    }

}
