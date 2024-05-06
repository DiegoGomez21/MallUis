

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProductoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductoTest
{
    /**
     * Default constructor for test class ProductoTest
     */
    public ProductoTest()
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
     * Test de metodos de clase de producto
     */
    @Test
    public void testMetodosProducto()
    {
        Perfil perfil = new Perfil("Emprendimiento1", "lunes 5pm - 10pm", "Ct-201");
        Producto producto = new Producto("Empanada", 2000, "comida",true, 20, perfil);
        assertEquals("Empanada",producto.getNombre());
        assertEquals(2000,producto.getPrecio());
        assertEquals("comida",producto.getCategoria());
        assertEquals(true,producto.getDisponible());
        assertEquals(20,producto.getCantidad());
    }
}
