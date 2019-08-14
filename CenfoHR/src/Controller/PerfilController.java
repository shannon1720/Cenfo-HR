/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author franciscosandoval
 */
import BusinessLayer.PersonalLogica;
import Entities.MediaPersonal;
import Entities.Personal;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PerfilController implements Initializable {

    PersonalLogica mipersonal = new PersonalLogica();

    @FXML
    private AnchorPane pnlPersonalCrear;

    @FXML
    private TextField perfil_id;

    @FXML
    private TextField perfil_nombre;

    @FXML
    private TextField perfil_papellido;

    @FXML
    private TextField perfil_sapellido;

    @FXML
    private DatePicker perfil_fechanac;

    @FXML
    private DatePicker perfil_fechaentrada;

    @FXML
    private ComboBox<String> perfil_rol;

    @FXML
    private ComboBox<String> perfil_genero;

    @FXML
    private ComboBox<String> perfil_gradoacad;

    @FXML
    private TextField perfil_urldoc;

    @FXML
    private PasswordField perfil_pass;

    @FXML
    private Button btnEditarPerfil;

    @FXML
    private Button btnGuardar;

    @FXML
    void editarDatos(ActionEvent event) {
        perfil_id.setDisable(false);
        perfil_nombre.setDisable(false);
        perfil_papellido.setDisable(false);
        perfil_sapellido.setDisable(false);
        perfil_rol.setDisable(false);
        perfil_gradoacad.setDisable(false);
        perfil_genero.setDisable(false);
        perfil_fechanac.setDisable(false);
        perfil_fechaentrada.setDisable(false);
        perfil_urldoc.setDisable(false);
        perfil_pass.setDisable(false);
    }

    @FXML
    void guardarDatos(ActionEvent event) {

        if (validateBlanks()) {
            int rol = 0, grado = 0;
            if (perfil_rol.getValue().equals("Administrador")) {
                rol = 1;
            } else {
                if (perfil_rol.getValue().equals("Supervisor")) {
                    rol = 2;
                } else {
                    if (perfil_rol.getValue().equals("Empleado")) {
                        rol = 3;
                    }
                }
            }
            if (perfil_gradoacad.getValue().equals("Bachillerato")) {
                grado = 1;
            } else {
                if (perfil_gradoacad.getValue().equals("Diplomado")) {
                    grado = 2;
                } else {
                    if (perfil_gradoacad.getValue().equals("Técnico")) {
                        grado = 3;
                    }
                }
            }

            MediaPersonal mimedia = new MediaPersonal();
            mimedia.setTipo("Documento xls");
            mimedia.setUrl("ruta");

            Personal miPersonal = new Personal();

            miPersonal.setIdentificacion(perfil_id.getText());
            miPersonal.setNombre(perfil_nombre.getText());
            miPersonal.setApellidoUno(perfil_papellido.getText());
            miPersonal.setApellidoDos(perfil_sapellido.getText());
            miPersonal.setFechaNacimiento(Date.from(perfil_fechanac.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            miPersonal.setFechaIngreso(Date.from(perfil_fechaentrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            miPersonal.setGenero(perfil_genero.getValue());
            miPersonal.setContrasenna(perfil_pass.getText());
            miPersonal.setRol(rol);
            miPersonal.setGrado_academico(grado);
            miPersonal.setMiMedia(mimedia);

            mipersonal.modificarObjeto(miPersonal);

            Alert errorAlert = new Alert(AlertType.CONFIRMATION);
            errorAlert.setHeaderText("Cambios guardados");
            errorAlert.setContentText("Los cambios han sido guardados en la base de datos");
            errorAlert.showAndWait();

            disableFields();

        }
    }

    @FXML
    void llenarAcademico(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perfil_id.setText(Personal.getMipersonal().getIdentificacion());
        perfil_nombre.setText(Personal.getMipersonal().getNombre());
        perfil_papellido.setText(Personal.getMipersonal().getApellidoUno());
        perfil_sapellido.setText(Personal.getMipersonal().getApellidoDos());

        perfil_rol.setValue(getNameRol(Personal.getMipersonal().getRol()));
        perfil_gradoacad.setValue(getNameGradoAcademico(Personal.getMipersonal().getGrado_academico()));
        perfil_genero.setValue(Personal.getMipersonal().getGenero());

        //Fechas
        perfil_fechanac.setValue(convertToLocalDateViaSqlDate(Personal.getMipersonal().getFechaNacimiento()));
        perfil_fechaentrada.setValue(convertToLocalDateViaSqlDate(Personal.getMipersonal().getFechaIngreso()));

        perfil_urldoc.setText(Personal.getMipersonal().getMiMedia().getTipo());

        //Pass
        perfil_pass.setText(Personal.getMipersonal().getContrasenna());

        System.out.println(Personal.getMipersonal().getMiMedia().getTipo()); //Devuelve null
        System.out.println(Personal.getMipersonal().getContrasenna()); // Devuelve null

        //Metodo que desabilita la edicion del campo de texto
        disableFields();

    }

    public String getNameRol(int id) {
        String res;
        switch (id) {
            case 1:
                res = "Administrador";
                return res;
            case 2:
                res = "Supervisor";
                break;
            case 3:
                res = "Empleado";
                break;
            default:
                res = "nombre invalido";
                break;
        }
        return res;
    }

    public String getNameGradoAcademico(int id) {
        String res;
        switch (id) {
            case 1:
                res = "Bachillerato";
                return res;
            case 2:
                res = "Diplomado";
                break;
            case 3:
                res = "Técnico";
                break;
            default:
                res = "nombre invalido";
                break;
        }
        return res;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public void disableFields() {
        perfil_id.setDisable(true);
        perfil_nombre.setDisable(true);
        perfil_papellido.setDisable(true);
        perfil_sapellido.setDisable(true);
        perfil_rol.setDisable(true);
        perfil_gradoacad.setDisable(true);
        perfil_genero.setDisable(true);
        perfil_fechanac.setDisable(true);
        perfil_fechaentrada.setDisable(true);
        perfil_urldoc.setDisable(true);
        perfil_pass.setDisable(true);

    }

    public boolean validateBlanks() {

        if (perfil_id.getText() == null || perfil_nombre.getText() == null
                || perfil_papellido.getText() == null || perfil_sapellido.getText() == null
                || perfil_urldoc.getText() == null || perfil_pass.getText() == null) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Casillas vacias");
            errorAlert.setContentText("Por favor rellenar todas las casillas");
            errorAlert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

}
