package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto("Hamburguesa", 10.0, "Comida");
        Producto p2 = new Producto("Refresco", 2.5, "Bebida");

        // Crear cliente VIP
        Cliente cliente = new Cliente("vip");

        // Crear pedido y agregar productos
        Pedido pedido = new Pedido();
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);

        // Aplicar descuento si es VIP
        if (cliente.getTipo().equals("vip")) {
            pedido.aplicarDescuento(10);
        }

        // Seleccionar método de pago
        Pago metodoPago = PagoFactory.crearMetodoPago("efectivo");

        // Procesar pago
        metodoPago.procesarPago(pedido.getTotal());

        // Mostrar total
        System.out.println("Total a pagar: " + pedido.getTotal());
    }
}

class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}

class Pedido {
    private List<Producto> listaProductos;
    private double total;
    private double descuento;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.total = 0.0;
        this.descuento = 0.0;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        total += producto.getPrecio();
    }

    public void aplicarDescuento(double porcentaje) {
        descuento = total * (porcentaje / 100);
        total -= descuento;
    }

    public double getTotal() {
        return total;
    }
}

class Cliente {
    private String tipo; // "regular" o "vip"

    public Cliente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

interface Pago {
    void procesarPago(double monto);
}

class PagoEfectivo implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago en efectivo de " + monto + " procesado.");
    }
}

class PagoTarjeta implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta de " + monto + " procesado.");
    }
}

class PagoPayPal implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal de " + monto + " procesado.");
    }
}

class PagoFactory {
    public static Pago crearMetodoPago(String tipo) {
        switch (tipo.toLowerCase()) {
            case "efectivo":
                return new PagoEfectivo();
            case "tarjeta":
                return new PagoTarjeta();
            case "paypal":
                return new PagoPayPal();
            default:
                throw new IllegalArgumentException("Tipo de pago no soportado: " + tipo);
        }
    }
}