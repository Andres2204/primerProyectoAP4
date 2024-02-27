import java.util.*;

public class ArrayMatriz {
    FileManager fm = null;
    String noFormated;
    ArrayList<ArrayList<Integer>> arrayMatriz = new ArrayList<>();

    // ================ [ Metodos Constructores ] ================
    public ArrayMatriz(FileManager f) {
        this.fm = f;
        leerYCargar();
    }

    public void leerYCargar() {
        // Leer archivo
        noFormated = fm.readFile();

        // Separar lineas y crear Iterador
        ArrayList<String> lineas = FileManager.linesToArrayList(noFormated);
        Iterator<String> i = lineas.iterator();

        // Iterar y añadir al ArrayList de ArrayList
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

    // ================ [ Metodos de Mostrado ] ================
    public /*void*/String mostrar() { // modificado por antolinez
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();
        String r = "";
        while (i.hasNext()) {
            ArrayList<Integer> linea = i.next();
            r += linea.toString()+ "\n";
        }
        return r;
    }

    // ================ [ Metodos de Eliminacion ] ================
    // 2- Eliminar un entero dado
    public void eliminarEntero(int n) {
        // Crear Iterador
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        // Iterar dos veces, filtrando sobre el ArrayList interno para remover
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
        // Crear Iterador
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        // Iterar, filtrar y remover vacios del ArrayList primario
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            if (arrayInt.isEmpty()) i.remove(); // para remover el array si queda esta vacio
        }
    }


    // ================ [ Metodos de calculo ] ================
    // 5- Calcular tamaño de cada arrayList
    public ArrayList<Integer> tamañoDeArrays() {
        // Crear Iterador y ArrayList de retorno
        ArrayList<Integer> output = new ArrayList<Integer>();
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        // Iterar y adicionar el tamaño del ArraList interno al ArrayList de retorno
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            output.add(arrayInt.size());
        }
        return output;
    }

    // 1- Realizar la suma y el promedio de cada fila (ArrayList)
    public ArrayList<Float> promedioArrays() {
        // Crear Iterador y ArrayList de retorno
        ArrayList<Float> output = new ArrayList<>();
        Iterator<ArrayList<Integer>> i = arrayMatriz.iterator();

        // Iterar en el ArrayList externo y posteriormente el interno, sumando sus elementos
        // y Adicionar al ArrayList de retorno
        while (i.hasNext()) {
            ArrayList<Integer> arrayInt = i.next();
            Iterator<Integer> j = arrayInt.iterator();
            float promedio = 0;
            if (!arrayInt.isEmpty()) {
                while (j.hasNext()) promedio += j.next();
                promedio /= arrayInt.size(); // Reutilizar el la variable de promedio, para dividir entre el tamaño
            }
            output.add(promedio);
        }
        return output;
    }


    // ================ [ Metodos de Adicion ] ================
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
}
