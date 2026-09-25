
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private String codigo;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private double valorTotal;

    private List<Producto> listaProductos;

    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, double valorTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;

        // Empieza en 0 hasta que se calcule
        this.valorTotal = 0;

        // Inicializar la lista de productos
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

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Compra: " +
                "codigo= " + codigo + " | " +
                "fecha= " + fecha + " | " +
                "metodoPago= " + metodoPago + " | " +
                "valorTotal= " + valorTotal + " | " +
                "productos= " + listaProductos + "\n";
    }

    // Verifica si un producto ya está en la compra
    public boolean verificarProducto(String codigoProducto) {

        boolean existe = false;

        for (Producto producto : listaProductos) {

            if (producto.getCodigo().equals(codigoProducto)) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    // Agrega un producto a la compra
    public boolean agregarProducto(Producto producto) {

        boolean agregado = false;

        boolean existe = verificarProducto(producto.getCodigo());

        if (existe == false && producto.verificarDisponibilidad(1)) {
            listaProductos.add(producto);
            agregado = true;
        }

        return agregado;
    }

    // Calcula el valor total de la compra
    public double calcularValorTotal() {

        double total = 0;

        for (Producto producto : listaProductos) {
            total = total + producto.getPrecioUnitario();
        }

        valorTotal = total;

        return valorTotal;
    }

    // Confirma la compra y actualiza el inventario
    public void confirmarCompra() {

        calcularValorTotal();

        for (Producto producto : listaProductos) {
            producto.actualizarInventario(1);
        }
    }
}




