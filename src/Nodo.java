import java.util.ArrayList;

/**
 * Created by DiegoC on 12/11/2016.
 */
public class Nodo {

    public int x;
    public int y;
    public int peso;
    public boolean listo, proceso, vacio;
    public ArrayList<Nodo> recorrido = new ArrayList<Nodo>();


    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int pesoRecorrido(int resolucionTipoIndex) {
        int regreso = 0;
        for (Nodo n : recorrido) {
            regreso = +n.pesoPropio(resolucionTipoIndex);
            regreso++; /*Se le suma 1 porque cada arista pesa 1, asi que para trasladarse de nodo a nodo, necesita de una arista*/
        }
        regreso += this.pesoPropio(resolucionTipoIndex);
        return regreso;
    }

    public int pesoPropio(int resolucionTipoIndex) {
        int regreso = (resolucionTipoIndex - this.getX()) + (resolucionTipoIndex - this.getY());
        return regreso;
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

    public String label(int resolucion) {
        int numero = y * resolucion + x;
        return "" + numero;
    }

    public int vecinoArriba(int resolucionTipoIndex) {
        int x = this.getX();
        int y = this.getY();

        if (y == resolucionTipoIndex) {
            /*Se devuelve 0 en caso de que el vecino de arriba sea inexistente*/
            return 0;
        }
        else{
            y=+1;
            return (y*resolucionTipoIndex+1) +x;
        }
    }
    public int vecinoAbajo(int resolucionTipoIndex) {
        int x = this.getX();
        int y = this.getY();

        if (y == 0) {
            /*Se devuelve 0 en caso de que el vecino de arriba sea inexistente*/
            return 0;
        }
        else{
            y=-1;
            return (y*resolucionTipoIndex+1) +x;
        }
    }
    public int vecinoDerecha(int resolucionTipoIndex) {
        int x = this.getX();
        int y = this.getY();

        if (x == resolucionTipoIndex) {
            /*Se devuelve 0 en caso de que el vecino de arriba sea inexistente*/
            return 0;
        }
        else{
            x=+1;
            return (y*resolucionTipoIndex+1) +x;
        }
    }
    public int vecinoIzquierda(int resolucionTipoIndex) {
        int x = this.getX();
        int y = this.getY();

        if (x == 0) {
            /*Se devuelve 0 en caso de que el vecino de arriba sea inexistente*/
            return 0;
        }
        else{
            x=-1;
            return (y*resolucionTipoIndex+1) +x;
        }
    }

    public void addRecorrido(Nodo n ){
        recorrido.add(n);
    }

    public int posicion(int resolucionTipoIndex){
        int res = resolucionTipoIndex +1;
        return (this.getY()*res) + this.getX();
    }

    public boolean isListo() {
        return listo;
    }

    public boolean isProceso() {
        return proceso;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public void setProceso(boolean proceso) {
        this.proceso = proceso;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public ArrayList<Nodo> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(ArrayList<Nodo> n ){
        this.recorrido = n;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {

        return peso;
    }

}


