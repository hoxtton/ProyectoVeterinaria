/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;

import com.ProyectoTiendaVeterinaria.domain.Mascota;
import com.ProyectoTiendaVeterinaria.service.CategoriaService;
import com.ProyectoTiendaVeterinaria.service.MascotaService;
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
@RequestMapping("/admin/adopcion")
public class AdminMascotaController {
    
    
    @Autowired
    private MascotaService mascotaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var mascotas = mascotaService.getMascotas(true);
        model.addAttribute("mascotas", mascotas);
        
        return "/admin/adopcion/listado";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/guardar")
    public String guardar(Mascota mascota, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            mascotaService.saveMascota(mascota);
            mascota.setRutaImagen(firebaseStorageImpl.cargaImagen(imagenFile, "mascota", mascota.getIdMascota()));
        }
        mascotaService.saveMascota(mascota);
        return "redirect:/admin/adopcion/listado";
    }
    
    @GetMapping("/eliminar/{idMascota}")
    public String elimina(Mascota mascota) {
        mascotaService.deleteMascota(mascota);
        
        return "redirect:/admin/adopcion/listado";
    }
    
    @GetMapping("/modificar/{idMascota}")
    public String modifica(Mascota mascota, Model model) {
        mascota = mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascota);
        
        return "/admin/adopcion/modifica";
    }
    
            
}
