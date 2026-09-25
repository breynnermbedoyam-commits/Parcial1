public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Supermercado supermercado = new Supermercado(
            "MarketPlus",
            "Carrera 14",
            "3001234567"
    );

    int opcion = 0;

    do {

        System.out.println("\n========== MENU MARKETPLUS ==========");
        System.out.println("1. Agregar cliente.");
        System.out.println("2. Mostrar clientes.");
        System.out.println("3. Agregar producto.");
        System.out.println("4. Mostrar productos.");
        System.out.println("5. Registrar compra.");
        System.out.println("6. Consultar compras de un cliente.");
        System.out.println("7. Ventas totales por fecha.");
        System.out.println("0. Salir.");

        System.out.print("Opcion: ");
        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {

            case 1:

                System.out.println("--------- Agregar cliente ---------");

                System.out.print("Nombre completo: ");
                String nombreCliente = sc.nextLine();

                System.out.print("Documento de identidad: ");
                String documentoCliente = sc.nextLine();

                System.out.print("Telefono: ");
                String telefonoCliente = sc.nextLine();

                System.out.print("Correo electronico: ");
                String correoCliente = sc.nextLine();

                Cliente cliente = new Cliente(
                        nombreCliente,
                        documentoCliente,
                        telefonoCliente,
                        correoCliente
                );

                if (supermercado.agregarCliente(cliente)) {
                    System.out.println("Cliente agregado correctamente.");
                } else {
                    System.out.println("El cliente ya existe.");
                }

                break;


            case 2:

                System.out.println("--------- Lista de clientes ---------");

                for (Cliente clienteListado : supermercado.getListaClientes()) {
                    System.out.println(clienteListado);
                }

                break;


            case 3:

                System.out.println("--------- Agregar producto ---------");

                System.out.print("Codigo: ");
                String codigoProducto = sc.nextLine();

                System.out.print("Nombre: ");
                String nombreProducto = sc.nextLine();

                System.out.print("Categoria (ALIMENTOS, BEBIDAS, PRODUCTOS_DE_ASEO, CUIDADO_PERSONAL): ");
                Categoria categoriaProducto =
                        Categoria.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Precio unitario: ");
                double precioProducto =
                        Double.parseDouble(sc.nextLine());

                System.out.print("Cantidad disponible: ");
                int cantidadProducto =
                        Integer.parseInt(sc.nextLine());

                Producto producto = new Producto(
                        codigoProducto,
                        nombreProducto,
                        categoriaProducto,
                        precioProducto,
                        cantidadProducto
                );

                if (supermercado.agregarProducto(producto)) {
                    System.out.println("Producto agregado correctamente.");
                } else {
                    System.out.println("El producto ya existe.");
                }

                break;


            case 4:

                System.out.println("--------- Lista de productos ---------");

                for (Producto productoListado : supermercado.getListaProductos()) {
                    System.out.println(productoListado);
                }

                break;


            case 5:

                System.out.println("--------- Registrar compra ---------");

                System.out.print("Documento del cliente: ");
                String documentoComprador = sc.nextLine();

                Cliente comprador =
                        supermercado.buscarCliente(documentoComprador);

                if (comprador == null) {
                    System.out.println("El cliente no existe.");
                    break;
                }

                System.out.print("Codigo de la compra: ");
                String codigoCompra = sc.nextLine();

                if (supermercado.verificarCompra(codigoCompra)) {
                    System.out.println("Ya existe una compra con ese codigo.");
                    break;
                }

                System.out.print("Fecha (AAAA-MM-DD): ");
                LocalDate fechaCompra =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Metodo de pago (TARJETA, TRANSFERENCIA_BANCARIA, EFECTIVO): ");
                MetodoPago metodoCompra =
                        MetodoPago.valueOf(sc.nextLine().toUpperCase());

                Compra compra = new Compra(
                        codigoCompra,
                        fechaCompra,
                        metodoCompra,
                        0
                );

                String codigoSeleccionado = "";

                do {

                    System.out.print("Codigo del producto (0 para terminar): ");
                    codigoSeleccionado = sc.nextLine();

                    if (!codigoSeleccionado.equals("0")) {

                        Producto productoSeleccionado =
                                supermercado.buscarProducto(codigoSeleccionado);

                        if (productoSeleccionado == null) {

                            System.out.println("El producto no existe.");

                        } else if (compra.agregarProducto(productoSeleccionado)) {

                            System.out.println("Producto agregado a la compra.");

                        } else {

                            System.out.println(
                                    "Producto sin disponibilidad o ya agregado."
                            );
                        }
                    }

                } while (!codigoSeleccionado.equals("0"));

                if (compra.getListaProductos().isEmpty()) {

                    System.out.println(
                            "La compra no tiene productos, no se registro."
                    );

                } else {

                    compra.confirmarCompra();

                    comprador.agregarCompra(compra);

                    System.out.println(
                            "Compra registrada correctamente."
                    );

                    System.out.println(
                            "Valor total: " + compra.getValorTotal()
                    );
                }

                break;


            case 6:

                System.out.println("--------- Compras de un cliente ---------");

                System.out.print("Documento del cliente: ");
                String documentoConsulta = sc.nextLine();

                Cliente clienteConsulta =
                        supermercado.buscarCliente(documentoConsulta);

                if (clienteConsulta == null) {

                    System.out.println("El cliente no existe.");

                } else if (clienteConsulta.getListaCompras().isEmpty()) {

                    System.out.println("El cliente no tiene compras.");

                } else {

                    for (Compra compraListada :
                            clienteConsulta.getListaCompras()) {

                        System.out.println(compraListada);
                    }
                }

                break;


            case 7:

                System.out.println("--------- Ventas por fecha ---------");

                System.out.print("Fecha (AAAA-MM-DD): ");
                LocalDate fechaReporte =
                        LocalDate.parse(sc.nextLine());

                double totalVendido =
                        supermercado.calcularVentasPorFecha(fechaReporte);

                System.out.println(
                        "Total vendido el " +
                                fechaReporte +
                                ": " +
                                totalVendido
                );

                break;


            case 0:

                System.out.println("Gracias por usar MarketPlus.");

                break;


            default:

                System.out.println("Opcion no valida.");

                break;
        }

    } while (opcion != 0);

    sc.close();
}


