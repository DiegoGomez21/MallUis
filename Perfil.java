import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Perfil here. 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Perfil
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String horario;
    private String ubicacion;
    private List<Producto> productos;

    /**
     * Constructor for objects of class Perfil
     */
    public Perfil( String nombre, String horario, String ubicacion)
    {
        this.nombre = nombre;
        this.horario = horario;
        this.ubicacion = ubicacion;
        this.productos = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    public String getUbicacion(){
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public Producto crearProducto(String nombre, int precio, String categoria, boolean disponible, int cantidad_dis){
        Producto producto = new Producto(nombre,precio,categoria,disponible,cantidad_dis,this);
        productos.add(producto);
        System.out.println("Se ha agregado el producto "+producto.getNombre()+" - $"+producto.getPrecio()+" COP al perfil "+this.getNombre());
        return producto;
    }
    
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
}
