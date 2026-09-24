import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String codigo;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private double valorTotal;

    //Creación de la lista: aquí se asocian los productos que el cliente selecciona
    private List<Producto> listaProductos;

    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, double valorTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.valorTotal = 0; //empieza en 0 hasta que se calcule

        //Inicializar la lista (sin esto daría error al agregar productos)
        listaProductos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    //Getter: devuelve la lista de productos de la compra
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    //Setter: cambia la lista de productos
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //toString: arma el texto que se muestra cuando se imprime una compra (incluye sus productos)
    @Override
    public String toString() {
        return "Compra: " + " | " +
                "codigo= " + codigo + " | " +
                "fecha= " + fecha + " | " +
                "metodoPago= " + metodoPago + " | " +
                "valorTotal= " + valorTotal + " | " +
                "productos= " + listaProductos + "\n";
    }

    //Método verificar producto: revisa si un producto ya está en la compra
    //Recorre la lista y compara los códigos con equals. Devuelve true si lo encuentra
    public boolean verificarProducto(String codigoProducto) {
        boolean existe = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigoProducto)) {
                existe = true;
                break; //Ya lo encontró, no necesita seguir recorriendo
            }
        }
        return existe;
    }

    //Método agregar producto: asocia un producto a la compra
    //Valida dos cosas: que no esté repetido y que haya disponibilidad (1 unidad) en el inventario
    //Devuelve true si lo agregó y false si no
    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        boolean existe = verificarProducto(producto.getCodigo());
        if (existe == false && producto.verificarDisponibilidad(1)) {
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }

    //Método calcular valor total: suma el precio unitario de todos los productos de la compra
    //Guarda el resultado en el atributo valorTotal y también lo devuelve
    public double calcularValorTotal() {
        double total = 0; //Acumulador que empieza en 0
        for (Producto producto : listaProductos) {
            total = total + producto.getPrecioUnitario();
        }
        valorTotal = total;
        return valorTotal;
    }

    //Método confirmar compra: calcula el total y actualiza el inventario de cada producto
    //Como se asume 1 unidad por producto, a cada uno se le descuenta 1 del inventario
    public void confirmarCompra() {
        calcularValorTotal();
        for (Producto producto : listaProductos) {
            producto.actualizarInventario(1);
        }
    }
}

}




