package peluchitos;
import java.util.Scanner;

public class Peluchitos {
    static Scanner lector = new Scanner(System.in);
    static int opcion = 0;
    static int num_producto = 0;
    static int busqueda = 0;
    static int flag = 0;
    
    //String producto;
    String[ ] producto = new String[100];
    String buscar_producto;
    //int cantidad;
    int[ ] cantidad = new int[100];
    int cantidad_venta;
    int[ ] num_producto_venta = new int[100];
    //double valor;
    double[ ] valor = new double [100];
    //double ganancias = 0;
    double[ ] ganancias = new double [100];

    public static Scanner getLector() {
        return lector;
    }

    public static void setLector(Scanner lector) {
        Peluchitos.lector = lector;
    }

    public static int getOpcion() {
        return opcion;
    }

    public static void setOpcion(int opcion) {
        Peluchitos.opcion = opcion;
    }

    public static int getNum_producto() {
        return num_producto;
    }

    public static void setNum_producto(int num_producto) {
        Peluchitos.num_producto = num_producto;
    }

    public static int getBusqueda() {
        return busqueda;
    }

    public static void setBusqueda(int busqueda) {
        Peluchitos.busqueda = busqueda;
    }

    public static int getFlag() {
        return flag;
    }

    public static void setFlag(int flag) {
        Peluchitos.flag = flag;
    }

    public String[] getProducto() {
        return producto;
    }

    public void setProducto(String[] producto) {
        this.producto = producto;
    }

    public String getBuscar_producto() {
        return buscar_producto;
    }

    public void setBuscar_producto(String buscar_producto) {
        this.buscar_producto = buscar_producto;
    }

    public int[] getCantidad() {
        return cantidad;
    }

    public void setCantidad(int[] cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int[] getNum_producto_venta() {
        return num_producto_venta;
    }

    public void setNum_producto_venta(int[] num_producto_venta) {
        this.num_producto_venta = num_producto_venta;
    }

    public double[] getValor() {
        return valor;
    }

    public void setValor(double[] valor) {
        this.valor = valor;
    }

    public double[] getGanancias() {
        return ganancias;
    }

    public void setGanancias(double[] ganancias) {
        this.ganancias = ganancias;
    }
    
    
    public void agregar()
    {
        
       if (num_producto < 100)
       {
           System.out.println("Ingrese el nombre del producto:");
           producto[num_producto] = lector.next();
           System.out.println("Ingrese la cantidad del producto:"); 
           cantidad[num_producto] = lector.nextInt();
           System.out.println("Ingrese el valor del producto:"); 
           valor[num_producto] = lector.nextDouble();
           num_producto++;
       }
    }
    
    public void buscar()
    {
       System.out.println("Ingrese el nombre del producto a buscar:"); 
       buscar_producto = lector.next();
       while (busqueda < num_producto)
       {
            if (buscar_producto.equals(producto[busqueda]))
            {
                System.out.println("Producto:"+producto[busqueda]); 
                System.out.println("Cantidad:"+cantidad[busqueda]); 
                System.out.println("Valor:"+valor[busqueda]); 
                
                flag = 1;
                busqueda = num_producto;
            }
            busqueda++;
       }
       if (flag == 0)
       {
           System.out.println("El producto no se encuentra!"); 
       }
       flag = 0;
       busqueda = 0;
    }
    
    public void eliminar()
    {
       System.out.println("Ingrese el nombre del producto a eliminar:"); 
       buscar_producto = lector.next();
       while (busqueda < num_producto)
       {
            if (buscar_producto.equals(producto[busqueda]))
            {
                System.out.println("El producto"+producto[busqueda]+"se ha eliminado!"); 
                producto[busqueda] = "";
                System.out.println("Producto:"+producto[busqueda]); 
                cantidad[busqueda] = 0;
                System.out.println("Cantidad:"+cantidad[busqueda]); 
                valor[busqueda] = 0;
                System.out.println("Valor:"+valor[busqueda]);
                flag = 1;
                busqueda = num_producto;
            }
            busqueda++;
       }
       if (flag == 0)
       {
           System.out.println("El producto no se encuentra!"); 
       }
       flag = 0;
       busqueda = 0;
    }
    
    public void mostrar()
    {
        System.out.println("producto    Cantidad     Valor   "); 
       while (busqueda < num_producto)
       { 
            System.out.println(producto[busqueda]+"\t"+cantidad[busqueda]+"\t"+valor[busqueda]); 
            busqueda++;
       }
       busqueda = 0;
    }
    
    public void realizar_venta()
    {
        System.out.println("producto a vender:"); 
       buscar_producto = lector.next();
       while (busqueda < num_producto)
       {
            if (buscar_producto.equals(producto[busqueda]))
            {
                System.out.println("cantidad del producto:"); 
                cantidad_venta = lector.nextInt();
                if (cantidad_venta <= cantidad[busqueda])
                {
                System.out.println("venta exitosa:"); 
                cantidad[busqueda] = cantidad[busqueda] - cantidad_venta;
                num_producto_venta[busqueda] = cantidad_venta;
                ganancias[busqueda] = ganancias[busqueda] + cantidad_venta*valor[busqueda];
                }else
                {
                    System.out.println("solo hay tanta"+cantidad[busqueda]+" de "+producto); 
                }
                busqueda = num_producto;
                flag = 1;
            }
            busqueda++;
       }
       if (flag == 0)
       {
           System.out.println("El producto no se encuentra!"); 
       }
       flag = 0;
       busqueda = 0;
    }
    
    public void ganancias_totales()
    {
         System.out.println("producto    Cantidad Venta    Valor Venta  "); 
        while (busqueda < num_producto)
       {
            System.out.println(producto[busqueda]+"\t"+num_producto_venta[busqueda]+"\t"+ganancias[busqueda]); 
            busqueda++;
       }
       busqueda = 0;
    }
    
    public void salir()
    {
        System.out.println("Muchas gracias, que tenga un feliz dia"); 
    }
    
    public void otraOpcion()
    {
        System.out.println("Intente nuevamente, recuerde opciones de 1 a 7"); 
    }
    public void menu()
    {
        System.out.println("ADMINISTRACION PELUCHITOS");
        System.out.println("Elija una de las opciones");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Mostrar inventario");
        System.out.println("5. Realizar venta");
        System.out.println("6. Mostrar Ganancias totales");
        System.out.println("7. SALIR");
    }
    
    public static void main(String[] args) {
        
        Peluchitos Persona = new Peluchitos();
        
        do
        {
            Persona.menu();
            opcion = lector.nextInt();
            switch(opcion)
            {
                case 1:
                     Persona.agregar();
                     break;
                 case 2:
                        Persona.buscar();
                     break;
                 case 3:
                        Persona.eliminar();
                     break;
                 case 4:
                        Persona.mostrar();
                     break;
                 case 5:
                        Persona.realizar_venta();
                     break;
                 case 6:
                        Persona.ganancias_totales();
                     break;
                 case 7:
                        Persona.salir();
                     break;
                 default:
                        Persona.otraOpcion();
                     break;
            }
        }while(opcion != 7);
    }
}