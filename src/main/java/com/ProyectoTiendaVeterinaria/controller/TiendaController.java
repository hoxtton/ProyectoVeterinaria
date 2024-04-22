/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;


import com.ProyectoTiendaVeterinaria.domain.Producto;
import com.ProyectoTiendaVeterinaria.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/tienda")
public class TiendaController {
    
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos")
    public String listado(Model model){
        var productos = productoService.getProductos(true);

        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        return "/tienda/productos";
    }

    @PostMapping("/busqueda")
    public String consultaQuery1(
            @RequestParam(value="titulo") String titulo, Model model){
        
        var productos = productoService.busquedaProducto(titulo);
        model.addAttribute("productos", productos);
        model.addAttribute("titulo", titulo);
        
        return "/tienda/busqueda";
    }
    

}
