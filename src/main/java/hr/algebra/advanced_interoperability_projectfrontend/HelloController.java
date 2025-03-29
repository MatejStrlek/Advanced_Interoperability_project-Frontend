package hr.algebra.advanced_interoperability_projectfrontend;

import hr.algebra.advanced_interoperability_projectfrontend.config.RestTemplateFactory;
import hr.algebra.advanced_interoperability_projectfrontend.model.Mobile;
import hr.algebra.advanced_interoperability_projectfrontend.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Mobile> mobileTable;
    @FXML
    private TableColumn<Mobile, String> nameColumn;
    @FXML
    private TableColumn<Mobile, String> brandColumn;
    @FXML
    private TableColumn<Mobile, Double> priceColumn;
    @FXML
    private TableColumn<Mobile, String> descriptionColumn;
    @FXML
    private TableColumn<Mobile, Double> ratingColumn;

    @FXML
    protected void onHelloButtonClick() {
        RestTemplate restTemplate = RestTemplateFactory.createRestTemplate();

        String restEndpointUrl = "http://localhost:8081/rest/mobiles";

        try {
            ResponseEntity<Mobile[]> mobileArrayResponse =
                    restTemplate.getForEntity(restEndpointUrl, Mobile[].class);

            for (Mobile mobile : mobileArrayResponse.getBody()) {
                System.out.println("Mobile name: " + mobile.getName());
                System.out.println("Mobile brand: " + mobile.getBrand());
            }

            ObservableList<Mobile> mobiles = FXCollections.observableArrayList();
            Mobile[] mobileArray = mobileArrayResponse.getBody();
            List<Mobile> mobileList = new ArrayList<>(List.of(mobileArray));
            mobiles.addAll(mobileList);

            mobileTable.setItems(mobiles);
        }
        catch (Exception e) {
            AlertUtil.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }
}