/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Producto {
    private int cantidad;
    
    public Item(){
        
    }
    
    public Item(Producto p) {
        super.setIdProducto(p.getIdProducto());
        super.setCategoria(p.getCategoria());
        super.setTitulo(p.getTitulo());
        super.setDescripcion(p.getDescripcion());
        super.setPrecio(p.getPrecio());
        super.setStock(p.getStock());
        super.setActivo(p.isActivo());
        super.setRutaImagen(p.getRutaImagen());
        this.cantidad = 0;
    }
    
}
