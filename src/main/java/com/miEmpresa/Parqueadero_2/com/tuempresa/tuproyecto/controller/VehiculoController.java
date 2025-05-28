/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miEmpresa.Parqueadero_2.com.tuempresa.tuproyecto.controller;

import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Vehiculo;
import com.miEmpresa.Parqueadero_2.dto.VehiculoDTO;
import com.miEmpresa.Parqueadero_2.service.UsuarioService;
import com.miEmpresa.Parqueadero_2.service.VehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jeronimo
 */
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final UsuarioService usuarioService; 

    @Autowired
    public VehiculoController(VehiculoService vehiculoService, UsuarioService usuarioService) {
        this.vehiculoService = vehiculoService;
        this.usuarioService = usuarioService;
    }

    
    @PostMapping
    public String agregarVehiculo(@RequestBody VehiculoDTO dto) {
        return vehiculoService.agregarVehiculo(dto, usuarioService.obtenerUsuarios());
    }

    
    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoService.obtenerVehiculos();
    }

   
    @DeleteMapping("/{placa}")
    public String eliminarVehiculo(@PathVariable String placa) {
        return vehiculoService.eliminarVehiculo(placa);
    }

    
    @PutMapping("/{placa}")
    public String modificarVehiculo(@PathVariable String placa, @RequestBody VehiculoDTO dto) {
        return vehiculoService.modificarVehiculo(placa, dto, usuarioService.obtenerUsuarios());
    }
}