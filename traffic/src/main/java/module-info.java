module com.tay.trafficlight {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.lab2 to javafx.fxml;
    exports com.lab2;
}