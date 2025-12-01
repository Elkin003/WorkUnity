package unl.edu.cc.workunity.view;

import unl.edu.cc.workunity.domain.Entidad;
import unl.edu.cc.workunity.domain.Integrante;
import unl.edu.cc.workunity.domain.Proyecto;
import unl.edu.cc.workunity.domain.Tarea;
import unl.edu.cc.workunity.exceptions.UnauthorizedAccessException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FuncionalidadCrearProyectoYTarea {
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
                        System.out.println("\nIngresa el nombre del proyecto:");
                        String nombreProyecto = sc.nextLine();
                        System.out.println("Ingresa la descripción del proyecto:");
                        String descripcionProyecto = sc.nextLine();
                        System.out.println("Ingresa la fecha límite del proyecto:");
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
                    } catch (DateTimeException dte) {
                        System.out.println("Ingrese bien la fecha.");
                    } catch (InputMismatchException ime) {
                        System.out.println("Ingrese los datos que se pide.");
                    }
                    break;

                case 2:
                    int contador = 1;
                    List<Proyecto> proyectos = entidad.listarProyectos();
                    System.out.println("\n---------Lista de Proyectos----------");
                    if (proyectos.isEmpty()) {
                        System.out.println("Debe crear un proyecto primero.");
                        break;
                    }
                    for (Proyecto proyecto : proyectos) {
                        System.out.println("\n" + contador + ". Nombre: " + proyecto.getNombre());
                        System.out.println("Descripción: " + proyecto.getDescripcion());
                        System.out.println("Fecha Límite: " + proyecto.getFechaLimite());
                        contador++;
                    }
                    int seleccion;
                    try {
                        System.out.println("\nElige un proyecto para gestionar(Número) o pulse otro tecla para retroceder:");
                        seleccion = sc.nextInt();
                    } catch (InputMismatchException ime) {
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();

                    if (seleccion <= 0 || seleccion > proyectos.size()) {
                        break;
                    }
                    Proyecto proyectoSeleccionado = proyectos.get(seleccion - 1);

                    Integrante integranteProyecto = null;
                    for (Integrante integrante : proyectoSeleccionado.getMiembros()) {
                        if (integrante.getEntidad().getNombre().equals(entidad.getNombre())) {
                            integranteProyecto = integrante;
                            break;
                        }
                    }

                    int opcionProyecto = 0;
                    while (opcionProyecto != 3) {
                        try {
                            System.out.println("\n----Gestionar Proyecto " + proyectoSeleccionado.getNombre() + "----");
                            System.out.println("1. Crear Tarea");
                            System.out.println("2. Listar Tareas");
                            System.out.println("3. Retroceder");
                            opcionProyecto = sc.nextInt();
                        } catch (InputMismatchException ime) {
                            System.out.println("Ingrese las opciones del programa.");
                            sc.nextLine();
                        }
                        sc.nextLine();

                        switch (opcionProyecto) {
                            case 1:
                                try {
                                    System.out.println("\nIngresa el título de la tarea:");
                                    String tituloTarea = sc.nextLine();
                                    System.out.println("Ingresa la descripción de la tarea:");
                                    String descripcionTarea = sc.nextLine();
                                    System.out.println("Ingresa la fecha límite de la tarea:");
                                    System.out.print("Día: ");
                                    int dia = sc.nextInt();
                                    System.out.print("Mes: ");
                                    int mes = sc.nextInt();
                                    System.out.print("Año: ");
                                    int anio = sc.nextInt();
                                    LocalDate fechaLimiteTarea = LocalDate.of(anio, mes, dia);
                                    integranteProyecto.crearTarea(tituloTarea, descripcionTarea, fechaLimiteTarea);
                                    System.out.println("Tarea creada exitosamente.");
                                } catch (UnauthorizedAccessException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                } catch (DateTimeException dte) {
                                    System.out.println("Ingrese bien la fecha.");
                                } catch (InputMismatchException ime) {
                                    System.out.println("Ingrese los datos que se pide.");
                                }
                                break;

                            case 2:
                                List<Tarea> tareas = proyectoSeleccionado.getTareas();
                                System.out.println("\n---------Lista de Tareas----------");
                                if (tareas.isEmpty()) {
                                    System.out.println("Debe crear una tarea primero.");
                                    break;
                                }

                                int tareaContador = 1;
                                for (Tarea tarea : tareas) {
                                    System.out.println("\n" + tareaContador + ". Título: " + tarea.getTitulo());
                                    System.out.println("Descripción: " + tarea.getDescripcion());
                                    System.out.println("Estado: " + tarea.getEstado());
                                    System.out.println("Fecha Límite: " + tarea.getFechaLimite());
                                    System.out.println("Miembro Asignado: " + tarea.getIntegranteAsignado());
                                    tareaContador++;
                                }
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
