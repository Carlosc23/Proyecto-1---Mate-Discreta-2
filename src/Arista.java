/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */

public class Arista implements Comparable<Arista> {

    private Vertice one, two;
    private int weight;

    /**
     *
     * @param one
     * @param two
     * @param weight
     */
    public Arista(Vertice one, Vertice two, int weight){
        this.one = (one.getNombre().compareTo(two.getNombre()) <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }


    /**
     *
     * @param current
     * @return conexion of current along this Edge
     */
    public Vertice getConexion(Vertice current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }

        return (current.equals(one)) ? two : one;
    }

    /**
     *
     * @return Vertex this.one
     */
    public Vertice getOne(){
        return this.one;
    }

    /**
     *
     * @return Vertex this.two
     */
    public Vertice getTwo(){
        return this.two;
    }


    /**
     *
     * @return int The weight of this Edge
     */
    public int getWeight(){
        return this.weight;
    }


    /**
     *
     * @param weight The new weight of this Edge
     */
    public void setWeight(int weight){
        this.weight = weight;
    }


    /**
     *
     * @param other The Edge to compare against this
     * @return int this.weight - other.weight
     */
    public int compareTo(Arista other){
        return this.weight - other.weight;
    }

    /**
     *
     * @return String
     */
    public String toString(){
        return "Nodo inicial: " + one + ", Nodo final: " + two + ", peso: " + weight);
    }

    /**
     *
     * @return int
     */
    public int hashCode(){
        return (one.getNombre() + two.getNombre()).hashCode();
    }

    /**
     *
     * @param other The Object to compare against this
     * @return ture iff other is an Edge with the same Vertices as this
     */
    public boolean equals(Object other){
        if(!(other instanceof Arista)){
            return false;
        }

        Arista e = (Arista)other;

        return e.one.equals(this.one) && e.two.equals(this.two);
    }

    /**
     *
     * @param one
     * @param two
     */
    public Arista(Vertice one, Vertice two){
        this(one, two, 1);
    }
}

