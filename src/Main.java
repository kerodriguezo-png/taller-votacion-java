import votacion.Votacion;
import votacion.LectorVotos;
import votacion.Resultado;
import escrutinio.Escrutinio;
import escrutinio.MayoriaSimple;
import escrutinio.MetodoBorda;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: voter <archivo.txt> <simple|borda>");
            return;
        }

        String ruta = args[0];
        String metodoStr = args[1].toLowerCase();

        LectorVotos lector = new LectorVotos(ruta);
        Votacion votacion = lector.leerYEscanear();

        if (votacion == null) {
            System.out.println("Error al procesar el archivo de votos.");
            return;
        }

        Escrutinio escrutinio;
        if (metodoStr.equals("simple")) {
            escrutinio = new MayoriaSimple();
        } else if (metodoStr.equals("borda")) {
            escrutinio = new MetodoBorda();
        } else {
            System.out.println("Metodo no reconocido. Use 'simple' o 'borda'.");
            return;
        }

        Resultado resultado = escrutinio.calcularGanador(votacion);
        
        resultado.mostrarResultados(
            votacion.getTotalVotosLeidos(),
            votacion.getVotosValidos().size(),
            votacion.getVotosNulos(),
            metodoStr
        );
    }
}