module hr.algebra.advanced_interoperability_projectfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.web;


    opens hr.algebra.advanced_interoperability_projectfrontend to javafx.fxml;
    exports hr.algebra.advanced_interoperability_projectfrontend;
    exports hr.algebra.advanced_interoperability_projectfrontend.model;
    opens hr.algebra.advanced_interoperability_projectfrontend.model to com.fasterxml.jackson.databind;
}