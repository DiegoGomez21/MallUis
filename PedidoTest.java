

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PedidoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PedidoTest
{
    /**
     * Default constructor for test class PedidoTest
     */
    public PedidoTest()
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
     * Test para crear pedido y agregar productos
     */
    @Test
    public void testFuncionalidadPedido()
    {   
        Vendedor vendedor = new Vendedor("Diego", "correo@test.com", 93482);
        Perfil perfil1 = vendedor.crearPerfil("Emprendimiento1", "lunes 5pm - 10pm", "Ct-201");
        Producto producto1 = perfil1.crearProducto("Hamburguesa", 20000, "comida",true,20);
        Comprador comprador = new Comprador("Diego", "correo@test.com", 93482);
        CarroCompras carro = comprador.crearCarroCompras(producto1, 2);
        
        Pedido pedido = new Pedido(perfil1, carro, "Transferencia");
        pedido.agregarProducto(producto1, 5);
        
        assertEquals(1, pedido.getProductos().size());
        assertEquals(5*20000, pedido.getPrecioTotal());
        
        vendedor = null;
        perfil1 = null;
        producto1 = null;
        comprador = null;
        carro = null;
        pedido = null;
    }
}
