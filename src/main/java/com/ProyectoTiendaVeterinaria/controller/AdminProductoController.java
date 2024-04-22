/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;

import com.ProyectoTiendaVeterinaria.domain.Producto;
import com.ProyectoTiendaVeterinaria.service.CategoriaService;
import com.ProyectoTiendaVeterinaria.service.ProductoService;
import com.ProyectoTiendaVeterinaria.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/producto")
public class AdminProductoController {
    
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var productos = productoService.getProductos(true);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        
        return "/admin/producto/listado";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productoService.saveProducto(producto);
            producto.setRutaImagen(firebaseStorageImpl.cargaImagen(imagenFile, "producto", producto.getIdProducto()));
        }
        productoService.saveProducto(producto);
        return "redirect:/admin/producto/listado";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String elimina(Producto producto) {
        productoService.deleteProducto(producto);
        
        return "redirect:/admin/producto/listado";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        return "/admin/producto/modifica";
    }
    
            
}
