package hr.algebra.advanced_interoperability_projectfrontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {
    public void openGetMobileByIdScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("getMobileById.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("Get mobile by ID");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openUpdateMobileScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updateMobile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("Update mobile");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openCreateMobileScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createMobile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("Create mobile");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }

    public void openDeleteMobileScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteMobile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HelloApplication.getCentralStage().setTitle("Delete mobile");
        HelloApplication.getCentralStage().setScene(scene);
        HelloApplication.getCentralStage().show();
    }
}
