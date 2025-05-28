package com.miEmpresa.Parqueadero_2.dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jeronimo
 */
public class VehiculoDTO {
    private String placa;
    private String tipoVehiculo;
    private int cedulaUsuario;

    
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public int getCedulaUsuario() { return cedulaUsuario; }
    public void setCedulaUsuario(int cedulaUsuario) { this.cedulaUsuario = cedulaUsuario; }
}