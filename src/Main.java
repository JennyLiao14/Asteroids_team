import javafx.animation.AnimationTimer;
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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;
public class Main extends Application {     //contains graphics, inputs and game loop. Will call on LvlHandler and SceneHandler to set up the game after choices completed
    private GraphicsContext gc;
    private SceneHandler sceneHandler;
    public static void main(String[] args) {
        launch(args); //auto call start
    }
    public void start(Stage primaryStage) { //like a new main
        primaryStage.setTitle("Asteroids");//can have scene + can change scenes
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        Canvas canvas = new Canvas(800, 600); //800, 600
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        sceneHandler = new SceneHandler(1);

// Create an ImageView and set its size
        //ImageView player = new ImageView(image);
        //player.setFitWidth(100);
        //player.setFitHeight(100);
        // player.setPreserveRatio(true);

// Add the ImageView to the layout
        //StackPane stackPane = new StackPane();
        //stackPane.getChildren().add(player);
        //root.setTop(stackPane);
        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                // Move up
                sceneHandler.getPlayer().accelerate();
            }
            else if (event.getCode() == KeyCode.D) {
                // Rotate right
                sceneHandler.getPlayer().turnRight();
            } else if (event.getCode() == KeyCode.A) {
                // Rotate left
                sceneHandler.getPlayer().turnLeft();
            }
            else if (event.getCode() == KeyCode.M) {
                //testing in progress
                sceneHandler.replaceAsteroid();
            }
            else if (event.getCode() == KeyCode.N) {
                //testing in progress
                sceneHandler.enhanceAsteroid();
            }
            if (event.getCode() == KeyCode.L) {
                sceneHandler.getPlayer().shoot();
            }
            //level change testing
            if (event.getCode() == KeyCode.I) { //level change test
                sceneHandler = new SceneHandler(1);
                System.out.println("Level 1");
            }
            if (event.getCode() == KeyCode.O) { //level change test
                sceneHandler = new SceneHandler(2);
                System.out.println("Level 2");
            }
            if (event.getCode() == KeyCode.P) { //level change test
                sceneHandler = new SceneHandler(3);
                System.out.println("Level 3");
            }
        });
//creating the game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                sceneHandler.draw(gc);
                // Update player's position and rotation based on key inputs
                gc.save();
                gc.translate(sceneHandler.getPlayer().getPos().getX(), sceneHandler.getPlayer().getPos().getY());
                gc.rotate(sceneHandler.getPlayer().getRotation());
                // Draw the image with its center at the origin (the new translated and rotated point)
                //gc.drawImage(image, -100 / 2, -100 / 2, 100, 100); // Use hardcoded size since ImageView is no longer used
                sceneHandler.drawPlayer(gc);
                gc.restore();
            }
        }.start();
        primaryStage.show();
    }
}