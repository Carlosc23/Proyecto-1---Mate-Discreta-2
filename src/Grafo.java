import java.util.ArrayList;

/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */
public class Grafo {
    private ArrayList <Unidad> grafoLista = new ArrayList<>();

    /**
     * Llena la lista de los nodos y sus conexiones
     */
    public void addNodes(){

        for (int X = 0 ; X < 15 ; X++){
            for (int Y = 0 ; Y < 15 ; Y++){

                if ( X == 0 && Y == 0) {
                    // esquina superior izquierda
                    Unidad esquinaSI = new Unidad(X, Y);
                    esquinaSI.addConnectedPoints((X+1), Y);
                    esquinaSI.addConnectedPoints(X, (Y+1));
                    grafoLista.add(esquinaSI);
                }
                else if ( X == 15 && Y == 0){
                    // esquina superior derecha
                    Unidad esquinaSD = new Unidad(X,Y);
                    esquinaSD.addConnectedPoints((X-1),Y);
                    esquinaSD.addConnectedPoints(X,(Y+1));
                    grafoLista.add(esquinaSD);
                }
                else if ( X == 0 && Y == 15){
                    // esquina inferior derecha
                    Unidad esquinaID = new Unidad(X,Y);
                    esquinaID.addConnectedPoints(X,(Y-1));
                    esquinaID.addConnectedPoints((X+1),Y);
                    grafoLista.add(esquinaID);
                }
                else if (X == 15 && Y == 15){
                    // esquina inferior izquierda
                    Unidad esquinaII = new Unidad(X,Y);
                    esquinaII.addConnectedPoints((X-1),Y);
                    esquinaII.addConnectedPoints(X,(Y-1));
                    grafoLista.add(esquinaII);
                }

                else if ( X == 0 && Y > 0 && Y < 15){
                    // columna izquierda
                    Unidad colI = new Unidad (X,Y);
                    colI.addConnectedPoints((X),(Y-1));
                    colI.addConnectedPoints((X),(Y+1));
                    colI.addConnectedPoints((X+1),(Y));
                    grafoLista.add(colI);
                }

                else if ( X == 15 && Y > 0 && Y < 15){
                    // colmuna derecha
                    Unidad colD = new Unidad (X,Y);
                    colD.addConnectedPoints((X),(Y-1));
                    colD.addConnectedPoints((X),(Y+1));
                    colD.addConnectedPoints((X-1),(Y));
                    grafoLista.add(colD);
                }

                else if ( Y == 0 && X < 15 && X > 0){
                    //fila superior
                    Unidad filS = new Unidad (X,0);
                    filS.addConnectedPoints((i-1),(0));
                    filS.addConnectedPoints((i+1),(0));
                    filS.addConnectedPoints((i),(1));
                    grafoLista.add(filS);
                }

                else if ( Y == 15 && X < 15 && X > 0){
                    // fila inferior
                }

                else {
                    //interior
                }
            }
        }

        //fila arriba
        for (int i = 1 ; i < 14 ; i++ ){

        }

        //fila abajo
        for (int i = 1 ; i < 14 ; i++ ){
            Unidad ID = new Unidad (i,15);
            ID.addConnectedPoints((i+1),(15));
            ID.addConnectedPoints((i-1),(15));
            ID.addConnectedPoints((i),(14));
            grafoLista.add(ID);
        }
    }

    public ArrayList<Unidad> getGrafoLista() {
        return grafoLista;
    }
}