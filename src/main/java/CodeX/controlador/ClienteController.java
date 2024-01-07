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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;


import java.util.List;

public class ClienteController {
    private Datos datos;

    // ---------------- Componentes de Menú Clientes -------------------

    @FXML private Button AgregarCliente;
    @FXML private Button MostrarClientes;
    @FXML private Button EliminarCliente;
    @FXML private Button VolverMenu;

    // Los archivos FXML separados para cada vista
    private final String agregarClienteView = "/vista/MenuAgregarCLIENTE.fxml";
    private final String mostrarClientesView = "/vista/MenuMostrarCLIENTESv2.fxml";
    private final String eliminarClienteView = "/vista/MenuEliminarCLIENTE.fxml";
    private final String menuPrincipalView = "/vista/MenuInicial.fxml";

    public ClienteController() {
        datos = new Datos();
    }

    // Métodos para manejar eventos en el menú principal de clientes

    @FXML
    private void abrirAgregarCliente(ActionEvent event) throws Exception {
        cambiarVista(event, agregarClienteView);
    }
    @FXML
    private void abrirMostrarClientes(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuMostrarCLIENTESv2.fxml"));
        ClienteControllerTable clienteControllerTable = new ClienteControllerTable();
        clienteControllerTable.setDatos(datos);
        loader.setController(clienteControllerTable);

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void abrirEliminarCliente(ActionEvent event) throws Exception {
        cambiarVista(event, eliminarClienteView);
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
    private void volverAMenuClientes(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuClientes.fxml");
    }

    // Métodos específicos para las acciones de cliente >

    // ----------------- Métodos para Agregar Cliente -------------------

    // Componentes de la vista AgregarCliente
    @FXML private TextField NombreCliente;
    @FXML private TextField DireccionCliente;
    @FXML private TextField MailCliente;
    @FXML private TextField NIFCliente;
    @FXML private CheckBox ClienteEstandar;
    @FXML private CheckBox ClientePremium;
    @FXML private Button AgregarCliente01;
    @FXML private Button VolverMenuClente;

    // métodos específicos AgregarCliente
    @FXML
    private void agregarCliente(ActionEvent event) {
        try {
            String nombre = NombreCliente.getText();
            String direccion = DireccionCliente.getText();
            String email = MailCliente.getText();
            String nif = NIFCliente.getText();
            String tipoCliente = ClienteEstandar.isSelected() ? "Estandar" : "Premium";

            datos.agregarCliente(tipoCliente, nombre, direccion, email, nif);

            // Mostrar mensaje de éxito
            showAlert("Cliente Agregado", "El cliente ha sido agregado con éxito.", Alert.AlertType.INFORMATION);

            // Opcionalmente, limpia los campos para un nuevo ingreso
            NombreCliente.clear();
            DireccionCliente.clear();
            MailCliente.clear();
            NIFCliente.clear();
            ClienteEstandar.setSelected(false);
            ClientePremium.setSelected(false);

        } catch (Exception e) {
            // Mostrar mensaje de error
            showAlert("Error", "No se pudo agregar el cliente: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /*

    // ----------------- Métodos para Mostrar Clientes -------------------

    // Componentes de la vista MostrarClientes (variantes Estandar/Premium)
    @FXML private TableView<Cliente> MostrarClientes01;
    @FXML private TableColumn<Cliente, String> nif;
    @FXML private TableColumn<Cliente, String> nombre;
    @FXML private TableColumn<Cliente, String> domicilio;
    @FXML private TableColumn<Cliente, String> email;
    @FXML private TableColumn<Cliente, String> tipoCliente;
    @FXML private TableColumn<Cliente, String> DTYPE;
    @FXML private Button VolverMenuClientes02;
    @FXML private Button filtrarEstandarBtn;
    @FXML private Button filtrarPremiumBtn;
    @FXML private Button TodosBtn;
    // métodos específicos Clientes general

    private void configurarYCargarClientes() {
        nif.setCellValueFactory(new PropertyValueFactory<>("nif"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        domicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tipoCliente.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));
        DTYPE.setCellValueFactory(new PropertyValueFactory<>("DTYPE"));

        cargarClientes();
    }

    private void cargarClientes() {
        List<Cliente> clientes = datos.listarClientes();
        MostrarClientes01.getItems().setAll(clientes);
    }


   // Componentes de la vista MostrarClientes (variante Estandar)
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
        configurarYCargarClientes();
    }

    private void cargarClientesFiltrados(String tipo) {
        List<Cliente> clientes;
        if (tipo == null) {
            clientes = datos.listarClientes(); // Sin filtro
        } else {
            clientes = datos.listarClientesFiltro(tipo);
        }
        ObservableList<Cliente> clientesObservable = FXCollections.observableArrayList(clientes);
        MostrarClientes01.setItems(clientesObservable);
    }

    // Metodo volver vista MenuClientes
    @FXML
    private void volverAMenuClientes(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuClientes.fxml");
    }

     */

    // ----------------- Métodos para Eliminar Cliente -------------------

    // Componentes de la vista EliminarCliente
    @FXML private TextField IngresarMailClienteEliminar;
    @FXML private Button VolverMenuCliente04;

    @FXML
    private void eliminarCliente(ActionEvent event) {
        try {
            String email = IngresarMailClienteEliminar.getText();
            datos.eliminarCliente(email);

            // Muestra una alerta de confirmación
            Alert alertaConfirmacion = new Alert(AlertType.INFORMATION);
            alertaConfirmacion.setTitle("Confirmación");
            alertaConfirmacion.setHeaderText(null);
            alertaConfirmacion.setContentText("Cliente eliminado con éxito.");
            alertaConfirmacion.showAndWait();

            // Opcional: Limpia el campo de texto
            IngresarMailClienteEliminar.clear();
        } catch (Exception e) {
            // Muestra una alerta de error
            Alert alertaError = new Alert(AlertType.ERROR);
            alertaError.setTitle("Error");
            alertaError.setHeaderText("Error al eliminar el cliente");
            alertaError.setContentText(e.getMessage());
            alertaError.showAndWait();
        }
    }


}