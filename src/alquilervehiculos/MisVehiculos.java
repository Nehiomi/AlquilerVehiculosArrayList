/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class MisVehiculos {

    public static void main(String[] args) {
        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");

        // registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));

        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));

        // registro de los vehículos de la empresa
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true));

        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));

        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));

        // imprime la relación de clientes de easydrive
        System.out.println("Imprime la relación de clientes de easydrive: ");
        easydrive.imprimirClientes();

        // imprime el catálogo de vehículos de easydrive
        System.out.println("Imprime el catálogo de vehículos de easydrive: ");
        easydrive.imprimirVehiculos();

        //Rellenar el array de vehículos de forma aleatoria
        System.out.println("Rellena el array de vehículos de easydrive de forma aleatoria: ");
        easydrive.rellenarVehiculos();

        //Rellenar el array de clientes de forma aleatoria.
        System.out.println("Rellena el array de clientes de easydrive de manera aleatoria: ");
        easydrive.rellenarCLientes();

        //Imprimir ambos arrays.
        System.out.println("Imprime clientes: ");
        easydrive.imprimirClientes();
        System.out.println("Imprime clientes: ");
        easydrive.imprimirVehiculos();

        //Búsqueda binaria del cliente por nif.
        easydrive.buscarCliente("Z7568991Y");

        //Búsqueda binaria del vehículo por matrícula.
        easydrive.buscarVehiculo("4070 DEP");

        System.out.println();
        //Busco el cliente concreto y el vehiculo concreto.
        easydrive.buscarCliente("21358003L");
        easydrive.buscarVehiculo("9326HLM");

        easydrive.imprimirClientes();
        easydrive.imprimirVehiculos();

        //Se alquila un vehiculo a un usuario
        System.out.println();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu NIF: ");
        String nif = teclado.nextLine();
        System.out.println("Introduce la matrícula del coche: ");
        String matr = teclado.nextLine();
        System.out.println("Introduce los días: ");
        int dias = teclado.nextInt();

        easydrive.alquilarVehiculo(matr, nif, dias);

        System.out.println();
        teclado.nextLine();
        System.out.println("Introduce tu NIF: ");
        nif = teclado.nextLine();
        System.out.println(easydrive.buscarCliente(nif));

        System.out.println("Introduce la matrícula del coche: ");
        matr = teclado.nextLine();
        System.out.println(easydrive.buscarVehiculo(matr));
    }
}
