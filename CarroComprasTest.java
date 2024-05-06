
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Comprador comprador;

    public CarroComprasTest()
    {
    }

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

        comprador = new Comprador("Diego", "correo@test.com", 93482);
        carrito = new CarroCompras(comprador);
    }

    @AfterEach
    public void tearDown()
    {
        carrito.getProductos().clear(); // Limpiar el carrito después de cada prueba
    }

    @Test
    public void testAgregarProductoCarrito()
    {
        carrito.agregarProducto(producto1, 2);
        Map<Producto, Integer> productos = new HashMap<>();
        productos.put(producto1, 2);
        assertEquals(productos, carrito.getProductos());
    }

    @Test
    public void testEliminarProductoCarrito()
    {
        carrito.agregarProducto(producto1, 2);
        carrito.eliminarProducto(producto1);
        Map<Producto, Integer> productos = new HashMap<>();
        assertEquals(productos, carrito.getProductos());
    }

    @Test
    public void testHacerPedidoDiferentesPerfiles()
    {   
        CarroCompras carrito = new CarroCompras(comprador);
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
    }
}

