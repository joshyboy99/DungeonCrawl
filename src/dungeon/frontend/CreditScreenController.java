package dungeon.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * This class is responsible for handling
 * all of the behaviour of the credit screen.
 * @author Amy
 *
 */
public class CreditScreenController {
	
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
