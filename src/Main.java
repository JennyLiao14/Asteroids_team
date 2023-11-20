import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    public static void main(String[] args) {
        launch(args); //auto call start
    }

    public void start(Stage primaryStage) { //like a new main
        primaryStage.setTitle("Asteroids");//can have scene + can change scenes

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        context.setFill(Color.BLUE);
        context.fillRect(0,0,800,600);

        //testing classes (don't mind me)
        System.out.println("factory testing");
        ArrayList<Entity> temp = new ArrayList<>();
        temp.add(AsteroidFactory.getAsteroid(2));
        temp.add(AsteroidFactory.getAsteroid(3));
        temp.add(EntityFactory.getEntity("Player",1));
        for(int i = 0; i < temp.size(); i++) {
            temp.get(i).move();
        }

        System.out.println(" ");
        System.out.println("Random Testing");

        NumberGenerator n = new NumberGenerator();
        for(int i = 0; i < 6; i++) {
            EntityFactory.getEntity("Asteroid",n.randomInt(1,3)).move();

        }


        primaryStage.show();
    }
}