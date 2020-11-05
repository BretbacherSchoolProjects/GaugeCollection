import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class GaugeElijah extends GaugeBase{
    //Global scopes
    private int currentDuration=0;
    private Label song=new Label();
    private boolean[] isStopped = {false};

    //Function is called multiple times. The main function
    @Override
    public void redraw() {
        //Clear all children. Used for not stacking the point on the line
        this.getChildren().clear();

        //Roots
        VBox root=new VBox();           //main root
        Group line_root=new Group();    //where the music happens
        HBox switch_root=new HBox();    //where the buttons are

        //Variables
        Polygon prev=new Polygon();     //Just for show
        Polygon next=new Polygon();     //Hust for show
        Polygon start=new Polygon();
        Rectangle stop=new Rectangle(30,30);

        Line line=new Line();
        Circle point=new Circle(5);

        //Positioning
        line.setStartX(50);
        line.setStartY(400);
        line.setEndY(400);
        line.setEndX(350);
        point.setCenterX(line.getStartX()+currentDuration);
        point.setCenterY(line.getStartY());

        prev.getPoints().addAll(
                50.0, 50.0,
                70.0, 30.0,
                70.0, 70.0);

        next.getPoints().addAll(
                200.0, 50.0,
                180.0, 30.0,
                180.0, 70.0);

        start.getPoints().addAll(
                190.0, 50.0,
                160.0, 35.0,
                160.0, 65.0);

        //Making sure the point stays on the line
        if (point.getCenterX()>=line.getEndX()){
            currentDuration=0;
        }else{
            currentDuration++;
        }

        //Styling
        line.setStroke(Color.WHITE);
        point.setFill(Color.WHITE);
        prev.setFill(Color.WHITE);
        start.setFill(Color.WHITE);
        stop.setFill(Color.WHITE);
        next.setFill(Color.WHITE);
        song.setTextFill(Color.WHITE);

        switch_root.setSpacing(60);

        //Event Handlers
        //Causes the music to stop
        EventHandler handleStop=new EventHandler() {
            @Override
            public void handle(Event event) {
                isStopped[0] =true;
            }
        };

        //Resumes the play
        EventHandler handleStart=new EventHandler() {
            @Override
            public void handle(Event event) {
                isStopped[0]=false;
            }
        };

        //Assigning handlers
        start.setOnMouseClicked(handleStart);
        stop.setOnMouseClicked(handleStop);

        //Adding
        line_root.getChildren().addAll(line,point);
        switch_root.getChildren().addAll(prev,start, stop, next);
        root.getChildren().addAll(song, line_root, switch_root);

        this.getChildren().addAll(root);
    }

    @Override
    public void init(int width, int height) {
        super.init(width, height);
    }

    public void setValue(String v) {
        song.setText(v);
        redraw();
    }

    public int getCurrentDuration() {
        return currentDuration;
    }

    public Label getSong() {
        return song;
    }

    public boolean[] getIsStopped() {
        return isStopped;
    }
}
