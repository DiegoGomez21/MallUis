
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CompradorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompradorTest
{
    /**
     * Default constructor for test class CompradorTest
     */
    public CompradorTest()
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
     * Test para metodo principal de Comprador creando un carro de compras
     */
    @Test
    public void testCrearCarrito()
    {
        Vendedor vendedor = new Vendedor("Diego", "correo@test.com", 93482);
        Perfil perfil1 = vendedor.crearPerfil("Emprendimiento1", "lunes 5pm - 10pm", "Ct-201");
        Producto producto1 = perfil1.crearProducto("Hamburguesa", 20000, "comida",true,20);
        Comprador comprador = new Comprador("Diego", "correo@test.com", 93482);
        
        CarroCompras carro = comprador.crearCarroCompras(producto1, 2);
        List<Pedido> pedidos_generados = carro.hacerPedidos("Efectivo");
        
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido1 = new Pedido(perfil1, carro, "Efectivo");
        pedido1.agregarProducto(producto1, 2);
        pedidos.add(pedido1);
        
        assertEquals(pedidos.size(), pedidos_generados.size());
        
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedidoGenerado = pedidos_generados.get(i);
            Pedido pedidoEsperado = pedidos.get(i);
            assertEquals(pedidoEsperado.getPrecioTotal(), pedidoGenerado.getPrecioTotal());
            assertEquals(pedidoEsperado.getPerfil(), pedidoGenerado.getPerfil());
        }
    }
}
