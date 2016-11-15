import java.util.ArrayList;

/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */

public class Node {
    private String nodeName;
    private ArrayList <String> connectedNodesArrayName  =  new ArrayList <>();
    private ArrayList <Integer> connectedWeightArrayName =  new ArrayList <>();

    /**
     *
     * @param height
     */
    public void setNodeName(int height){
        this.nodeName= nodeName;
    }

    /**
     *
     * @return nodeName
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     *
     * @param nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     *
     * @return connectedNodesArrayName
     */
    public ArrayList<String> getConnectedNodesArrayName() {
        return connectedNodesArrayName;
    }

    public void setConnectedNodesArrayName(ArrayList<String> connectedNodesArrayName) {
        this.connectedNodesArrayName = connectedNodesArrayName;
    }

    public ArrayList<Integer> getConnectedWeightArrayName() {
        return connectedWeightArrayName;
    }

    public void setConnectedWeightArrayName(ArrayList<Integer> connectedWeightArrayName) {
        this.connectedWeightArrayName = connectedWeightArrayName;
    }

    public void agregarNode(String name, int weight){
        connectedNodesArrayName.add(name);
        connectedWeightArrayName.add(weight);
    }

}
