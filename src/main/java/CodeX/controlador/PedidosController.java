package CodeX.controlador;

import CodeX.modelo.*;
import CodeX.controlador.Controlador;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import java.util.List;
import java.util.ArrayList;


public class PedidosController {
    private Datos datos;

    // Componentes del menú principal de pedidos

    @FXML private Button AgregarPedido;
    @FXML private Button EliminarPedido;
    @FXML private Button MostrarPedidos;
    @FXML private Button VolverMenuPrincipal;

    // Los archivos FXML separados para cada vista
    private final String agregarPedidoView = "/CodeX/vista/MenuAgregarPEDIDO.fxml";
    private final String mostrarPedidosView = "/CodeX/vista/MenuMostrarPEDIDOS.fxml";
    private final String eliminarPedidoView = "/CodeX/vista/MenuEliminarPEDIDO.fxml";
    private final String menuPrincipalView = "/CodeX/vista/MenuPrincipal.fxml";

    public PedidosController() {
        datos = new Datos();
    }

    // Métodos para abrir vistas específicas de pedidos
    @FXML
    private void abrirAgregarPedido(ActionEvent event) throws Exception {
        cambiarVista(event, agregarPedidoView);
    }
    @FXML
    private void abrirEliminarPedido(ActionEvent event) throws Exception {
        cambiarVista(event, eliminarPedidoView);
    }
    @FXML
    private void abrirMostrarPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, mostrarPedidosView);
    }
    @FXML
    private void volverMenuInicial(ActionEvent event) throws Exception {
        cambiarVista(event, menuPrincipalView);
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Metodo volver vista MenuClientes
    @FXML
    private void volverAMenuPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, "/CodeX/vista/MenuPedidos.fxml");
    }

    // Métodos para manejar acciones específicas (agregar, eliminar, listar)

    // ----------------- Métodos para Agregar Pedido -------------------

    // Componentes de la vista AgregarPedido

    @FXML private TextField AgregarCodigoArticulo;
    @FXML private TextField AgregarCantidad;
    @FXML private TextField IntroducirMail;
    @FXML private Button Agregar;
    @FXML private Button VolverMenuPedidos01;

    // métodos específicos AgregarPedido
    @FXML
    private void agregarPedido(ActionEvent event) {
        try {
            String codigoArticulo = AgregarCodigoArticulo.getText();
            int cantidad = Integer.parseInt(AgregarCantidad.getText());
            String emailCliente = IntroducirMail.getText();

            datos.hacerPedidos(codigoArticulo, cantidad, emailCliente);

            // Muestra una alerta de confirmación de éxito
            Alert alertaExito = new Alert(AlertType.INFORMATION);
            alertaExito.setTitle("Pedido Agregado");
            alertaExito.setHeaderText(null);
            alertaExito.setContentText("El pedido ha sido agregado con éxito.");
            alertaExito.showAndWait();

            // Opcional: Limpia los campos después de agregar
            AgregarCodigoArticulo.clear();
            AgregarCantidad.clear();
            IntroducirMail.clear();

        } catch (NumberFormatException e) {
            // Muestra una alerta de error si la cantidad no es un número válido
            Alert alertaError = new Alert(AlertType.ERROR);
            alertaError.setTitle("Error en la Entrada");
            alertaError.setHeaderText("Cantidad Inválida");
            alertaError.setContentText("Por favor, ingresa un número válido para la cantidad.");
            alertaError.showAndWait();
        } catch (Exception e) {
            // Muestra una alerta de error para otras excepciones
            Alert alertaError = new Alert(AlertType.ERROR);
            alertaError.setTitle("Error al Agregar Pedido");
            alertaError.setHeaderText("Error en el Pedido");
            alertaError.setContentText(e.getMessage());
            alertaError.showAndWait();
        }
    }

    // ----------------- Métodos para Eliminar Pedido -------------------

    // Componentes de la vista EliminarPedido

    @FXML private TextField IngresIdPedido;
    @FXML private Button Eliminar;
    @FXML private Button VolverMenuPedidos02;

    // métodos específicos EliminarPedido
    @FXML
    private void eliminarPedido(ActionEvent event) {
        try {
            String idPedido = IngresIdPedido.getText();
            datos.eliminarPedidos(idPedido);

            // Muestra una confirmación de éxito
            Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
            alertaExito.setTitle("Pedido Eliminado");
            alertaExito.setHeaderText(null);
            alertaExito.setContentText("El pedido ha sido eliminado con éxito.");
            alertaExito.showAndWait();

            // Opcional: Limpia el campo de texto
            IngresIdPedido.clear();
        } catch (Exception e) {
            // Muestra un mensaje de error
            Alert alertaError = new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error al Eliminar Pedido");
            alertaError.setHeaderText("Error en el Pedido");
            alertaError.setContentText(e.getMessage());
            alertaError.showAndWait();
        }
    }

    // ----------------- Métodos para Mostrar Pedidos -------------------

    // Componentes de la vista MostrarPedidos (variantes Pendientes/Enviados)
    @FXML private TableView<Pedidos> tableViewPedidos;
    @FXML private TableColumn<Pedidos, String> idPedido, nombreCliente, emailCliente, codigoArticulo, cantidadArticulo, fechaPedido, nifCliente;
    @FXML private Button ListarPendientes;
    @FXML private Button ListarEnviados;
    @FXML private Button Todos;
    @FXML private Button VolverMenuPedidos03;

    @FXML
    private void listarPedidosPendientes(ActionEvent event) {
        List<Pedidos> listaPedidos = datos.listarPedidosPendientes(null);
        cargarPedidosEnTabla(listaPedidos);
    }

    @FXML
    private void listarPedidosEnviados(ActionEvent event) {
        List<Pedidos> listaPedidos = datos.listarPedidosEnviados(null);
        cargarPedidosEnTabla(listaPedidos);
    }

    @FXML
    private void listarTodosLosPedidos(ActionEvent event) {
        List<Pedidos> listaPedidos = new ArrayList<>();
        listaPedidos.addAll(datos.listarPedidosPendientes(null));
        listaPedidos.addAll(datos.listarPedidosEnviados(null));
        cargarPedidosEnTabla(listaPedidos);
    }

    private void cargarPedidosEnTabla(List<Pedidos> listaPedidos) {
        ObservableList<Pedidos> pedidos = FXCollections.observableArrayList(listaPedidos);
        tableViewPedidos.setItems(pedidos);
    }

}


