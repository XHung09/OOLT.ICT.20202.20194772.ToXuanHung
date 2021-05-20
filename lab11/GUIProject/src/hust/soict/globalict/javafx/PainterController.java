package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {
	
	private boolean check;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton Pen;

    @FXML
    private ToggleGroup tools;

    @FXML
    private RadioButton Eraser;
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (check == true) {
            Circle newCircle = new Circle(event.getX(),
        			event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
    	} else {
            Circle newCircle = new Circle(event.getX(),
        			event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
    	}

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void choosePen(ActionEvent event) {
    	if (event.getSource() == Pen) {
    		check = true;
    	}
    }

    @FXML
    void chooseEraser(ActionEvent event) {
    	if (event.getSource() == Eraser) {
    		check = false;
    	}
    }
    
}
