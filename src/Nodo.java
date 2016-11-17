/**
 * Created by DiegoC on 12/11/2016.
 */
public class Nodo {

    public int x;
    public int y;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String label(int resolucion){
        int numero = y*resolucion + x;
        return ""+numero;
    }


}
