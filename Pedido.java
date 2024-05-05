import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    // instance variables - replace the example below with your own
    private Perfil perfil;
    private Comprador comprador;
    private Map<Producto, Integer> productos;
    private double precioTotal;
    private String metodoPago;
    private String estado;
    /**
     * Constructor for objects of class Pedido
     */
    public Pedido(Perfil perfil, CarroCompras carrito, String metodoPago, String estado) {
        this.perfil = perfil;
        this.comprador = carrito.getComprador();
        this.productos = carrito.getProductos();
        this.precioTotal = this.calcularPrecioTotal();
        this.metodoPago = metodoPago;
        this.estado = estado;
        System.out.println("Se ha generado un pedido para "+comprador.getNombre()+" por un valor de "+precioTotal);
    }
    
    public void agregarProducto(Producto producto, int cantidad) {
        if (productos.containsKey(producto)) {
            int cantidadExistente = productos.get(producto);
            productos.put(producto, cantidadExistente + cantidad);
        } else {
            productos.put(producto, cantidad);
        }
        precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }

    public double getPrecioTotal() {
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
