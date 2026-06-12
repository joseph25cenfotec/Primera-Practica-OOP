import java.time.LocalDate;
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
            String contrasenia,
            String sexo,
            String profesion,
            String direccion) {

        super(nombreCompleto, cedula, correoElectronico, contrasenia);

        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public String getSexo() {
        return sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (!cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
        }
    }

    public CuentaAhorro crearCuentaAhorro(String numeroCuenta, double saldo, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        CuentaAhorro cuenta = new CuentaAhorro(numeroCuenta, saldo, porcentajeInteres, fechaEmision, fechaVencimiento);
        agregarCuenta(cuenta);
        return cuenta;
    }

    public CuentaDebito crearCuentaDebito(String numeroCuenta, double saldo, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        CuentaDebito cuenta = new CuentaDebito(numeroCuenta, saldo, porcentajeInteres, fechaEmision, fechaVencimiento);
        agregarCuenta(cuenta);
        return cuenta;
    }

    public CuentaCredito crearCuentaCredito(String numeroCuenta, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento, double limiteCredito, String tipo) {
        CuentaCredito cuenta = new CuentaCredito(numeroCuenta, porcentajeInteres, fechaEmision, fechaVencimiento, limiteCredito, tipo);
        agregarCuenta(cuenta);
        return cuenta;
    }

    public void imprimirReporteCuentas() {
        double saldoFinal = 0;
        System.out.println("Reporte de cuentas de " + getNombreCompleto() + ":");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
            if (cuenta instanceof CuentaCredito) {
                saldoFinal -= cuenta.getSaldo();
            } else {
                saldoFinal += cuenta.getSaldo();
            }
        }
        System.out.println("Saldo final consolidado: " + saldoFinal);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                ", sexo='" + sexo + '\'' +
                ", profesion='" + profesion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cuentas=" + cuentas.size() +
                '}';
    }

}
