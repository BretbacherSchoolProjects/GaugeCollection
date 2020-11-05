import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Smartphone extends Group {
    GaugeElijah gauge1=new GaugeElijah();
    GaugeNevena gauge_timeDisplay = new GaugeNevena();
    GaugeElijah gauge3=new GaugeElijah();
    GaugeElijah gauge4=new GaugeElijah();
    private int width=410;
    private int height=786;
    private int minutes=0;
    private int seconds=0;

    public void draw(String currentDate, String currentTime, String currentBattery, String currentSong){
        VBox phone_root=new VBox();
        Rectangle phoneBase=new Rectangle(width, height);

        VBox music_root=new VBox();
        HBox duration_root=new HBox();
        Label currentDuration=new Label();
        Label maxDuration=new Label("5:00");

        //clock gauge
        VBox vbx_timeDisplay = new VBox();
        vbx_timeDisplay.setPrefSize(width-100, 150);
        vbx_timeDisplay.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        gauge_timeDisplay.setLabelWidth(400);

        Rectangle batteryBase=new Rectangle(width-200, 120);


        Image img=new Image("/pics/stars.jpg");
        phoneBase.setFill(new ImagePattern(img));
        music_root.setPrefWidth(width-10);
        music_root.setPrefHeight(250);
        music_root.setStyle("-fx-background-color: black;" +
                "-fx-opacity: 0.80;");
        currentDuration.setTextFill(Color.WHITE);
        maxDuration.setTextFill(Color.WHITE);
        batteryBase.setFill(Color.DARKBLUE);

        Timeline musicPlayer = new Timeline(
                new KeyFrame(Duration.seconds(0.05),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                gauge1.redraw();
                                if (gauge1.getCurrentDuration()%60==0 && gauge1.getCurrentDuration()!=0){
                                    minutes++;
                                    seconds=0;
                                }else{
                                    seconds++;
                                }
                                if (gauge1.getCurrentDuration()==300){
                                    minutes=0;
                                    seconds=0;
                                }

                                currentDuration.setText(String.format(minutes + ":%02d", seconds));
                            }
                        }));
        musicPlayer.setCycleCount(Timeline.INDEFINITE);
        musicPlayer.play();

        phone_root.setPadding(new Insets(50, 5, 5, 5));
        phone_root.setAlignment(Pos.CENTER);
        phone_root.setSpacing(25);

        gauge_timeDisplay.setValue(currentTime);

        duration_root.setPrefWidth(music_root.getWidth());
        duration_root.setSpacing(255);
        duration_root.setPadding(new Insets(20));
        duration_root.setAlignment(Pos.CENTER);
        music_root.setAlignment(Pos.CENTER);
        music_root.setSpacing(-10);


        duration_root.getChildren().addAll(currentDuration, maxDuration);
        music_root.getChildren().addAll(gauge1, duration_root);
        vbx_timeDisplay.getChildren().addAll(gauge_timeDisplay);

        phone_root.getChildren().addAll(vbx_timeDisplay, music_root, batteryBase);
        this.getChildren().addAll(phoneBase, phone_root);
    }
}
