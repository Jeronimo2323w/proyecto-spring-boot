package com.miEmpresa.Parqueadero_2.service;


import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Usuario;
import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Vehiculo;
import com.miEmpresa.Parqueadero_2.dto.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jeronimo
 */
@Service
public class VehiculoService {

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    
    public String agregarVehiculo(VehiculoDTO dto, List<Usuario> usuarios) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getCedula() == dto.getCedulaUsuario())
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            return "Usuario no encontrado";
        }

        Vehiculo vehiculo = new Vehiculo(dto.getPlaca(), usuario, dto.getTipoVehiculo());
        vehiculos.add(vehiculo);
        return "Vehículo registrado";
    }

   
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    
    public String eliminarVehiculo(String placa) {
        Vehiculo encontrado = vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);

        if (encontrado != null) {
            vehiculos.remove(encontrado);
            return "Vehículo eliminado";
        }
        return "Vehículo no encontrado";
    }

    
    public String modificarVehiculo(String placa, VehiculoDTO datosActualizados, List<Usuario> usuarios) {
        Vehiculo vehiculo = vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);

        if (vehiculo == null) {
            return "Vehículo no encontrado";
        }

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getCedula() == datosActualizados.getCedulaUsuario())
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            return "Usuario no encontrado";
        }

        vehiculo.setTipoVehiculo(datosActualizados.getTipoVehiculo());
        vehiculo.setUsuario(usuario);
        return "Vehículo actualizado";
    }
}