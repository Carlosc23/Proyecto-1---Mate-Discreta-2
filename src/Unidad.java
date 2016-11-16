import java.util.ArrayList;

/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */
public class Unidad {
    private Point originPoint = new Point();
    private ArrayList<Point> connectedPoints =  new ArrayList <>();
    final int weight = 1;

    /**
     * Agrega a que puntos esta conectado el orignal
     * @param xCoordinate
     * @param yCoordinate
     */
    public void addConnectedPoints (int xCoordinate , int yCoordinate){
        Point connectedPoint = new Point(xCoordinate, yCoordinate);
        connectedPoints.add(connectedPoint);
    }

    public Unidad (int xInical , int yInicial){
        Point newPoint = new Point(xInical,yInicial);

    }
}
