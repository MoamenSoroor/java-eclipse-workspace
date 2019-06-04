/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadeTransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Moamen Soroor
 */
public class AnimationProject extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        Pane pane = new Pane();
        Rectangle rec = new Rectangle(100, 100, 200, 200);
        rec.setFill(Color.RED);
        pane.getChildren().add(rec);
        FadeTransition fade = new FadeTransition(Duration.millis(3000), rec);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.setAutoReverse(true);
        fade.setFromValue(0.3);
        fade.setToValue(1);
        fade.play();
        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
