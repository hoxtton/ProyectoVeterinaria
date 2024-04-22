/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service;

import com.ProyectoTiendaVeterinaria.domain.Servicio;
import java.util.List;

public interface ServicioService {
    public List<Servicio> getServicios();
    
    public Servicio getServicio(Servicio servicio);
    
    public void deleteServicio(Servicio servicio);

    public void saveServicio(Servicio servicio);
    
}
