package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The screen displaying the creators of the
 * game.  
 * @author Amy
 *
 */
public class CreditScreen {
		private Stage stage;
		private String title;
		private CreditScreenController controller;
		private Scene scene;
		    
	public CreditScreen (Stage stage) throws IOException {
		this.stage = stage;
		this.title = "Credits";
		
		controller = new CreditScreenController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("credit.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		scene = new Scene(root);
	}
	
	public void start() {
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public CreditScreenController getController() {
		return this.controller;
	}
}
