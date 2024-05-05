
/**
 * Write a description of class Producto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int precio;
    private String categoria;
    private boolean disponible;
    private int cantidad_dis;
    private Perfil perfil;

    /**
     * Constructor for objects of class Producto
     */
    public Producto(String nombre, int precio, String categoria, boolean disponible, int cantidad_dis, Perfil perfil)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.disponible = disponible;
        this.cantidad_dis = cantidad_dis;
        this.perfil = perfil;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public boolean getDisponible(){
        return disponible;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    
    public int getCantidad(){
        return cantidad_dis;
    }
    
    public void setCantidad(int cantidad_dis){
        this.cantidad_dis = cantidad_dis;
    }
    
    public Perfil getPerfil(){
        return perfil;
    }
}
