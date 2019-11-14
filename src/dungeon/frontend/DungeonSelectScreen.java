package dungeon.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class DungeonSelectScreen {
	private Stage stage;
	private String title;
	private Scene scene;
	private DungeonSelectController controller;
	private DungeonApplication dungeonApplication;
	
	public  MediaPlayer selectScreenMusic;
	
	public DungeonSelectScreen (Stage stage) throws IOException {
		this.stage = stage;
		this.title = "Level Selection";
		this.controller = new DungeonSelectController(stage, this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectStage.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		this.scene = new Scene(root);

	}

	public void start() {
		
		String musicFile = "music/kahoot8bit.mp3";     // For example

		Media sound = new Media(new File(musicFile).toURI().toString());
		selectScreenMusic = new MediaPlayer(sound);
		selectScreenMusic.play();
		
		stage.setTitle(this.title);
		stage.setScene(this.scene);
		stage.show();
		
		
	}
	
	public DungeonSelectController getController() {
		return this.controller;
	}

}
