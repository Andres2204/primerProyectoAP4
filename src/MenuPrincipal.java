public class MenuPrincipal extends Menu {

    public MenuPrincipal(String t) {
        super(t);
    }

    @Override
    public void menu() {
        while (true) {
            String opt = input("Seleccione una opción:\n1. Menu ArrayList Simple\n2. Menu ArrayList Objeto\n3. Menu ArrayList ArrayList\n4. Salir");
            if (opt == null || opt.equals("4")) {
                msg("[!] Saliendo del programa...");
                System.exit(0);
            }
            switch (opt) {
                case "1":
                    msg("llendo el menu de ArrayList Simple");
                    MenuArrayListSimple mas = new MenuArrayListSimple("Menu ArrayList Simple");
                    mas.menu();
                    break;

                case "2":
                    msg("llendo el menu de ArrayList Objeto");
                    MenuPartidos menos = new MenuPartidos("Menu Partidos");
                    menos.menu();
                    break;

                case "3":
                    msg("llendo el menu ArrayList ArrayList");
                    MenuArrayMatriz mul = new MenuArrayMatriz("Menu ArrayList ArrayList");
                    mul.menu();
                    break;

                default:
                    msg("Opción inválida. Por favor, seleccione otra opción.");
            }
        }
    }
}
