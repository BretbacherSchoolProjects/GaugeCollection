import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Timer;

public class GaugeElijah extends GaugeBase{
    private int currentDuration=0;
    private int maxDuration=300;    //5min

    @Override
    public void redraw() {
        this.getChildren().clear();
        Line line=new Line();
        Circle point=new Circle(5);
        line.setStartX(50);
        line.setStartY(400);
        line.setEndY(400);
        line.setEndX(350);
        point.setCenterX(line.getStartX()+currentDuration);
        point.setCenterY(line.getStartY());
        if (point.getCenterX()>=line.getEndX()){
            currentDuration=0;
        }else{
            currentDuration++;
        }
        line.setStroke(Color.WHITE);
        point.setFill(Color.WHITE);
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

    public int getCurrentDuration() {
        return currentDuration;
    }

    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }
}
