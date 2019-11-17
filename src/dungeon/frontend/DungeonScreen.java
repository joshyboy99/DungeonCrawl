package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The DungeonScreen is the screen on which each level is displayed.
 * @author Amy
 *
 */
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
    	this.controller = dungeonLoader.loadController();
    	
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
    
    /**
     * Reloads the level to its initial state.
     * @throws IOException
     */
    public void restart() throws IOException {
    	
    	String tempIns = this.controller.getInstructions();
    	DungeonEndScreen tempEnd = this.controller.getEndGameScreen();
    	DungeonSelectScreen tempSelect = this.controller.getDungeonSelectScreen();
    
    	
    	DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(stageName);
    	this.controller = dungeonLoader.loadController();
    	this.controller.setEndGameScreen(tempEnd);
    	this.controller.setDungeonSelectScreen(tempSelect);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
    	loader.setController(controller);
    	Parent root = loader.load();
        scene = new Scene(root);
        root.requestFocus();
    	this.controller.setInstructions(tempIns);
        this.controller.setDungeonScreen(this);
        
    	
        start();
    }
    
    public DungeonController getController() {
    	return this.controller;
    }

}
