/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTiendaVeterinaria.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Laboratorios
 */
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "veterinaria-19190.appspot.com";

    final String rutaSuperiorStorage = "petshop";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "veterinaria-19190-firebase-adminsdk-vrckm-e4e69e775a.json";
    
}
