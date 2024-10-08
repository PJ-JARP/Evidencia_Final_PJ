public class Administrador {

    //creación de atributos.
    private String usuario;
    private String password;

    //constructor.
    public Administrador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public boolean inicioSesion(String usuario, String password) {
        return this.usuario.equals(usuario) && this.password.equals(password);
    }

    public void mostrarCredencial (){
        System.out.println("_________________________________");
        System.out.println("[ Usuario: " + this.usuario + " ]");
    }
}//fin de clase administrador.
