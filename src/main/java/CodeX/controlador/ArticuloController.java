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
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ArticuloController {
    private Datos datos;

    // ---------------- Componentes -------------------

    // Componentes menu Articulo
    @FXML private Button AgregarArticuloButton;
    @FXML private Button EliminarArticuloButton;
    @FXML private Button ListarArticuloButton;
    @FXML private Button VolverButton01;

    // Los archivos FXML separados para cada vista
    private final String agregarArticuloView = "/CodeX/vista/MenuAgregarARTICULO.fxml";
    private final String eliminarArticuloView = "/CodeX/vista/MenuEliminarARTICULO.fxml";
    private final String listarArticuloView = "/CodeX/vista/MenuListarARTICULO.fxml";
    private final String menuPrincipalView = "/CodeX/vista/MenuPrincipal.fxml";

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
        cambiarVista(event, listarArticuloView);
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

    // Componentes del archivo FXML para agregar un artículo
    @FXML private TextField codigoTextField;
    @FXML private TextField descripcionTextField;
    @FXML private TextField precioTextField;
    @FXML private TextField gastosEnviosTextField;
    @FXML private TextField tiempoPreparacionTextField;
    @FXML private Button agregarArticuloButton;
    @FXML private Button VolverButton;

    // Componentes del archivo FXML para eliminar un artículo
    @FXML private TextField codigoEliminarTextField;
    @FXML private Button eliminarArticuloButton;

    // Componentes del archivo FXML para listar artículos
    @FXML private TableView<Articulo> TablaArticulos;
    @FXML private TableColumn<Articulo, String> codigo;
    @FXML private TableColumn<Articulo, String> descripcion;
    @FXML private TableColumn<Articulo, Float> precio;
    @FXML private TableColumn<Articulo, Float> gastosEnvio;
    @FXML private TableColumn<Articulo, Integer> tpreparacion;

    @FXML private Button ListarArticulosButton;

    // ----------------- Metodos -------------------

    public ArticuloController() {
              datos = new Datos ();
    }

    @FXML
    private void agregarArticulo(ActionEvent event) {
        try {
            String codigo = codigoTextField.getText();
            String descripcion = descripcionTextField.getText();
            float precio = Float.parseFloat(precioTextField.getText());
            float gastosEnvios = Float.parseFloat(gastosEnviosTextField.getText());
            int tiempoPreparacion = Integer.parseInt(tiempoPreparacionTextField.getText());

            datos.crearArticulo(codigo, descripcion, precio, gastosEnvios, tiempoPreparacion);
            // Proporcionar retroalimentación de éxito, por ejemplo, mostrar un mensaje al usuario
        } catch (NumberFormatException e) {
            // Manejar el error si los números no son válidos
            // Por ejemplo, mostrar un mensaje de error
        } catch (Exception e) {
            // Manejar otras excepciones, como un artículo duplicado
            // Por ejemplo, mostrar un mensaje de error
        }
    }

    @FXML
    private void eliminarArticulo(ActionEvent event) {
        try {
            String codigo = codigoEliminarTextField.getText();
            datos.eliminarArticulo(codigo);

            // Mostrar mensaje de éxito
            mostrarMensaje("Artículo eliminado con éxito.");
        } catch (Exception e) {
            // Mostrar mensaje de error si hay un problema
            mostrarMensaje("Error al eliminar artículo: " + e.getMessage());
        }
    }
    private void mostrarMensaje(String mensaje) {
        // Implementa la lógica para mostrar el mensaje al usuario
    }

    // Método para inicializar la tabla
    @FXML
    public void initialize() {
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        gastosEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
        tpreparacion.setCellValueFactory(new PropertyValueFactory<>("tpreparacion"));

        listarArticulos();
    }

    @FXML
    private void listarArticulos() {
        TablaArticulos.getItems().clear();
        List<Articulo> articulos = datos.listArticulos();
        TablaArticulos.getItems().addAll(articulos);
    }

}
