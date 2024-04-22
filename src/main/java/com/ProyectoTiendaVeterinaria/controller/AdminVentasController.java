/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;

import com.ProyectoTiendaVeterinaria.domain.Venta;
import com.ProyectoTiendaVeterinaria.service.VentaService;
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
@RequestMapping("/admin/venta")
public class AdminVentasController {
    
    
    @Autowired
    private VentaService ventaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var ventas = ventaService.getVentas();
        model.addAttribute("ventas", ventas);
        
        return "/admin/venta/listado";
    }         
    
    @GetMapping("/eliminar/{idVenta}")
    public String elimina(Venta venta) {
        ventaService.delete(venta);
        
        return "redirect:/admin/venta/listado";
    }
}
