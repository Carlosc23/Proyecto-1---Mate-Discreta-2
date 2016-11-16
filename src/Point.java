/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */

public class Point {
    private String nodeName;
    private int xCoordinate;
    private int yCoordinate;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     *
     * @param yCoord
     * @param xCoord
     */
    public Point(int xCoord , int yCoord) {
        this.nodeName = (Integer.toString(xCoord) + "." + Integer.toString(yCoord));
        this.xCoordinate = xCoord;
        this.yCoordinate = yCoord;
    }

    public Point(){
        nodeName = "" ;
        xCoordinate = 0;
        yCoordinate = 0;
    }
}
