package dungeon.frontend;
import java.io.IOException;

import javafx.application.Application;
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
