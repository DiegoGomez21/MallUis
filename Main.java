import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Crear compradores
        Comprador comprador1 = new Comprador("Joan","sebaspedraza05@gmail.com",12345);
        Comprador comprador2 = new Comprador("Diego", "gomezpedraza@correo.com",98765);
        ArrayList<Comprador> compradores = new ArrayList<>();
        compradores.add(comprador1);
        compradores.add(comprador2);
        
        //Crear vendedores
        Vendedor vendedor1 = new Vendedor("Daniela","sweetP@correo.com",13579);
        Vendedor vendedor2 = new Vendedor("Alejandro","sweetP@correo.com",12367);
        Vendedor vendedor3 = new Vendedor("Sebastian","qwerty@correo.com",45678);
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(vendedor1);
        vendedores.add(vendedor2);
        vendedores.add(vendedor3);
        
        //Vendedor crea un perfil
        Perfil sweetP = vendedor1.crearPerfil("Sweet Petit","Lunes a Viernes, 8am a 8pm","UIS");
        Perfil montaditosC = vendedor3.crearPerfil("Montaditos de Cerdo", "Lunes a viernes, 3pm a 8pm", "Luis A.Calvo");
        ArrayList<Perfil> perfiles = new ArrayList<>();
        perfiles.add(sweetP);
        perfiles.add(montaditosC);
        
        //Perfil SweetPetit crea 3 productos
        Producto postreL = sweetP.crearProducto("Postre de Limon", 5000, "Comida", true, 10);
        Producto postreO = sweetP.crearProducto("Postre de Oreo", 5000, "Comida", true, 5);
        Producto postreC = sweetP.crearProducto("Postre de Chocolate", 5000, "Comida", false, 10);
        
        //Perfil montaditos de cerdo crea 1 producto
        Producto mCerdo = montaditosC.crearProducto("Montaditos de Cerdo",6500,"Comida",true,15);
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(postreL);
        productos.add(postreO);
        productos.add(postreC);
        productos.add(mCerdo);
        
        List<Pedido> nuevosPedidos = new ArrayList<>();
        
        int opcion1;
        do{
            System.out.println("----------------------------------------------------");
            System.out.println("Bienvenido a MALLUIS");
            System.out.println("----------------------------------------------------");
        
            System.out.println("¿Qué accion quiere realizar?");
            System.out.println("1. Ingresar como comprador");
            System.out.println("2. Ingresar como vendedor");
            System.out.println("3. Salir");
        
            opcion1 = scanner.nextInt();
        
            switch(opcion1){
        
                case 1:
                    Comprador compradorMenu = ingresarComprador(compradores);
                     if (compradorMenu != null) {
                        nuevosPedidos = menuComprador(compradorMenu, productos,nuevosPedidos);
                    } else {
                        System.out.println("Inicio de sesión como comprador fallido.");
                    }
                    break;
                case 2:
                    Vendedor vendedorMenu =  ingresarVendedor(vendedores);
                     if (vendedorMenu != null) {
                        menuVendedor(vendedorMenu, nuevosPedidos);
                    } else {
                        System.out.println("Inicio de sesión como comprador fallido.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");  
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion1 != 3);
        
    }
    
    private static Comprador ingresarComprador(ArrayList<Comprador> compradores){
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        
        do{
            
            System.out.println("------------------------------------");
            System.out.println("1. Crear un nuevo usuario comprador");
            System.out.println("2. Ingresar con un comprador existente");
            System.out.println("3. Regresar al Menu");
            opcion = scanner.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre del comprador:");
                    String saltoDeLinea3 = scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el correo electrónico del comprador:");
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del comprador:");
                    int telefono = scanner.nextInt();

                    Comprador compradorNew = new Comprador(nombre, correo, telefono);
                    compradores.add(compradorNew);
                    return compradorNew;
            
                case 2:
                    System.out.println("Ingrese el nombre/correo del comprador:");
                    String saltoDeLinea = scanner.nextLine();
                    String entradaComprador = scanner.nextLine();
                
                    Comprador compradorSelec = null;
                    for (Comprador comprador : compradores) {
                        if (comprador.getNombre().equalsIgnoreCase(entradaComprador) || comprador.getCorreo().equalsIgnoreCase(entradaComprador)) {
                            compradorSelec = comprador;
                            return compradorSelec;
                        }
                    }
                    
                    if (compradorSelec == null) {
                        System.out.println("Comprador no encontrado.");
                        return null;
                    }
                    return null;
                case 3:
                    System.out.println("Saliendo al Menú...");   
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }while(opcion != 3);
        
        scanner.close();
        return null;
    }
    
    private static Vendedor ingresarVendedor(ArrayList<Vendedor> vendedores){
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
 
        do{
            
            System.out.println("------------------------------------");
            System.out.println("1. Crear un nuevo usuario vendedor");
            System.out.println("2. Ingresar con un vendedor existente");
            System.out.println("3. Regresar al Menu");
            opcion = scanner.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre del vendedor:");
                    String saltoDeLinea3 = scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el correo electrónico del vendedor:");
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del vendedor:");
                    int telefono = scanner.nextInt();

                    Vendedor vendedorNew = new Vendedor(nombre, correo, telefono);
                    vendedores.add(vendedorNew);
                    return vendedorNew;
            
                case 2:
                    System.out.println("Ingrese el nombre/correo del vendedor:");
                    String saltoDeLinea5 = scanner.nextLine();
                    String entradaVendedor = scanner.nextLine();
        
                    Vendedor vendedorSelec = null;
                    for (Vendedor vendedor : vendedores) {
                        if (vendedor.getNombre().equalsIgnoreCase(entradaVendedor) || vendedor.getCorreo().equalsIgnoreCase(entradaVendedor)) {
                            vendedorSelec = vendedor;
                            return vendedorSelec;
                        }
                    }
                    
                    if (vendedorSelec == null) {
                        System.out.println("Vendedor no encontrado.");
                        return null;
                    }
                    return null;
                case 3:
                    System.out.println("Saliendo al Menú...");   
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }while(opcion != 3);
        
        scanner.close();
        return null;
    }
    
    private static List<Pedido> menuComprador(Comprador compradorMenu, ArrayList<Producto> productos, List<Pedido> nuevosPedidos){
        
        Scanner scanner = new Scanner(System.in);
        CarroCompras nuevoCarrito = null;
        //List<Pedido> nuevosPedidos = new ArrayList<>();
        
        int opcion;
        int cantidad;
        
        do{
            
            System.out.println("------------------------------------");
            System.out.println("Seleccion una acción");
            System.out.println("1. Crear un carrito de compras");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito de compras");
            System.out.println("4. Hacer un pedido");
            System.out.println("5. Ver pedidos");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
            
            switch(opcion){
                
                case 1:
                    System.out.println("------------------------------------");
                    System.out.println("Ingrese el nombre del producto para crear su carrito");
                    String saltoDeLinea = scanner.nextLine();
                    String productoEntrada = scanner.nextLine();
                    
                    Producto productoSelec = null;
                    for( Producto producto : productos){
                        if(producto.getNombre().equalsIgnoreCase(productoEntrada)){
                            productoSelec = producto;
                        }
                    }
                    if (productoSelec == null) {
                        System.out.println("Producto no encontrado");
                        break;
                    }
                    
                    System.out.println("Ingrese la cantidad de producto que va a solicitar");
                    cantidad = scanner.nextInt();
                    
                    nuevoCarrito = compradorMenu.crearCarroCompras(productoSelec,cantidad);
                    
                    break;
                    
                case 2:
                    System.out.println("------------------------------------");
                    
                    if(nuevoCarrito != null){
                        System.out.println("Ingrese el nombre del producto que desee añadir a su carrito");
                        String saltoDeLinea2 = scanner.nextLine();
                        String productoNuevo = scanner.nextLine();
                    
                        Producto productoNSelec = null;
                        for( Producto producto : productos){
                            if(producto.getNombre().equalsIgnoreCase(productoNuevo)){
                                productoNSelec = producto;
                            }
                        }
                        if (productoNSelec == null) {
                            System.out.println("Producto no encontrado");
                            break;
                        }
                    
                        System.out.println("Ingrese la cantidad de producto que va a solicitar");
                        cantidad = scanner.nextInt();
                    
                        compradorMenu.agregarProductoCarro(nuevoCarrito,productoNSelec,cantidad);
                        
                        break;
                    }
                    else{
                        System.out.println("Cree un carrito de compras primero");
                        break;
                    }
                    
                case 3:    
                    if(nuevoCarrito!=null){
                        System.out.println("------------------------------------");
                        System.out.println("Estos son sus productos seleccionados: ");
                        Map<Producto, Integer> mapa = nuevoCarrito.getProductos();
                        for (Map.Entry<Producto, Integer> entry : mapa.entrySet()) {
                            Producto producto = entry.getKey();
                            int cantidadP = entry.getValue();
                            System.out.println("Producto: " + producto.getNombre() + ", Cantidad: " + cantidadP);
                        }
                        break;
                    }
                    else{
                        System.out.println("Cree un carrito de compras primero");
                        break;
                    }
                    
                case 4:
                    if(nuevoCarrito!=null){
                        System.out.println("------------------------------------");
                        System.out.println("Ingrese el metodo de pago");
                        String saltoDeLinea3 = scanner.nextLine();
                        String pago = scanner.nextLine();
                        nuevosPedidos = nuevoCarrito.hacerPedidos(pago);
                        break;
                    }
                    else{
                        System.out.println("Cree un carrito de compras primero");
                        break;
                    }
                    
                case 5:
                    System.out.println("------------------------------------");
                    System.out.println("Estos son los pedidos que usted ha realizado: ");
                    for (Pedido pedido : nuevosPedidos) {
                        System.out.println("Pedido:");
                        System.out.println("Vendedor: " + pedido.getPerfil().getNombre());
                        System.out.println("Comprador: " + pedido.getComprador().getNombre());
                        System.out.println("Productos:");

                        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
                            Producto producto = entry.getKey();
                            int cantidadPP = entry.getValue();
                            if(producto.getPerfil().getNombre()==pedido.getPerfil().getNombre()){
                                    System.out.println("- " + producto.getNombre() + ", Cantidad: " + cantidadPP/2);
                            }
                        }   
                        System.out.println("Precio total: " + pedido.getPrecioTotal()/2);
                        System.out.println("Método de pago: " + pedido.getMetodoPago());
                        System.out.println("Estado: " + pedido.getEstado());
                        System.out.println();
                    }
                    
                    break;
                
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");    
                    
            }
        }while(opcion!=6);
        
        return nuevosPedidos;
    }
    
    private static void menuVendedor(Vendedor vendedorMenu, List<Pedido> nuevosPedidos){
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        int cantidad;
        
        do{
            
            System.out.println("------------------------------------");
            System.out.println("Seleccion una acción");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Ver Productos");
            System.out.println("3. Crear Productos");
            System.out.println("4. Ver Pedidos");
            System.out.println("5. Salir");
            System.out.println("------------------------------------");
            opcion = scanner.nextInt();
            
            switch(opcion){
                
                case 1:
                    if(vendedorMenu.getPerfil().getNombre() == null){
                        System.out.println("------------------------------------");
                        System.out.println("Usted no ha creado perfiles aún");
                        break;
                    }
                    else{
                        System.out.println("------------------------------------");
                        System.out.println("Este es su perfil");
                        System.out.println("- " + vendedorMenu.getPerfil().getNombre());
                        break;
                    }
                    
                case 2:
                    if(vendedorMenu.getPerfil().getNombre() == null){
                        System.out.println("------------------------------------");
                        System.out.println("Usted no ha creado productos aún");
                        break;
                    }
                    else{
                        System.out.println("------------------------------------");
                        System.out.println("Estos son sus productos");
                        for( Producto producto : vendedorMenu.getPerfil().getProductos()){
                            System.out.println("- " + producto.getNombre());
                        }
                        break;
                    }
                    
                case 3:
                    System.out.println("------------------------------------");
                    System.out.println("Ingrese el nombre del producto:");
                    String saltoDeLinea3 = scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el precio");
                    int precio = scanner.nextInt();
                    String saltoDeLinea4 = scanner.nextLine();
                    System.out.println("Ingrese la categoria del producto:");
                    String categoria = scanner.nextLine();
                    System.out.println("Ingrese la disponibilidad del producto:");
                    boolean disp = scanner.nextBoolean();
                    System.out.println("Ingrese la cantidad en Stock:");
                    int cantidad_disp = scanner.nextInt();
                    vendedorMenu.getPerfil().crearProducto(nombre,precio,categoria,disp,cantidad_disp);
                    break;
                
                case 4:
                    System.out.println("------------------------------------");
                    System.out.println("Estos son los pedidos que le han llegado ");
                    for (Pedido pedido : nuevosPedidos) {
                        if(pedido.getPerfil().getNombre()==vendedorMenu.getPerfil().getNombre()){
                            System.out.println("Pedido:");
                            System.out.println("Vendedor: " + pedido.getPerfil().getNombre());
                            System.out.println("Comprador: " + pedido.getComprador().getNombre());
                            System.out.println("Productos:");

                            for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
                                Producto producto = entry.getKey();
                                int cantidadPP = entry.getValue();
                                if(producto.getPerfil().getNombre()==vendedorMenu.getPerfil().getNombre()){
                                    System.out.println("- " + producto.getNombre() + ", Cantidad: " + cantidadPP/2);
                                }
                            }   
                            System.out.println("Precio total: " + pedido.getPrecioTotal()/2);
                            System.out.println("Método de pago: " + pedido.getMetodoPago());
                            System.out.println("Estado: " + pedido.getEstado());
                            System.out.println();
                        }
                        else{
                            System.out.println("Usted no tiene pedidos");
                        }
                    }
                    break;
                    
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    
            }
            
        }while(opcion!=5);
    }
}

