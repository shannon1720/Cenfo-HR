/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane panelPaCambiar;
    @FXML
    private Button btnBandeja;
    @FXML
    private Button btnMensajes;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private AnchorPane panelMenuSuperior;
    @FXML
    private Button btnProyecto;
    @FXML
    private Button btnPersonal;
    @FXML
    private AnchorPane panelMenuEmpleado1;

    @FXML
    void panelPerfil(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/GUI/personal.fxml"));
        panelPaCambiar.getChildren().setAll(pane1);
    }

    @FXML
    void panelProyecto(ActionEvent event) {

    }

    @FXML
    void panelBandeja(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/GUI/notificaciones.fxml"));
        panelPaCambiar.getChildren().setAll(pane1);
    }

    @FXML
    void panelPagos(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/GUI/pagos.fxml"));
        panelPaCambiar.getChildren().setAll(pane1);
    }

    @FXML
    public void panelMensajes(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Resources/NotificacionesOpcion.fxml"));
        panelPaCambiar.getChildren().setAll(pane2);
    }

    @FXML
    void panelPersonal(ActionEvent event) throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/Resources/PersonalCrear.fxml"));
        panelPaCambiar.getChildren().setAll(pane3);
    }

    @FXML
    void panelInicioSesion(ActionEvent event) throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/Resources/InicioSesion.fxml"));
        panelMenuEmpleado1.getChildren().setAll(pane3);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NotificacionLogica miNotificacion = new NotificacionLogica();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText(miNotificacion.notificarObservador());
        alert.show();
    }

}
