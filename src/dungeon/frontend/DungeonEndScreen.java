package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class DungeonEndScreen {

	private Stage stage;
	private String title;
	private Scene scene;
	
	private DungeonEndController controller;
	
	public MediaPlayer EndScreenMusic;
	
	public DungeonEndScreen (Stage stage) throws IOException {
		this.stage = stage;
		title = "Thank you for playing";
		
		controller = new DungeonEndController();
		controller.setEndScreen(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EndGame.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		scene = new Scene(root);
	}
	
	
	public void start(boolean complete) {
		
		String musicFile = null;
		
		if (complete) {
			controller.completeStage();
			musicFile = "music/nggyu8bit.mp3";  
		} else {
			musicFile = "music/rbweide.mp3";  
		} 

		Media sound = new Media(new File(musicFile).toURI().toString());
		EndScreenMusic = new MediaPlayer(sound);
		EndScreenMusic.play();
	
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public DungeonEndController getController() {
		return controller;
	}
	
	
	
}