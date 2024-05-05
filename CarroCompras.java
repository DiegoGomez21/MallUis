import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class CarroCompras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarroCompras
{
    private List<Producto> productos;

    /**
     * Constructor for objects of class CarroCompras
     */
    public CarroCompras(Producto producto)
    {
        this.productos = new ArrayList<>();
        productos.add(producto);
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
}
