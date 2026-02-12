package src;

public class Articulo {

    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Articulo(String nombre, int cantidad, double precioUnitario) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del artículo no puede estar vacío");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor que 0");
        }
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return nombre + " x" + cantidad + " (" + precioUnitario + " €/u) = " + getSubtotal() + " €";
    }
}