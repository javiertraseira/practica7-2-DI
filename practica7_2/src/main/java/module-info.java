module victor.practica7_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens victor.practica7_2 to javafx.fxml;
    exports victor.practica7_2;
    exports victor.practica7_2.controlador;
    opens victor.practica7_2.controlador to javafx.fxml;
}