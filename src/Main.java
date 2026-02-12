package src;

public class Main {
    public static void main(String[] args) {

      
        Pedido pedido1 = new Pedido("Juan Pérez");
        pedido1.agregarArticulo(new Articulo("Hamburguesa", 2, 6.5));
        pedido1.agregarArticulo(new Articulo("Refresco", 2, 2.0));
        pedido1.mostrarResumen();

        pedido1.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido1.mostrarResumen();

        pedido1.cambiarEstado(EstadoPedido.ENTREGADO);
        pedido1.mostrarResumen();

      
        pedido1.cambiarEstado(EstadoPedido.EN_PREPARACION);

     
        Pedido pedido2 = new Pedido("María López");
        pedido2.agregarArticulo(new Articulo("Pizza", 1, 10));
        pedido2.agregarArticulo(new Articulo("Agua", 1, 1.5));
        pedido2.agregarArticulo(new Articulo("Postre", 2, 3));
        pedido2.agregarArticulo(new Articulo("Café", 1, 1.2));
        pedido2.agregarArticulo(new Articulo("Ensalada", 1, 5));
       
        pedido2.agregarArticulo(new Articulo("Extra pan", 1, 1));

        pedido2.mostrarResumen();
    }
   
}
