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

    public void addConnections(String name, int weight){
        connectedNodesArrayName.add(name);
        connectedWeightArrayName.add(weight);
    }

}
