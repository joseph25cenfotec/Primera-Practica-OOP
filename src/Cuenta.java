import java.time.LocalDate;

public abstract class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private double porcentajeInteres;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;

    public Cuenta(String numeroCuenta, double saldo, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.porcentajeInteres = porcentajeInteres;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cuenta cuenta = (Cuenta) object;
        return numeroCuenta.equals(cuenta.numeroCuenta);
    }

    public boolean validarVencimiento() {
        return fechaVencimiento.isBefore(LocalDate.now()) || fechaVencimiento.isEqual(LocalDate.now());
    }

    public void generarIntereses() {
        saldo += saldo * (porcentajeInteres / 100);
    }

    public void pagar(double monto) {
        if (validarVencimiento()) {
            System.out.println("Transacción bloqueada: la cuenta " + numeroCuenta + " está vencida.");
            return;
        }
        saldo -= monto;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", porcentajeInteres=" + porcentajeInteres +
                ", fechaEmision=" + fechaEmision +
                ", fechaVencimiento=" + fechaVencimiento +
                ", estado=" + (validarVencimiento() ? "VENCIDA" : "VIGENTE") +
                '}';
    }

}
