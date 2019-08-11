/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.PersonalLogica;
import Entities.Personal;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML
    public void buscarDocumento(ActionEvent event) {
            FileChooser fc= new FileChooser();
            File selectFile= fc.showOpenDialog(null);
            if(selectFile!=null){
            tfUrlDocumento.setText(selectFile.getPath());
            }
    }

    @FXML
    void enviarDatos(ActionEvent event) {

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
                }
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}
