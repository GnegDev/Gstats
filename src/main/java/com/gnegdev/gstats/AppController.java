package com.gnegdev.gstats;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;


public class AppController {
    private double[] numbersArray;


    @FXML
    private TextArea arrayInput;
    @FXML
    private TextField separatorInput;
    @FXML
    private ComboBox<String> meanSelector;
    @FXML
    private TextField meanOutput;
    @FXML
    private TextField minOutput;
    @FXML
    private TextField maxOutput;
    @FXML
    private TextField sumOutput;


    @FXML
    protected void initialize() {
        meanSelector.setItems(FXCollections.observableArrayList("Arithmetic mean", "Geometric mean", "Harmonic mean", "Median"));
    }


    @FXML
    protected void calculateArray() {
        if(!(arrayInput.getText().isEmpty() || separatorInput.getText().isEmpty())) {
            try {
                numbersArray = Arrays.stream(arrayInput.getText().replace(separatorInput.getText(), ",").split(",")).mapToDouble(Double::parseDouble).toArray();
            } catch (Exception ignored) {}
            if(numbersArray.length != 0) {
                minOutput.setText(String.valueOf(Arrays.stream(numbersArray).min().getAsDouble()));
                maxOutput.setText(String.valueOf(Arrays.stream(numbersArray).max().getAsDouble()));
                sumOutput.setText(String.valueOf(Arrays.stream(numbersArray).sum()));
                showMean();
            }
        }
    }
    @FXML
    protected void showMean() {
        if(!(numbersArray == null || meanSelector.getValue() == null)) {
            switch (meanSelector.getValue()) {
                case "Arithmetic mean" -> meanOutput.setText(String.valueOf(MeansAlgorithms.arithmeticMean(numbersArray)));
                case "Geometric mean" -> meanOutput.setText(String.valueOf(MeansAlgorithms.geometricMean(numbersArray)));
                case "Harmonic mean" -> meanOutput.setText(String.valueOf(MeansAlgorithms.harmonicMean(numbersArray)));
                case "Median" -> meanOutput.setText(String.valueOf(MeansAlgorithms.median(numbersArray)));
            }
        }
    }

    @FXML
    protected void showInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gstats");
        alert.setHeaderText("Gstats v1.0.0");
        alert.setContentText("By Ivan Valtuille\n\n2023 GnegDev");

        alert.showAndWait();
    }

}