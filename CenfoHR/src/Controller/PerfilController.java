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
import Entities.Personal;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PerfilController implements Initializable {

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
    void editarDatos(ActionEvent event) {

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
                res = "Gerente";
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

}
