/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service;

import com.ProyectoTiendaVeterinaria.domain.Venta;
import java.util.List;

public interface VentaService {
    public List<Venta> getVentas();
    
    public void delete(Venta venta);
    
}
