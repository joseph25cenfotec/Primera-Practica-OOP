import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== DEMOSTRACION DEL SISTEMA BANCARIO ===");

        // --- Administrador (Singleton - Solo uno puede existir) ---
        System.out.println("\n--- Administrador ---");
        Administrador admin = Administrador.crear("Carlos Mora", "1-1111-1111", "admin@banco.com", "Admin#2024");
        System.out.println(admin);

        // Intento de crear un segundo administrador (debe ser rechazado)
        Administrador admin2 = Administrador.crear("Otra Persona", "9-999-9999", "otro@banco.com", "Otro#2024");
        System.out.println("Instancia actual del administrador: " + Administrador.getInstancia());

        // --- Validacion de contrasenia ---
        System.out.println("\n--- Validacion de contrasenia ---");
        System.out.println("'Maria#2024' es valida: " + Usuario.validarContrasenia("Maria#2024"));
        System.out.println("'abc123' es valida: " + Usuario.validarContrasenia("abc123"));

        // --- Cliente ---
        System.out.println("\n--- Cliente ---");
        Cliente cliente = new Cliente("Maria Lopez", "2-2222-2222", "maria@correo.com", "Maria#2024",
                "Femenino", "Ingeniera", "San Jose, Costa Rica");
        System.out.println(cliente);

        // --- CuentaAhorro (creada a traves del cliente) ---
        System.out.println("\n--- CuentaAhorro ---");
        CuentaAhorro ahorro = cliente.crearCuentaAhorro("AH-001", 500.0, 2.0,
                LocalDate.now(), LocalDate.now().plusYears(1));
        System.out.println("Cuenta creada: " + ahorro);

        ahorro.depositar(200);
        System.out.println("Despues de depositar 200: " + ahorro);

        ahorro.pagar(550);
        System.out.println("Intento de pago de 550 (no debe bajar de $100): " + ahorro);

        ahorro.pagar(100);
        System.out.println("Despues de pagar 100: " + ahorro);

        ahorro.generarIntereses();
        System.out.println("Despues de generar intereses: " + ahorro);

        // --- CuentaDebito ---
        System.out.println("\n--- CuentaDebito ---");
        CuentaDebito debito = cliente.crearCuentaDebito("DB-001", 300.0, 1.0,
                LocalDate.now(), LocalDate.now().plusYears(1));
        System.out.println("Cuenta creada: " + debito);

        debito.depositar(150);
        System.out.println("Despues de depositar 150: " + debito);

        debito.pagar(500);
        System.out.println("Intento de pago de 500 (no debe quedar negativo): " + debito);

        debito.pagar(200);
        System.out.println("Despues de pagar 200: " + debito);

        debito.generarIntereses();
        System.out.println("Despues de generar intereses: " + debito);

        // --- CuentaCredito ---
        System.out.println("\n--- CuentaCredito ---");
        CuentaCredito credito = cliente.crearCuentaCredito("CR-001", 1.5,
                LocalDate.now(), LocalDate.now().plusYears(1), 1000.0, "Cashback");
        System.out.println("Cuenta creada (saldo inicial $0): " + credito);

        credito.pagar(300);
        System.out.println("Despues de pagar (usar tarjeta) 300: " + credito);

        credito.pagar(900);
        System.out.println("Intento de pago de 900 (no debe superar limite de credito): " + credito);

        credito.abonar(100);
        System.out.println("Despues de abonar 100: " + credito);

        credito.abonar(500);
        System.out.println("Intento de abono de 500 (no debe superar la deuda actual): " + credito);

        credito.generarIntereses();
        System.out.println("Despues de generar intereses: " + credito);

        // --- Cuenta vencida ---
        System.out.println("\n--- Cuenta vencida ---");
        CuentaAhorro ahorroVencida = cliente.crearCuentaAhorro("AH-002", 200.0, 2.0,
                LocalDate.now().minusYears(2), LocalDate.now().minusDays(1));
        System.out.println("Cuenta creada: " + ahorroVencida);

        ahorroVencida.depositar(50);
        System.out.println("Intento de deposito en cuenta vencida (debe bloquearse): " + ahorroVencida);

        // --- Reporte final del cliente ---
        System.out.println("\n--- Reporte de cuentas del cliente ---");
        cliente.imprimirReporteCuentas();
    }
}