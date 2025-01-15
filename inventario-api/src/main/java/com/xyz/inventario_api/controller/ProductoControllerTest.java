package com.xyz.inventario_api.controller;

import com.xyz.inventario_api.model.Producto;
import com.xyz.inventario_api.service.InventarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(ProductoController.class)
@AutoConfigureMockMvc
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConsultarProductoValido() throws Exception {
        InventarioService inventarioService = mock(InventarioService.class);
        Producto producto = new Producto(1, "Producto A", 100);
        when(inventarioService.consultarProducto(1)).thenReturn(producto);

        mockMvc.perform(get("/producto/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Producto A"))
                .andExpect(jsonPath("$.cantidad").value(100));
    }

    @Test
    void testConsultarProductoInvalido() throws Exception {
        InventarioService inventarioService = mock(InventarioService.class);
        when(inventarioService.consultarProducto(999)).thenReturn(null);

        mockMvc.perform(get("/producto/999"))
                .andExpect(status().isNotFound());
    }
}
