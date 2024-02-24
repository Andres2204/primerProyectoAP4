import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    File f;
    public FileManager(String path) throws IOException {
        f = new File(path);
    }
    public String readFile() {
        Scanner s = null;
        String output = "";
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                output += linea + "-";
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (s != null) s.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return output;
    }

    public static ArrayList<String> linesToArrayList(String noFormated) {
        String[] lineas = noFormated.split("-");
        ArrayList<String> output = new ArrayList<>();
        for (String l : lineas) {
            output.add(l);
        }
        return output;
    }

    public void adicionarLinea(String linea) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(f.getAbsoluteFile(), true);
            fw.write(linea);
        } catch (IOException e) {
            System.out.println("E");
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) fw.close();
                System.out.println("pass");
            } catch (IOException e2) {
                System.out.println("E2");
                e2.printStackTrace();
            }
        }
    }
}
