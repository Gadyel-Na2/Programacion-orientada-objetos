/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Proyecto {
    private static HashMap<String, String> usuarios = new HashMap<>();
    private static HashMap<String, String> roles = new HashMap<>();
    private static ArrayList<String> notificaciones = new ArrayList<>();
    private static HashMap<String, List<String>> equipos = new HashMap<>(); // Estructura para equipos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarse(scanner);
                    break;
                case 2:
                    iniciarSesion(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private static String obtenerFechaHoraActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatoFecha.format(new Date());
    }

    private static void registrarse(Scanner scanner) {
        System.out.println("\n=== Registro ===");
        System.out.print("Ingresa un nombre de usuario: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("El usuario ya existe. Intenta con otro nombre.");
            return;
        }

        System.out.print("Ingresa una contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.println("Selecciona el rol del usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Desarrollador");
        System.out.println("3. Gerente de Proyecto");
        System.out.print("Elige una opción: ");
        int opcionRol = scanner.nextInt();
        scanner.nextLine();

        String rol;
        switch (opcionRol) {
            case 1:
                rol = "Administrador";
                break;
            case 2:
                rol = "Desarrollador";
                break;
            case 3:
                rol = "Gerente de Proyecto";
                break;
            default:
                rol = "Desarrollador"; // Valor por defecto
                break;
        }
        usuarios.put(usuario, contrasena);
        roles.put(usuario, rol);
        System.out.println("Registro exitoso como " + rol + ".");
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.println("\n=== Inicio de Sesión ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        if (!usuarios.containsKey(usuario)) {
            System.out.println("El usuario no existe. Regístrate primero.");
            return;
        }

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.get(usuario).equals(contrasena)) {
            String rol = roles.get(usuario);
            System.out.println("Inicio exitoso como " + rol + ".");
            if (rol.equals("Administrador")) {
                mostrarMenuAdministrador(scanner, usuario);
            } else if (rol.equals("Gerente de Proyecto")) {
                mostrarMenuGerenteProyecto(scanner);
            } else {
                mostrarMenuDesarrollador(scanner);
            }
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }

    private static void mostrarMenuAdministrador(Scanner scanner, String usuario) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú Administrador ===");
            System.out.println("1. Crear proyecto");
            System.out.println("2. Agendar tarea");
            System.out.println("3. Ver notificaciones");
            System.out.println("4. Ver proyectos");
            System.out.println("5. Eliminar proyecto");
            System.out.println("6. Actualizar perfil");
            System.out.println("7. Asignar rol");
            System.out.println("8. Formar equipo"); // Nueva opción para formar equipo
            System.out.println("9. Cerrar sesión");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearProyecto(scanner);
                    break;
                case 2:
                    agendarTarea(scanner);
                    break;
                case 3:
                    verNotificaciones();
                    break;
                case 4:
                    verProyectos(scanner);
                    break;
                case 5:
                    eliminarProyecto(scanner);
                    break;
                case 6:
                    actualizarPerfil(scanner, usuario);
                    break;
                case 7:
                    asignarRol(scanner);
                    break;
                case 8:
                    formarEquipo(scanner); // Llamar al nuevo método para formar equipo
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenuGerenteProyecto(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== Menú Gerente de Proyecto ===");
            System.out.println("1. Ver proyectos");
            System.out.println("2. Agregar tarea a proyecto");
            System.out.println("3. Ver notificaciones");
            System.out.println("4. Formar equipo"); // Nueva opción para formar equipo
            System.out.println("5. Cerrar sesión");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verProyectos(scanner);
                    break;
                case 2:
                    agregarTareaProyecto(scanner);
                    break;
                case 3:
                    verNotificaciones();
                    break;
                case 4:
                    formarEquipo(scanner); // Llamar al nuevo método para formar equipo
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void formarEquipo(Scanner scanner) {
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        if (equipos.containsKey(nombreEquipo)) {
            System.out.println("El equipo ya existe.");
            return;
        }

        List<String> miembros = new ArrayList<>();
        boolean agregarMiembro = true;

        while (agregarMiembro) {
            System.out.print("Ingresa el nombre de usuario del miembro a agregar (o 'fin' para terminar): ");
            String miembro = scanner.nextLine();

            if (miembro.equalsIgnoreCase("fin")) {
                agregarMiembro = false;
            } else if (usuarios.containsKey(miembro)) {
                miembros.add(miembro);
                System.out.println("Miembro agregado: " + miembro);
            } else {
                System.out.println("El usuario no existe.");
            }
        }

        equipos.put(nombreEquipo, miembros);
        notificaciones.add("Equipo formado: " + nombreEquipo + " con miembros: " + miembros + " a las " + obtenerFechaHoraActual());
        System.out.println("Equipo " + nombreEquipo + " formado con éxito.");
    }

    private static void asignarRol(Scanner scanner) {
        System.out.print("Ingresa el nombre del usuario al que deseas asignar un rol: ");
        String usuario = scanner.nextLine();

        if (!usuarios.containsKey(usuario)) {
            System.out.println("El usuario no existe.");
            return;
        }

        System.out.println("Selecciona el nuevo rol:");
        System.out.println("1. Administrador");
        System.out.println("2. Desarrollador");
        System.out.println("3. Gerente de Proyecto");
        System.out.print("Elige una opción: ");
        int opcionRol = scanner.nextInt();
        scanner.nextLine();

        String nuevoRol;
        switch (opcionRol) {
            case 1:
                nuevoRol = "Administrador";
                break;
            case 2:
                nuevoRol = "Desarrollador";
                break;
            case 3:
                nuevoRol = "Gerente de Proyecto";
                break;
            default:
                nuevoRol = "Desarrollador"; // Valor por defecto
                break;
        }
        roles.put(usuario, nuevoRol);
        notificaciones.add("Rol asignado a " + usuario + ": " + nuevoRol + " a las " + obtenerFechaHoraActual());
        System.out.println("Rol asignado a " + usuario + ": " + nuevoRol);
    }

    private static void crearProyecto(Scanner scanner) {
        System.out.print("Nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();
        try {
            File archivo = new File(nombreProyecto + ".txt");
            if (archivo.createNewFile()) {
                System.out.println("Proyecto creado: " + archivo.getName());
                notificaciones.add("Proyecto creado: " + archivo.getName() + " a las " + obtenerFechaHoraActual());
            } else {
                System.out.println("El proyecto ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el proyecto.");
        }
    }

    private static void gestionarProyecto(Scanner scanner) {
        System.out.print("Nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();
        File archivo = new File(nombreProyecto + ".txt");

        if (archivo.exists()) {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n=== Gestión de Proyecto ===");
                System.out.println("1. Ver contenido");
                System.out.println("2. Agregar texto");
                System.out.println("3. Eliminar contenido y sobrescribir");
                System.out.println("4. Guardar y salir");
                System.out.print("Opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        try (Scanner lector = new Scanner(archivo, "UTF-8")) {
                            System.out.println("\nContenido del proyecto:");
                            while (lector.hasNextLine()) {
                                System.out.println(lector.nextLine());
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo.");
                        }
                        break;
                    case 2:
                        System.out.print("Texto a agregar: ");
                        String texto = scanner.nextLine();
                        try (FileWriter escritor = new FileWriter(archivo, true)) {
                            escritor.write(texto + "\n");
                            System.out.println("Texto agregado.");
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo.");
                        }
                        break;
                    case 3:
                        System.out.print("Nuevo contenido: ");
                        String nuevoContenido = scanner.nextLine();
                        try (FileWriter escritor = new FileWriter(archivo, false)) {
                            escritor.write(nuevoContenido + "\n");
                            System.out.println("Contenido sobrescrito.");
                        } catch (IOException e) {
                            System.out.println("Error al sobrescribir el archivo.");
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo de la gestión del proyecto...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            }
        } else {
            System.out.println("El proyecto no existe.");
        }
    }

    private static void agendarTarea(Scanner scanner) {
        System.out.print("Mensaje de la tarea: ");
        String mensajeTarea = scanner.nextLine();
        notificaciones.add("Tarea agendada: " + mensajeTarea + " a las " + obtenerFechaHoraActual());
        System.out.println("Tarea agendada con éxito.");
    }

    private static void verNotificaciones() {
        System.out.println("\n=== Notificaciones ===");
        if (notificaciones.isEmpty()) {
            System.out.println("No hay notificaciones.");
        } else {
            for (String notificacion : notificaciones) {
                System.out.println(notificacion);
            }
        }
    }

    private static void verProyectos(Scanner scanner) {
        System.out.print("Nombre del proyecto a leer: ");
        String nombreProyecto = scanner.nextLine();
        File archivo = new File(nombreProyecto + ".txt");

        if (archivo.exists()) {
            System.out.println("\n=== Contenido del Proyecto ===");
            try (Scanner lector = new Scanner(archivo, "UTF-8")) {
                while (lector.hasNextLine()) {
                    System.out.println(lector.nextLine());
                }
                notificaciones.add("Acceso al proyecto: " + archivo.getName() + " a las " + obtenerFechaHoraActual());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo.");
            }
        } else {
            System.out.println("El proyecto no existe.");
        }
    }

    private static void eliminarProyecto(Scanner scanner) {
        System.out.print("Nombre del proyecto a eliminar: ");
        String nombreProyecto = scanner.nextLine();
        File archivo = new File(nombreProyecto + ".txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Proyecto eliminado: " + archivo.getName());
                notificaciones.add("Proyecto eliminado: " + archivo.getName() + " a las " + obtenerFechaHoraActual());
            } else {
                System.out.println("No se pudo eliminar el proyecto.");
            }
        } else {
            System.out.println("El proyecto no existe.");
        }
    }

    private static void actualizarPerfil(Scanner scanner, String usuario) {
        System.out.print("Nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        usuarios.put(usuario, nuevaContrasena);
        System.out.println("Contraseña actualizada con éxito.");
        notificaciones.add("Contraseña actualizada para " + usuario + " a las " + obtenerFechaHoraActual());
    }

    private static void mostrarMenuDesarrollador(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú Desarrollador ===");
            System.out.println("1. Proyecto");
            System.out.println("2. Ver tareas");
            System.out.println("3. Actualizar perfil");
            System.out.println("4. Cerrar sesión");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarProyecto(scanner);
                    break;
                case 2:
                    verTareas();
                    break;
                case 3:
                    actualizarPerfilDesarrollador(scanner);
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void verTareas() {
        System.out.println("\n=== Tareas ===");
        if (notificaciones.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            for (String notificacion : notificaciones) {
                System.out.println(notificacion);
            }
        }
    }

    private static void actualizarPerfilDesarrollador(Scanner scanner) {
        System.out.print("Nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        // Cambia según el usuario actual
        usuarios.put("Desarrollador", nuevaContrasena);
        System.out.println("Contraseña actualizada con éxito.");
        notificaciones.add("Contraseña actualizada para Desarrollador a las " + obtenerFechaHoraActual());
    }

    private static void agregarTareaProyecto(Scanner scanner) {
        System.out.print("Nombre del proyecto al que deseas agregar una tarea: ");
        String nombreProyecto = scanner.nextLine();
        File archivo = new File(nombreProyecto + ".txt");

        if (archivo.exists()) {
            System.out.print("Descripción de la tarea: ");
            String tarea = scanner.nextLine();
            try (FileWriter escritor = new FileWriter(archivo, true)) {
                escritor.write("Tarea: " + tarea + "\n");
                System.out.println("Tarea agregada al proyecto " + nombreProyecto + ".");
                notificaciones.add("Tarea agregada al proyecto: " + nombreProyecto + " a las " + obtenerFechaHoraActual());
            } catch (IOException e) {
                System.out.println("Error al agregar la tarea al proyecto.");
            }
        } else {
            System.out.println("El proyecto no existe.");
        }
    }
}
