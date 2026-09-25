public class Producto {

    //Atributos privados (los que salieron en la abstracción)
    private String codigo;
    private String nombre;
    private Categoria categoria; //Se asocia el enum Categoria al producto
    private double precioUnitario;
    private int cantidadDisponible; //Unidades que hay en el inventario

    //Constructor: recibe todos los datos y los guarda en los atributos con this
    public Producto(String codigo, String nombre, Categoria categoria, double precioUnitario, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
    }

    //Getter: devuelve el código
    public String getCodigo() {
        return codigo;
    }

    //Setter: cambia el código
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Getter: devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    //Setter: cambia el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter: devuelve la categoría
    public Categoria getCategoria() {
        return categoria;
    }

    //Setter: cambia la categoría
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //Getter: devuelve el precio unitario (se usa para calcular el total de la compra)
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    //Setter: cambia el precio unitario
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    //Getter: devuelve cuántas unidades hay disponibles
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    //Setter: cambia la cantidad disponible
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    //toString: arma el texto que se muestra cuando se imprime un producto
    @Override
    public String toString() {
        return "Producto: " + " | " +
                "codigo= " + codigo + " | " +
                "nombre= " + nombre + " | " +
                "categoria= " + categoria + " | " +
                "precioUnitario= " + precioUnitario + " | " +
                "cantidadDisponible= " + cantidadDisponible;
    }

    //Método verificar disponibilidad: revisa si hay suficientes unidades en el inventario
    //Devuelve true si la cantidad disponible es mayor o igual a la cantidad pedida
    public boolean verificarDisponibilidad(int cantidad) {
        return cantidadDisponible >= cantidad;
    }

    //Método actualizar inventario: descuenta las unidades vendidas de la cantidad disponible
    public void actualizarInventario(int cantidad) {
        cantidadDisponible = cantidadDisponible - cantidad;
    }
}