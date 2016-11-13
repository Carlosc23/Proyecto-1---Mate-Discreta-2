import java.util.ArrayList;

/**
 * Created by DiegoC on 12/11/2016.
 */
public class Implementaciones {

    /*Al aplicar la seccion 2 de heuristica*/
    public Nodo temporal;
    public Heuristica reglas = new Heuristica();
    public Nodo elNodo = reglas.getInicial();
    public int x = elNodo.getX();
    public int y = elNodo.getY();

    public ArrayList prueba(){
        while (x <= 14  && y <= 14){
            if(x == 14 && y == 14){
                break;
            }
            else if(x == 14 && y < 14){
                reglas.agregarNodo();
                reglas.subir();
            }
            else if(y == 14 && x < 14){
                reglas.agregarNodo();
                reglas.cruzar();
            }
            else{
                Nodo cruce = reglas.DondeEsMasBaratoCruzar();
                if (cruce == null){
                    Nodo subida = reglas.DondeEsMasBaratoSubir();
                    if(subida == reglas.getInicial()){
                        reglas.agregarNodo();
                        reglas.subir();
                    }
                    else{
                        reglas.agregarNodo();
                        reglas.cruzar();
                        reglas.agregarNodo();
                        reglas.subir();
                    }
                }
                else if (cruce == reglas.getInicial()){
                    reglas.agregarNodo();
                    reglas.cruzar();
                }
                else{
                    reglas.agregarNodo();
                    reglas.subir();
                    reglas.agregarNodo();
                    reglas.cruzar();
                }
            }
        }return reglas.getRecorrido();

    }



}
