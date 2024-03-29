/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author naomi
 */

public class VehiculoAlquilado {

    // Atributos de la clase VehiculoAlquilado
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int diaAlquiler;
    private Month mesAlquiler;
    private int añoAlquiler;
    private int totalDiasAlquiler;

    public VehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, int diaAlquiler, Month mesAlquiler, int añoAlquiler, int totalDiasAlquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.diaAlquiler = diaAlquiler;
        this.mesAlquiler = mesAlquiler;
        this.añoAlquiler = añoAlquiler;
        this.totalDiasAlquiler = totalDiasAlquiler;
    }
    
    // Métodos getters y setters
    public Month getMesAlquiler() {
        return mesAlquiler;
    }

    public void setMesAlquiler(Month mesAlquiler) {
        this.mesAlquiler = mesAlquiler;
    }
    
    public int getAñoAlquiler() {
        return añoAlquiler;
    }

    public void setAñoAlquiler(int añoAlquiler) {
        this.añoAlquiler = añoAlquiler;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDiaAlquiler() {
        return diaAlquiler;
    }

    public int getTotalDiasAlquiler() {
        return totalDiasAlquiler;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setDiaAlquiler(int diaAlquiler) {
        this.diaAlquiler = diaAlquiler;
    }

    public void setTotalDiasAlquiler(int totalDiasAlquiler) {
        this.totalDiasAlquiler = totalDiasAlquiler;
    }
}
