
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PerfilTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PerfilTest
{
    /**
     * Default constructor for test class PerfilTest
     */
    public PerfilTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Test de clase perfil para crear productos y añadirlos automaticamente.
     */
    @Test
    public void testCrearProducto()
    {
        Perfil perfil = new Perfil("Diego", "lunes a viernes", "Ct-201");
        Producto producto = perfil.crearProducto("Hamburguesa", 20000, "comida",true,20);
        assertNotNull(producto);
        List<Producto> productos = new ArrayList<>();
        productos.add(producto);
        assertEquals("Hamburguesa",producto.getNombre());
        assertEquals(productos,perfil.getProductos());
    }
}
