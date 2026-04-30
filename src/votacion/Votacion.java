package votacion;
import java.util.ArrayList;
public class Votacion{
    // todo lo que tenga la forma (algo) es una manera de referirme a un termino anterior usado
    private int numCandidatos;
    private ArrayList<int[]> votosValidos = new ArrayList<>();//** 
    private int votosNulos; //(··)
    private int totalVotosLeidos;
    public Votacion(int n){
        this.numCandidatos=n; // inicializamos la votacion con n numeros de candidatos que nos (ªª)
        this.totalVotosLeidos=0;//pedira al principio el lector de votos, inicializamos en 0
        this.votosNulos = 0;//votos nulos y total de votos leidos
    }
    public void agregarVoto(int[] voto , boolean valido){
        totalVotosLeidos++; // cada voto leido sumara
        if(valido){
            votosValidos.add(voto);// so el voto es valido, lo añadira aqui (**)
        }else{
            votosNulos++; // si no es valido hara Votos nulos +1, aqui (··)
        }
    }
    public int getNumCandidatos(){
        return numCandidatos; //creo que esta es facil, retorna el numero de candidatos, aqui (ªª)
    }
    public ArrayList<int[]> getVotosValidos(){
        return votosValidos; //la misma vuela
    }
    public int getVotosNulos(){
        return votosNulos;
    }
    public int getTotalVotosLeidos(){
        return totalVotosLeidos; 
    }
}    
