/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelTransition;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ParallelTransitionDemo extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        stage = stage;
        Pane pane = new Pane();
        Rectangle rectParallel = new Rectangle(10, 200, 50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);
        rectParallel.setTranslateX(50);
        rectParallel.setTranslateY(75);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), rectParallel);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);

        TranslateTransition translateTransition
                = new TranslateTransition(Duration.millis(2000), rectParallel);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        translateTransition.setAutoReverse(true);
        
        RotateTransition rotateTransition
                = new RotateTransition(Duration.millis(3000), rectParallel);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition
                = new ScaleTransition(Duration.millis(2000), rectParallel);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

        Rectangle rect = new Rectangle(100, 100);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.ORANGE);
        pane.getChildren().addAll(rectParallel);
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Path transition");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
