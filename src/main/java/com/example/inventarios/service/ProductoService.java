/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.inventarios.service;

import com.example.inventarios.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventarios.model.Producto;
import java.util.List;
import java.util.Optional;



/**
 *
 * @author FLHORIAN
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    /**
     * Funcion para listar la tabla persona
     * @return
     */
    public List<Producto> listarTodas(){
        return repository.findAll();
    }
     /**Funcion para Guardar datos del inventario
      *@param producto
      */
    public void guardar(Producto producto){
        repository.save(producto);
        
    }
    /***
     *FUNCION PARA  BUSCAR REGISTRO  DE INVENTARIO POR ID
     *@param id
     *@return
     */
    public Optional<Producto> buscarPorId(Long id){
        return repository.findById(id);
    }
    /**
     * Funcion para eliminar el registro de una inventario
     * @param id
     */
     public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
