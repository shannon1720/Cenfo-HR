/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import Entities.Notificacion;
import Entities.PermisoHorasExtra;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private Label lbAsunto;
    @FXML
    private Label lbHorasReportadas;
    @FXML
    private Label lbProyecto;
    @FXML
    private Label lbRemitente;
    @FXML
    private Label lbFechaSalida;
    @FXML
    private Label lbTipoPermiso;
    @FXML
    private Label lbDescripcion;
    @FXML
    private Label lbFechaEntrada;
    @FXML
    private Label lbFechaHorasExtra;
    @FXML
    private Button btnRechazarP;
    @FXML
    private Button btnAceptarP;
    @FXML
    private Button btnRechazarH;
    @FXML
    private Button btnAceptarH;
    @FXML
    private VBox vbPermisoSalida;
     @FXML
    private AnchorPane vbHorasExtra;

    @FXML
    void aceptarNotificacionPermiso(ActionEvent event) {

    }

    @FXML
    void rechazarNotificacionPermiso(ActionEvent event) {

    }

    @FXML
    void aceptarNotificacionHoras(ActionEvent event) {

    }

    @FXML
    void rechazarNotificacionHoras(ActionEvent event) {

    }

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
        try {
            panelBandeja();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    void eliminarNotificacion(ActionEvent event) {
        Notificacion notificacionSeleccionada = tblNotificacion.getSelectionModel().getSelectedItem();
        notificacionSeleccionada.getId();
        miNotificacion.eliminarNotificacion(notificacionSeleccionada.getId());
        panelBandeja();

    }

    @FXML
    void verNotificacion(ActionEvent event) throws IOException {
        Notificacion notificacionSeleccionada = tblNotificacion.getSelectionModel().getSelectedItem();
        String CambiarEstado = miNotificacion.CambiarEstado(notificacionSeleccionada.getId());
        panelBandeja();
        Object notificacionObtenida = miNotificacion.ObtenerNotificacion(notificacionSeleccionada.getId());
        crearPanel(notificacionObtenida,notificacionSeleccionada);
    }
       private void crearPanel(Object notificacionObtenida, Notificacion notificacionSeleccionada) throws IOException {
        PermisoHorasExtra miExtra = (PermisoHorasExtra) notificacionObtenida;

        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString = df.format(miExtra.getFecha_horaExtra().getTime());

        AnchorPane pane4 = FXMLLoader.load(getClass().getResource("/Resources/HorasExtraVista.fxml"));
        pnlNotificaciones.getChildren().setAll(pane4);

//        lbFechaHorasExtra.setText(todayAsString);
        lbAsunto.setText(notificacionSeleccionada.getAsunto());
        lbRemitente.setText(notificacionSeleccionada.getRemitente());
        lbProyecto.setText(miExtra.getNombreProyecto());
        lbHorasReportadas.setText(String.valueOf(miExtra.getHorasExtra()));

    }
}
