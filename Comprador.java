import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Write a description of class Comprador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comprador extends Usuario
{
    // instance variables - replace the example below with your own
    private int saldo;

    /**
     * Constructor for objects of class Comprador
     */
    public Comprador(String nombre, String correo, int telefono)
    {
        super(nombre,correo,telefono);
        saldo = 0;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
        System.out.println("Se ha establecido un saldo de "+saldo+" para "+this.getNombre());
    }
    
    public CarroCompras crearCarroCompras(Producto producto, int cantidad) {
        CarroCompras carro = new CarroCompras(this);
        System.out.println("El comprador "+this.getNombre()+" creo un carro de compras");
        carro.agregarProducto(producto,cantidad);
        return carro;
    }
    
    public void agregarProductoCarro(CarroCompras carro, Producto producto, int cantidad) {
        carro.agregarProducto(producto, cantidad);
    }
    
    public void eliminarProductoCarro(CarroCompras carro, Producto producto) {
        carro.eliminarProducto(producto);
    }
    
    public List<Pedido> crearPedido(CarroCompras carrito, String metodoPago){
        List<Pedido> pedidos = carrito.hacerPedidos(metodoPago);
        System.out.println("El comprador "+this.getNombre()+" ha realizado un pedido");
        return pedidos;
    }
}
