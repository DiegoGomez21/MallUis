
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
    }
}
