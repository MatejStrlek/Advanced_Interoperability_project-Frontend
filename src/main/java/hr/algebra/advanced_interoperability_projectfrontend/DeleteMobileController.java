package hr.algebra.advanced_interoperability_projectfrontend;

import hr.algebra.advanced_interoperability_projectfrontend.config.RestTemplateFactory;
import hr.algebra.advanced_interoperability_projectfrontend.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class DeleteMobileController {
    @FXML
    private TextField idField;

    public void deleteMobile() {
        if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
            AlertUtil.showAlert("Error", "Please enter mobile ID", Alert.AlertType.WARNING);
            return;
        }

        long mobileId = Long.parseLong(idField.getText());
        RestTemplate restTemplate = RestTemplateFactory.createRestTemplate();

        String restEndpointUrl = "http://localhost:8081/rest/mobiles/" + mobileId;

        try {
            restTemplate.delete(restEndpointUrl);
            AlertUtil.showAlert("Success", "Mobile deleted", Alert.AlertType.INFORMATION);
        }
        catch (HttpClientErrorException e) {
            AlertUtil.showAlert("Error", "Mobile with ID " + mobileId + " not found", Alert.AlertType.WARNING);
            System.out.println("Mobile with ID " + mobileId + " not found");
        }
        catch (RestClientException e) {
            AlertUtil.showAlert("Error", "Error while fetching mobile with ID", Alert.AlertType.ERROR);
            System.out.println("Error while fetching mobile with ID " + mobileId);
        }
    }
}
