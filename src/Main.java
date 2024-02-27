import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            FileManager archivoPartidos = new FileManager("C:\\Users\\Andre\\IdeaProjects\\primerProyectoAP4\\partidos.txt");
            FileManager archivoNumeros = new FileManager("C:\\Users\\Andre\\IdeaProjects\\primerProyectoAP4\\numeros.txt");

            Partidos p = new Partidos(archivoPartidos);
            p.existeEnArchivo("Betis::Osasuna::1::0");


            MenuPrincipal menuPrincipal = new MenuPrincipal("Menu Principal");
            menuPrincipal.menu();




        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}