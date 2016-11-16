import java.util.ArrayList;

/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */
public class Grafo {
    private ArrayList <Unidad> grafo = new ArrayList<>();

    /**
     * Llena la lista de los nodos y sus conexiones
     */
    public void addNodes(){
        //esquina 0.0
        Unidad esquina0 = new Unidad(0,0);
        esquina0.addConnectedPoints(1,0);
        esquina0.addConnectedPoints(0,1);
        grafo.add(esquina0);

        //esquina 15.0
        Unidad esquina1 = new Unidad(15,0);
        esquina1.addConnectedPoints(14,0);
        esquina1.addConnectedPoints(15,1);
        grafo.add(esquina1);

        // esquina 0.15
        Unidad esquina2 = new Unidad(0,15);
        esquina2.addConnectedPoints(0,14);
        esquina2.addConnectedPoints(15,0);
        grafo.add(esquina2);

        //esquina 15.15
        Unidad esquina3 = new Unidad(15,15);
        esquina3.addConnectedPoints(14,15);
        esquina3.addConnectedPoints(15,14);
        grafo.add(esquina3);

        //parte central
        for (int X = 1 ; X < 14 ; X++){
            for (int Y = 1 ; Y < 14 ; Y++){
                Unidad ID = new Unidad (X,Y);
                ID.addConnectedPoints((X-1),(Y));
                ID.addConnectedPoints((X+1),(Y));
                ID.addConnectedPoints((X),(Y-1));
                ID.addConnectedPoints((X),(Y+1));
            }

        }

        // columna izqueirda
        for (int i = 1 ; i < 14 ; i++ ){
            Unidad ID = new Unidad (0,i);
            ID.addConnectedPoints((0),(i-1));
            ID.addConnectedPoints((0),(i+1));
            ID.addConnectedPoints((1),(i));
        }

        // columna derecha
        for (int i = 1 ; i < 14 ; i++ ){
            Unidad ID = new Unidad (15,i);
            ID.addConnectedPoints((15),(i-1));
            ID.addConnectedPoints((15),(i+1));
            ID.addConnectedPoints((14),(i));
        }

        //fila arriba
        for (int i = 1 ; i < 14 ; i++ ){
            Unidad ID = new Unidad (i,0);
            ID.addConnectedPoints((i-1),(0));
            ID.addConnectedPoints((i+1),(0));
            ID.addConnectedPoints((i),(1));
        }

        //fila abajo
        for (int i = 1 ; i < 14 ; i++ ){
            Unidad ID = new Unidad (i,15);
            ID.addConnectedPoints((i+1),(15));
            ID.addConnectedPoints((i-1),(15));
            ID.addConnectedPoints((i),(14));
        }
    }
}