import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Partidos {
    ArrayList<Partido> partidos;
    String noFormated;
    FileManager fm;

    // ================ [ Metodos Constructores ] ================
    public Partidos(FileManager f) {
        this.fm = f;
        leerYCargar();
    }


    public void leerYCargar() {
        // obtener archivo origuinal
        noFormated = fm.readFile();
        if (noFormated == null || noFormated.equals("")) return;

        // partir lineas
        String[] splitedLines = noFormated.split("-");
        partidos = new ArrayList<Partido>();

        // llenar con las lineas existentes.
        for (String sl : splitedLines) {
            String[] d = sl.split("::");
            partidos.add(new Partido(d[0], d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3])));
        }
    }

    // ================ [ Metodos de mostrado ] ================
    public String mostrarPartidos() { // modificado por antolinez
        Iterator<Partido> i = partidos.iterator();
        String r = "";
        while (i.hasNext()) {
            Partido partido = i.next();
            // mostrarPartido(partido);
            r += " -> Local: " + partido.getEquipoLocal() + " - " + partido.getGolesLocal() + "\n" +
            "Visitante: " + partido.getEquipoVisitante() + " - " + partido.getGolesVisitante() + "\n";
        }
        return r;
    }

    public static void mostrarPartido(Partido partido) {
        System.out.println("\n -> Local: " + partido.getEquipoLocal() + " - " + partido.getGolesLocal() + "\n" +
                "Visitante: " + partido.getEquipoVisitante() + " - " + partido.getGolesVisitante());
    }

    public String mostrarPartidos(ArrayList<Partido> array) { // Sobrecarga de metodos
        Iterator<Partido> i = array.iterator();
        String r = "";
        while (i.hasNext()) {
            Partido partido = i.next();
            // mostrarPartido(partido);
            r += " -> Local: " + partido.getEquipoLocal() + " - " + partido.getGolesLocal() + "\n" +
            "Visitante: " + partido.getEquipoVisitante() + " - " + partido.getGolesVisitante() + "\n";
        }
        return r;
    }

    // ================ [ Metodos de Eliminacion ] ================
    public /*ArrayList<Partido>*/ void removerEmpates() { // modificado por antolinez
        // crear Iterador y ArrayList de retorno
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> empates = new ArrayList<>();

        // Iterar, Verificar y remover retornando el ArrayList de los eliminados
        while (i.hasNext()) {
            Partido p = i.next();
            if (p.getGolesLocal() == p.getGolesVisitante()) {
                i.remove();
                empates.add(p);
            }
        }
        //return empates;
        partidos = empates;
    }

    // ================ [ Metodos de Filtrado ] ================
    public ArrayList<Partido> localGanador(Boolean local) {
        // crear iteradores y ArrayList de retorno
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> partidosGanados = new ArrayList<>();

        // Iterar, verificar y añadir al ArrayList de retorno
        while (i.hasNext()) {
            Partido p = i.next();

            // Dependiendo de la flag, va a añadir al ArrayList de retorno los locales o visitantes
            if (local && p.getGolesLocal() > p.getGolesVisitante()) {
                partidosGanados.add(p); // añadir si los locales ganan
            } else if (!local && p.getGolesLocal() < p.getGolesVisitante()) {
                partidosGanados.add(p); // añadir si visitantes ganan
            }
        }
        return partidosGanados;
    }

    // [POSIBLE MEJORA] Este metodo se puede condensar con el de remover empates con una flag y sobrecarga
    public ArrayList<Partido> empates() {
        // crear iteradores y ArrayList de retorno
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> empates = new ArrayList<>();

        // Iterar, verificar y añadir al ArrayList de retorno
        while (i.hasNext()) {
            Partido p = i.next();
            if (p.getGolesLocal() == p.getGolesVisitante())
                empates.add(p); // añadir empatados

        }
        return empates;
    }

    public ArrayList<Partido> goleadas() {
        // crear iteradores y ArrayList de retorno
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> goleadas = new ArrayList<>();

        // Iterar, verificar y añadir al ArrayList de retorno
        while (i.hasNext()) {
            Partido p = i.next();
            int diff = Math.abs(p.getGolesLocal() - p.getGolesVisitante());
            if (diff >= 3) goleadas.add(p);
        }
        return goleadas;
    }

    // ================ [ Metodos de Adicion ] ================
    public void adicionarPartido(Partido p) throws Exception { // sobrecarga de metodos
        adicionarPartido(p.getEquipoLocal(), p.getEquipoVisitante(), p.getGolesLocal(), p.getGolesVisitante());
    }

    public void adicionarPartido(String nombreLocal, String nombreVisitante, int golesLocal, int golesVisitante) throws Exception {
        String lineaFormateada = nombreLocal + "::" + nombreVisitante + "::" + golesLocal + "::" + golesVisitante;

        if (golesLocal > 0) throw new Exception("Goles locales invalidos");
        if (golesVisitante > 0) throw new Exception("Goles visitantes invalidos");
        nombreLocal = nombreLocal.trim();
        nombreVisitante = nombreVisitante.trim();

        // verificar existencia y adicionar
        if (existeEnArchivo(lineaFormateada)) {
            partidos.add(new Partido(nombreLocal, nombreVisitante, golesLocal, golesVisitante));
            fm.adicionarLinea(lineaFormateada);

            // cargar nuevamente
            leerYCargar();
        }
    }

    public boolean existeEnArchivo(String lineaFormateada) {
        // obtener el archivo actual
        noFormated = fm.readFile();
        if (noFormated == null || noFormated.equals("")) return false;

        // verificar la existencia
        String[] splitedLines = noFormated.split("-");
        if (Arrays.stream(splitedLines).toList().contains(lineaFormateada)) return true;
        return false;
    }
}
