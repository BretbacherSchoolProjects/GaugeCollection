import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.util.Collections;

public class Smartphone extends Group {
    GaugeElijah gauge1=new GaugeElijah();
    GaugeElijah gauge2=new GaugeElijah();
    GaugeElijah gauge3=new GaugeElijah();
    GaugeElijah gauge4=new GaugeElijah();
    private int width=410;
    private int height=796;

    public void draw(){
        VBox phone_root=new VBox();
        Rectangle phoneBase=new Rectangle(width, height);
        Rectangle musicBase=new Rectangle(width-10, 250);
        Rectangle timeBase=new Rectangle(width-100, 200);
        Rectangle batteryBase=new Rectangle(width-200, 120);

        Image img=new Image("/pics/stars.jpg");
        phoneBase.setFill(new ImagePattern(img));
        musicBase.setFill(Color.DARKGREY);
        timeBase.setFill(Color.DARKRED);
        batteryBase.setFill(Color.DARKBLUE);

        phone_root.setPadding(new Insets(50, 5, 5, 5));
        phone_root.setAlignment(Pos.CENTER);
        phone_root.setSpacing(25);

        phone_root.getChildren().addAll(timeBase, musicBase, batteryBase);
        this.getChildren().addAll(phoneBase, phone_root);
    }
}
