import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayMatriz {
    FileManager fm = null;
    String noFormated;
    ArrayList<ArrayList<Integer>> arrayMatriz = new ArrayList<>();

    public ArrayMatriz(FileManager f) {
        this.fm = f;
        leerYCargar();
    }

    public void leerYCargar() {
        noFormated = fm.readFile();
        ArrayList<String> lineas = FileManager.linesToArrayList(noFormated);
        Iterator<String> i = lineas.iterator();

        while(i.hasNext()) {
            String linea = i.next();
            ArrayList<Integer> arrayNumeros = new ArrayList<>();
            String[] nums = linea.split(" ");

            for (String n : nums)   {
                arrayNumeros.add(Integer.parseInt(n));
            }
            arrayMatriz.add(arrayNumeros);
        }
    }

    // <= Methods =>

    // mostrar
    public void mostrar() {
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        while(i.hasNext()) {
            ArrayList<Integer> linea = i.next();
            System.out.println(linea.toString());
        }

    }

}
