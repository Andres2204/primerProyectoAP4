import java.util.ArrayList;
import java.util.Iterator;

public class Partidos {
    ArrayList<Partido> partidos;
    String noFormated;
    FileManager fm;

    // <= Contructor =>
    public Partidos(FileManager f) {
        this.fm = f;
        leerYCargar();
    }

    public void leerYCargar() {
        noFormated = fm.readFile();
        if (noFormated == null || noFormated == "") return;

        String[] splitedLines = noFormated.split("-");
        partidos = new ArrayList<Partido>();

        for(String sl : splitedLines) {
            String[] d = sl.split("::");
            partidos.add(new Partido(d[0], d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3])));
        }
    }

    // <= Methods =>

    // mostrar
    public void mostrarPartidos() {
        Iterator<Partido> i = partidos.iterator();
        while(i.hasNext()) {
            Partido partido = i.next();
            mostrarPartido(partido);
        }
    }

    public static void mostrarPartido(Partido partido) {
        System.out.println("\n -> Local: " + partido.getEquipoLocal()+" - "+partido.getGolesLocal() + "\n" +
                "Visitante: " + partido.getEquipoVisitante() + " - " + partido.getGolesVisitante());
    }

    // remover
    public ArrayList<Partido> removerEmpates() {
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> empates = new ArrayList<>();
        while(i.hasNext()) {
            Partido p = i.next();
            if (p.getGolesLocal() == p.getGolesVisitante()) {
                i.remove();
                empates.add(p);
            }
        }
        return empates;
    }

    // filtrar
    public ArrayList<Partido> localGanador(Boolean local) {
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> partidosGanados = new ArrayList<>();
        while(i.hasNext()) {
            Partido p = i.next();
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
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> empates = new ArrayList<>();
        while(i.hasNext()) {
            Partido p = i.next();
            if (p.getGolesLocal() == p.getGolesVisitante())
                empates.add(p); // añadir empatados

        }
        return empates;
    }

    public ArrayList<Partido> goleadas() {
        Iterator<Partido> i = partidos.iterator();
        ArrayList<Partido> goleadas = new ArrayList<>();
        while(i.hasNext()) {
            Partido p = i.next();
            int diff = p.getGolesLocal() - p.getGolesVisitante();
            if (diff < 0) diff *= -1;
            if (diff >= 3) goleadas.add(p);
        }
        return goleadas;
    }

    // adicionar
    public void adicionarPartido(Partido p) throws Exception {
        adicionarPartido(p.getEquipoLocal(), p.getEquipoVisitante(), p.getGolesLocal(), p.getGolesVisitante());
    }
    public void adicionarPartido(String nombreLocal, String nombreVisitante, int golesLocal, int golesVisitante) throws Exception {
        //  - validaciones y formateos-
        if (golesLocal > 0) throw new Exception("Goles locales invalidos");
        if (golesVisitante > 0) throw new Exception("Goles visitantes invalidos");
        nombreLocal = nombreLocal.trim();
        nombreVisitante = nombreVisitante.trim();

        // - adicionar -
        String lineaFormateada = nombreLocal+"::"+nombreVisitante+"::"+golesLocal+"::"+golesVisitante;
        partidos.add(new Partido(nombreLocal,nombreVisitante,golesLocal,golesVisitante));
        fm.adicionarLinea(lineaFormateada);
    }


}
