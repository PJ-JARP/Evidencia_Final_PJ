import java.util.UUID;

public class Paciente {

    //creación de variables.
    private String id;
    private String nombrePaciente;

    //constructor
    public Paciente(String id, String nombrePaciente) {
        this.id = UUID.randomUUID().toString();
        this.nombrePaciente = nombrePaciente;

    }

    public Paciente(String nombrePaciente) {
        this.id = UUID.randomUUID().toString(); // Genera un ID si no se pasa uno
        this.nombrePaciente = nombrePaciente;
    }

    public void mostrarInfoPaciente() {
        System.out.println("____________________________________________________________");
        System.out.println("[ ID: " + id + " Nombre del paciente: " + nombrePaciente + " ]");
       // this.nombrePaciente = nombrePaciente;
    }

    //getters y setters.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return "[ Nombre del paciente: " + nombrePaciente + " ]";
    }


}//fin de clase Paciente.
