/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author naomi
 */

public class Vehiculo {

    // Atributos de la clase vehiculo
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    // Constructor parametrizado
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    // Métodos getters y setters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Genero un vehículo aleatorio.
    public static Vehiculo vehiculoAleatorio() {
        String Matricula = "";

        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {

            if (i < 4) {

                Matricula += rnd.nextInt(10);
            } else {

                Matricula += (char) (rnd.nextInt(90 - 65 + 1) + 65);
            }
        }
        String Color = "";

        int numeroColor = rnd.nextInt(9);

        switch (numeroColor) {
            case 0:
                Color = "Rojo";
                break;
            case 1:
                Color = "Amarillo";
                break;
            case 2:
                Color = "Azul";
                break;
            case 3:
                Color = "Negro";
                break;
            case 4:
                Color = "Morado";
                break;
            case 5:
                Color = "Naranja";
                break;
            case 6:
                Color = "Verde";
                break;
            case 7:
                Color = "Blanco";
                break;
            case 8:
                Color = "Cian";
                break;
        }
        double Tarifa;

        Tarifa = rnd.nextInt(150 - 100 + 1) + 100;
        boolean disponibilidad;

        if (rnd.nextBoolean()) {
            disponibilidad = true;
        } else {
            disponibilidad = false;
        }

        ArrayList<String> marca = new ArrayList<>();
        marca.add("Lexus");
        marca.add("Ferrari");
        marca.add("Maserrati");
        marca.add("Ford");
        marca.add("Renault");
        marca.add("Seat");
        
        ArrayList<String> modelo = new ArrayList<>();
        modelo.add("Marbella");
        modelo.add("Pianto");
        modelo.add("RSX300");
        modelo.add("Laguna");
        modelo.add("Focus");
        modelo.add("Golf");

        String marcaElegido = marca.get(rnd.nextInt(marca.size()));
        String modeloElegido = modelo.get(rnd.nextInt(modelo.size()));

        Vehiculo v = new Vehiculo(Matricula, marcaElegido, modeloElegido, Color, Tarifa, disponibilidad);
        return v;
    }

    //Método toString.
    @Override
    public String toString() {
        return matricula + " " + marca + " " + modelo + " " + color + " " + tarifa + " " + disponible;
    }


}
