import java.util.*;

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

        while (i.hasNext()) {
            String linea = i.next();
            ArrayList<Integer> arrayNumeros = new ArrayList<>();
            String[] nums = linea.split(" ");

            for (String n : nums) {
                arrayNumeros.add(Integer.parseInt(n));
            }
            arrayMatriz.add(arrayNumeros);
        }
    }

    // <= Methods =>

    // mostrar
    public void mostrar() {
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();
        while (i.hasNext()) {
            ArrayList<Integer> linea = i.next();
            System.out.println(linea.toString());
        }

    }

    // 2- Eliminar un entero dado
    public void eliminarEntero(int n) {
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            Iterator<Integer> j = arrayInt.iterator();
            while (j.hasNext()) {
                int num = j.next();
                if (num == n) j.remove();
            }
            // if (arrayInt.isEmpty()) i.remove(); // para remover el array si queda esta vacio

        }
    }

    // Eliminar vacios
    public void eliminarVacios() {
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            if (arrayInt.isEmpty()) i.remove(); // para remover el array si queda esta vacio

        }
    }

    // 5- Calcular tamaño de cada arrayList
    public ArrayList<Integer> tamañoDeArrays() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            output.add(arrayInt.size());
        }
        return output;
    }

    // 6- Adicionar Datos [m,n]
    public void adicionarNumero(int arrayInt, int e) throws Exception{
        adicionarNumero(arrayInt, e, -1);
    }

    public void adicionarNumero(int arrayInt, int e, int posIn) throws Exception {
        if (arrayInt <= arrayMatriz.size() && arrayInt > 0) { // no se sale del size
            if (posIn > 0 && posIn <= arrayMatriz.get(arrayInt).size()) {
                arrayMatriz.get(arrayInt - 1).add(posIn, e);
                return;
            }
            arrayMatriz.get(arrayInt - 1).add(e);
        } else {
            throw new Exception("ArrayList inexistente");
        }
    }

    // Adicionar datos (Nuevo array)
    public void nuevoArray(Integer[] datos) {
        ArrayList<Integer> newArray = new ArrayList<Integer>(Arrays.<Integer>asList(datos));
        arrayMatriz.add(newArray);
    }

    // 1- Realizar la suma y el promedio de cada fila (ArrayList)
    public ArrayList<Float> promedioArrays() {
        ArrayList<Float> output = new ArrayList<>();
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            Iterator<Integer> j = arrayInt.iterator();
            float promedio = 0;
            if (!arrayInt.isEmpty()) {
                while (j.hasNext()) {
                    promedio += j.next();
                }
                promedio /= arrayInt.size();
            }
            output.add(promedio);
        }
        return output;
    }


}
