import java.util.ArrayList;

public class Cliente extends Usuario {

    private String sexo;
    private String profesion;
    private String direccion;
    private ArrayList<Cuenta> cuentas;

    public Cliente(
            String nombreCompleto,
            String cedula,
            String correoElectronico,
            String password,
            String sexo,
            String profesion,
            String direccion) {

        super(nombreCompleto, cedula, correoElectronico, password);

        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (!cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
        }
    }
}
