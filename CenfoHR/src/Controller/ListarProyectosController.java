/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessLayer.ProyectoLogica;
import Entities.Notificacion;
import Entities.Personal;
import Entities.Proyecto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Tremi
 */
public class ListarProyectosController implements Initializable {

    @FXML
    private AnchorPane pnlListarProyectos;

    @FXML
    private TableView<Proyecto> tblProyectos;

    @FXML
    private TableColumn<Proyecto, String> colCodigo;

    @FXML
    private TableColumn<Proyecto, String> colNombre;

    @FXML
    private TableColumn<Proyecto, Date> colFechaFin;

    @FXML
    private TableColumn<Proyecto, String> colEstado;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnVolver;

    private ProyectoLogica pLogica = new ProyectoLogica();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    public void loadTable() {
        ArrayList<Proyecto> lstProyectos = new ArrayList<Proyecto>();
        String msj = "";
        try {
            lstProyectos = pLogica.listarProyectos(getUserId());
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        ObservableList<Proyecto> rowsProyectos = FXCollections.observableList(lstProyectos);

        colCodigo.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("estado"));
        colFechaFin.setCellValueFactory(new PropertyValueFactory<Proyecto, Date>("fechaFin"));
        tblProyectos.setItems(rowsProyectos);
    }

    public String getUserId() {
        return Personal.getMipersonal().getIdentificacion();
    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/Resources/MenuProyectos.fxml"));
        pnlListarProyectos.getChildren().setAll(pane1);
    }
}
