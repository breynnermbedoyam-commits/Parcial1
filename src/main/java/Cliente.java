public class Cliente {
    private String nombreCompleto;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    //Creación de la lista: aquí se asocian las compras del cliente (un cliente puede tener varias)
    private List<Compra> listaCompras;

    public Cliente(String nombreCompleto, String documentoIdentidad, String telefono,
                   String correoElectronico){
        this.nombreCompleto=nombreCompleto;
        this.documentoIdentidad=documentoIdentidad;
        this.telefono=telefono;
        this.correoElectronico=correoElectronico;

        //Inicializar la lista
        listaCompras = new ArrayList<>();
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    //Setter: cambia la lista de compras
    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", listaCompras=" + listaCompras +
                '}';
    }
    //Método agregar compra: asocia una compra al cliente agregándola a su lista
    public void agregarCompra(Compra compra) {
        listaCompras.add(compra);
    }
}
}

