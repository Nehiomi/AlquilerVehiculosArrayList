/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naomi
 */
public class EmpresaAlquilerVehiculos {

    // Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;
    private int totalClientes;
    private int totalVehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<VehiculoAlquilado> alquileres;


    /* Constructor parametrizado donde se establece que el total de clientes
    será 50, igual que el total de vehiculos disponibles. El histórico de vehículos
    puede contener hasta 100 elementos.
     */
    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>(50);
        this.vehiculos = new ArrayList<>(50);
        this.alquileres = new ArrayList<>(100);
    }

    // Métodos getters y setters
    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<VehiculoAlquilado> getAlquileres() {
        return alquileres;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
        this.alquileres = alquileres;
    }

    // Añade un nuevo cliente a la lista de clientes de la empresa.
    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(nuevo);
    }

    // Añade un vehículo al catálogo de vehículos de la empresa.
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos.add(nuevo);
    }

    /*
    Muestra la relación de clientes de la empresa. Este método recorre el array 
    clientes y va mostrando los datos de cada cliente.
     */
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(clientes.get(i));
        }
    }

    /*
    Muestra el catálogo de vehículos de la empresa, recorriendo el array 
    vehiculos y llamando al método getAtributos() de cada uno. 
     */
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int i = 0; i < this.totalVehiculos; i++) {
            System.out.println(vehiculos.get(i));
        }
    }

    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes.get(i).getNif().equals(nif)) {
                return this.clientes.get(i);
            }
        }
        return null;
    }

    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.getTotalVehiculos(); i++) {
            if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
                return this.vehiculos.get(i);
            }
        }
        return null;
    }

    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres.add(new VehiculoAlquilado(cliente, vehiculo, diaHoy(), mesHoy(), añoHoy(), dias));
        }
    }

    // Creo el método diaHoy para saber el día en que estamos, usando LocalDate.
    // Hago lo mismo con mesHoy y añoHoy.
    public static int diaHoy() {
        return LocalDate.now().getDayOfMonth();
    }

    public static Month mesHoy() {
        return LocalDate.now().getMonth();
    }

    public static int añoHoy() {
        return LocalDate.now().getYear();
    }

    public void recibirVehiculo(String matricula) {

        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }
    }

    //Método que genera un cliente aleatorio
    public ArrayList<Cliente> rellenarCLientes() {
        int clientesExistentes = this.totalClientes;
        for (int i = 0; i < 25; i++) {
            registrarCliente(Cliente.clienteAleatorio());
            this.totalClientes++;
        }
        return this.clientes;
    }

    //Método que genera un vehiculo aleatorio
    // Este método debería rellenar el array completo
    // Además, si quieres rellenar a partir de la que ya hubiera, no está bien implementado
    public ArrayList<Vehiculo> rellenarVehiculos() {
        int vehiculosExistentes = this.totalVehiculos;
        for (int i = 0; i < 25; i++) {
            registrarVehiculo(Vehiculo.vehiculoAleatorio());
            this.totalVehiculos++;
        }
        return this.vehiculos;
    }

    //Método Burbuja que ordena en el arrayList los vehículos por matrículas.
    public ArrayList<Vehiculo> ordenarVehiculo() {
        Vehiculo tmp;
        for (int i = 0; i < vehiculos.size() - 1; i++) {
            for (int j = i + 1; j < vehiculos.size(); j++) {
                if (vehiculos.get(i).getMatricula().compareTo(vehiculos.get(j).getMatricula()) > 0) {
                    tmp = vehiculos.get(i);
                    vehiculos.set(i, vehiculos.get(j));
                    vehiculos.set(j, tmp);
                }
            }
        }
        return vehiculos;
    }

    //Método Burbuja que ordena en el arrayList los vehículos por matrículas.
    public ArrayList<Cliente> ordenarCliente() {
        Cliente tmp;
        for (int i = 0; i < clientes.size() - 1; i++) {
            for (int j = i + 1; j < clientes.size(); j++) {
                if (clientes.get(i).getNif().compareTo(clientes.get(j).getNif()) > 0) {
                    tmp = clientes.get(i);
                    clientes.set(i, clientes.get(j));
                    clientes.set(j, tmp);
                }
            }
        }
        return clientes;
    }

    //Método Binario para buscar un cliente
    public int buscarCliente(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = clientes.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes.get(mitad).getNif().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Está en la posición: " + mitad);
                return mitad;
            } else if (clientes.get(mitad).getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } else if (clientes.get(mitad).getNif().compareTo(buscado) < 0) {
                izquierda = mitad + 1;
            }

        }
        return -1;
    }

    //Método Binario para buscar un vehiculo
    public int buscarVehiculo(String buscado) {
        int mitad;
        int izquierda = 0;
        int derecha = vehiculos.size() - 1;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos.get(mitad).getMatricula().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Está en la posición: " + mitad);
                return mitad;
            } else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) > 0) {
                derecha = mitad - 1;
            } else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) < 0) {
                izquierda = mitad + 1;
            }
        }
        return -1;

    }

}
