package hust.soict.globalict.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton Pen;
    @FXML
    private ToggleGroup choose;


    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    private boolean color = false;

    @FXML
    void switchBetweenPenAndEraser(ActionEvent event) {
        RadioButton chosenButton = (RadioButton) choose.getSelectedToggle();
        if(chosenButton.equals(Pen)) {
            color = true;
        }
        else color = false;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(color) {
            Circle newCircle = new Circle(event.getX(), event.getY() , 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
        else {
            Circle newCircle = new Circle(event.getX(), event.getY() , 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}
