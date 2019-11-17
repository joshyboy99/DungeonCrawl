package dungeon.frontend;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The overarching application that establishes the 
 * primary stage for the game, and calls the subsequent
 * classes.
 * @author joshy
 *
 */
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
