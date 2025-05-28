/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miEmpresa.Parqueadero_2.service;

import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Reserva;
import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Usuario;
import com.miEmpresa.Parqueadero_2.com.miEmpresa.Parqueadero_2.model.Vehiculo;
import com.miEmpresa.Parqueadero_2.dto.ReservaDTO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeronimo
 */
@Service
public class ReservaService {

    private final List<Reserva> reservas = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VehiculoService vehiculoService;

    public String agregarReserva(ReservaDTO dto) {
        Usuario usuario = usuarioService.buscarUsuario(dto.getCedulaUsuario());
        if (usuario == null) return "Usuario no encontrado";

        Vehiculo vehiculo = vehiculoService.obtenerVehiculos().stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(dto.getPlacaVehiculo()))
                .findFirst()
                .orElse(null);

        if (vehiculo == null) return "Vehículo no encontrado";

        ArrayList<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(vehiculo);

        Reserva reserva = new Reserva(
                dto.getOcupado(),
                dto.getTiempo(),
                dto.getPrecioMoto(),
                dto.getPrecioCarro(),
                LocalTime.parse(dto.getHoraEntrada()),
                LocalTime.parse(dto.getHoraSalida()),
                dto.getPrecioCarro() * dto.getNumeroHoras(),
                dto.getPrecioMoto() * dto.getNumeroHoras(),
                dto.getPrecioMoto(),
                dto.getPrecioCarro(),
                vehiculoList,
                dto.getNumeroCuenta(),
                dto.getBanco(),
                dto.getNumeroHoras(),
                dto.getPiso(),
                dto.getLugar(),
                dto.getCodigo()
        );

        reservas.add(reserva);
        return "Reserva agregada correctamente";
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public String modificarReserva(int id, ReservaDTO dto) {
        if (id < 0 || id >= reservas.size()) return "Reserva no encontrada";

        Usuario usuario = usuarioService.buscarUsuario(dto.getCedulaUsuario());
        if (usuario == null) return "Usuario no encontrado";

        Vehiculo vehiculo = vehiculoService.obtenerVehiculos().stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(dto.getPlacaVehiculo()))
                .findFirst()
                .orElse(null);

        if (vehiculo == null) return "Vehículo no encontrado";

        ArrayList<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(vehiculo);

        Reserva reserva = new Reserva(
                dto.getOcupado(),
                dto.getTiempo(),
                dto.getPrecioMoto(),
                dto.getPrecioCarro(),
                LocalTime.parse(dto.getHoraEntrada()),
                LocalTime.parse(dto.getHoraSalida()),
                dto.getPrecioCarro() * dto.getNumeroHoras(),
                dto.getPrecioMoto() * dto.getNumeroHoras(),
                dto.getPrecioMoto(),
                dto.getPrecioCarro(),
                vehiculoList,
                dto.getNumeroCuenta(),
                dto.getBanco(),
                dto.getNumeroHoras(),
                dto.getPiso(),
                dto.getLugar(),
                dto.getCodigo()
        );

        reservas.set(id, reserva);
        return "Reserva modificada correctamente";
    }

    public String eliminarReserva(int id) {
        if (id < 0 || id >= reservas.size()) return "Reserva no encontrada";
        reservas.remove(id);
        return "Reserva eliminada correctamente";
    }
}