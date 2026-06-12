import java.time.LocalDate;

public class CuentaDebito extends Cuenta {

    public CuentaDebito(String numeroCuenta, double saldo, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        super(numeroCuenta, saldo, porcentajeInteres, fechaEmision, fechaVencimiento);
    }

    public void depositar(double monto) {
        if (validarVencimiento()) {
            System.out.println("Transacción bloqueada: la cuenta " + getNumeroCuenta() + " está vencida.");
            return;
        }
        setSaldo(getSaldo() + monto);
    }

    @Override
    public void pagar(double monto) {
        if (validarVencimiento()) {
            System.out.println("Transacción bloqueada: la cuenta " + getNumeroCuenta() + " está vencida.");
            return;
        }
        if (getSaldo() - monto < 0) {
            System.out.println("Pago rechazado: el monto supera la cantidad de dinero en la cuenta.");
            return;
        }
        setSaldo(getSaldo() - monto);
    }
}