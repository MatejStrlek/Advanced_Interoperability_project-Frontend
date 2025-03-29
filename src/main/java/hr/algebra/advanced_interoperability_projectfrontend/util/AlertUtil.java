package hr.algebra.advanced_interoperability_projectfrontend.util;

import javafx.scene.control.Alert;

public class AlertUtil {
    public static void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
