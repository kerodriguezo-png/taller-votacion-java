package votacion;
import java.util.ArrayList;
import java.util.HashMap; //estos maps y hashmaps son como diccionarios
import java.util.Map;
public class Resultado {
    private Map<Integer,Integer> puntaje; // en la izquierda la clave y en la derecha el valor
    private ArrayList<Integer> ganadores;
    private boolean empate;

    public Resultado(){
        this.puntaje = new HashMap<>(); // asi se inicializan
        this.ganadores = new ArrayList<>();
        this.empate = false; //usualmente suponemos falso el empate
    }
    public void sumarPuntos(int candidato, int puntos){ // metodo sumar puntos, exige una cadidato y un numero de puntos
        int actual = puntaje.getOrDefault(candidato,0);
        int nuevoTotal = actual + puntos;
        puntaje.put(candidato, nuevoTotal);

    }
    public void sumarVoto(int candidato){
        sumarPuntos(candidato,1);

    }
    public void definirGanador(){
        int mayor_puntaje=0;
        ganadores.clear();
        for (Map.Entry<Integer,Integer> entry : puntaje.entrySet()) {
            int candidato = entry.getKey();
            int puntos = entry.getValue();

            if(puntos> mayor_puntaje){
                mayor_puntaje=puntos;
                ganadores.clear();
                ganadores.add(candidato);
            } else if (puntos == mayor_puntaje){
                ganadores.add(candidato);
            }
        }
        empate = ganadores.size()>1;
    }
    public Map<Integer, Integer> getPuntajes(){
        return puntaje;
    }
    public ArrayList<Integer> getGanadores(){
        return ganadores;
    }
    public boolean hayempate(){
        return empate;
    }
    public void mostrarResultados(int total, int validos, int nulos, String metodo) {
    System.out.println("Método: " + metodo);
    System.out.println("Total votos: " + total);
    System.out.println("Válidos: " + validos);
    System.out.println("Nulos: " + nulos);
    System.out.println("Puntajes: " + puntaje);
    System.out.println("Ganador: " + (empate ? "Empate: " + ganadores : ganadores.get(0)));
}
}    

