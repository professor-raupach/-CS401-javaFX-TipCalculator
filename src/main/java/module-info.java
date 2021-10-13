module edu.csueastbay.cs401.tipcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.csueastbay.cs401.tipcalculator to javafx.fxml;
    exports edu.csueastbay.cs401.tipcalculator;
}