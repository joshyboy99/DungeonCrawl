package dungeon.frontend;

import java.io.IOException;

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
	
	@FXML
	private Button avatar;
	
	@FXML
	private Button credits;
	
	private Stage stage;
	private DungeonSelectScreen screen;
	
	public DungeonSelectController(Stage stage, DungeonSelectScreen screen) {
		this.stage =stage;
		this.screen = screen;
	}
	
	@FXML
	public void creditPage() throws IOException {
		CreditScreen creditScreen = new CreditScreen(this.stage);
		creditScreen.getController().setDungeonSelectScreen(this.screen);
		creditScreen.start();
		
	}
	
	@FXML
	public void BoulderStage() throws IOException {
		String name = "boulders.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		//this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void MazeStage() throws IOException {
		String name = "maze.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		//this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void AdvancedStage() throws IOException {
		String name = "advaced.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		//this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	dungeonScreen.start();
	}
	
	@FXML
	public void TheLastAirBender() throws IOException {
		String name = "avatar.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		//this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	dungeonScreen.start();
	}


}
