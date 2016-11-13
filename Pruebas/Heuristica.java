import java.util.ArrayList;

/**
 * Created by DiegoC on 12/11/2016.
 */
public class Heuristica {

    public ArrayList<Nodo> recorrido  = new ArrayList<>();
    public Nodo inicial = new Nodo(0,0);
    public int resultado;


    public int AristaHorizontal(){
        return 1;
    }

    public int AristaVertical (Nodo origen){
        return origen.getX() + origen.getY();
    }

    /**
     * Heuristica es el metodo que aplica la funcion del grafo a las aristas
     * @param origen Nodo inical de donde sale la arista
     * @param destino Nodo Destino a donde se dirige la arista
     * @return El valor de la funcion de euristica basado en el movimiento tomado
     */
    public int heuristica(Nodo origen, Nodo destino){
        if(destino.getY() - origen.getY() != 0){
            resultado = AristaVertical(origen);

        }
        else if (destino.getX() - origen.getX() != 0){
            resultado = AristaHorizontal();
        }

        return resultado;
    }


    /**
     * DondeEsMasBaratoSubir da indicios de donde sera la funcion de heuristica menor
     * @return Nodo, entre futuro u origen, en donde es mas barato subir
     */
    public Nodo DondeEsMasBaratoSubir(){
        Nodo Futuro = new Nodo(inicial.getX()+1, inicial.getY());
        Nodo Destino1 = new Nodo(inicial.getX(), inicial.getY()+1);
        Nodo Destino2 = new Nodo(Futuro.getX(), Futuro.getY()+1);

        int heuristica1 = heuristica(inicial, Destino1);
        int heuristica2 = heuristica(Futuro, Destino2);

        if (heuristica1 <= heuristica2){
            return inicial;
        }
        else{
            return Futuro;
        }

    }

    /**
     * DondeEsMasBaratoCruzar da indicios de donde sera la funcion de heuristica menor
     * Si en dado caso el valor de cruzar es igual para ambos, devolvera null y entenderemos
     * que dependera unicamente de donde sea mas barato subir
     *
     * @return Nodo en donde sea mas barato la funcion de heuristica
     */
    public Nodo DondeEsMasBaratoCruzar(){

        Nodo futuro = new Nodo(inicial.getX(), inicial.getY() +1);
        Nodo Destino1 = new Nodo(inicial.getX() +1, inicial.getY());
        Nodo Destino2 = new Nodo(futuro.getX() +1, futuro.getY());

        int heuristica1 = heuristica(inicial, Destino1);
        int heuristica2 = heuristica(futuro, Destino2);

        if (heuristica1 ==  heuristica2){
            return null;
        }
        else if (heuristica2 < heuristica1){
            return futuro;
        }
        else {
            return inicial;
        }

    }

    public void agregarNodo(){recorrido.add(inicial);
    }

    public ArrayList<Nodo> getRecorrido() {
        return recorrido;
    }

    public void cruzar(){ inicial.setX(inicial.getX() +1);
    }

    public void subir(){
        inicial.setY(inicial.getY()+1);
    }

    public Nodo getInicial() {
        return inicial;
    }


}



