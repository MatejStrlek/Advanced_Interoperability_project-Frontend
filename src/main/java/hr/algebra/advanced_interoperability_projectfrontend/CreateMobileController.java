package hr.algebra.advanced_interoperability_projectfrontend;

import hr.algebra.advanced_interoperability_projectfrontend.config.RestTemplateFactory;
import hr.algebra.advanced_interoperability_projectfrontend.model.Mobile;
import hr.algebra.advanced_interoperability_projectfrontend.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CreateMobileController {
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

    public void createMobile() {
        if (!validateFields()) {
            return;
        }

        RestTemplate restTemplate = RestTemplateFactory.createRestTemplate();
        String restEndpointUrl = "http://localhost:8081/rest/mobiles";

        try {
            Mobile mobile = new Mobile(
                    nameField.getText(),
                    brandField.getText(),
                    Double.parseDouble(priceField.getText()),
                    descriptionField.getText(),
                    Double.parseDouble(ratingField.getText()));

            ResponseEntity<?> response = restTemplate.postForEntity(restEndpointUrl, mobile, String.class);

            System.out.println("Status code: " + response.getStatusCodeValue());
            System.out.println("Body: " + response.getBody());
            AlertUtil.showAlert("Success", "Mobile created", Alert.AlertType.INFORMATION);

            clearFields();
        } catch (Exception e) {
            AlertUtil.showAlert("Error", "Error while creating mobile", Alert.AlertType.ERROR);
            System.out.println("Error while creating mobile");
        }
    }

    private void clearFields() {
        nameField.clear();
        brandField.clear();
        priceField.clear();
        descriptionField.clear();
        ratingField.clear();
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

        else return true;
    }
}
