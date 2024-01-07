package CodeX.controlador;

import CodeX.modelo.Articulo;
import CodeX.controlador.ArticuloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import CodeX.modelo.Datos;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ArticuloControllerTable implements Initializable {

    @FXML private ListView<String> ListaArticulos;
    private Datos datos;

    public ArticuloControllerTable() {
        // inicialización si es necesario
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatosEnLista();
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    private void cargarDatosEnLista() {
        List<Articulo> articulos = datos.listArticulos();
        List<String> articulosStr = articulos.stream().map(Articulo::toString).collect(Collectors.toList());
        ListaArticulos.getItems().setAll(articulosStr);
    }

    @FXML
    private void volverAMenuArticulo(ActionEvent event) throws Exception {
        cambiarVista(event, "/vista/MenuArticulos.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


/*
    @FXML private TableView<Articulo> TablaArticulos;
    @FXML private TableColumn<Articulo, String> codigo;
    @FXML private TableColumn<Articulo, String> descripcion;
    @FXML private TableColumn<Articulo, Float> precio;
    @FXML private TableColumn<Articulo, Float> gastosEnvio;
    @FXML private TableColumn<Articulo, Integer> tpreparacion;

    @FXML private Button VolverButton03;

    // Constructor que acepta una instancia de Datos
    public ArticuloControllerTable(Datos datos) {
        this.datos = datos;
    }
    // Método setter para establecer la instancia de Datos
    public void setDatos(Datos datos) {
        this.datos = datos;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatosEnTabla();
    }

    // ----------------- Metodos -------------------

    // Método para inicializar la tabla

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
