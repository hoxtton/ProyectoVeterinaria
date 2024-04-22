/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service.impl;



import com.ProyectoTiendaVeterinaria.dao.VentaDao;
import com.ProyectoTiendaVeterinaria.domain.Venta;
import com.ProyectoTiendaVeterinaria.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceImpl implements VentaService {

    
    @Autowired
    private VentaDao ventaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Venta> getVentas() {
        var lista = ventaDao.findAll();
        return lista;
    }

    @Override
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }

    
}
