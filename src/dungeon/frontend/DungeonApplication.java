package dungeon.frontend;
import java.io.IOException;

import dungeon.backend.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	DungeonSelectScreen dungeonLevels = new DungeonSelectScreen(primaryStage);
    	
    	dungeonLevels.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
