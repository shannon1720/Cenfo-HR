/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.NotificacionLogica;
import Entities.Notificacion;
import Entities.PermisoHorasExtra;
import Entities.PermisoSalida;
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
import javafx.scene.control.TextArea;
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
    private TextArea tfInfo;
    @FXML
    private Button btnEliminar;
    
    @FXML
    private Button bntVer;
  

    @FXML
    private Button btnRechazar;

    @FXML
    private Button btnAceptar;

    @FXML
    void aceptarNotificacion(ActionEvent event) {

    }
     @FXML
    void rechazarNotificacion(ActionEvent event) {

    }
    
    

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
            tfInfo.setEditable(false);
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
        PermisoHorasExtra miExtra = new PermisoHorasExtra();
        PermisoSalida miSalida=new PermisoSalida();
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString="";
        String info="";
        try{
        
        miExtra=(PermisoHorasExtra) notificacionObtenida;
        todayAsString = df.format(miExtra.getFecha_horaExtra().getTime());
       
        info=" Remitente:"+"\n "+notificacionSeleccionada.getRemitente()+
                  "\n Asunto:"+"\n "+notificacionSeleccionada.getAsunto()+"\n Fecha:"+"\n "+todayAsString+"\n Horas extra reportadas:"+"\n "+miExtra.getHorasExtra()+
                  "\n Nombre del proyecto:"+"\n "+miExtra.getNombreProyecto();
        tfInfo.setText(info);

        }catch(Exception ex){
            
        miSalida=(PermisoSalida)notificacionObtenida;
        todayAsString = df.format(notificacionSeleccionada.getFechaNotificacion().getTime());
        String fechaE=df.format(miSalida.getFechaentrada().getTime());
        String fechaS=df.format(miSalida.getFechasalida().getTime());
        info=" Remitente:"+"\n "+notificacionSeleccionada.getRemitente()+
                  "\n Asunto:"+"\n "+notificacionSeleccionada.getAsunto()+"\n Fecha:"+"\n "+todayAsString+"\n Tipo de permiso:"+"\n "+miSalida.getTipoNotificacion()+
                  "\n Fecha salida:"+"\n "+fechaS+"\n Fecha entrada:"+"\n "+fechaE+"\n Descripción:"+"\n "+miSalida.getDescripcion();
        tfInfo.setText(info);
        }

    }
}
