/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Usuario
 */
public class PermisoSalidaViewController implements Initializable {
    NotificacionLogica miNotificacion = new NotificacionLogica();
    
    @FXML
    private Button btnRechazar;

    @FXML
    private Button btnAceptar;

    @FXML
    private Label lbAsunto;

    @FXML
    private Label lbFechaSalida;

    @FXML
    private Label lbTipoPermiso;

    @FXML
    private Label lbDescripcion;

    @FXML
    private Label lbFechaEntrada;

    @FXML
    private Label lbRemitente;

    @FXML
    void aceptarNotificacion(ActionEvent event) {

    }

    @FXML
    void rechazarNotificacion(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
