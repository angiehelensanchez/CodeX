package CodeX.controlador;


import CodeX.modelo.Cliente;
import CodeX.modelo.Datos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ClienteControllerTable implements Initializable {

    @FXML private Button VolverMenuClientes02;
    @FXML private Button filtrarEstandarBtn;
    @FXML private Button filtrarPremiumBtn;
    @FXML private Button TodosBtn;
    @FXML private ListView<String> ListaClientes;
    private Datos datos;

    public ClienteControllerTable() {
        // inicialización si es necesario
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarClientes();
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    private void cargarClientes() {
        List<Cliente> clientes = datos.listarClientes();
        List<String> clientesStr = clientes.stream().map(Cliente::toString).collect(Collectors.toList());
        ListaClientes.getItems().setAll(clientesStr);
    }

    @FXML
    private void filtrarEstandar(ActionEvent event) {
        cargarClientesFiltrados("Estandar");
    }

    @FXML
    private void filtrarPremium(ActionEvent event) {
        cargarClientesFiltrados("Premium");
    }

    @FXML
    private void resetFiltro(ActionEvent event) {
        cargarClientes();
    }

    private void cargarClientesFiltrados(String tipo) {
        List<Cliente> clientes = datos.listarClientesFiltro(tipo);
        List<String> clientesStr = clientes.stream().map(Cliente::toString).collect(Collectors.toList());
        ListaClientes.getItems().setAll(clientesStr);
    }

    @FXML
    private void volverAMenuClientes(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuClientes.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}



