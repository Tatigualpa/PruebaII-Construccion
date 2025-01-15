package com.xyz.inventario_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.inventario_api.model.Producto;
import com.xyz.inventario_api.service.InventarioService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final InventarioService inventarioService;

    public ProductoController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/{id}")
    public Producto consultarProducto(@PathVariable int id) {
        Producto producto = inventarioService.consultarProducto(id);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
        return producto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto agregarProducto(@RequestParam String nombre, @RequestParam int cantidad) {
        Producto producto = new Producto(0, nombre, cantidad); // ID se asignará automáticamente
        return inventarioService.agregarProducto(producto.getId(), cantidad);
    }

    @PutMapping("/{id}")
    public Producto actualizarStock(@PathVariable int id, @RequestParam int nuevaCantidad) {
        return inventarioService.actualizarStock(id, nuevaCantidad);
    }
}
