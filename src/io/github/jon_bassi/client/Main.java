package io.github.jon_bassi.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by jon on 9/22/2016.
 * Entry point for application
 */
public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/io/github/jon_bassi/client/Client.fxml"));
        primaryStage.setTitle("open-pass");
        primaryStage.setScene(new Scene(root, 950, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
