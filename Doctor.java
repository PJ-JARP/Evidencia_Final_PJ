import java.util.UUID;

public class Doctor {

    //delcaración de variables.
    private String idDoctor;
    private String nombreDoctor;
    private String especialidad;

    public Doctor(String id, String nombre, String especialidad) {
        this.idDoctor = UUID.randomUUID().toString();
        this.nombreDoctor = nombre;
        this.especialidad = especialidad;
    }

    //creacion de constructor dr.
    public Doctor(String nombre, String especialidad) {
        this.idDoctor = UUID.randomUUID().toString(); // Genera un ID si no se pasa uno
        this.nombreDoctor = nombre;
        this.especialidad = especialidad;
    }

    //metodo para mostrar la información.
    public void mostrarInfoDoctor() {
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("[ ID del doctor: " + idDoctor + " | Nombre del doctor: " + nombreDoctor + " | Especialidad: " + especialidad + " ]");
    }

    //getters y setters.
    public String getId() {
        return idDoctor;
    }

    public void setId(String id) {
        this.idDoctor = id;
    }

    public String getNombre() {
        return nombreDoctor;
    }

    public void setNombre(String nombre) {
        this.nombreDoctor = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "[ Nombre del doctor: " + nombreDoctor + " Especialidad: " + especialidad + " ]";
    }

}//fin de la clase Doctor.
