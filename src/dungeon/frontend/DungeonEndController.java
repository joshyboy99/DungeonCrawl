package dungeon.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DungeonEndController {

//	private static final Stage DungeonScreen = null;
	
	@FXML
	private Button selectButton;
	
	@FXML
	private Button exit;
	
	@FXML
	private ImageView gameResult;
	
	
	private DungeonScreen dungeonScreen;
	
	private DungeonSelectScreen selectScreen;
	
	private DungeonEndScreen endScreen;

	
	public void setEndScreen(DungeonEndScreen endScreen) {
		this.endScreen = endScreen;
	}
	
	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		this.dungeonScreen = dungeonScreen;
	}
	
	public void setDungeonSelectScreen(DungeonSelectScreen selectScreen) {
		this.selectScreen = selectScreen;
	}
	

	public void completeStage() {
		
		Image win = new Image("/winner.gif");
    	gameResult.setImage(win);
	}


	@FXML
	public void initialize() {
		
    	Image lose = new Image("/gameover.gif");
    	gameResult.setImage(lose);
	}
	
	@FXML
	public void handleSelect(ActionEvent event) {
		this.endScreen.EndScreenMusic.stop();
		selectScreen.start();
	}
	
	@FXML
	public void handleExit(ActionEvent event) {
		Stage stage = (Stage)exit.getScene().getWindow();
		stage.close();
	}
	
}
