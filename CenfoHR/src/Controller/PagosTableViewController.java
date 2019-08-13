/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Pagos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import DataAccess.PagosMapper;
import Entities.Personal;
import java.util.ArrayList;

/**
 *
 * @author franciscosandoval
 */
public class PagosTableViewController implements Initializable {

    @FXML
    private Button btnActualizar;

    @FXML
    void actualizarTablaPagos(ActionEvent event) {
        tblPagos.setItems(agregarPagosATabla());
    }

    //configurar la tabla de pagos
    @FXML
    private TableView<Pagos> tblPagos;
    @FXML
    private TableColumn<Pagos, String> colMes;
    @FXML
    private TableColumn<Pagos, Integer> colAnho;
    @FXML
    private TableColumn<Pagos, Integer> colHorasTrabajadas;
    @FXML
    private TableColumn<Pagos, Integer> colSalario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Set up the columns in the table
        colMes.setCellValueFactory(new PropertyValueFactory<Pagos, String>("mes"));
        colAnho.setCellValueFactory(new PropertyValueFactory<Pagos, Integer>("anho"));
        colHorasTrabajadas.setCellValueFactory(new PropertyValueFactory<Pagos, Integer>("totalHorasPorMes"));
        colSalario.setCellValueFactory(new PropertyValueFactory<Pagos, Integer>("totalAPagar"));

        //load dummy data
        tblPagos.setItems(agregarPagosATabla());

    }

    //Este metodo retorna un ObservableList de Pagos
    public ObservableList<Pagos> agregarPagosATabla() {
        ObservableList<Pagos> tmpPagos = FXCollections.observableArrayList();
        ArrayList<Pagos> lstPagos = new ArrayList<Pagos>();
        lstPagos = getPagos(); //Llama a metodo que obtiene la lista de pagos de la base de datos

        for (Pagos iPago : lstPagos) {
            tmpPagos.add(new Pagos(iPago.getMes(), iPago.getAnho(), iPago.getTotalHorasPorMes()));

        }

        return tmpPagos;

    }

    public ArrayList<Pagos> getPagos() {
        ArrayList<Pagos> lstPagos = new ArrayList<Pagos>();
        String id_persona = Personal.getMipersonal().getIdentificacion(); //Cambiar este id por el del usuario loggeado

        PagosMapper dataPagosBD = new PagosMapper();
        lstPagos = dataPagosBD.obtenerHorasLaborasPorFecha(id_persona);
        return lstPagos;
    }

}
