package src;

public class Pedido {

    private static int siguienteId = 1; 

    private int id;
    private String nombreCliente;
    private ArticuloPedido[] articulos;
    private int numeroArticulos;
    private EstadoPedido estado;
    private double total;

    public Pedido(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        this.id = siguienteId++;
        this.nombreCliente = nombreCliente;
        this.articulos = new ArticuloPedido[5]; 
        this.numeroArticulos = 0;
        this.estado = EstadoPedido.EN_PREPARACION;
        this.total = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public boolean agregarArticulo(ArticuloPedido articulo) {
        if (articulo == null) {
            System.out.println("El artículo no puede ser nulo");
            return false;
        }
        if (numeroArticulos >= articulos.length) {
            System.out.println("No se pueden agregar más de 5 artículos al pedido " + id);
            return false;
        }
        articulos[numeroArticulos] = articulo;
        numeroArticulos++;
        calcularTotal();
        return true;
    }

    private void calcularTotal() {
        double suma = 0.0;
        for (int i = 0; i < numeroArticulos; i++) {
            suma += articulos[i].getSubtotal();
        }
        this.total = suma;
    }

    public boolean cambiarEstado(EstadoPedido nuevoEstado) {
       
        if (nuevoEstado.ordinal() < this.estado.ordinal()) {
            System.out.println("No se puede retroceder el estado del pedido " + id);
            return false;
        }
        this.estado = nuevoEstado;
        return true;
    }

    public void mostrarResumen() {
        System.out.println("===== Pedido #" + id + " =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);
        System.out.println("Artículos:");
        if (numeroArticulos == 0) {
            System.out.println("  (Sin artículos)");
        } else {
            for (int i = 0; i < numeroArticulos; i++) {
                System.out.println("  - " + articulos[i]);
            }
        }
        System.out.println("Total: " + total + " €");
        
    }
}
