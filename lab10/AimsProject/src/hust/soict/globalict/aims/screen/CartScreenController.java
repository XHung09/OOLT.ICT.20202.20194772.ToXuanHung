package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	
    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
	
    @FXML
    private Button btnPlaceOrdered;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;
    
    @FXML
    private Label totalCost;
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    void btnRemovePressed(ActionEvent ae) {	
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	this.cart.removeMedia(media);
    	
    	String stringTotalCost = String.valueOf(Math.round(this.cart.totalCost() * 100.0) / 100.0) + "$";
    	Label lb = new Label(stringTotalCost);
    	totalCost.textProperty().bind(lb.textProperty());
    }
    
    @FXML
    void addBookPressed(ActionEvent event) {

    }

    @FXML
    void addCDPressed(ActionEvent event) {

    }

    @FXML
    void addDVDPressed(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent ae) {
		JOptionPane.showMessageDialog(null, "An order has been created!" 
				+ "\nTotal cost: " + cart.totalCost() + "$",
				"NOTIFICATION" , JOptionPane.INFORMATION_MESSAGE);
    }
    
    @FXML
    void btnPlayPressed(ActionEvent ae) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();

		if (media instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc)media;
			String str = "Playing DVD: " + dvd.getTitle()
						+ "\nLength: " + dvd.getLength(); 
			JOptionPane.showMessageDialog(null, str, "Play " , JOptionPane.INFORMATION_MESSAGE);
		} else if (media instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc)media;
			String str = "Playing CD: " + cd.getTitle()
						+ "\nARTIST: " + cd.getArtist();
			
			for (int i = 0; i < cd.getNbTrack(); i++) {
				str = str + "\n" + cd.playGUI();
			}
		
			JOptionPane.showMessageDialog(null, str, "Play " , JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    @FXML
    private void initialize() {	
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue, 
    						Media newValue) {
    					if (newValue != null) {
    						updateButtonBar(newValue);
    					}
    				}
				});
 
    	String stringTotalCost = String.valueOf(Math.round(this.cart.totalCost() * 100.0) / 100.0) + "$";
    	Label lb = new Label(stringTotalCost);
    	totalCost.textProperty().bind(lb.textProperty());
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    	}
    }
    
}