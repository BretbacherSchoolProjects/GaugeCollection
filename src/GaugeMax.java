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
        battery.setStroke(Color.GREY);


        Rectangle tip = new Rectangle();
        tip.setY(0);
        tip.setX(200-10);
        tip.setWidth(20);
        tip.setHeight(30);
        tip.setArcWidth(10);
        tip.setArcHeight(10);
        tip.setFill(Color.GREY);


        Text t = new Text();
        t.setText(String.valueOf(this.value));
        t.setFont(Font.font ("Verdana", 30));
        t.setFill(Color.WHITE);


        //calculate center
        t.setX(battery.getWidth()/ 2.0-10);
        t.setY(battery.getHeight() / 2.0+20);

        if(value>100)
            value=100;

        Rectangle charge = new Rectangle();

        for(int i=0;i<value;i++){

            charge.setX(2+20*(i/10));
            charge.setY(2);
            charge.setWidth(20);
            charge.setHeight(60);
            charge.setArcWidth(20);
            charge.setArcHeight(20);

            if (value==0){
                charge.setFill(Color.GRAY);
            }
            else if (value!=0 && value<=33){
                charge.setFill(Color.RED);
            }
            else if (33<value && value<=66){
                charge.setFill(Color.YELLOW);
            }
            else if (value>=66) {
                charge.setFill(Color.GREEN);
            }

        }



        this.getChildren().addAll(battery, tip, t, charge);
    }


    @Override
    public void setValue(int v) {
        this.value = v;
        this.redraw();
    }

}
