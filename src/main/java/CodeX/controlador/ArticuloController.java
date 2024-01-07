package CodeX.controlador;

import CodeX.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.control.Alert;
import CodeX.modelo.Articulo;
import CodeX.modelo.Datos;

public class ArticuloController {
    private Datos datos;

    // ---------------- Componentes -------------------

    // Componentes menu Articulo
    @FXML private Button AgregarArticuloButton;
    @FXML private Button EliminarArticuloButton;
    @FXML private Button ListarArticuloButton;
    @FXML private Button VolverButton01;

    // Los archivos FXML separados para cada vista
    private final String agregarArticuloView = "/vista/MenuAgregarARTICULO.fxml";
    private final String eliminarArticuloView = "/vista/MenuEliminarARTICULO.fxml";
   private final String listarArticuloView = "/vista/MenuListarARTICULOSv2.fxml";
    private final String menuPrincipalView = "/vista/MenuInicial.fxml";

    public ArticuloController() {
        datos = new Datos ();
    }

    // Métodos para abrir vistas específicas
    @FXML
    private void abrirAgregarArticulo(ActionEvent event) throws Exception {
        cambiarVista(event, agregarArticuloView);
    }
    @FXML
    private void abrirEliminarArticulo(ActionEvent event) throws Exception {
        cambiarVista(event, eliminarArticuloView);
    }
    @FXML
    private void abrirListarArticulos(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuListarARTICULOSv2.fxml"));
        ArticuloControllerTable articuloControllerTable = new ArticuloControllerTable();
        articuloControllerTable.setDatos(datos);
        loader.setController(articuloControllerTable);

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    // Metodo volver vista MenuCPedidos
    @FXML
    private void volverMenuInicial(ActionEvent event) throws Exception {
        cambiarVista(event, menuPrincipalView);
    }
    @FXML
    public void volverAMenuArticulo(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuArticulos.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent parent = loader.load();

        // Si es la vista de listar artículos, establecer 'datos'
        if (fxmlFile.equals(listarArticuloView)) {
            ArticuloControllerTable articuloControllerTable = loader.getController();
            articuloControllerTable.setDatos(datos);
        }
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    // ----------------- Métodos para Agregar Articulo -------------------

    // Componentes de la vista AgregarArticulo

    // Componentes del archivo FXML para agregar un artículo
    @FXML private TextField codigoTextField;
    @FXML private TextField descripcionTextField;
    @FXML private TextField precioTextField;
    @FXML private TextField gastosEnviosTextField;
    @FXML private TextField tiempoPreparacionTextField;
    @FXML private Button agregarArticuloButton;
    @FXML private Button VolverButton;

    @FXML
    private void agregarArticulo(ActionEvent event) {
        try {
            String codigo = codigoTextField.getText();
            String descripcion = descripcionTextField.getText();
            float precio = Float.parseFloat(precioTextField.getText());
            float gastosEnvios = Float.parseFloat(gastosEnviosTextField.getText());
            int tpreparacion = Integer.parseInt(tiempoPreparacionTextField.getText());

            datos.crearArticulo(codigo, descripcion, precio, gastosEnvios, tpreparacion);

            // Mostrar un mensaje de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Artículo agregado con éxito.");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            // Mostrar un mensaje de error por formato de número inválido
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error en el formato numérico. Por favor, revisa los datos ingresados.");
            alert.showAndWait();
        } catch (Exception e) {
            // Mostrar un mensaje de error por otro tipo de excepción
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al agregar el artículo: " + e.getMessage());
            alert.showAndWait();
        }
    }


    // Componentes del archivo FXML para eliminar un artículo
    @FXML private TextField codigoEliminarTextField;
    @FXML private Button eliminarArticuloButton;
    @FXML private Button VolverButton02;


    @FXML
    private void eliminarArticulo(ActionEvent event) {
        try {
            String codigo = codigoEliminarTextField.getText();
            datos.eliminarArticulo(codigo);

            // Mostrar mensaje de éxito
            mostrarMensaje("Éxito", "Artículo eliminado con éxito.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            // Mostrar mensaje de error si hay un problema
            mostrarMensaje("Error", "Error al eliminar artículo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipoAlerta) {
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


/*
    // Componentes del archivo FXML para listar artículos
    @FXML private TableView<Articulo> TablaArticulos;
    @FXML private TableColumn<Articulo, String> codigo;
    @FXML private TableColumn<Articulo, String> descripcion;
    @FXML private TableColumn<Articulo, Float> precio;
    @FXML private TableColumn<Articulo, Float> gastosEnvio;
    @FXML private TableColumn<Articulo, Integer> tpreparacion;

    @FXML private Button ListarArticulosButton;
    @FXML private Button VolverButton03;

    // ----------------- Metodos -------------------

    // Método para inicializar la tabla

    @FXML
    private void handleListarArticulosButtonAction(ActionEvent event) {
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        gastosEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosenvio"));
        tpreparacion.setCellValueFactory(new PropertyValueFactory<>("tpreparacion"));

        listarArticulos();
    }

    private void listarArticulos() {
        TablaArticulos.getItems().clear();
        List<Articulo> articulos = datos.listArticulos();
        TablaArticulos.getItems().addAll(articulos);
    }

 */


}
