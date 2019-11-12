package dungeon.frontend;

import java.io.IOException;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DungeonSelectController {
	// FXML STUFF
	// how many stages + what other features we have
	
	@FXML
	private Button boulder;
	
	@FXML
	private Button maze;
	
	@FXML
	private Button advanced;
	
	private Stage stage;
	private DungeonSelectScreen screen;
	private DungeonScreen dungeonScreen;
	
	public DungeonSelectController(Stage stage, DungeonSelectScreen screen) {
		this.stage =stage;
		this.screen = screen;
	}
	
	@FXML
	public void BoulderStage() throws IOException {
		String name = "boulders.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setStageSelectScreen(this.screen);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void MazeStage() throws IOException {
		String name = "maze.json";
		
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setStageSelectScreen(this.screen);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void AdvancedStage() throws IOException {
		String name = "advanced.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setStageSelectScreen(this.screen);
    	
    	dungeonScreen.start();
	}


}
