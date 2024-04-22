/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.dao;

import com.ProyectoTiendaVeterinaria.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository < Producto, Long> {
    
    public List<Producto> findByTituloContaining(String titulo);
    
}
