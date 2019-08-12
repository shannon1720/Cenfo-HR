/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import Entities.*;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Usuario
 */
public class PermisoSalidaController implements Initializable {

    NotificacionLogica miNotificacion = new NotificacionLogica();
    @FXML
    private AnchorPane pnlPermisoSalida;
    @FXML
    private ComboBox<String> cbTipoPermiso;
    @FXML
    private TextField tfAsunto;
    @FXML
    private Button btnEnviar;
    @FXML
    private DatePicker tfEntrada;
    @FXML
    private DatePicker tfSalida;
    @FXML
    private TextArea tfDescripcion;

    @FXML
    void enviarDatos(ActionEvent event) {
        int idNotificacion = miNotificacion.crearNotificaciones(new Notificacion(tfAsunto.getText(), Personal.getMipersonal().getIdentificacion()));
        String mensaje = miNotificacion.crearNotificacionesPermiso(new PermisoSalida(Date.from(tfSalida.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(tfEntrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), tfDescripcion.getText(), cbTipoPermiso.getValue(), idNotificacion));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText(mensaje);
        limpiarcampos();
        alert.show();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        obtenerProyectos();
    }

    private void obtenerProyectos() {
        ObservableList<String> pTiposDepermiso = FXCollections.observableArrayList("Cita médica", "Vacaciones", "Ausencia medio dia", "Ausencia dia completo");
        cbTipoPermiso.setItems(pTiposDepermiso);
    }

    private void limpiarcampos() {
        tfAsunto.setText("");
        tfDescripcion.setText("");

    }
}
