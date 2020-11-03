import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Timer;

public class GaugeElijah extends GaugeBase{
    private int currentDuration=0;

    @Override
    public void redraw() {
        this.getChildren().clear();
        Line line=new Line();
        Circle point=new Circle(5);
        line.setStartX(50);
        line.setStartY(100);
        line.setEndY(100);
        line.setEndX(200);
        point.setCenterX(line.getStartX()+currentDuration);
        point.setCenterY(line.getStartY());
        if (point.getCenterX()>=line.getEndX()){
            currentDuration=0;
        }else{
            currentDuration++;
        }
        line.setFill(Color.BLACK);
        point.setFill(Color.BLACK);
        this.getChildren().addAll(line, point);
    }

    @Override
    public void init(int width, int height) {
        super.init(width, height);
    }

    @Override
    public void setValue(int v) {
        super.setValue(v);
        redraw();
    }

    public void update(){
        redraw();
    }
}
