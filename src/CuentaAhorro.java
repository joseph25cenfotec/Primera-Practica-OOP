import java.time.LocalDate;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(String numeroCuenta, double saldo, double porcentajeInteres, LocalDate fechaEmision, LocalDate fechaVencimiento) {
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
        if (getSaldo() - monto < 100) {
            System.out.println("Pago rechazado: el saldo no puede ser menor a $100 en una cuenta de ahorro.");
            return;
        }
        setSaldo(getSaldo() - monto);
    }
}