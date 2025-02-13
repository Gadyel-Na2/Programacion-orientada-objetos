package com.mycompany.product;

import java.util.Scanner;

/**
 *
 * @author aldopazmendiola
 */
public class Product {
    private String descripcion;
    private String codigo;
    private String tipo;
    private Double costo;
    private Double impuesto;

    // Métodos de acceso (get)
    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    // Métodos establecedores (set)
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    // Método para mostrar el producto
    public void muestraProducto() {
        System.out.println("Descripción: " + descripcion);
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: " + costo);
        System.out.println("Impuesto: " + impuesto);
    }

    // Método para calcular el precio de venta
    public Double calcularPrecio(double utilidad) {
        double precioAntesImpuesto = costo + (costo * (utilidad / 100));
        return precioAntesImpuesto + (precioAntesImpuesto * (impuesto / 100));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product producto1 = new Product();
        Product producto2 = new Product();

        try {
            // Ingresar datos para el primer producto
            System.out.println("Ingrese la descripción del producto 1:");
            producto1.setDescripcion(scanner.nextLine());
            System.out.println("Ingrese el código del producto 1:");
            producto1.setCodigo(scanner.nextLine());
            System.out.println("Ingrese el tipo del producto 1:");
            producto1.setTipo(scanner.nextLine());
            System.out.println("Ingrese el costo del producto 1:");
            producto1.setCosto(scanner.nextDouble());
            System.out.println("Ingrese el impuesto del producto 1:");
            producto1.setImpuesto(scanner.nextDouble());
            scanner.nextLine(); // Limpiar el buffer
            
            // Ingresar datos para el segundo producto
            System.out.println("Ingrese la descripción del producto 2:");
            producto2.setDescripcion(scanner.nextLine());
            System.out.println("Ingrese el código del producto 2:");
            producto2.setCodigo(scanner.nextLine());
            System.out.println("Ingrese el tipo del producto 2:");
            producto2.setTipo(scanner.nextLine());
            System.out.println("Ingrese el costo del producto 2:");
            producto2.setCosto(scanner.nextDouble());
            System.out.println("Ingrese el impuesto del producto 2:");
            producto2.setImpuesto(scanner.nextDouble());
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
        }

        // Mostrar productos
        System.out.println("\nProducto 1:");
        producto1.muestraProducto();
        System.out.println("\nProducto 2:");
        producto2.muestraProducto();

        // Comparar productos y mostrar resultado
        String resultado = compararProductos(producto1, producto2, 20); // Supongamos una utilidad del 20%
        System.out.println("\nProducto con mayor precio de venta: " + resultado);
    }

    public static String compararProductos(Product p1, Product p2, double utilidad) {
        double precio1 = p1.calcularPrecio(utilidad);
        double precio2 = p2.calcularPrecio(utilidad);

        if (precio1 > precio2) {
            return p1.getDescripcion();
        } else if (precio2 > precio1) {
            return p2.getDescripcion();
        } else {
            return "Ambos productos tienen el mismo precio de venta.";
        }
    }
}
