/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miEmpresa.Parqueadero_2.com.tuempresa.tuproyecto.controller;

import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Usuario;
import com.miEmpresa.Parqueadero_2.service.UsuarioService;
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

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String agregarUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.agregarUsuario(nuevoUsuario);
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{cedula}")
    public Usuario buscarUsuario(@PathVariable int cedula) {
        return usuarioService.buscarUsuario(cedula);
    }

    @PutMapping("/{cedula}")
    public String actualizarUsuario(@PathVariable int cedula, @RequestBody Usuario datosActualizados) {
        return usuarioService.actualizarUsuario(cedula, datosActualizados);
    }

    @DeleteMapping("/{cedula}")
    public String eliminarUsuario(@PathVariable int cedula) {
        return usuarioService.eliminarUsuario(cedula);
    }
}