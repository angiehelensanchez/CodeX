package CodeX.controlador;

import CodeX.modelo.Datos;
import CodeX.modelo.Pedidos;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PedidosControllerTable implements Initializable {

    @FXML
    private Button VolverMenuPedidos03;
    @FXML
    private Button ListarPendientes;
    @FXML
    private Button ListarEnviados;
    @FXML
    private Button Todos;
    @FXML
    private ListView<String> ListaPedidos;

    private Datos datos;

    public PedidosControllerTable() {
        // inicialización si es necesario
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPedidos();
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    private void cargarPedidos() {
        List<Pedidos> listaPedidos = datos.listarPedidosPendientes(null); // Asumiendo que null es un valor aceptable
        cargarPedidosEnTabla(listaPedidos);
    }



    @FXML
    private void listarPedidosPendientes(ActionEvent event) {
        List<Pedidos> listaPedidos = datos.listarPedidosPendientes(null);

        if (listaPedidos.isEmpty()) {
            // Mostrar un mensaje si no hay pedidos pendientes
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información de Pedidos");
            alert.setHeaderText(null);
            alert.setContentText("No hay pedidos pendientes.");
            alert.showAndWait();
        } else {
            // Cargar los pedidos en la tabla si hay pedidos pendientes
            cargarPedidosEnTabla(listaPedidos);
        }
    }


    @FXML
    private void listarPedidosEnviados(ActionEvent event) {
        List<Pedidos> listaPedidos = datos.listarPedidosEnviados(null);
        cargarPedidosEnTabla(listaPedidos);
    }

    @FXML
    private void listarTodosLosPedidos(ActionEvent event) {
        // tu código aquí
    }


    private void cargarPedidosEnTabla(List<Pedidos> listaPedidos) {
        List<String> pedidosStr = listaPedidos.stream().map(Pedidos::toString).collect(Collectors.toList());
        ListaPedidos.getItems().setAll(pedidosStr);
    }

    @FXML
    private void volverAMenuPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuPedidos.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
