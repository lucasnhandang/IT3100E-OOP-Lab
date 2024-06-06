package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Store store;
    private Cart cart;
    public CartController(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(((Playable) media).toString());
        dialogPane.setHeaderText("Playing Media");
        dialog.setDialogPane(dialogPane);

        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        if (cart.getItemsOrdered().isEmpty()){
            dialogPane.setContentText("Your cart is empty.");
        }
        else {
            dialogPane.setContentText("An order has been created!\n" + "The order costs " + costLabel.getText());
            cart.deleteAll();
            costLabel.setText(" 0$!");
        }
        dialogPane.setHeaderText("Placing Order");
        dialog.setDialogPane(dialogPane);
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        setCost();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try{
            final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store,cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldStr, String newStr) {
                showFilteredMedia(newStr);
            }
        });
        setCost();
    }
    public void setCost(){
        float cost = 0;
        for (Media media : cart.getItemsOrdered()){
            cost += media.getCost();
        }
        costLabel.setText(cost + " $");
    }
    void updateButtonBar(Media media){
        if (media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }
    public void showFilteredMedia(String value){
        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered(), b -> true);

        if (value == null || value.isEmpty()) {
            filteredData.setPredicate(media -> true);
        } else {
            if (radioBtnFilterId.isSelected()) {
                filteredData.setPredicate(media -> String.valueOf(media.getId()).contains(value));
            } else if (radioBtnFilterTitle.isSelected()) {
                filteredData.setPredicate(media -> media.getTitle().toLowerCase().contains(value.toLowerCase()));
            }
        }

        tblMedia.setItems(filteredData);
    }
}