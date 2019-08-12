/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import Entities.Notificacion;
import Entities.PermisoHorasExtra;
import Entities.Personal;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class HorasExtrasController implements Initializable {

    NotificacionLogica miNotificacion = new NotificacionLogica();
    @FXML
    private AnchorPane pnlHorasExtra;
    @FXML
    private TextField tfAsunto;
    @FXML
    private Button btnEnviar;
    @FXML
    private DatePicker tfFecha;
    @FXML
    private TextField tfHorasextra;

    @FXML
    private ComboBox<String> cbProyecto;

    @FXML
    void enviarDatos(ActionEvent event) {
        int idNotificacion = miNotificacion.crearNotificaciones(new Notificacion(tfAsunto.getText(), Personal.getMipersonal().getIdentificacion()));
        String mensaje = miNotificacion.crearNotificacionesHoras(new PermisoHorasExtra(Integer.parseInt(tfHorasextra.getText()), idNotificacion, Date.from(tfFecha.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), cbProyecto.getValue()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText(mensaje);
        limpiarcampos();
        alert.show();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObtenerProyectos();
    }

    private void ObtenerProyectos() {
        ObservableList<String> pProyecto = FXCollections.observableArrayList("Proyecto 1", "Proyecto 2");
        cbProyecto.setItems(pProyecto);
    }

    private void limpiarcampos() {
        tfAsunto.setText("");
        tfHorasextra.setText("");

    }

}
