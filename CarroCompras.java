import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Write a description of class CarroCompras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarroCompras {
    
    private Map<Producto, Integer> productos;
    private Comprador comprador;
    
    /**
    * Constructor for objects of class CarroCompras
     */
    
    public CarroCompras(Comprador comprador) {
        this.productos = new HashMap<>();
        this.comprador = comprador;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (productos.containsKey(producto)) {
            int cantidadActual = productos.get(producto);
            productos.put(producto, cantidadActual + cantidad);
            System.out.println("Se aumentó la cantidad de " + producto.getNombre() + " en el carrito de compras a " + (cantidadActual + cantidad));
        } else {
            productos.put(producto, cantidad);
            System.out.println("Se agregó el producto " + producto.getNombre() + " al carrito de compras");
        }
    }

    public void eliminarProducto(Producto producto) {
        if (productos.containsKey(producto)) {
            productos.remove(producto);
            System.out.println("Se eliminó el producto " + producto.getNombre() + " del carrito de compras");
        } else {
            System.out.println("El producto " + producto.getNombre() + " no está en el carrito de compras");
        }
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }
    
    public Comprador getComprador(){
        return comprador;
    }
    
    public List<Pedido> hacerPedidos(String metodoPago) {
        List<Pedido> pedidos = new ArrayList<>();
        Map<Perfil, Pedido> pedidosPorPerfil = new HashMap<>();

        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            Perfil perfil = producto.getPerfil();
    
            // Si ya hay un pedido para este perfil, lo obtenemos
            Pedido pedido = pedidosPorPerfil.getOrDefault(perfil, null);
    
            // Si no existe un pedido para este perfil, creamos uno nuevo
            if (pedido == null) {
                pedido = new Pedido(perfil, this, metodoPago);
                pedidosPorPerfil.put(perfil, pedido);
                pedidos.add(pedido); // Agregamos el pedido a la lista de pedidos
            }
    
            // Agregamos el producto al pedido correspondiente
            pedido.agregarProducto(producto, cantidad);
        }
    
        return pedidos;
    }

}