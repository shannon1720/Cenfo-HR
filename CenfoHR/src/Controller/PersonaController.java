/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.PersonalLogica;
import Entities.MediaPersonal;
import Entities.Personal;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class PersonaController implements Initializable {

    PersonalLogica mipersonal = new PersonalLogica();
    @FXML
    private AnchorPane pnlPersonalCrear;

    @FXML
    private TextField tfNombre;

    @FXML
    private Button btnRegistrar;

    @FXML
    private DatePicker tfNacimiento;

    @FXML
    private DatePicker tfEntrada;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    private TextField tfApellidoUno;

    @FXML
    private ComboBox<String> cbGenero;

    @FXML
    private TextField tfApellidoSegundo;

    @FXML
    private ComboBox<String> cbGradoAcademico;

    @FXML
    private TextField tfUrlDocumento;

    @FXML
    private Button btnBuscar;
    @FXML
    private TextField tfClave;
    @FXML
    private TextField tfIdentificacion;
    @FXML
    private AnchorPane pnlInicioSesion;

    @FXML
    private TextField tfCorreo;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField tfContraseña;
    ObservableList<String> pTiposDeRol = FXCollections.observableArrayList("Administrador", "Supervisor", "Empleado");
    ObservableList<String> pTiposDeGrado = FXCollections.observableArrayList("Bachillerato", "Diplomado", "Técnico");
    ObservableList<String> pTiposDeGenero = FXCollections.observableArrayList("Femenino", "Masculino", "Otro");

    @FXML
    public void buscarDocumento(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectFile = fc.showOpenDialog(null);
        if (selectFile != null) {
            tfUrlDocumento.setText(selectFile.getPath());
        }
    }

    @FXML
    public void enviarDatos(ActionEvent event) {

        int rol = 0, grado = 0;
        String genero = "";
        if (cbRol.getValue().equals("Administrador")) {
            rol = 1;
        } else {
            if (cbRol.getValue().equals("Supervisor")) {
                rol = 2;
            } else {
                if (cbRol.getValue().equals("Supervisor")) {
                    rol = 3;
                }
            }
        }
        if (cbGradoAcademico.getValue().equals("Bachillerato")) {
            grado = 1;
        } else {
            if (cbGradoAcademico.getValue().equals("Diplomado")) {
                grado = 2;
            } else {
                if (cbGradoAcademico.getValue().equals("Técnico")) {
                    grado = 3;
                }
            }
        }

        MediaPersonal mimedia = new MediaPersonal();
        mimedia.setTipo("Docuemento xls");
        mimedia.setUrl(tfUrlDocumento.getText());
        Personal miPersonal = new Personal(tfIdentificacion.getText(), tfNombre.getText(), tfApellidoUno.getText(), tfApellidoSegundo.getText(), Date.from(tfNacimiento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(tfEntrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), cbGenero.getValue(), tfClave.getText(), rol, grado, mimedia);
        if (validarPersonal(miPersonal)) {
            String mensaje = (String) mipersonal.crearObjeto(miPersonal);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText(mensaje);
        }
    }

    @FXML

    public void buscarDocumento(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectFile = fc.showOpenDialog(null);
        if (selectFile != null) {
            tfUrlDocumento.setText(selectFile.getPath());
        }
    }

    @FXML
    public void enviarDatos(ActionEvent event) {

        int rol = 0, grado = 0;
        if (cbRol.getValue().equals("Administrador")) {
            rol = 1;
        } else {
            if (cbRol.getValue().equals("Supervisor")) {
                rol = 2;
            } else {
                if (cbRol.getValue().equals("Supervisor")) {
                    rol = 3;
                }
            }
        }
        if (cbGradoAcademico.getValue().equals("Bachillerato")) {
            grado = 1;
        } else {
            if (cbGradoAcademico.getValue().equals("Diplomado")) {
                grado = 2;
            } else {
                if (cbGradoAcademico.getValue().equals("Técnico")) {
                    grado = 3;
                }
            }
        }

        MediaPersonal mimedia = new MediaPersonal();
        mimedia.setTipo("Docuemento xls");
        mimedia.setUrl(tfUrlDocumento.getText());
        Personal miPersonal = new Personal(tfIdentificacion.getText(), tfNombre.getText(), tfApellidoUno.getText(), tfApellidoSegundo.getText(), Date.from(tfNacimiento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(tfEntrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), cbGenero.getValue(), tfClave.getText(), rol, grado, mimedia);
        String mensaje =(String)mipersonal.crearObjeto(miPersonal);
        
    }

    @FXML
    public void ingresaSesion(ActionEvent event) throws Exception {

        Personal miPersonal2 = new Personal(), miPersonal;
        miPersonal2.setIdentificacion(tfCorreo.getText());
        miPersonal2.setContrasenna(tfContraseña.getText());
        miPersonal = (Personal) mipersonal.buscarObjeto(miPersonal2);
        if (miPersonal != null) {
            if (miPersonal.getRol() == 3) {
                AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/UiEmpleado.fxml"));
                pnlInicioSesion.getChildren().setAll(pane1);
            } else {
                if (miPersonal.getRol() == 2 || miPersonal.getRol() == 1) {
                    AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Resources/UiSuperior.fxml"));
                    pnlInicioSesion.getChildren().setAll(pane2);

    public void ingresaSesion(ActionEvent event) throws Exception {

        Entities.Personal miPersonal2 = new Personal(), miPersonal;
        miPersonal2.setIdentificacion(tfCorreo.getText());
        miPersonal2.setContrasenna(tfContraseña.getText());
        miPersonal = (Entities.Personal) mipersonal.buscarObjeto(miPersonal2);
        if (miPersonal != null) {
            if (miPersonal.getRol() == 3) {
                Personal.getPersonal(miPersonal);
                AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/UiEmpleado.fxml"));
                pnlInicioSesion.getChildren().setAll(pane1);
               
            } else {
                if (miPersonal.getRol() == 2 || miPersonal.getRol() == 1) {
                     Personal.getPersonal(miPersonal);
                    AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/Resources/UiSuperior.fxml"));
                    pnlInicioSesion.getChildren().setAll(pane2);
                  
                }
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        
        obtenerDatos();
    }

    private void obtenerDatos() {
        ObservableList<String> pTiposDeRol = FXCollections.observableArrayList("Administrador", "Supervisor", "Empleado");
        cbRol.setItems(pTiposDeRol);

        ObservableList<String> pTiposDeGrado = FXCollections.observableArrayList("Bachillerato", "Diplomado", "Técnico");
        cbGradoAcademico.setItems(pTiposDeGrado);
    }

    @FXML
    void llenarAcademico(MouseEvent event) {
        cbGradoAcademico.setItems(pTiposDeGrado);
    }

    @FXML
    void llenarGenero(ActionEvent event) {
        cbGenero.setItems(pTiposDeGenero);
    }

    @FXML
    void llenarRol(ActionEvent event) {
        cbRol.setItems(pTiposDeRol);
    }

    private boolean validarPersonal(Personal miPersonal) {
        boolean existe = false;
        ArrayList<Object> listaPersonal = mipersonal.listarObjeto();

        for (int i = 0; i < listaPersonal.size(); i++) {
            Personal miPersonal2 = (Personal) listaPersonal.get(i);

            if (miPersonal2.getIdentificacion().equals(miPersonal.getIdentificacion())) {
                existe = true;
            }
        }
        return existe;
    }
}
