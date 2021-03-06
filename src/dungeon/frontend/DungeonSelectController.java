package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * A controller object for the primary opening page of the game
 * to allow the user to choose how to navigate the application.
 * @author Amy
 *
 */
public class DungeonSelectController {
	
	@FXML
	private Button boulder;
	
	@FXML
	private Button maze;
	
	@FXML
	private Button advanced;
	
	@FXML
	private Button avatar;
	
	@FXML
	private Button escape;
	
	@FXML
	private Button m3Test;
	
	@FXML
	private Button credits;
	
	@FXML
	private Button help;
	
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
	public void helpMenu() throws IOException {
		HelpScreen helpScreen = new HelpScreen(this.stage);
		helpScreen.getController().setDungeonSelectScreen(this.screen);
		helpScreen.start();
		
	}

	@FXML
	public void m3Test() throws IOException {
		String name = "test.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
	
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Testing Stage with m3";
    	
    	dungeonScreen.getController().setInstructions(instructions);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void BoulderStage() throws IOException {
		String name = "boulders.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
	
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Push all boulders on \n\n to the switch!";
    	
    	dungeonScreen.getController().setInstructions(instructions);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void MazeStage() throws IOException {
		String name = "maze.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Under stand basic control & reach the exit!\n\n hint: Pick up key using 'a' ";
    	
    	dungeonScreen.getController().setInstructions(instructions);
		
    	dungeonScreen.start();
	}
	
	@FXML
	public void AdvancedStage() throws IOException {
		String name = "advanced.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Slay enemy + Collect all treasure \n\n hint: \n\n - Collect Sword 'a' \n\n - Use Sword 'S'" ;
    	
    	dungeonScreen.getController().setInstructions(instructions);
    	
    	dungeonScreen.start();
	}
	
	@FXML
	public void TheLastAirBender() throws IOException {
		String name = "avatar.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Collect all treasure + push all boulder on to switch";
    	
    	dungeonScreen.getController().setInstructions(instructions);
    	
    	dungeonScreen.start();
	}
	
	@FXML
	public void Escape() throws IOException {
		String name = "Escape.json";
		DungeonScreen dungeonScreen = new DungeonScreen(this.stage, name);
		
		this.screen.selectScreenMusic.stop();
		
		DungeonEndScreen endGameScreen = new DungeonEndScreen(this.stage);
		dungeonScreen.getController().setEndGameScreen(endGameScreen);
		dungeonScreen.getController().setDungeonSelectScreen(this.screen);
    	endGameScreen.getController().setDungeonScreen(dungeonScreen);
    	endGameScreen.getController().setDungeonSelectScreen(this.screen);
    	
    	String instructions = "Turn the right keys before the enemies can catch you!";
    	
    	dungeonScreen.getController().setInstructions(instructions);
    	
    	dungeonScreen.start();
	}


}
