package com.example.notepad;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class NotepadController {
    @FXML
    private TextArea textArea;

    @FXML
    private String fileName;

    @FXML
    protected void onMenuItemOpenClick() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Otwórz plik");
            File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(file);
            stringBuilder.append(scanner.nextLine());
            textArea.setText(String.valueOf(stringBuilder));
            fileName = file.getAbsolutePath();
        }
        catch (Exception e){
            textArea.setText("");
        }
    }
    @FXML
    protected void onMenuItemSaveClick() throws IOException {
        try{FileWriter fileWriter = new FileWriter(new File(fileName));
        fileWriter.write(textArea.getText());
        fileWriter.close();} catch (Exception e){
            onMenuItemOpenClick();
        }

    }
    @FXML
    protected void onMenuItemQuitClick() {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    protected void onMenuItemDeleteClick() {
        textArea.setText("");
    }
    @FXML
    protected void onMenuItemAboutClick() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("O programie");
        a.setHeaderText("Program notepad wersja 0.0.1 Autor: Marek Wasiewski ");
        a.showAndWait();
    }
    @FXML
    protected void onMenuItemCipherClick() {
        textArea.setText("");
    }@FXML
    protected void onMenuItemDecipherClick() {
        textArea.setText("");
    }

}