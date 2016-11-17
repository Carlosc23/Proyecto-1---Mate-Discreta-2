import java.util.ArrayList;

import static java.lang.Character.MAX_VALUE;

/**
 * Created by DiegoC on 16/11/2016.
 */
public class astar {
    public ArrayList<Nodo> nodos = new ArrayList();
    public ArrayList<Nodo> queue = new ArrayList();
    public ArrayList<Integer> pesos = new ArrayList<>();
    public int resolucion; /*Debe de ser 1 menos que el tamanio del grafo cuadrado */

    public Nodo inicial;
    public Nodo destino;
    public Nodo fatality;

    public astar(int resolucion, int x, int y) {
        this.resolucion = resolucion-1; /*^^^^^*/
        inicial = new Nodo(x, y);
        destino = new Nodo(resolucion-1 , resolucion-1);
    }

    public void fillTheArray(){
        for(int i = 0; i<resolucion; i++){
            for(int j =0; j<resolucion; j++){
                Nodo temp = new Nodo(i,j);
                nodos.add(temp);
            }
        }
    }

    public Nodo aestrella(){
        int index = inicial.posicion(resolucion);
        fatality = nodos.get(index);
        fatality.setListo(true);


        while(fatality.getX() != destino.getX() && fatality.getY() != destino.getY()){
            vecindad(fatality);
            for (Nodo n: queue){

                pesos.add(n.pesoRecorrido(resolucion));
            }
            int i = MAX_VALUE;
            int indice = 0;
            for(int n: pesos){
                if(n < i){
                    i = n;
                    indice = pesos.indexOf(n);
                }
            }
            fatality = nodos.get(indice);
        }

        return fatality;
    }

    public void vecindad(Nodo n){
        int a = n.vecinoAbajo(resolucion);
        int b = n.vecinoArriba(resolucion);
        int c = n.vecinoDerecha(resolucion);
        int d = n.vecinoIzquierda(resolucion);

        if (a != 0 && !nodos.get(a).isListo() && !nodos.get(a).isProceso()){
            queue.add(nodos.get(a));
            nodos.get(a).setProceso(true);
            nodos.get(a).setRecorrido(n.getRecorrido());
            nodos.get(a).addRecorrido(n);

        }
        if (b != 0 && !nodos.get(b).isListo() && !nodos.get(b).isProceso()){
            queue.add(nodos.get(b));
            nodos.get(b).setProceso(true);
            nodos.get(b).setRecorrido(n.getRecorrido());
            nodos.get(b).addRecorrido(n);
        }
        if (c != 0&& !nodos.get(c).isListo() && !nodos.get(c).isProceso()){
            queue.add(nodos.get(c));
            nodos.get(c).setProceso(true);
            nodos.get(c).setRecorrido(n.getRecorrido());
            nodos.get(c).addRecorrido(n);
        }
        if (d != 0&& !nodos.get(d).isListo() && !nodos.get(d).isProceso()){
            queue.add(nodos.get(d));
            nodos.get(d).setProceso(true);
            nodos.get(d).setRecorrido(n.getRecorrido());
            nodos.get(d).addRecorrido(n);
        }
    }


    public static void main(String [] args){
        astar algoritmo = new astar(15, 0,0);
        algoritmo.fillTheArray();
        Nodo x = algoritmo.aestrella();

        System.out.println(x.getX());
        System.out.println(x.getY());

    }



}
