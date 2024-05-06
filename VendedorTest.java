import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VendedorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendedorTest
{
    /**
     * Default constructor for test class VendedorTest
     */
    public VendedorTest()
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
     * Test para metodo principal de Vendedor creando perfiles
     */
    @Test
    public void testCrearPerfil()
    {
        Vendedor vendedor = new Vendedor("Diego", "correo@test.com", 93482);
        Perfil perfil = vendedor.crearPerfil("Emprendimiento1", "lunes 5pm - 10pm", "Ct-201");
        assertNotNull(perfil);
        assertEquals("Emprendimiento1",perfil.getNombre());
        assertEquals(perfil,vendedor.getPerfil());
    }

}
