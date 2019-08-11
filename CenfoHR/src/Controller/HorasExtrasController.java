/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Usuario
 */
public class HorasExtrasController implements Initializable{
   @FXML
    private AnchorPane pnlHorasExtra;

    @FXML
    private TextField tfAsunto;

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField tfHorasextra;

    @FXML
    private ComboBox<String> cbProyecto;

    @FXML
    void enviarDatos(ActionEvent event) {   
       
    tfAsunto.getText();
    tfHorasextra.getText();
    cbProyecto.getValue();
    }

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObtenerProyectos();
    }

    private void ObtenerProyectos() {
      ObservableList<String> pProyecto=FXCollections.observableArrayList("Proyecto 1","Proyecto 2");
      cbProyecto.setItems(pProyecto);
    }
    
    
}
