import java.util.ArrayList;

/**
 * Created by Julio on 11/14/2016.
 */
public class Grafo {
    private int height = 15; // "n"
    private int width = 25;	 // "m"
    Node nodeCreated = new Node();
    private ArrayList< Node > grafoNodos  =  new ArrayList <>();
    private int totalNodos = grafoNodos.size();

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addNodes(){
        grafoNodos.add(nodeCreated);

    }

}
