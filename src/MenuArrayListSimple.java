public class MenuArrayListSimple extends Menu {

    public MenuArrayListSimple(String t) {
        super(t);
    }

    @Override
    public void menu() {
        ArrayListSimple simple = new ArrayListSimple();
        while (true) {
            String opt = input(
                    "Seleccione una opción:\n1. Ingresar un elemento nuevo\n2. Ingresar un elemento nuevo en una poscicion especifica\n3. Mostrar\n4. Borrar Elemento\n5. Borrar el Elemento de una poscicion especifica\n6. Regresar");
            if (opt == null || opt.equals("6")) {
                msg("Regresando...");
                break;
            }
            switch (opt) {
                case "1":
                    // Lógica para la opción 1
                    simple.llenar(input("Ingrese el elemento"));
                    break;

                case "2":
                    // Lógica para la opción 2
                    try {
                        simple.Adicionar(input("Ingrese el elemento"),
                                Integer.parseInt(input("Ingrese la posicion")) - 1);
                    } catch (Exception e) {
                        // TODO: handle exception
                        msg("Poscicion invalida");
                    }
                    break;

                case "3":
                    // Lógica para la opción 3
                    msg(simple.listar());
                    break;

                case "4":
                    // Lógica para la opción 4
                    try {
                        simple.Belemento(input("Ingrese el elemento"));
                    } catch (Exception e) {
                        // TODO: handle exception
                        msg("No se encuentra este elemento");
                    }

                    break;
                case "5":
                    // Lógica para la opción 5
                    try {
                        simple.BelementoPn(Integer.parseInt(input("Ingrese la poscicion")) - 1);
                    } catch (Exception e) {
                        // TODO: handle exception
                        msg("Poscicion invalida");
                    }
                    break;

                default: {
                    msg("Opción inválida. Por favor, elija otra opción.");
                }
            }
        }
    }
}
