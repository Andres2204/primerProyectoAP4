import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListSimple {
    private ArrayList<String> arraylist;

    public ArrayListSimple(){
        arraylist = new ArrayList<String>();
    }

    public ArrayList<String> getArraylist() {
        return arraylist;
    }

    public void setArraylist(ArrayList<String> arraylist) {
        this.arraylist = arraylist;
    }

    // 1-Llenar el arraylist
    public void llenar(String Nelemento){
        arraylist.add(Nelemento);
    }

    // 2-Adicionar nuevo elemento en posicion n
    public void Adicionar(String Nelemento,int posicion){
        arraylist.add(posicion,Nelemento);
    }

    // 3-Listar el arraylist
    public String listar(){
        Iterator<String> iterator = arraylist.iterator();
        String lista = "";
        while (iterator.hasNext()) {
            lista += iterator.next() + " / ";
        }
        return lista;
    }

    // 5-Borrar elemento especifico 
    public void Belemento(String elemento){
        arraylist.remove(elemento);
    }

    // 4-Borrar elemento en pocision n
    public void BelementoPn(int posicion ){
        arraylist.remove(posicion);
    }

}
