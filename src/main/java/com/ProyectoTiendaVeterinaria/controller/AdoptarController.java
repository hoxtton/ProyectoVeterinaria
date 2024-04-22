/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.controller;


import com.ProyectoTiendaVeterinaria.domain.Mascota;
import com.ProyectoTiendaVeterinaria.domain.Servicio;
import com.ProyectoTiendaVeterinaria.service.MascotaService;
import com.ProyectoTiendaVeterinaria.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/adoptar")
public class AdoptarController {
    
    
    @Autowired
    private MascotaService mascotaService;
    
    @GetMapping("/mascotas")
    public String mascotas(Model model){
        var mascotas = mascotaService.getMascotas(true);
        model.addAttribute("mascotas", mascotas);

        return "/adoptar/mascotas";
    }
    
    @GetMapping("/mascota/{idMascota}")
    public String mascota(Mascota mascota, Model model) {
        mascota = mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascota);
        return "/adoptar/mascota";
    }
    
    
}
