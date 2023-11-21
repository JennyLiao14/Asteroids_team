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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.canvas.GraphicsContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {     //contains graphics, inputs and game loop. Will call on LvlHandler and SceneHandler to set up the game after choices completed
    private GraphicsContext gc;
    public static void main(String[] args) {
        launch(args); //auto call start
    }

    public void start(Stage primaryStage) { //like a new main

        primaryStage.setTitle("Asteroids");//can have scene + can change scenes

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        Canvas canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);


        //testing classes (don't mind me)
        Image image = new Image("file:src/Images/MicrosoftTeams-image.png");

// Create an ImageView and set its size
        //ImageView player = new ImageView(image);
        //player.setFitWidth(100);
        //player.setFitHeight(100);
        // player.setPreserveRatio(true);

// Add the ImageView to the layout
        //StackPane stackPane = new StackPane();
        //stackPane.getChildren().add(player);
        //root.setTop(stackPane);
        PVector playerPosition = new PVector(400, 300);
        Player player = new Player(1, playerPosition);

        //double[] playerPosition = {400, 300}; // Starting position in the middle of the canvas
        //double[] playerRotation = {0}; // Starting rotation

        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                // Move up

                player.accelerate();            //FIX ACCELERATION CODE
            } else if (event.getCode() == KeyCode.D) {
                // Rotate right
                player.turnRight();
            } else if (event.getCode() == KeyCode.A) {
                // Rotate left
                player.turnLeft();
            }

        });
        player.move();
        player.deccelerate();


//creating the game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                // Update player's position and rotation based on key inputs
                gc.save();
                gc.translate(player.getPos().getX(), player.getPos().getY());
                gc.rotate(player.getRotation());
                // Draw the image with its center at the origin (the new translated and rotated point)
                gc.drawImage(image, -100 / 2, -100 / 2, 100, 100); // Use hardcoded size since ImageView is no longer used
                gc.restore();
            }
        }.start();


        primaryStage.show();
    }
}