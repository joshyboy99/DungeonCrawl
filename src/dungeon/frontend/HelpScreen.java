package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Tutorial page for the application, allowing the 
 * user to gain an understanding for the controls of the
 * game.
 * @author joshy
 *
 */
public class HelpScreen {

		private Stage stage;
		private String title;
		private HelpScreenController controller;
		private Scene scene;
		    
	public HelpScreen (Stage stage) throws IOException {
		this.stage = stage;
		this.title = "Help Menu";
		
		controller = new HelpScreenController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("helpMenu.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		scene = new Scene(root);
	}
	
	public void start() {
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public HelpScreenController getController() {
		return this.controller;
	}
}
