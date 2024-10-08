import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SistemaCitas {

    //creación de listas.
    private List<Doctor> listaDoctores;
    private List<Paciente> listaPacientes;
    private List<Cita> listaCitas;
    private Administrador admin;

    public SistemaCitas() {
        listaDoctores = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaCitas = new ArrayList<>();
        admin = new Administrador("admin", "System32"); // Credenciales de acceso
    }

    public static void main(String[] args) {
        SistemaCitas sistema = new SistemaCitas();
        sistema.iniciarSistema();
    }

    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);

        // Validar acceso del administrador
        if (!validarAdministrador(scanner)) {
            System.out.println("\n X Acceso denegado.");
            return; // Si las credenciales son incorrectas Salir del programa.
        }

        // Menú de interacción con métodos.
        int opcion;
        do {
            System.out.println("\n**** MENÚ **** ");
            System.out.println("[ 1. Dar de alta doctor   ]");
            System.out.println("[ 2. Dar de alta paciente ]");
            System.out.println("[ 3. Crear cita           ]");
            System.out.println("[ 0. Salir                ]");
            System.out.print("[ Seleccione una opción = ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del doctor: ");
                    String nombreDoctor = scanner.nextLine();
                    System.out.print("Ingrese la especialidad del doctor: ");
                    String especialidadDoctor = scanner.nextLine();
                    altaDoctor(nombreDoctor, especialidadDoctor);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    altaPaciente(nombrePaciente);
                    break;

                case 3:
                    System.out.print("Ingrese la fecha de la cita con el formato DÍA / MÉS / AÑO: ");
                    String fechaCita = scanner.nextLine();
                    System.out.print("Ingrese el motivo de la cita: ");
                    String motivoCita = scanner.nextLine();
                    crearCita(fechaCita, motivoCita);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0); // con esta opción terminamos el bucle cuando el usuario quiera.
    }

    // Método para validar administrador
    private boolean validarAdministrador(Scanner scanner) {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        return admin.inicioSesion(usuario, password);
    }

    // Método para dar de alta doctor
    public void altaDoctor(String nombreDoctor, String especialidad) {
        Doctor doctor = new Doctor(nombreDoctor, especialidad);
        listaDoctores.add(doctor);
        doctor.mostrarInfoDoctor();
    }

    // Método para dar de alta paciente
    public void altaPaciente(String nombrePaciente) {
        Paciente paciente = new Paciente(nombrePaciente);
        listaPacientes.add(paciente);
        paciente.mostrarInfoPaciente();
    }

    // Método para crear cita
    public void crearCita(String fechaCita, String motivo) {
        Scanner scn = new Scanner(System.in);

        System.out.println("\n____________________________________");
        System.out.println("[ Por favor, seleccione un doctor: ]");
        for (int i = 0; i < listaDoctores.size(); i++) {
            Doctor doctor = listaDoctores.get(i);
            System.out.println(i + ". " + doctor.getNombre()); // Mostrar el nombre correctamente
        }
        int indiceDoctor = scn.nextInt();
        Doctor doctorSeleccionado = listaDoctores.get(indiceDoctor);

        System.out.println("\n____________________________________");
        System.out.println("[ Seleccione un paciente: ] ");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println(i + ". " + listaPacientes.get(i).getNombrePaciente()); // Mostrar el nombre del paciente correctamente
        }
        int indicePaciente = scn.nextInt();
        Paciente pacienteSeleccionado = listaPacientes.get(indicePaciente);

        Cita nuevaCita = new Cita(UUID.randomUUID().toString(), fechaCita, motivo, doctorSeleccionado, pacienteSeleccionado);
        listaCitas.add(nuevaCita);
        System.out.println("\n* CITA CREADA CON ÉXITO  *");
        try {
            guardarCita(nuevaCita);
            System.out.println(" \n ****Cita guardada en el archivo de texto****");
        } catch (IOException e) {
            System.err.println(" \n XXXX-Error al guardar la cita-XXXX " + e.getMessage());
        }
    }

    //guaradr información en archivo de texto plano.
    public void guardarCita(Cita cita) throws IOException {
        String csvFile = "CitasMédicas.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile, true))) {
            writer.printf("[ ID: %s | Fecha de la cita: %s | Motivo de la cita: %s | Nombre del doctor: %s | Especialidad del doctor: %s | Nombre del Paciente: %s%n ]",
                    cita.getIdCita(),
                    cita.getFechaCita(),
                    cita.getMotivo(),
                    cita.getDoctor().getNombre(),
                    cita.getDoctor().getEspecialidad(),
                    cita.getPaciente().getNombrePaciente());
        } catch (IOException e) {
            System.err.println(" XXXXXX-Error al guardar la cita en el archivo-XXXXXX " + e.getMessage());
        }
    }

}//fin de clase sistema Cita

