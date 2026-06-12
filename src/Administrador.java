public class Administrador extends Usuario {

    private static Administrador instancia = null;

    private Administrador(String nombreCompleto, String cedula, String correoElectronico, String contrasenia) {
        super(nombreCompleto, cedula, correoElectronico, contrasenia);
    }

    public static Administrador crear(String nombreCompleto, String cedula, String correoElectronico, String contrasenia) {
        if (instancia != null) {
            System.out.println("Ya existe un administrador registrado. No se puede crear otro.");
            return null;
        }
        instancia = new Administrador(nombreCompleto, cedula, correoElectronico, contrasenia);
        return instancia;
    }

    public static Administrador getInstancia() {
        return instancia;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                '}';
    }
}