/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service;


import com.ProyectoTiendaVeterinaria.domain.Mascota;
import java.util.List;

public interface MascotaService {

    public List<Mascota> getMascotas(boolean activos);

    public Mascota getMascota(Mascota mascota);

    public void deleteMascota(Mascota mascota);

    public void saveMascota(Mascota mascota);
    
}
