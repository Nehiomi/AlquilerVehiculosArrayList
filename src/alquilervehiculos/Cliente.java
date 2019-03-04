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

public class Cliente {

    // Atributos de la clase cliente
    private String nif;
    private String nombre;
    private String apellidos;

    // Constructor parametrizado
    public Cliente(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Métodos getters y setters
    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //Método para generar clientes aletaorios
    //Genero un cliente aleatorio.
    public static Cliente clienteAleatorio() {
        Random rnd = new Random();

        ArrayList<String> nombre = new ArrayList<>();
        nombre.add("Andrés");
        nombre.add("Rubén");
        nombre.add("Yolanda");
        nombre.add("Manuel");
        nombre.add("Miguel");
        nombre.add("Felix");
        
        ArrayList<String> apellido = new ArrayList<>();
        apellido.add("Zuri");
        apellido.add("García");
        apellido.add("Pérez");
        apellido.add("Zarza");
        apellido.add("Páez");
        apellido.add("Rodriguez");

        String nifrandom = "";
        ArrayList<Integer> dni = new ArrayList<>(8);
        for (int i = 0; i <= 8 - 1; i++) {
            dni.add(rnd.nextInt(10));
        }
        
        String letra = "";
        int i = 0;
        for (int value : dni) {
            letra += String.valueOf(value);
        }
        int calculoLetra = Integer.parseInt(letra);
        int c = calculoLetra % 23;
        switch (c) {
            case 0:
                letra += "T";
                break;
            case 1:
                letra += "R";
                break;
            case 2:
                letra += "W";
                break;
            case 3:
                letra += "A";
                break;
            case 4:
                letra += "G";
                break;
            case 5:
                letra += "M";
                break;
            case 6:
                letra += "Y";
                break;
            case 7:
                letra += "F";
                break;
            case 8:
                letra += "P";
                break;
            case 9:
                letra += "D";
                break;
            case 10:
                letra += "X";
                break;
            case 11:
                letra += "B";
                break;
            case 12:
                letra += "N";
                break;
            case 13:
                letra += "J";
                break;
            case 14:
                letra += "Z";
                break;
            case 15:
                letra += "S";
                break;
            case 16:
                letra += "Q";
                break;
            case 17:
                letra += "V";
                break;
            case 18:
                letra += "H";
                break;
            case 19:
                letra += "L";
                break;
            case 20:
                letra += "C";
                break;
            case 21:
                letra += "K";
                break;
            case 22:
                letra += "E";
                break;

        }

        String nombreElegido = nombre.get(rnd.nextInt(nombre.size()));
        System.out.println("Nombre: " + nombreElegido);
        String apellidoElegido = apellido.get(rnd.nextInt(apellido.size()));
        System.out.println("Apellido: " + apellidoElegido);
        System.out.println("Nif :" + letra);
        Cliente cliente = new Cliente(letra, nombreElegido, apellidoElegido);
        return cliente;
    }

    @Override
    public String toString() {
        return nif + " " + nombre + " " + apellidos;
    }

}
