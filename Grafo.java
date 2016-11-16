import java.util.ArrayList;

/**
 * Created by Julio on 11/14/2016.
 */
public class Grafo {
    private int height = 15; // "n"
    private int width = 25;	 // "m"
    private ArrayList< Node > grafoNodos  =  new ArrayList <>();
    private int totalNodos = grafoNodos.size();

    /**
     * agrega todos los nodos al grafo
     * @param
     */
    public void addNodes(){
        // mientras no se haya cubierto todas las columas
        for (int widthCounter = 1; widthCounter<25 ; widthCounter++){
            for(int heightCounter = 1; heightCounter<15 ; heightCounter++){
                if (heightCounter != 1 && heightCounter != 25){
                    Node newNode = new Node();
                    newNode.setNodeName( Integer.toString(heightCounter) + "." + Integer.toString(widthCounter));
                    grafoNodos.add(newNode);
                }

            }
        }
    }
}
