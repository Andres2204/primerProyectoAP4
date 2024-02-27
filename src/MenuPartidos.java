import java.io.IOException;

public class MenuPartidos extends Menu {

    public MenuPartidos(String title) {
        super(title);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub
        try {
            Partidos p = new Partidos(new FileManager("./partidos.txt"));
            while (true) {
                String opt = input(
                        "Seleccione una opción:\n1. Mostrar\n2. Remover empates\n3. Partidos ganados por locales\n4. Partidos ganados por visitantes\n5. Empates\n6. Goleadas\n7. Agregar Partidos\n8. Regresar");
                if (opt == null || opt.equals("8")) {
                    msg("Regresando...");
                    break;
                }
                switch (opt) {
                    case "1":
                        msgScroll(p.mostrarPartidos());
                        break;

                    case "2":
                        p.removerEmpates();
                        break;

                    case "3":
                        msgScroll(p.mostrarPartidos(p.localGanador(true)));
                        break;

                    case "4":
                        msgScroll(p.mostrarPartidos(p.localGanador(false)));
                        break;

                    case "5":
                        msgScroll(p.mostrarPartidos(p.empates()));
                        break;

                    case "6":
                        msgScroll(p.mostrarPartidos(p.goleadas()));
                        break;

                    case "7":
                        p.adicionarPartido(input("Ingrese el nombre del equipo local"),
                                input("Ingrese el nombre del equipo visitante"),
                                Integer.parseInt(input("Ingrese el numero de goles del equipo local")),
                                Integer.parseInt(input("Ingrese el numero de goles del equipo visitante")));
                        break;

                    default:
                        msg("Opción inválida. Por favor, seleccione otra opción.");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
