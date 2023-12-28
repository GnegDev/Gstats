module com.gnegdev.gstats {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gnegdev.gstats to javafx.fxml;
    exports com.gnegdev.gstats;
}