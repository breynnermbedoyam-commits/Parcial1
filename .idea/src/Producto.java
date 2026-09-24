public class Producto {
    private String codigo;
    private String nombre;
    private Categoria categoria;
    private double precioUnitario;
    private int cantidadDisponible;

    public  Producto(String codigo, String nombre, Categoria categoria, double precioUnitario, int cantidadDisponible){
        this.codigo=codigo;
        this.nombre=nombre;
        this.categoria=categoria;
        this.precioUnitario=precioUnitario;
        this.cantidadDisponible=cantidadDisponible;


    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


}

