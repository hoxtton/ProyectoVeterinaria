/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service.impl;



import com.ProyectoTiendaVeterinaria.dao.ProductoDao;
import com.ProyectoTiendaVeterinaria.domain.Producto;
import com.ProyectoTiendaVeterinaria.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        return lista;
    }

    @Override
    public Producto getProducto(Producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoDao.save(producto);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> busquedaProducto(String titulo) {
        return productoDao.findByTituloContaining(titulo);
    }
    
}
