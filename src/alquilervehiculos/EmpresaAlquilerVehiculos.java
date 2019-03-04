/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
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
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<VehiculoAlquilado> alquileres;

    /* Constructor parametrizado donde se establece que el total de clientes
    será 50, igual que el total de vehiculos disponibles. El histórico de vehículos
    puede contener hasta 100 elementos.
     */
    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    //Método que devuelve un vehiculo aleatorio
    //Uso la clase Random para generar vehiculos aleatorios
    public Vehiculo vehiculoRandom() {
        Random aleaNum = new Random();

        //Genero un número aleatorio
        int numAlea = aleaNum.nextInt(vehiculos.length);
        return vehiculos[numAlea];

        //Devuelvo una posición del array vehiculo aleatorio comprendida entre 0 y su longitud
        //return vehiculos[aleaNum.nextInt(vehiculos.length)];
    }

    //Método que devuelve un cliente aleatorio
    //Uso la clase Random para generar clientes aleatorios
    public Cliente clienteRandom() {
        Random aleaNum = new Random();

        //Genero un número aleatorio
        int clienteAlea = aleaNum.nextInt(clientes.length);
        return clientes[clienteAlea];

        //Devuelvo una posición del array cliente aleatorio comprendida entre 0 y su longitud
        //return vehiculos[aleaNum.nextInt(vehiculos.length)];
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<VehiculoAlquilado> getAlquileres() {
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

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setAlquileres(List<VehiculoAlquilado> alquileres) {
        this.alquileres = alquileres;
    }

    // Añade un nuevo cliente a la lista de clientes de la empresa.
    public void registrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    // Añade un vehículo al catálogo de vehículos de la empresa.
    public void registrarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    /*
    Muestra la relación de clientes de la empresa. Este método recorre el array 
    clientes y va mostrando los datos de cada cliente.
     */
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (Cliente c : this.clientes) {
            System.out.println(c.toString());
        }
    }

    /*
    Muestra el catálogo de vehículos de la empresa, recorriendo el array 
    vehiculos y llamando al método getAtributos() de cada uno. 
     */
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");

        for (Vehiculo v : this.vehiculos) {
            System.out.println(v.toString());
        }
    }

    private Cliente getCliente(String nif) {
        for (Cliente c : this.clientes) {
            if (c.getNif().equals(nif)) {
                return c;
            }
        }

        return null;
    }

    private Vehiculo getVehiculo(String matricula) {

        for (Vehiculo c : this.vehiculos) {
            if (c.getMatricula().equals(matricula)) {
                return c;
            }
        }
        return null;
    }

    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);

        if (vehiculo.getDisponible()) {
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

    //Método Burbuja que ordena en el array los vehículos por matrículas.
    public void ordenarVehiculo() {
        Vehiculo tmp;
        for (int i = 0; i < vehiculos.length - 1; i++) {
            for (int j = i + 1; j < vehiculos.length; j++) {
                if (vehiculos[i].getMatricula().compareTo(vehiculos[i].getMatricula()) > 0) {
                    tmp = vehiculos[i];
                    vehiculos[i] = vehiculos[j];
                    vehiculos[j] = tmp;
                }
            }
        }
    }

    //Método Burbuja que ordena en el array los vehículos por matrículas.
    public void ordenarCliente() {
        Cliente tmp;
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = i + 1; j < clientes.length; j++) {
                if (clientes[i].getNif().compareTo(clientes[i].getNif()) > 0) {
                    tmp = clientes[i];
                    clientes[i] = clientes[j];
                    clientes[j] = tmp;
                }
            }
        }
    }

    //Método Binario para buscar un cliente
    public int buscarCliente(String aux) {
        int mitad;
        int izquierda = 0;
        int derecha = clientes.length - 1;
        String buscado = aux;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (clientes[mitad].getNif().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Se encuentra en la posición " + mitad);
                return mitad;
            } else if (clientes[mitad].getNif().compareTo(buscado) > 0) {
                derecha = mitad - 1; //buscar en el trozo izquierdo
            } else if (clientes[mitad].getNif().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }

        }
        return -1;

    }

    //Método Binario para buscar un vehiculo
    public int buscarVehiculo(String aux) {
        int mitad;
        int izquierda = 0;
        int derecha = vehiculos.length - 1;
        String buscado = aux;
        boolean encontrado = false;
        while ((izquierda <= derecha) && (!encontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (vehiculos[mitad].getMatricula().compareTo(buscado) == 0) {
                encontrado = true;
                System.out.println("Se encuentra en la posición " + mitad);
                return mitad;
            } else if (vehiculos[mitad].getMatricula().compareTo(buscado) > 0) {
                derecha = mitad - 1; //buscar en el trozo izquierdo
            } else if (vehiculos[mitad].getMatricula().compareTo(buscado) < 0) {
                izquierda = mitad + 1; // buscar en el trozo derecho
            }
        }
        return -1;
    }

}
