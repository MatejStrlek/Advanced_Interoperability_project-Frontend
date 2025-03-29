package hr.algebra.advanced_interoperability_projectfrontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {

    public void openPostScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("postHardware.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("POST");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openGetByIdScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("getMobileById.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("GET BY ID");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openGetAllReviewsByCodeScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("getAllReviewsByCode.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("GET ALL REVIEWS BY CODE");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openPostReviewScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("postReview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("POST REVIEW");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }
}
