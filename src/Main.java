import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    Smartphone smartphone=new Smartphone();
    //TextField txtValue = new TextField();

    public static void main(String[] args) {
        // Launch the JavaFX application
        Application.launch(args);
    }

    @Override public void start(Stage stage) {
        Group prim_root=new Group();
        VBox setup_root=new VBox();
        Label lbl_currentTime=new Label("Current Time");
        TextArea txta_currentTime=new TextArea();
        Label lbl_currentDate=new Label("Current Date");
        TextArea txta_currentDate=new TextArea();
        Label lbl_currentBattery=new Label("Current Battery");
        TextArea txta_currentBattery=new TextArea();
        Label lbl_currentSong=new Label("Current Song");
        TextArea txta_currentSong=new TextArea();
        Button btn_submit=new Button("Confirm");

        Image img=new Image("/pics/horizon.jpg");
        Rectangle background=new Rectangle(410, 706);
        background.setFill(new ImagePattern(img));

        setup_root.setPrefHeight(706);
        setup_root.setPrefWidth(410);

        txta_currentDate.setPrefRowCount(1);
        txta_currentTime.setPrefRowCount(1);
        txta_currentBattery.setPrefRowCount(1);
        txta_currentSong.setPrefRowCount(1);

        lbl_currentDate.setTextFill(Color.WHITE);
        lbl_currentTime.setTextFill(Color.WHITE);
        lbl_currentBattery.setTextFill(Color.WHITE);
        lbl_currentSong.setTextFill(Color.WHITE);


        EventHandler<MouseEvent> handleSetup = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                smartphone.draw(txta_currentDate.getText(), txta_currentTime.getText(), txta_currentBattery.getText(), txta_currentSong.getText());

                VBox smartphone_root = new VBox();
                smartphone_root.setSpacing(20);
                smartphone_root.getChildren().addAll(smartphone);

                Scene smartphone_scene=new Scene(smartphone_root);
                stage.setScene(smartphone_scene);
            }
        };

        btn_submit.setOnMouseClicked(handleSetup);

        setup_root.getChildren().addAll(lbl_currentDate, txta_currentDate, lbl_currentTime, txta_currentTime, lbl_currentBattery, txta_currentBattery, lbl_currentSong, txta_currentSong, btn_submit);
        prim_root.getChildren().addAll(background, setup_root);


        //Creating a Scene
        Scene scene = new Scene(prim_root);

        //Setting title to the scene
        stage.setTitle("Gauge Collection");
        //Adding the scene to the stage
        stage.setScene(scene);
        stage.setResizable(false);

        //Displaying the contents of a scene
        stage.show();
    }

}