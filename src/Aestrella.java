import java.util.Objects;

import static java.sql.DriverManager.println;

/**
 * Created by DiegoC  on 16/11/2016.
 */
public class Aestrella {


    public  int[] aestrella(WeightedGraph grafo, int s ){

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

    public static void main(String [] args){


        WeightedGraph grafo = new WeightedGraph(15);
        grafo.lasEtiquetas();
        Aestrella algoritmo = new Aestrella();

        System.out.println(grafo.size());

        int[] recuerdos = algoritmo.aestrella(grafo, 0);


        System.out.println();
    }

}
