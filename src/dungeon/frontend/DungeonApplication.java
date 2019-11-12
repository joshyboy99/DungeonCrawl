package dungeon.frontend;
import java.io.IOException;

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
<<<<<<< HEAD
=======


>>>>>>> 011c409b2ce35d88f603a4af30e3deb0e0573019
    }

    public static void main(String[] args) {
        launch(args);
    }

}
