package unl.edu.cc.workunity.view;

import unl.edu.cc.workunity.domain.Entidad;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionalidadCrearProyecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Entidad entidad = new Entidad("Elkin", "Jiménez", "0991534536");
        System.out.println("\n-----Bienvenido " + entidad.getNombre() + " a WorkUnity-----");
        int opcion = 0;
        while (opcion != 3) {
            try {
                System.out.println("\n-----------Elija una opción-----------");
                System.out.println("1. Crear Proyecto");
                System.out.println("2. Listar Proyectos");
                System.out.println("3. Salir");
                opcion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Ingrese las opciones del programa.");
            }
            sc.nextLine();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("\nIngresa el nombre del proyecto");
                        String nombreProyecto = sc.nextLine();
                        System.out.println("Ingresa la descripción del proyecto");
                        String descripcionProyecto = sc.nextLine();
                        System.out.println("Ingresa la fecha límite del proyecto");
                        System.out.print("Día: ");
                        int dia = sc.nextInt();
                        System.out.print("Mes: ");
                        int mes = sc.nextInt();
                        System.out.print("Año: ");
                        int anio = sc.nextInt();
                        LocalDate fechaLimiteProyecto = LocalDate.of(anio, mes, dia);
                        entidad.crearProyecto(nombreProyecto, descripcionProyecto, fechaLimiteProyecto);
                        System.out.println("Proyecto creado exitosamente.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }catch (DateTimeException dte) {
                        System.out.println("Ingrese bien la fecha.");
                    } catch (InputMismatchException ime) {
                        System.out.println("Ingrese los datos que se pide.");
                    }
                    break;

                case 2:
                    System.out.println("\n---------Lista de Proyectos----------");
                    System.out.println(entidad.listarProyectos());
                    break;
            }
        }
    }
}
