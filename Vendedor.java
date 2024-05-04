
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

    public void crearPerfil(String nombre, String horario, String ubicacion){
        this.perfil = new Perfil(nombre, horario, ubicacion);
    }
    
    public Perfil getPerfil() {
        return perfil;
    }
}
