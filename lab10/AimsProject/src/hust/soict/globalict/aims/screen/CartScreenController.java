package hust.soict.globalict.aims.screen;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CartScreenController {

	private Cart cart;
	
    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;
	
    @FXML
    private MenuItem viewStore;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterID;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
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
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private TableColumn<Media, String> colMediaId;
    
    @FXML
    protected Label totalCost;
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    void btnRemovePressed(ActionEvent ae) {	
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	this.cart.removeMedia(media);
    	
    	totalCost.textProperty().bind(new SimpleFloatProperty(this.cart.totalCost()).asString("%.2f$"));
    }
    
    @FXML
    void addBookPressed(ActionEvent event) {
		new AddBookToStoreScreen(StoreScreen.store);
    }

    @FXML
    void addCDPressed(ActionEvent event) {
		new AddCompactDiscToStoreScreen(StoreScreen.store);
    }

    @FXML
    void addDVDPressed(ActionEvent event) {
		new AddDigitalVideoDiscToStoreScreen(StoreScreen.store);
    }

    @FXML
    void viewStorePressed(ActionEvent event) {
    	new StoreScreen(StoreScreen.store);
    }
    
    @FXML
    void detectMouseEntered(MouseEvent event) {
    	totalCost.textProperty().bind(new SimpleFloatProperty(this.cart.totalCost()).asString("%.2f$"));
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent ae) {
    	String stringTotalCost = String.valueOf(Math.round(this.cart.totalCost() * 100.0) / 100.0) + "$";
    	
		JOptionPane.showMessageDialog(null, "An order has been created!" 
				+ "\nTotal cost: " + stringTotalCost,
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
      	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, String>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
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
    	
    	filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
    		@Override
    		public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, 
					Toggle newValue) {
    			RadioButton btn = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
    		
    			if (btn == radioBtnFilterTitle) {
    				showFilteredMediaTitle();
    			} else {
    				showFilteredMediaId();
    			}
    		}

		});

    	totalCost.textProperty().bind(new SimpleFloatProperty(this.cart.totalCost()).asString("%.2f$"));
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    	}
    }
    
    // used for filtering
    private boolean searchFindsTitle(Media media, String search) {
    	return (media.getTitle().toLowerCase().contains(search.toLowerCase()));
    }
    
    private boolean searchFindsId(Media media, String search) {
    	return (String.valueOf(media.getId()).equals(search));
    }
    
    private ObservableList<Media> filterListTitle(List<Media> list, String search) {
    	List<Media> filteredList = new ArrayList<>();
    	
    	for (Media media : list) {
    		if (searchFindsTitle(media, search)) {
    			filteredList.add(media);
    		}
    	}
    	
    	return FXCollections.observableList(filteredList);
    }
    
    private ObservableList<Media> filterListId(List<Media> list, String search) {
    	List<Media> filteredList = new ArrayList<>();
    	
    	for (Media media : list) {
    		if (searchFindsId(media, search)) {
    			filteredList.add(media);
    		}
    	}
    	
    	return FXCollections.observableList(filteredList);
    }
    
    private void showFilteredMediaTitle() {
    	tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
    		tblMedia.setItems(filterListTitle(cart.getItemsOrdered(), newValue));
    	});
    }
    
	private void showFilteredMediaId() {
    	tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
    		tblMedia.setItems(filterListId(cart.getItemsOrdered(), newValue));
    	});
	}
   
}