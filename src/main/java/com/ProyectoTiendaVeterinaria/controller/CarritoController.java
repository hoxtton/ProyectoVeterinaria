/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;

import com.ProyectoTiendaVeterinaria.domain.Item;
import com.ProyectoTiendaVeterinaria.domain.Producto;
import com.ProyectoTiendaVeterinaria.service.ProductoService;
import com.ProyectoTiendaVeterinaria.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/carrito/listado")
    public String listado(Model model, Item item) {
        var items = itemService.gets();
        
        model.addAttribute("items", items);
        
        var carritoTotalVenta=0;
        
        for (Item i : items) {
            carritoTotalVenta+=(i.getCantidad()*i.getPrecio());
        }
        
        model.addAttribute("carritoTotal", carritoTotalVenta);
                
        return "/carrito/listado";
        
    }
    
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregarItem(Model model, Item item){
        Item item2 = itemService.get(item);
        
        if (item2==null) {
            Producto p = productoService.getProducto(item);
            item2 = new Item(p);
        }
        itemService.save(item2);
        
        var lista = itemService.gets();
        var totalCarrito = 0;
        var carritoTotalVenta = 0;
        
        for (Item i : lista) {
            totalCarrito += i.getCantidad();
            carritoTotalVenta += (i.getCantidad()*i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarrito);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.update(item);
        return "redirect:/carrito/listado";
    }
    
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(){
        itemService.facturar();
        return "redirect:/";
    }
}
