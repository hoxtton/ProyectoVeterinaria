/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service.impl;


import com.ProyectoTiendaVeterinaria.dao.ServicioDao;
import com.ProyectoTiendaVeterinaria.domain.Servicio;
import com.ProyectoTiendaVeterinaria.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceimpl implements ServicioService {

    
    @Autowired
    private ServicioDao servicioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Servicio> getServicios() {
        var lista = servicioDao.findAll();
        return lista;
    }

    @Override
    public Servicio getServicio(Servicio servicio) {
       return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    }

    @Override
    public void deleteServicio(Servicio servicio) {
        servicioDao.delete(servicio);
    }

    @Override
    public void saveServicio(Servicio servicio) {
        servicioDao.save(servicio);
    }
    
}
