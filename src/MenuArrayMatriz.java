import java.io.IOException;

public class MenuArrayMatriz extends Menu{

    public MenuArrayMatriz(String title) {
        super(title);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void menu() {
        // TODO Auto-generated method stub
        try {
            ArrayMatriz p = new ArrayMatriz(new FileManager("./numeros.txt"));
            while (true) {
                String opt = input(
                        "Seleccione una opción:\n1. Mostrar\n2. Remover un entero\n3. Eliminar Vacios\n4. Tamaño de cada ArrayList\n5. Promedio de cada ArrayList\n6. Adicionar un nuevo dato en un Array existente\n7. Adicionar un nuevo dato en un Array nuevo\n8. Regresar");
                if (opt == null || opt.equals("8")) {
                    msg("Regresando...");
                    System.exit(0);
                }
                switch (opt) {
                    case "1":
                        msg(p.mostrar());
                        break;

                    case "2":
                        p.eliminarEntero(Integer.parseInt(input("Ingrese el entero a eliminar")));
                        break;

                    case "3":
                        p.eliminarVacios();
                        break;

                    case "4":
                        msg(p.tamañoDeArrays().toString());
                        break;

                    case "5":
                        msg(p.promedioArrays().toString());
                        break;

                    case "6":
                        p.adicionarNumero(Integer.parseInt(input("Ingrese a que Array va a pertenecer el nuevo dato")), Integer.parseInt(input("Ingrese el dato nuevo")), Integer.parseInt(input("Ingrese la poscicion del dato nuevo")));
                        break;

                    case "7":
                        Integer[] d = {Integer.parseInt(input("Ingrese el dato nuevo"))};
                        p.nuevoArray(d);
                        break;

                    default:
                        msg("Opción inválida. Por favor, seleccione otra opción.");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
