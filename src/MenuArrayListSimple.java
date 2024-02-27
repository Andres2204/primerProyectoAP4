public class MenuArrayListSimple extends Menu {

    public MenuArrayListSimple(String t) {
        super(t);
    }

    @Override
    public void menu() {
        while (true) {
            String opt = input("Seleccione una opción:\n1. Menu 1\n2. Menu 2\n3. Menu 3\n4. Salir");
            if (opt.equals("0")) {
                msg("Saliendo del programa...");
                break;
            }
            switch (opt) {
                case "1":
                    // Lógica para la opción 1
                    msg("Seleccionaste la opción 1");
                    break;

                case "2":
                    // Lógica para la opción 2
                    msg("Seleccionaste la opción 2");
                    break;


                default: {
                    msg("Opción inválida. Por favor, elija otra opción.");
                }
            }
        }
    }
}
