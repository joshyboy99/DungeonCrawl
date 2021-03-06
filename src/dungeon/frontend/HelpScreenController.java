package dungeon.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller Object for the instruction screen of the Game.
 * @author joshy
 *
 */
public class HelpScreenController {
	
	@FXML
	private Button select;
	
	private DungeonSelectScreen selectScreen;
	
	
	public void setDungeonSelectScreen(DungeonSelectScreen selectScreen) {
		this.selectScreen = selectScreen;
	}
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void handleSelect(ActionEvent event) {
		this.selectScreen.selectScreenMusic.stop();
		
		selectScreen.start();
	}


}
