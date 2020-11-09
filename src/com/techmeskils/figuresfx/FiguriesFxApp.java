package com.techmeskils.figuresfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class FiguriesFxApp extends Application {

    private static final Logger logger = Logger.getLogger(FiguriesFxApp.class);

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("FXFigure");
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainScreenView.fxml"));
        window.setScene(new Scene(root, 1024,600));
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
