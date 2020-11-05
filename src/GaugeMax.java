import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GaugeMax extends GaugeBase {


    private int value = 0;

    @Override
    public void redraw() {
        Rectangle battery = new Rectangle();
        battery.setX(0);
        battery.setY(0);
        battery.setWidth(204);
        battery.setHeight(64);
        battery.setStroke(Color.WHITE);
        battery.setArcWidth(20);
        battery.setArcHeight(20);

        Rectangle tip = new Rectangle();
        tip.setY(16);
        tip.setX(204-10);
        tip.setWidth(20);
        tip.setHeight(30);
        tip.setFill(Color.WHITE);
        tip.setArcWidth(10);
        tip.setArcHeight(10);


        Text t = new Text();
        t.setText(String.valueOf(this.value + " %"));
        t.setFont(Font.font ("Verdana", 30));
        t.setFill(Color.WHITE);
        t.setLayoutY(-10);
        t.setLayoutX(-20);


        //calculate center
        t.setX(battery.getWidth()/ 2.0-10);
        t.setY(battery.getHeight() / 2.0+20);

        if(value>100)
            value=100;

        if(value == 100)
            t.setLayoutX(-30);

        Rectangle charge = new Rectangle();

        for(int i=0;i<value;i++){

            charge.setX(2);
            charge.setY(2);
            charge.setWidth(2*value);
            charge.setHeight(60);
            charge.setArcWidth(20);
            charge.setArcHeight(20);

            if (value==0){
                charge.setFill(Color.GRAY);
            }
            else if (value!=0 && value<=20){
                charge.setFill(Color.RED);
            }
            else if (20<value && value<=60){
                charge.setFill(Color.ORANGE);
            }
            else if (value>=60) {
                charge.setFill(Color.LIMEGREEN);
            }

        }

        this.getChildren().addAll(tip, battery , charge, t);
    }


    @Override
    public void setValue(int v) {
        this.value = v;
        this.redraw();
    }

}
