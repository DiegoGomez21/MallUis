import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    // instance variables - replace the example below with your own
    private Vendedor vendedor;
    private Comprador comprador;
    private List<Producto> productos;
    private int precioTotal;
    private String metodoPago;
    private String estado;

    /**
     * Constructor for objects of class Pedido
     */
    public Pedido(Vendedor vendedor, Comprador comprador, CarroCompras carrito, int precioTotal, String metodoPago, String estado) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.productos = carrito.getProductos();
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
