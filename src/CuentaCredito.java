import java.time.LocalDate;

public class CuentaCredito extends Cuenta {

    private double limiteCredito;
    private String tipo;

    public CuentaCredito(String numeroCuenta, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento, double limiteCredito, String tipo) {
        super(numeroCuenta, 0, porcentajeInteres, fechaEmision, fechaVencimiento);
        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void abonar(double monto) {
        if (validarVencimiento()) {
            System.out.println("Transacción bloqueada: la cuenta " + getNumeroCuenta() + " está vencida.");
            return;
        }
        if (monto > getSaldo()) {
            System.out.println("Abono rechazado: el monto supera la deuda actual.");
            return;
        }
        setSaldo(getSaldo() - monto);
    }

    @Override
    public void pagar(double monto) {
        if (validarVencimiento()) {
            System.out.println("Transacción bloqueada: la cuenta " + getNumeroCuenta() + " está vencida.");
            return;
        }
        if (getSaldo() + monto > limiteCredito) {
            System.out.println("Pago rechazado: supera el límite de crédito disponible.");
            return;
        }
        setSaldo(getSaldo() + monto);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", limiteCredito=" + getLimiteCredito() +
                ", tipo='" + getTipo() + '\'';
    }
}