 package votacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class LectorVotos {
    private String rutaArchivo;
    public LectorVotos(String ruta){
        this.rutaArchivo=ruta;
    }
    public Votacion leerYEscanear(){
        Votacion votacion = null;//(..)
        try { // es como una manera de decir trata de hacer esto, pero si no funciona: vamos a catch (:)
            File archivo = new File(rutaArchivo);//crea un archivo
            Scanner sc = new Scanner (archivo);//y lo lee con esto

            int n =sc.nextInt();
            sc.nextLine();
            votacion= new Votacion(n); // le damos forma a la votacion anteriormente nula aqui (..)


            while (sc.hasNextLine()){ //segun lo que entiendo, se pregunta "hay siguiente linea?", si la respuesta es si, mantiene el bucle
            String linea =sc.nextLine();// inicializa una linea unitaria, justamente la que se esta leyendo en el momento
            if(!linea.trim().isEmpty()){// busca a ver si la linea ni esta vacia "      " ---por el trim--->"", y por el isEmpty--->true o false
                boolean valido = ValidarVoto(linea, n); // utilizamos el metodo definido despues aqui (**)
            
            // aqui vamos a convertir la linea a voto
            int[] votoArray = convertirLineaAVoto(linea);
            votacion.agregarVoto(votoArray, valido);//agrega voto con la clase anterior mente definida
            }
        }
        sc.close();
        } catch (FileNotFoundException e) { //(:) y haz esto
            System.err.println("Archivo no encontrado: "+ rutaArchivo);
        }
        return votacion;
    }

    private int[] convertirLineaAVoto(String linea){
        Scanner sc = new Scanner(linea);
        ArrayList<Integer> lista = new ArrayList<>();
        while (sc.hasNextInt()){
            lista.add(sc.nextInt());
        }
        sc.close();

        int[] voto = new int[lista.size()];// un arreglo de tamaño de lista
        for(int i =0; i< lista.size();i++){
            voto[i] = lista.get(i);
        }
        return voto;
    }








    private boolean enRango(ArrayList<Integer> voto2, int n_2){ //mira si un voto esta fuera del rango:if(c<=0 || c>n_2){ return false; }, cada c es un elemento de la lista
                for(Integer c : voto2){//si ninguno es igual, retorna true, esta en el rango
                    if(c<=0 || c>n_2){
                        return false;
                    }
                }
                return true;
            }

    private boolean repetido(ArrayList<Integer> voto_3){ //mira si esta repetido
                for(int i =0; i<voto_3.size()-1; i++){// toma i =0 y el tamaño de la lista -1, para ir comparando
                    int voto_unitario=voto_3.get(i);//con el j que toma el tamaño de lista completo.
                    for(int j = i+1; j<voto_3.size();j++){// recorre desde la posicion i+1 hasta la longitud total
                        if(voto_unitario==voto_3.get(j)){// y compara, si esta repetido retorna true
                            return true;
                        }
                    }
                }
            return false;
        }

    private boolean  ValidarVoto(String linea, int n){//(**)
        ArrayList<Integer> voto = new ArrayList<>(); //este valida el voto, definimos una lista
            Scanner linea_1 = new Scanner(linea);//un escaner
            while (linea_1.hasNextInt()){ // hay siguiente linea?
                int numero = linea_1.nextInt(); // mira los numeros
                voto.add(numero);// los añade a voto
            }
            linea_1.close();
        return voto.size()== n && enRango(voto,n) && !repetido(voto); // esto es un booleano mira si las condiciones se cumplen o no
    }
}   

