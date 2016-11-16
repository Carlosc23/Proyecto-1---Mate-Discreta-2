import java.util.Objects;

/**
 * Created by DiegoC on 15/11/2016.
 */
public class WeightedGraph {
    private int [][] aristas;
    private Object[] etiquetas;

    public WeightedGraph(int n ){
        aristas = new int [n][n];
        etiquetas = new Object[n];
    }

    public int size() {return etiquetas.length; }

    public void setEtiquetas (int nodo, Object etiqueta){
        etiquetas[nodo] = etiqueta;
    }
    public Object getEtiqueta(int nodo) {
        return etiquetas[nodo];
    }

    public void addArtista(int origen, int objetivo, int peso){
        aristas[origen][objetivo] = peso;
    }

    public boolean esArista(int origen, int objetivo){
        return aristas[origen][objetivo] >0;
    }

    public void removerArista(int origen, int objetivo){
        aristas[origen][objetivo] = 0;
    }

    public int getPeso(int origen, int destino){
        return aristas[origen][destino];
    }

    public int [] vecinos (int nodo){
        int contador = 0;
        for (int i = 0; i < aristas[nodo].length; i++){
            contador++;
        }
        final int[] resultado = new int[contador];
        contador = 0;
        for(int i = 0; i<aristas[nodo].length; i++){
            if(aristas[nodo][i] > 0){
                resultado[contador++] = i;
            }
        }return resultado;
    }

    public void print(){
        for(int j = 0; j<aristas.length; j++){
            System.out.println(etiquetas[j]+": ");
            for(int i =0; i<aristas[i].length; i++){
                if(aristas[j][i]>0){
                    System.out.println (etiquetas[i]+":"+aristas[j][i]+" ");
                }
            }
        }
    }
}
