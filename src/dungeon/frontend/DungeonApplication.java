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
//<<<<<<< HEAD
    	
    	DungeonSelectScreen dungeonLevels = new DungeonSelectScreen(primaryStage);
    	
    	dungeonLevels.start();
//=======
//        primaryStage.setTitle("Dungeon");
//
//        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("advanced.json");
//
//        DungeonController controller = dungeonLoader.loadController();
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
//        loader.setController(controller);
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        root.requestFocus();
//        
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//>>>>>>> Cleanup
    }

    public static void main(String[] args) {
        launch(args);
    }

}
