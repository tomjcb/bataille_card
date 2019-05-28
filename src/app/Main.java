package app;

import app.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        this.primaryStage.setTitle("Bataille");

        // Set the application icon
        this.primaryStage.getIcons().add(new Image("app/resource/image/icon_card.png"));

        initRootLayout();

        showWelcomePage();
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            this.rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(this.rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showWelcomePage() {
        try {
            // FXML file localizing
            final URL url = getClass().getResource("view/WelcomePage.fxml");
            // Loader creation
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            // FXML loading
            final AnchorPane welcomePage = fxmlLoader.load();
            //  set page into the center of root layout
            this.rootLayout.setCenter(welcomePage);

            //   give the controller access to the main app
            WelcomePage controller = fxmlLoader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showMenuMain() {
        try {
            // FXML file localizing
            final URL url = getClass().getResource("view/MenuMain.fxml");
            // Loader creation
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            // FXML loading
            final AnchorPane menuMain = fxmlLoader.load();
            //  set personOverview into the center of root layout
            this.rootLayout.setCenter(menuMain);

            //   give the controller access to the main app
            MenuMain controller = fxmlLoader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGamePage(String J1, String J2){
        try {

            // FXML file localizing
            final URL url = getClass().getResource("view/GamePage.fxml");
            // Loader creation
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            // FXML loading
            final AnchorPane gamePage = fxmlLoader.load();
            //  set personOverview into the center of root layout
            this.rootLayout.setCenter(gamePage);

            //   give the controller access to the main app
            GamePage controller = fxmlLoader.getController();

            controller.init(J1,J2);
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
