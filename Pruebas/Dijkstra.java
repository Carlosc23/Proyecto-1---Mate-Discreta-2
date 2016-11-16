import java.util.ArrayList;
/**
 * Created by DiegoC on 15/11/2016.
 */
public class Dijkstra {
    public ArrayList camino = new ArrayList();

    public  int[] dijkstra(WeightedGraph grafo, int s ){
        final int [] distancias = new int[grafo.size()];
        final int [] anteriores = new int[grafo.size()];
        final boolean [] visitado = new boolean[grafo.size()];

        for(int i=0; i<distancias.length; i++ ){
            distancias[i] = Integer.MAX_VALUE;

        }
        distancias[s] = 0;

        for(int i=0; i<distancias.length; i++){
            final int siguiente = nodoMinimo(distancias, visitado);
            visitado[siguiente] = true;

            /*Entonces, el camino mas corto es distancias[siguiente] via anteriores[siguiente]*/

            final int [] n = grafo.vecinos(siguiente);
            for(int j = 0; j<n.length; j++){
                final int v = n[j];
                final int d = distancias[siguiente] + grafo.getPeso(siguiente, v);
                if(distancias[v] > d){
                    distancias[v] = d;
                    anteriores[v] = siguiente;
                }
            }
            for (int elemento : anteriores) {
                camino.add(elemento);
            }
        }
        return anteriores;

    }

    public static int nodoMinimo(int[] distancias, boolean[] visitado){
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i =0; i<distancias.length; i++){
            if(!visitado[i] && distancias[i]<x){
                y =i;
                x = distancias[i];
            }
        }return y;
    }

   public ArrayList getCamino(){
       return camino;
   }

}
