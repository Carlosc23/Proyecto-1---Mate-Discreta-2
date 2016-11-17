import com.sun.istack.internal.Pool;

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
    public ArrayList recorrido = new ArrayList();


    public ArrayList prueba(){
        while (elNodo.getX() <= 14  && elNodo.getY()<= 14){
            if(elNodo.getX() == 14 && elNodo.getY() == 14){
                break;
            }
            else if(elNodo.getX() == 14 && elNodo.getY() < 14){
                Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                recorrido.add(temp);
                reglas.subir();
            }
            else if(elNodo.getY() == 14 && elNodo.getX() <  14){
                Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                recorrido.add(temp);
                reglas.cruzar();
            }
            else{
                Nodo cruce = reglas.DondeEsMasBaratoCruzar();
                if (cruce == null){
                    Nodo subida = reglas.DondeEsMasBaratoSubir();
                    if(subida == reglas.getInicial()){
                        Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                        recorrido.add(temp);
                        reglas.subir();


                    }
                    else{
                        Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                        recorrido.add(temp);
                        reglas.cruzar();
                        Nodo temp2 = new Nodo(elNodo.getX(), elNodo.getY());
                        recorrido.add(temp2);
                        reglas.subir();

                    }
                }
                else if (cruce == reglas.getInicial()){
                    Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                    recorrido.add(temp);
                    reglas.cruzar();
                    break;
                }
                else{
                    Nodo temp = new Nodo(elNodo.getX(), elNodo.getY());
                    recorrido.add(temp);
                    reglas.subir();
                    Nodo temp2 = new Nodo(elNodo.getX(), elNodo.getY());
                    recorrido.add(temp2);
                    reglas.cruzar();

                }
            }
        }return recorrido;

    }

    public static void main(String [] args){
        Implementaciones imp = new Implementaciones();
        ArrayList<Nodo> datos = new ArrayList<Nodo>();
        datos = imp.prueba();

        System.out.println(datos);

        System.out.println(datos.get(25).getX());
        System.out.println(datos.get(25).getY());
        System.out.println(datos.get(27).getX());
        System.out.println(datos.get(27).getY());
        System.out.println(datos.get(26).getX());
        System.out.println(datos.get(26).getY());

    }



}
