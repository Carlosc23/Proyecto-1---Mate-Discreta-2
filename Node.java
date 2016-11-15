import java.util.ArrayList;

/**
 * Created by Julio oon 11/14/2016.
 */

public class Node {
    private String nodeName;
    private ArrayList < String > connectedNodesArrayName  =  new ArrayList <>();
    private ArrayList < Integer > connectedWeightArrayName =  new ArrayList <>();

    public void setNodeName(int height){
        this.nodeName= nodeName;
    }

    public String getNodeName(){
        return nodeName;
    }

    public void agregarNode(String name, int weight){
        connectedNodesArrayName.add(name);
        connectedWeightArrayName.add(weight);
    }

}
