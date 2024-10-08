import java.util.UUID;

public class Cita {

    //creación de variables.
    private String idCita;
    private String fechaCita;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    //constructor.
    public Cita(String idCita, String fechaCita, String motivo, Doctor doctor, Paciente paciente){
        this.idCita = UUID.randomUUID().toString();
        this.fechaCita = fechaCita;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }


    //getters y setters.
    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "[ ID de su cita: " + idCita + " Fecha de cita: " + fechaCita + ", Motivo de la cita : "
                + motivo + " con el Doctor " + doctor.toString() + " responsable " + " Nombre del paciente: " + paciente + " ]";
    }//fin to string.
}//Fin de la clase Cita.
