/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service.impl;

import com.ProyectoTiendaVeterinaria.dao.FacturaDao;
import com.ProyectoTiendaVeterinaria.dao.ProductoDao;
import com.ProyectoTiendaVeterinaria.dao.VentaDao;
import com.ProyectoTiendaVeterinaria.domain.Factura;
import com.ProyectoTiendaVeterinaria.service.ItemService;
import com.ProyectoTiendaVeterinaria.domain.Item;
import com.ProyectoTiendaVeterinaria.domain.Producto;
import com.ProyectoTiendaVeterinaria.domain.Usuario;
import com.ProyectoTiendaVeterinaria.domain.Venta;
import com.ProyectoTiendaVeterinaria.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        
        for (Item i : listaItems) {
            posicion++;
            if (i.getIdProducto() == item.getIdProducto()) {
                existe=true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public void save(Item item) {
        var existe = false;
        
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                existe=true;
                i.setCantidad(i.getCantidad() + 1);
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }    
    }

    @Override
    public void update(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                item.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        String username;
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        if (username.isBlank()) {
            return;
        }
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        if (usuario == null) {
            return;
        }
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaDao.save(factura);
        double total = 0;
        
        for (Item i : listaItems) {
            System.out.println("Producto: " + i.getTitulo()
                            + " Cantidad: " + i.getCantidad()
                            + " Total: " + i.getPrecio() * i.getCantidad());
            Venta venta = new Venta(factura.getIdFactura(), 
                    i.getIdProducto(), 
                    i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);
            Producto producto = productoDao.getReferenceById(i.getIdProducto());
            producto.setStock(producto.getStock()-i.getCantidad());
            productoDao.save(producto);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
        
    }
    
    
}
