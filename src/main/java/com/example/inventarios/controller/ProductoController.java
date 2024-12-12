/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.inventarios.controller;

import com.example.inventarios.service.ProductoService;
import com.example.inventarios.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FLHORIAN
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoService service;
    
    public ProductoController(ProductoService productoService){
        this.service=productoService;
        
    }
    @GetMapping
    public  String listarProductos(Model model){
        model.addAttribute("productos", this.service.listarTodas());
        return "productos";
    }
     @GetMapping("/nueva")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }
     @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        this.service.guardar(producto);
        return "redirect:/productos";
    }

   @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", this.service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID invalido" + id)));
        return "formulario";
    }
    
 @GetMapping("/eliminar/{id}")
public String eliminarProducto(@PathVariable Long id) {
    this.service.eliminar(id);
    return "redirect:/productos";
}
@DeleteMapping("/{id}")
public String eliminarPersonas(@PathVariable Long id) {
    this.service.eliminar(id);
    return "redirect:/productos";
}

}
