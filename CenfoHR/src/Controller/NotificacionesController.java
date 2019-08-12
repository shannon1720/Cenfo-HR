/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import Entities.Notificacion;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Shannon
 */
public class NotificacionesController implements Initializable {

    NotificacionLogica miNotificacion = new NotificacionLogica();
    @FXML
    private Button btnBandeja;
    @FXML
    private Button btnHorasEntra;
    @FXML
    private AnchorPane pnlNotificaciones;
    @FXML
    private Button btnPermisoSalida;
    @FXML
    private TableView<Notificacion> tblNotificacion;

    @FXML
    private TableColumn<Notificacion, String> colRemitente;

    @FXML
    private TableColumn<Notificacion, String> colAsunto;

    @FXML
    private TableColumn<Notificacion, String> colEstado;

    @FXML
    private TableColumn<Notificacion, Date> colFecha;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button bntVer;

    private void panelBandeja() {
        List<Notificacion> lstNotificaciones = miNotificacion.listarNotificaciones();
        ObservableList<Notificacion> olstNotificaciones = FXCollections.observableList(lstNotificaciones);

        colRemitente.setCellValueFactory(new PropertyValueFactory<Notificacion, String>("remitente"));
        colAsunto.setCellValueFactory(new PropertyValueFactory<Notificacion, String>("asunto"));
        colEstado.setCellValueFactory(new PropertyValueFactory<Notificacion, String>("estado"));
        colFecha.setCellValueFactory(new PropertyValueFactory<Notificacion, Date>("fechaNotificacion"));
        tblNotificacion.setItems(olstNotificaciones);
    }

    @FXML
    private void horasExtra(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/HorasExtra.fxml"));
        pnlNotificaciones.getChildren().setAll(pane1);
    }

    @FXML
    private void permisoSalida(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Resources/PermisoSalida.fxml"));
        pnlNotificaciones.getChildren().setAll(pane2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panelBandeja();
    }

    @FXML
    void eliminarNotificacion(ActionEvent event) {
        Notificacion notificacionSeleccionada = tblNotificacion.getSelectionModel().getSelectedItem();
        miNotificacion.eliminarNotificacion(notificacionSeleccionada.getId());
        panelBandeja();
        
    }

    @FXML
    void verNotificacion(ActionEvent event) {
        Notificacion notificacionSeleccionada = tblNotificacion.getSelectionModel().getSelectedItem();
        miNotificacion.CambiarEstado(notificacionSeleccionada.getId());
        panelBandeja();
    }
}
