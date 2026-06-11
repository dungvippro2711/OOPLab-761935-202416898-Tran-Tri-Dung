package hust.soict.hedspi.aims.screen.customer.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        
        // Add 21 items to store to test LimitExceededException
        for (int i = 1; i <= 21; i++) {
            store.addMedia(new DigitalVideoDisc("Test DVD " + i, "Animation", "Director", 87, 19.95f));
        }
        
        // Add a DVD with length 0 to test PlayerException (Phần 11)
        store.addMedia(new DigitalVideoDisc("Error DVD (Test Part 11)", "Test", "Tester", 0, 1.0f));
        
        launch(args);
    }
}
