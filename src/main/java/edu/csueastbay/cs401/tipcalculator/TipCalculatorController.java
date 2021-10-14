package edu.csueastbay.cs401.tipcalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;


public class TipCalculatorController {

    private static final NumberFormat currency =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent =
            NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15); // default tip value

    @FXML private TextField amountTextField;
    @FXML private Button calculateButton;
    @FXML private Label tipPercentageLabel;
    @FXML private Slider tipPercentageSlider;
    @FXML private TextField tipTextField;
    @FXML private TextField totalTextField;

    @FXML
    void calculateButtonPress(ActionEvent event) {
        try {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));

        }
        catch (NumberFormatException ex) {
            amountTextField.setText(("Enter an amount"));
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }

    }

    public void initialize() {
        tipPercentageSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        // get the new value as an integer and change it to a decimal for the percent
                        tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                        tipPercentageLabel.setText(percent.format(tipPercentage));
                    }
                }
        );
    }

}
