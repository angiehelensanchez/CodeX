package CodeX.controlador;
import CodeX.modelo.*;

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

public class Controlador {
    private Datos datos;
    public Controlador() {
        datos = new Datos ();
    }


    @FXML
    private void abrirMenuArticulos(ActionEvent event) throws Exception {
        cambiarVista(event, "/path/to/MenuArticulos.fxml");
    }

    @FXML
    private void abrirMenuClientes(ActionEvent event) throws Exception {
        cambiarVista(event, "/path/to/MenuClientes.fxml");
    }

    @FXML
    private void abrirMenuPedidos(ActionEvent event) throws Exception {
        cambiarVista(event, "/path/to/MenuPedidos.fxml");
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void cambiarVista(ActionEvent event, String fxmlFile) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
/*
    //CLIENTES
    public void aNuevoCliente(String tipocliente, String nombre, String domicilio, String email, String nif){
        datos.agregarCliente(tipocliente, nombre, domicilio, email, nif);

    }
    public void eCliente(String email) throws Exception{
        datos.eliminarCliente(email);
    }
    public ArrayList<String> lClientes(){
        return datos.listarClientes();
    }
    public ArrayList<String> lcFiltro(String tipo){
        return datos.listarClientesFiltro(tipo);
    }
    public Cliente bCliente(String mail){
        return datos.getCliente(mail);
    }



/*
    //ARTICULOS

    public void aNuevoArticulo(String codigo, String descripcion, Float precio, Float gastosenvios, int tpreparacion) throws Exception{
        datos.crearArticulo(codigo, descripcion, precio, gastosenvios, tpreparacion);
    }

    public void eArticulo(String id) throws Exception{
        datos.eliminarArticulo(id);
    }

   /* public ArrayList<String> lArticulo(){
        return datos.listArticulos();
    }

    */
/*
    public Articulo bArticulo(String codigo){
        return datos.getArticulo(codigo);
    }
    */

    //PEDIDOS
    public void aPedido(String arti, int cantidad, String cliente){ datos.hacerPedidos(arti,cantidad,cliente);}
    public Pedidos bPedido(String id){ return datos.buscarPedidos(id);}
    public void ePedido(String id){
        datos.eliminarPedidos(id);
    }
    public ArrayList<String> lPendientes(String email){
        return datos.listarPedidosPendientes(email);
    }
    public ArrayList<String> lEnviados(String email){
        return datos.listarPedidosEnviados(email);
    }

}
