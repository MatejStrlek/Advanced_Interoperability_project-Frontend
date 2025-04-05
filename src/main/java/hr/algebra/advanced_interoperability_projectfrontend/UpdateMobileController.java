package hr.algebra.advanced_interoperability_projectfrontend;

import hr.algebra.advanced_interoperability_projectfrontend.config.RestTemplateFactory;
import hr.algebra.advanced_interoperability_projectfrontend.model.Mobile;
import hr.algebra.advanced_interoperability_projectfrontend.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.web.client.RestTemplate;

public class UpdateMobileController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField brandField;
    @FXML
    private TextField priceField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField ratingField;
    @FXML
    private TextField idField;

    public void updateMobile() {
        if (!validateFields()) {
            return;
        }

        RestTemplate restTemplate = RestTemplateFactory.createRestTemplate();
        String restEndpointUrl = "http://localhost:8081/rest/mobiles/" + idField.getText();

        try {
            Mobile mobile = new Mobile(
                    nameField.getText(),
                    brandField.getText(),
                    Double.parseDouble(priceField.getText()),
                    descriptionField.getText(),
                    Double.parseDouble(ratingField.getText()));

            restTemplate.put(restEndpointUrl, mobile);

            AlertUtil.showAlert("Success", "Mobile updated", Alert.AlertType.INFORMATION);

            clearFields();
        } catch (Exception e) {
            AlertUtil.showAlert("Error", "Error while updating mobile", Alert.AlertType.ERROR);
            System.out.println("Error while updating mobile");
        }
    }

    private boolean validateFields() {
        if (nameField.getText().isEmpty()) {
            AlertUtil.showAlert("Error", "Please enter mobile name", Alert.AlertType.WARNING);
            return false;
        }
        else if (brandField.getText().isEmpty()) {
            AlertUtil.showAlert("Error", "Please enter mobile brand", Alert.AlertType.WARNING);
            return false;
        }
        else if (priceField.getText().isEmpty() || !priceField.getText().matches("\\d+(\\.\\d+)?")) {
            AlertUtil.showAlert("Error", "Please enter mobile price", Alert.AlertType.WARNING);
            return false;
        }
        else if (descriptionField.getText().isEmpty()) {
            AlertUtil.showAlert("Error", "Please enter mobile description", Alert.AlertType.WARNING);
            return false;
        }
        else if (ratingField.getText().isEmpty() || !priceField.getText().matches("\\d+(\\.\\d+)?")) {
            AlertUtil.showAlert("Error", "Please enter mobile rating", Alert.AlertType.WARNING);
            return false;
        }
        else if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
            AlertUtil.showAlert("Error", "Please enter mobile ID", Alert.AlertType.WARNING);
            return false;
        }

        else return true;
    }

    private void clearFields() {
        nameField.clear();
        brandField.clear();
        priceField.clear();
        descriptionField.clear();
        ratingField.clear();
        idField.clear();
    }
}
