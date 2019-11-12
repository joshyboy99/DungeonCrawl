package dungeon.frontend;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DungeonEndController {

//	private static final Stage DungeonScreen = null;
	
	@FXML
	private Button selectButton;
	
	@FXML
	private Button exit;
	
	@FXML
	private TextField result;
	
	
	private DungeonScreen dungeonScreen;
	
	private DungeonSelectScreen stageScreen;

	
	public void setDungeonScreen(DungeonScreen dungeonScreen) {
		this.dungeonScreen = dungeonScreen;
	}
	
	public void setStageSelectScreen(DungeonSelectScreen stageSelectScreen) {
		this.stageScreen = stageSelectScreen;
	}
	

	public void completeStage() {
		result.setText("YOU WIN");
	}


	@FXML
	public void initialize() {
		result.setEditable(false);
		result.setText("YOU LOSE");
	}
	
	@FXML
	public void handleSelect(ActionEvent event) {
		stageScreen.start();
	}
	
	@FXML
	public void handleExit(ActionEvent event) {
		Stage stage = (Stage)exit.getScene().getWindow();
		stage.close();
	}
	
}
