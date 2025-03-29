module hr.algebra.advanced_interoperability_projectfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens hr.algebra.advanced_interoperability_projectfrontend to javafx.fxml;
    exports hr.algebra.advanced_interoperability_projectfrontend;
}