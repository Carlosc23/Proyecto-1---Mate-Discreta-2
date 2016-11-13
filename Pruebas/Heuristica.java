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
     * @param origen Nodo inicial del movimiento
     * @param Futuro Nodo un espacio a la derecha del nodo inicial
     * @return Nodo, entre futuro u origen, en donde es mas barato subir
     */
    public Nodo DondeEsMasBaratoSubir(Nodo origen, Nodo Futuro){
        Nodo Destino1 = new Nodo(origen.getX(), origen.getY()+1);
        Nodo Destino2 = new Nodo(Futuro.getX(), Futuro.getY()+1);

        int heuristica1 = heuristica(origen, Destino1);
        int heuristica2 = heuristica(Futuro, Destino2);

        if (heuristica1 <= heuristica2){
            return origen;
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
     *
     * @param origen El nodo original donde esta ahorita
     * @param futuro El nodo posible si estubiera una posicion arriba
     * @return Nodo en donde sea mas barato la funcion de heuristica
     */
    public Nodo DondeEsMasBaratoCruzar(Nodo origen, Nodo futuro){
        Nodo Destino1 = new Nodo(origen.getX() +1, origen.getY());
        Nodo Destino2 = new Nodo(futuro.getX() +1, futuro.getY());

        int heuristica1 = heuristica(origen, Destino1);
        int heuristica2 = heuristica(futuro, Destino2);

        if (heuristica1 ==  heuristica2){
            return null;
        }
        else if (heuristica2 < heuristica1){
            return futuro;
        }
        else {
            return origen;
        }

    }

    public void agregarNodo(Nodo ultimo){
        recorrido.add(ultimo);
    }

    public ArrayList<Nodo> getRecorrido() {
        return recorrido;
    }

    public void addX(){
        inicial.setX(inicial.getX() +1);
    }

    public void addY(){
        inicial.setY(inicial.getY()+1);
    }

    public Nodo getInicial() {
        return inicial;
    }


}



