import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class GaugeNevena extends GaugeBase {
    //creates the time display
    Label lbl_time = new Label();

    //default constructor
    public GaugeNevena() {
        //do nothing
    }

    public void setLabelWidth(double width) {
        lbl_time.setMinWidth(width);
    }

    @Override
    public void redraw() {
        //clears all elements
        this.getChildren().clear();

        //styles the label
        lbl_time.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 110px");
        lbl_time.setTextFill(Color.WHITE);
        lbl_time.setOpacity(0.9);
        lbl_time.setAlignment(Pos.CENTER);

        //adds all elements
        this.getChildren().add(lbl_time);
    }

    //setting the given time
    public void setValue(String v) {
        lbl_time.setText(v);
        redraw();
    }
}
