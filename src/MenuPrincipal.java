public class MenuPrincipal extends Menu {

    public MenuPrincipal(String t) {
        super(t);
    }

    @Override
    public void menu() {
        while (true) {
            String opt = input("Seleccione una opción:\n1. Menu 1\n2. Menu 2\n3. Menu 3\n4. Salir");
            if (opt.equals("4")) {
                msg("[!] Saliendo del programa...");
                System.exit(0);
            }
            switch (opt) {
                case "1":
                    msg("llendo el menu 1");
                    MenuArrayListSimple mas = new MenuArrayListSimple("Menu ArrayList Simple");
                    mas.menu();
                    break;

                case "2":
                    msg("llendo el menu 2");
                    break;

                case "3":
                    msg("llendo el menu 3");
                    break;

                default:
                    msg("Opción inválida. Por favor, seleccione otra opción.");
            }
        }
    }
}
