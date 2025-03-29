package hr.algebra.advanced_interoperability_projectfrontend;

import hr.algebra.advanced_interoperability_projectfrontend.config.RestTemplateFactory;
import hr.algebra.advanced_interoperability_projectfrontend.model.Mobile;
import hr.algebra.advanced_interoperability_projectfrontend.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class GetMobileByIdController {
    @FXML
    private TextField idField;
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

    public void getMobileById() {
        if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
            AlertUtil.showAlert("Error", "Please enter mobile ID", Alert.AlertType.WARNING);
            return;
        }

        long mobileId = Long.parseLong(idField.getText());
        RestTemplate restTemplate = RestTemplateFactory.createRestTemplate();

        String restEndpointUrl = "http://localhost:8081/rest/mobiles/" + mobileId;

        try {
            ResponseEntity<Mobile> mobileResponse =
                    restTemplate.getForEntity(restEndpointUrl, Mobile.class);

            System.out.println("Mobile ID: " + mobileId);
            System.out.println("Mobile name: " + mobileResponse.getBody().getName());
            System.out.println("Mobile brand: " + mobileResponse.getBody().getBrand());

            nameField.setText(mobileResponse.getBody().getName());
            brandField.setText(mobileResponse.getBody().getBrand());
            priceField.setText(String.valueOf(mobileResponse.getBody().getPrice()));
            descriptionField.setText(mobileResponse.getBody().getDescription());
            ratingField.setText(String.valueOf(mobileResponse.getBody().getRating()));
        }
        catch (HttpClientErrorException e) {
            AlertUtil.showAlert("Error", "Mobile with ID " + mobileId + " not found", Alert.AlertType.WARNING);
            System.out.println("Mobile with ID " + mobileId + " not found");
        }
        catch (RestClientException e) {
            AlertUtil.showAlert("Error", "Error while fetching mobile with ID " + mobileId, Alert.AlertType.ERROR);
            System.out.println("Error while fetching mobile with ID " + mobileId);
        }
    }
}
