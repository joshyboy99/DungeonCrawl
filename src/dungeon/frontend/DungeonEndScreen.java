package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonEndScreen {

	private Stage stage;
	private String title;
	private Scene scene;
	
	private DungeonEndController controller;
	
	public DungeonEndScreen (Stage stage) throws IOException {
		this.stage = stage;
		title = "Thank you for playing";
		
		controller = new DungeonEndController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EndGame.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		scene = new Scene(root);
	}
	
	
	public void start(boolean complete) {
		if (complete) {
			controller.completeStage();
		}
		
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public DungeonEndController getController() {
		return controller;
	}
	
	
	
}