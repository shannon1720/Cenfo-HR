/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.ProyectoLogica;
import Entities.Proyecto;
import Entities.Proyecto.Estado;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Tremi
 */
public class CrearProyectoController implements Initializable {

    @FXML
    private AnchorPane pnlCrearProyecto;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnRegistrar;

    @FXML
    private DatePicker txtFechaInicio;

    @FXML
    private DatePicker txtFechaFin;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextArea txtDesc;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<String> txtEstado;

    ObservableList<String> estados;

    private ProyectoLogica pLogica = new ProyectoLogica();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validarNumericos();
        setCombobox();
        txtEstado.setItems(estados);
    }

    public void validarNumericos() {
        txtCodigo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtCodigo.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    public void crearProyecto(ActionEvent event) throws IOException {
        Proyecto nuevoProy = new Proyecto(txtNombre.getText(),
                Integer.parseInt(txtCodigo.getText()), Date.valueOf(txtFechaInicio.getValue()), Date.valueOf(txtFechaFin.getValue()), txtDesc.getText(), getValorEstado());
        String mnsj = (String) pLogica.crearObjeto(nuevoProy);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText(mnsj);
        alert.show();
        
        regresar();
    }

    public int getValorEstado() {
        int id = 0;
        for (Estado estado : Estado.values()) {
            if (estado.name().equalsIgnoreCase(txtEstado.getValue())) {
                id = estado.id;
            }
        }
        return id;
    }

    public void setCombobox() {

        List<String> lstEstados = new ArrayList<>();

        for (Estado estado : Estado.values()) {
            lstEstados.add(estado.name());
        }

        estados = FXCollections.observableArrayList(lstEstados);
        
    }

    @FXML
    void regresar() throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/MenuProyectos.fxml"));
        pnlCrearProyecto.getChildren().setAll(pane1);
    }



}
