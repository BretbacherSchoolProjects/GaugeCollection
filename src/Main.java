import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application
{
    Smartphone smartphone=new Smartphone();
    //TextField txtValue = new TextField();

    public static void main(String[] args) {
        // Launch the JavaFX application
        Application.launch(args);
    }

    @Override public void start(Stage stage) {
        EventHandler<MouseEvent> btn_handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    //int v = Integer.parseInt(txtValue.getText());
                    //gb.setValue(v);
                }
                catch(Exception ex) {
                    System.out.println("Input Exception!");
                }

            }
        };

        //gb.init(500, 500);
        //gb.setValue(45);
        smartphone.draw();

        /*
        Button btnValue = new Button();
        btnValue.setText("New Value");
        btnValue.addEventHandler(MouseEvent.MOUSE_CLICKED, btn_handler);




        Timeline musicPlayer = new Timeline(
                new KeyFrame(Duration.seconds(0.05),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                gb.update();
                            }
                        }));
        musicPlayer.setCycleCount(Timeline.INDEFINITE);
        musicPlayer.play();
*/
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 50, 50, 50));
        vBox.setSpacing(20);
        vBox.getChildren().addAll(smartphone);

        //Creating a Scene
        Scene scene = new Scene(vBox);

        //Setting title to the scene
        stage.setTitle("Gauge Collection");
        //Adding the scene to the stage
        stage.setScene(scene);
        stage.setResizable(false);

        //Displaying the contents of a scene
        stage.show();
    }

}