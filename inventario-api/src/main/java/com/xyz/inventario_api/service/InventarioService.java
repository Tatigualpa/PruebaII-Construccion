package com.xyz.inventario_api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xyz.inventario_api.model.Producto;

@Service
public class InventarioService {

    private final Map<Integer, Producto> inventario = new HashMap<>();

    public InventarioService() {
        // Agregar productos iniciales al inventario
        inventario.put(1, new Producto(1, "Producto A", 100));
        inventario.put(2, new Producto(2, "Producto B", 50));
        inventario.put(3, new Producto(3, "Producto C", 200));
    }

    public Producto consultarProducto(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un número entero positivo.");
        }
        return inventario.get(id);
    }

    public Producto agregarProducto(int id, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a agregar debe ser un número entero positivo.");
        }
        Producto producto = inventario.get(id);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
        producto.setCantidad(producto.getCantidad() + cantidad);
        return producto;
    }

    public Producto actualizarStock(int id, int nuevaCantidad) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un número entero positivo.");
        }
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La nueva cantidad no puede ser negativa.");
        }
        Producto producto = inventario.get(id);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
        producto.setCantidad(nuevaCantidad);
        return producto;
    }
}
