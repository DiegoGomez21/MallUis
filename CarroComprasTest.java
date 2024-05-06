
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CarroComprasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarroComprasTest
{
    private Vendedor vendedor;
    private Perfil perfil1;
    private Perfil perfil2;
    private CarroCompras carrito;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    /**
     * Default constructor for test class CarroComprasTest
     */
    public CarroComprasTest()
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
        vendedor = new Vendedor("Diego", "correo@test.com", 93482);
        perfil1 = vendedor.crearPerfil("Emprendimiento1", "lunes 5pm - 10pm", "Ct-201");
        producto1 = perfil1.crearProducto("Hamburguesa", 20000, "comida",true,20);
        producto2 = perfil1.crearProducto("Salchipapa", 15000, "comida",true,10);
        
        perfil2 = vendedor.crearPerfil("Emprendimiento2", "lunes a viernes 10am - 10pm", "Ct-601");
        producto3 = perfil2.crearProducto("Empanada", 20000, "comida",true,20);
        producto4 = perfil2.crearProducto("Bolso", 15000, "ropa",true,10);
        
        Comprador comprador = new Comprador("Diego", "correo@test.com", 93482);
        carrito = new CarroCompras(comprador);
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
     * Test para agregar producto al carrito
     */
    @Test
    public void testAgregarProductoCarrito()
    {   
        carrito.agregarProducto(producto1, 2);
        Map<Producto, Integer> productos = new HashMap<>();
        productos.put(producto1, 2);
        assertEquals(productos, carrito.getProductos());
    }
    
    /**
     * Test para eliminar producto del carrito
     */
    @Test
    public void testEliminarProductoCarrito()
    {   
        carrito.agregarProducto(producto1, 2);
        carrito.eliminarProducto(producto1);
        Map<Producto, Integer> productos = new HashMap<>();
        assertEquals(productos, carrito.getProductos());
    }
    
    /**
     * Test para agregar distintos productos y generar pedido siendo los productos de distintos perfiles
     */
    @Test
    public void testHacerPedidoDiferentesPerfiles()
    {   
        carrito.agregarProducto(producto1, 2);
        carrito.agregarProducto(producto2, 2);
        carrito.agregarProducto(producto3, 2);
        carrito.agregarProducto(producto4, 2);
        List<Pedido> pedidos_generados = carrito.hacerPedidos("Efectivo");
        
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido1 = new Pedido(perfil1, carrito, "Efectivo");
        pedido1.agregarProducto(producto1, 2);
        pedido1.agregarProducto(producto2, 2);
        pedidos.add(pedido1);
        
        Pedido pedido2 = new Pedido(perfil2, carrito, "Efectivo");
        pedido2.agregarProducto(producto3, 2);
        pedido2.agregarProducto(producto4, 2);
        pedidos.add(pedido2);
        
        assertEquals(pedidos.size(), pedidos_generados.size());
        
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedidoGenerado = pedidos_generados.get(i);
            Pedido pedidoEsperado = pedidos.get(i);
            assertEquals(pedidoEsperado.getPrecioTotal(), pedidoGenerado.getPrecioTotal());
            assertEquals(pedidoEsperado.getPerfil(), pedidoGenerado.getPerfil());
        }
    }
}
