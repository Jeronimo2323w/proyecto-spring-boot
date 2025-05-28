/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miEmpresa.Parqueadero_2.com.tuempresa.tuproyecto.controller;

import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Reserva;
import com.miEmpresa.Parqueadero_2.dto.ReservaDTO;
import com.miEmpresa.Parqueadero_2.service.ReservaService;
import com.miEmpresa.Parqueadero_2.service.UsuarioService;
import com.miEmpresa.Parqueadero_2.service.VehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody ReservaDTO dto) {
        String resultado = reservaService.agregarReserva(dto);
        if (resultado.contains("no encontrado")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservaService.obtenerReservas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarReserva(@PathVariable int id, @RequestBody ReservaDTO dto) {
        String resultado = reservaService.modificarReserva(id, dto);
        if (resultado.contains("no encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable int id) {
        String resultado = reservaService.eliminarReserva(id);
        if (resultado.contains("no encontrada")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }
}