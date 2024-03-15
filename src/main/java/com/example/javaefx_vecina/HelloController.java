package com.example.javaefx_vecina;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    public Button btnLogout;

    public VBox pnLogin;

    public Button pnLogout;

    public ColorPicker cpPicker;

    private static final String[] allUsernames = {"user1", "user2", "user3"};
    private static final String[] allPassword = {"pass1", "pass2", "pass3"};

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    protected void onLoginClick() throws IOException {
        String username = txtUser.getText();
        String password = txtPass.getText();

        boolean isValid = false;
        for (int i = 0; i < allUsernames.length; i++) {
            if (username.equals(allUsernames[i]) && password.equals(allPassword[i])) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getScene().getStylesheets().clear();
            p.getScene().getStylesheets().add(getClass().getResource("user1.css").toExternalForm());

            Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            scene.prefHeight(p.getScene().getHeight());
            scene.prefWidth(p.getScene().getWidth());
            p.getChildren().clear();
            p.getChildren().add(scene);
        }
    }

    @FXML
    protected void onLogoutClick() throws IOException {
        Color color = cpPicker.getValue();
        String realColor = "rgb(" +
                (int)(color.getRed() * 255) + ", " +
                (int)(color.getGreen() * 255) + ", " +
                (int)(color.getBlue() * 255) + ")";

        System.out.println(color);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("user1.css").getPath(), true));
            bw.write(".button { -fx-background-color: " + realColor + " }");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }
        AnchorPane p = (AnchorPane) pnLogout.getParent();
        Parent scene = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}