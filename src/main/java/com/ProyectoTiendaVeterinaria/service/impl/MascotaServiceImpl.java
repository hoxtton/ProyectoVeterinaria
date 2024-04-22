/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service.impl;

import com.ProyectoTiendaVeterinaria.dao.MascotaDao;
import com.ProyectoTiendaVeterinaria.domain.Mascota;
import com.ProyectoTiendaVeterinaria.service.MascotaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MascotaServiceImpl implements MascotaService {

    
    @Autowired
    private MascotaDao mascotaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Mascota> getMascotas(boolean activos) {
        var lista = mascotaDao.findAll();
        if (activos) {
           lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    public Mascota getMascota(Mascota mascota) {
       return mascotaDao.findById(mascota.getIdMascota()).orElse(null);
    }

    @Override
    public void deleteMascota(Mascota mascota) {
        mascotaDao.delete(mascota);
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaDao.save(mascota);
    }
    
}
