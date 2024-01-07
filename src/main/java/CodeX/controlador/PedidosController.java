package CodeX.controlador;

import CodeX.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;


public class PedidosController {
    private Datos datos;

    // Componentes del menú principal de pedidos

    @FXML private Button AgregarPedido;
    @FXML private Button EliminarPedido;
    @FXML private Button MostrarPedidos;
    @FXML private Button VolverMenuPrincipal;

    // Los archivos FXML separados para cada vista
    private final String agregarPedidoView = "/vista/MenuAgregarPEDIDO.fxml";
    private final String mostrarPedidosView = "/vista/MenuListarPEDIDOSv2.fxml";
    private final String eliminarPedidoView = "/vista/MenuEliminarPEDIDO.fxml";
    private final String menuPrincipalView = "/vista/MenuInicial.fxml";

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
    // Método para abrir la ventana de mostrar pedidos
    @FXML
    private void abrirMostrarPedidos(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuListarPEDIDOSv2.fxml")); // Asegúrate de que el nombre del archivo FXML sea correcto
        PedidosControllerTable pedidosControllerTable = new PedidosControllerTable();
        pedidosControllerTable.setDatos(datos);
        loader.setController(pedidosControllerTable);

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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

    // Metodo volver vista MenuCPedidos
    @FXML
    private void volverAMenuPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuPedidos.fxml");
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
            Alert alertaExito = new Alert(AlertType.INFORMATION);
            alertaExito.setTitle("Pedido Eliminado");
            alertaExito.setHeaderText(null);
            alertaExito.setContentText("El pedido ha sido eliminado con éxito.");
            alertaExito.showAndWait();

            // Opcional: Limpia el campo de texto
            IngresIdPedido.clear();
        } catch (Exception e) {
            // Muestra un mensaje de error
            Alert alertaError = new Alert(AlertType.ERROR);
            alertaError.setTitle("Error al Eliminar Pedido");
            alertaError.setHeaderText("Error en el Pedido");
            alertaError.setContentText(e.getMessage());
            alertaError.showAndWait();
        }
    }
/*
    // ----------------- Métodos para Mostrar Pedidos -------------------

    // Componentes de la vista MostrarPedidos (variantes Pendientes/Enviados)
    @FXML private TableView<Pedidos> tableViewPedidos;
    @FXML private TableColumn<Pedidos, String> idPedido, nombreCliente, emailCliente, codigoArticulo, cantidadArticulo, fechaPedido, nifCliente;
    @FXML private Button ListarPendientes;
    @FXML private Button ListarEnviados;
    @FXML private Button Todos;
    @FXML private Button VolverMenuPedidos03;

    @FXML
    private void configurarYCargarPedidos() {
        // Configura las columnas de la tabla
        idPedido.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        nombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        emailCliente.setCellValueFactory(new PropertyValueFactory<>("emailCliente"));
        codigoArticulo.setCellValueFactory(new PropertyValueFactory<>("codigoArticulo"));
        cantidadArticulo.setCellValueFactory(new PropertyValueFactory<>("cantidadArticulo"));
        fechaPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        nifCliente.setCellValueFactory(new PropertyValueFactory<>("nifCliente"));

        // Cargar todos los pedidos
        List<Pedidos> listaPedidos = new ArrayList<>();
        listaPedidos.addAll(datos.listarPedidosPendientes(null));
        listaPedidos.addAll(datos.listarPedidosEnviados(null));
        cargarPedidosEnTabla(listaPedidos);
    }
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

    // Este método se llama cuando se hace clic en el botón "Todos"
    @FXML
    private void listarTodosLosPedidos(ActionEvent event) {
        configurarYCargarPedidos();
    }
    // Método para cargar los pedidos en la tabla
    private void cargarPedidosEnTabla(List<Pedidos> listaPedidos) {
        ObservableList<Pedidos> pedidos = FXCollections.observableArrayList(listaPedidos);
        tableViewPedidos.setItems(pedidos);
    }

 */

}