/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tremi
 */
public class MenuProyectosController implements Initializable {

    @FXML
    private AnchorPane panelProyectos;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnListar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnVolver;

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void panelCrear(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/CrearProyecto.fxml"));
        panelProyectos.getChildren().setAll(pane1);
    }



    @FXML
    void panelListar(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/ListarProyectos.fxml"));
        panelProyectos.getChildren().setAll(pane1);
    }

    @FXML
    void panelModificar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
