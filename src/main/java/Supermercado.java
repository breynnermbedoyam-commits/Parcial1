public class Supermercado {

    private String nombreComercial;
    private String direccion;
    private String telefono;

    //Creación de listas: el supermercado registra clientes y administra productos
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;


    public Supermercado(String nombreComercial, String direccion, String telefono){
        this.nombreComercial=nombreComercial;
        this.direccion=direccion;
        this.telefono=telefono;
        //Inicializar las listas
        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();

        //Getter: devuelve el nombre comercial
        public String getNombreComercial() {
            return nombreComercial;
        }

        //Setter: cambia el nombre comercial
        public void setNombreComercial(String nombreComercial) {
            this.nombreComercial = nombreComercial;
        }

        //Getter: devuelve la dirección
        public String getDireccion() {
            return direccion;
        }

        //Setter: cambia la dirección
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        //Getter: devuelve el teléfono
        public String getTelefono() {
            return telefono;
        }

        //Setter: cambia el teléfono
        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        //Getter: devuelve la lista de clientes
        public List<Cliente> getListaClientes() {
            return listaClientes;
        }

        er: cambia la lista de clientes
        public void setListaClientes(List<Cliente> listaClientes) {
            this.listaClientes = listaClientes;
        }


        public List<Producto> getListaProductos() {
            return listaProductos;
        }

        //Setter: cambia la lista de productos
        public void setListaProductos(List<Producto> listaProductos) {
            this.listaProductos = listaProductos;
        }

        @Override
        public String toString() {
            return "Supermercado: {" +
                    "Nombre comercial= " + nombreComercial + " | " +
                    "Direccion= " + direccion + " | " +
                    "Telefono= " + telefono + " | " +
                    "Lista de clientes= " + listaClientes + " | " +
                    "Lista de productos= " + listaProductos +
                    '}';
        }

        //CLIENTES
        //Método verificar cliente: revisa si ya existe un cliente con ese documento
        //Recorre la lista y compara los documentos con equals. Devuelve true si lo encuentra
        public boolean verificarCliente(String documentoIdentidad) {
            boolean existe = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                    existe = true;
                    break; //Ya lo encontró, no necesita seguir recorriendo
                }
            }
            return existe;
        }

        //Método agregar cliente: registra un cliente nuevo en el supermercado
        //Primero verifica que no exista. Devuelve true si lo agregó y false si ya existía
        public boolean agregarCliente(Cliente cliente) {
            boolean agregado = false;
            boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
            if (existe == false) {
                listaClientes.add(cliente);
                agregado = true;
            }
            return agregado;
        }

        //Método buscar cliente: devuelve el objeto Cliente con ese documento, o null si no existe
        //Se usa para poder asociar una compra al cliente correcto
        public Cliente buscarCliente(String documentoIdentidad) {
            Cliente clienteEncontrado = null;
            for (Cliente cliente : listaClientes) {
                if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                    clienteEncontrado = cliente;
                    break;
                }
            }
            return clienteEncontrado;
        }

        //PRODUCTOS
        //Método verificar producto: revisa si ya existe un producto con ese código
        public boolean verificarProducto(String codigo) {
            boolean existe = false;
            for (Producto producto : listaProductos) {
                if (producto.getCodigo().equals(codigo)) {
                    existe = true;
                    break;
                }
            }
            return existe;
        }

        //Método agregar producto: registra un producto nuevo en el supermercado
        //Primero verifica que no exista. Devuelve true si lo agregó y false si ya existía
        public boolean agregarProducto(Producto producto) {
            boolean agregado = false;
            boolean existe = verificarProducto(producto.getCodigo());
            if (existe == false) {
                listaProductos.add(producto);
                agregado = true;
            }
            return agregado;
        }

        //Método buscar producto: devuelve el objeto Producto con ese código, o null si no existe
        //Se usa para poder seleccionar un producto al armar una compra
        public Producto buscarProducto(String codigo) {
            Producto productoEncontrado = null;
            for (Producto producto : listaProductos) {
                if (producto.getCodigo().equals(codigo)) {
                    productoEncontrado = producto;
                    break;
                }
            }
            return productoEncontrado;
        }

        //COMPRAS Y REPORTES
        //Método verificar compra: revisa si el código de una compra ya existe en alguno de los clientes
        //Usa dos for: uno para los clientes y otro para las compras de cada cliente
        public boolean verificarCompra(String codigoCompra) {
            boolean existe = false;
            for (Cliente cliente : listaClientes) {
                for (Compra compra : cliente.getListaCompras()) {
                    if (compra.getCodigo().equals(codigoCompra)) {
                        existe = true;
                        break;
                    }
                }
            }
            return existe;
        }

        //Método calcular ventas por fecha: suma el valor total de todas las compras hechas en esa fecha
        //Recorre los clientes, luego las compras de cada uno, y acumula solo las que tienen la misma fecha
        public double calcularVentasPorFecha(LocalDate fecha) {
            double totalVendido = 0; //Acumulador que empieza en 0
            for (Cliente cliente : listaClientes) {
                for (Compra compra : cliente.getListaCompras()) {
                    if (compra.getFecha().equals(fecha)) {
                        totalVendido = totalVendido + compra.getValorTotal();
                    }
                }
            }
            return totalVendido;
        }
    }