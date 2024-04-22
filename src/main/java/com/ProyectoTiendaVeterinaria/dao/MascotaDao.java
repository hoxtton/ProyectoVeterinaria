/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.dao;

import com.ProyectoTiendaVeterinaria.domain.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaDao extends JpaRepository < Mascota, Long> {
    
}
