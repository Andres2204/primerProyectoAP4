import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            FileManager archivoPartidos = new FileManager("C:\\Users\\Andre\\IdeaProjects\\primerProyectoAP4\\partidos.txt");
            FileManager archivoNumeros = new FileManager("C:\\Users\\Andre\\IdeaProjects\\primerProyectoAP4\\numeros.txt");

            Partidos partidos = new Partidos(archivoPartidos);
            ArrayList<Partido> res = partidos.goleadas();
            //Partido tempP = new Partido("nacional", "medellin", 0, 5);
            //partidos.adicionarPartido(tempP);
            for(Partido a : res) {
                Partidos.mostrarPartido(a);
            }

            System.out.println("\n------> matriz");
            ArrayMatriz am = new ArrayMatriz(archivoNumeros);
            am.eliminarEntero(0);
            am.adicionarNumero(1,3,8);
            am.nuevoArray(new Integer[] {1,2,3,4,5});
            am.eliminarVacios();
            am.mostrar();

            System.out.println("media: " + am.promedioArrays());
            System.out.println("size: " + am.tamañoDeArrays());





        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}