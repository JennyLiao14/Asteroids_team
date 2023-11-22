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


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {     //contains graphics, inputs and game loop. Will call on LvlHandler and SceneHandler to set up the game after choices completed
    private GraphicsContext gc;
    private LevelOne l1;
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


        //testing classes (don't mind me)
        Image image = new Image("file:src/Images/spaceship.png");
        l1 = new LevelOne();

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


        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                // Move up
                player.accelerate();
            } else if (event.getCode() == KeyCode.D) {
                // Rotate right
                player.turnRight();
            } else if (event.getCode() == KeyCode.A) {
                // Rotate left
                player.turnLeft();
            }
            else if (event.getCode() == KeyCode.M) {
                //testing in progress
                l1.replaceAsteroid(0);
            }
            else if (event.getCode() == KeyCode.N) {
                //testing in progress
                l1.enhanceAsteroid(0);
            }
            if (event.getCode() == KeyCode.L) {

                player.shoot();
            }

        });



//creating the game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                l1.summonAsteroid();
                l1.draw(gc);
                player.drawBul(gc);
                // Update player's position and rotation based on key inputs
                gc.save();
                gc.translate(player.getPos().getX(), player.getPos().getY());


                gc.rotate(player.getRotation());
                // Draw the image with its center at the origin (the new translated and rotated point)
                //gc.drawImage(image, -100 / 2, -100 / 2, 100, 100); // Use hardcoded size since ImageView is no longer used
                player.draw(gc);
                gc.restore();

                if(player.getPos().getX() >= canvas.getWidth()) {
                    player.setPos(-80, player.getPos().getY());
                }
                else if(player.getPos().getY() >= canvas.getHeight()) {
                    player.setPos(player.getPos().getX(), -80);
                }
                else if(player.getPos().getX() <= -80) {
                    player.setPos(canvas.getWidth(), player.getPos().getY());
                }
                else if(player.getPos().getY() <= -80) {
                    player.setPos(player.getPos().getX(), canvas.getHeight());
                }
                player.deccelerate();
            }
        }.start();


        primaryStage.show();
    }
}