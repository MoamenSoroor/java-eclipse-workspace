
package PathTransition;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFXClass extends Application{
    Stage stage;
    static final double FACTOR = 30;
    static final double SCENE_WIDTH = 800;
    static final double SCENE_LENGTH = 800;
    static final double SHAPE_WIDTH = 6*Math.PI * FACTOR;
    static final double SHAPE_LENGTH = FACTOR *4;

    
    DoubleProperty startx;
    DoubleProperty starty;
    @Override
    public void start(Stage stage1) throws Exception {
        stage = stage1;
        Pane pane = new Pane();
        startx = new SimpleDoubleProperty((SCENE_WIDTH - SHAPE_WIDTH)/2);
        starty = new SimpleDoubleProperty((SCENE_LENGTH - SHAPE_LENGTH)/2);
       
        Rectangle rect  = new Rectangle(100, 100);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.ORANGE);
        
        //Path path = new Path();
        //path.setStroke(Color.RED);
       // path.setStrokeWidth(4);
       // path.getElements().add(new MoveTo(startx.getValue(), starty.getValue()));
        
       // path.getElements().add(new CubicCurveTo(600 ,600, -200, 600, 400, 0));
        //path.getElements().add(new QuadCurveTo(200, 800, 400, 0));
       
        Polyline  polygon = new Polyline ();
        polygon.getPoints().add(startx.getValue());
        polygon.getPoints().add(starty.getValue() + SHAPE_LENGTH/2);
        for(double i = 0.0 ; i< 6* Math.PI ; i+= 0.01)
        {
            double y = Math.sin(i);
            double px = i * FACTOR + startx.getValue();
            double py = (y * FACTOR * 2) + starty.getValue()+ SHAPE_LENGTH/2;
            polygon.getPoints().add(px);
            polygon.getPoints().add(py);
        }
        
        polygon.setStroke(Color.RED);
        polygon.setStrokeWidth(5);
        
        Line line = new Line(startx.getValue(), starty.getValue() , startx.getValue(), starty.getValue() + SHAPE_LENGTH);
        Line line2 = new Line(startx.getValue() , starty.getValue() + SHAPE_LENGTH/2 , startx.getValue() + SHAPE_WIDTH ,  starty.getValue() + SHAPE_LENGTH/2);
        line.setStroke(Color.GRAY);
        line.setStrokeWidth(5);
        line2.setStroke(Color.GRAY);
        line2.setStrokeWidth(5);
        
        PathTransition trans = new PathTransition(Duration.seconds(4), polygon, rect);
        trans.setAutoReverse(true);
        trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        trans.setCycleCount(Timeline.INDEFINITE);
        trans.play();
        
        
        
        
        
        pane.getChildren().addAll(rect , polygon , line , line2);
        Scene scene = new Scene(pane , SCENE_WIDTH , SCENE_LENGTH);
        startx.bind(scene.widthProperty().subtract(SHAPE_WIDTH).divide(2));
        starty.bind(scene.heightProperty().subtract(SHAPE_LENGTH).divide(2));
        stage.setScene(scene);
        stage.setTitle("Path transition");
        stage.show();
    }
    
}
