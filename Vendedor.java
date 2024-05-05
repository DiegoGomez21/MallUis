
/**
 * Write a description of class Vendedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vendedor extends Usuario
{
    
    private Perfil perfil;
    
    /**
     * Constructor for objects of class Vendedor
     */
    public Vendedor(String nombre, String correo, int telefono)
    {
        super(nombre,correo,telefono);
    }

    public Perfil crearPerfil(String nombre, String horario, String ubicacion){
        Perfil perfil = new Perfil(nombre, horario, ubicacion);
        this.perfil = perfil;
        System.out.println("Se creó el perfil " + perfil.getNombre() + " del vendedor "+ this.getNombre());
        return perfil;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }
}
