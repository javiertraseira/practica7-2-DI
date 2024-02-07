package victor.practica7_2.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {


    @FXML
    private Button BTN_div;
    @FXML
    private Button BTN_0;
    @FXML
    private Button BTN_2;
    @FXML
    private Button BTN_1;
    @FXML
    private Button BTN_C;
    @FXML
    private Button BTN_mult;
    @FXML
    private Button BTN_rest;
    @FXML
    private Button BTN_mas;
    @FXML
    private Button BTN_4;
    @FXML
    private Button BTN_3;
    @FXML
    private Button BTN_6;
    @FXML
    private Button BTN_5;
    @FXML
    private Button BTN_8;
    @FXML
    private Button BTN_7;
    @FXML
    private Button BTN_igual;
    @FXML
    private Button BTN_9;
    @FXML
    private Label resultado;

    private int currentNumber = 0;
    private int result = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultado.setText("0");
    }

    @FXML
    public void suma(ActionEvent actionEvent) {
        operate("+");
    }

    @FXML
    public void multiplicacion(ActionEvent actionEvent) {
        operate("*");
    }

    @FXML
    public void siete(ActionEvent actionEvent) {
        numberButtonPressed(7);
    }

    @FXML
    public void ocho(ActionEvent actionEvent) {
        numberButtonPressed(8);
    }

    @FXML
    public void dos(ActionEvent actionEvent) {
        numberButtonPressed(2);
    }

    @FXML
    public void seis(ActionEvent actionEvent) {
        numberButtonPressed(6);
    }

    @FXML
    public void nueve(ActionEvent actionEvent) {
        numberButtonPressed(9);
    }

    @FXML
    public void clear(ActionEvent actionEvent) {
        resetCalculator();
    }

    @FXML
    public void cuatro(ActionEvent actionEvent) {
        numberButtonPressed(4);
    }

    @FXML
    public void cinco(ActionEvent actionEvent) {
        numberButtonPressed(5);
    }

    @FXML
    public void division(ActionEvent actionEvent) {
        operate("/");
    }

    @FXML
    public void cero(ActionEvent actionEvent) {
        numberButtonPressed(0);
    }

    @FXML
    public void uno(ActionEvent actionEvent) {
        numberButtonPressed(1);
    }

    @FXML
    public void igual(ActionEvent actionEvent) {
        operate("=");
    }

    @FXML
    public void tres(ActionEvent actionEvent) {
        numberButtonPressed(3);
    }

    @FXML
    public void resta(ActionEvent actionEvent) {
        operate("-");
    }

    // Método genérico para cuando se presiona un botón de número
    private void numberButtonPressed(int number) {
        if (startNewNumber) {
            currentNumber = number;
            resultado.setText(String.valueOf(number));
            startNewNumber = false;
        } else {
            currentNumber = currentNumber * 10 + number;
            resultado.setText(resultado.getText() + number);
        }
    }

    // Método para manejar las operaciones
    private void operate(String newOperator) {
        if (!startNewNumber) {
            calculate();
            operator = newOperator;
            startNewNumber = true;
        } else if (newOperator.equals("=")) {
            calculate();
            operator = "";
            startNewNumber = true;
        }
    }

    // Método para calcular basado en el operador
    private void calculate() {
        switch (operator) {
            case "+":
                result += currentNumber;
                break;
            case "-":
                result -= currentNumber;
                break;
            case "*":
                result *= currentNumber;
                break;
            case "/":
                if (currentNumber != 0) {
                    result /= currentNumber;
                } else {
                    // Manejar división por cero
                    resultado.setText("Error");
                    resetCalculator();
                    return;
                }
                break;
            default:
                result = currentNumber;
                break;
        }
        resultado.setText(String.valueOf(result));
        currentNumber = result;
    }

    // Método para reiniciar la calculadora
    private void resetCalculator() {
        result = 0;
        currentNumber = 0;
        operator = "";
        startNewNumber = true;
        resultado.setText("0");
    }

}