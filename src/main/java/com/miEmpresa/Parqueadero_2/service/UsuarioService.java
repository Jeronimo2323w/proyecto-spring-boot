/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miEmpresa.Parqueadero_2.service;

import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeronimo
 */
@Service
public class UsuarioService {
    
    private List<Usuario> usuarios = new ArrayList<>();

    public String agregarUsuario(Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        return "Usuario agregado con éxito.";
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(int cedula) {
        return usuarios.stream()
                .filter(u -> u.getCedula() == cedula)
                .findFirst()
                .orElse(null);
    }

    public String actualizarUsuario(int cedula, Usuario datosActualizados) {
        for (Usuario u : usuarios) {
            if (u.getCedula() == cedula) {
                u.setNombre(datosActualizados.getNombre());
                u.setCorreo(datosActualizados.getCorreo());
                u.setTelefono(datosActualizados.getTelefono());
                return "Usuario actualizado.";
            }
        }
        return "Usuario no encontrado.";
    }

    public String eliminarUsuario(int cedula) {
        Usuario encontrado = buscarUsuario(cedula);
        if (encontrado != null) {
            usuarios.remove(encontrado);
            return "Usuario eliminado.";
        }
        return "Usuario no encontrado.";
    }
}

