package escrutinio;

import votacion.Votacion;
import votacion.Resultado;

public class MetodoBorda implements Escrutinio {
    @Override
    public Resultado calcularGanador(Votacion votacion) {
        Resultado res = new Resultado();
        int n = votacion.getNumCandidatos();
        for (int[] voto : votacion.getVotosValidos()) {
            for (int i = 0; i < voto.length; i++) {
                int puntos = n - 1 - i;
                res.sumarPuntos(voto[i], puntos);
            }
        }
        res.definirGanador();
        return res;
    }
}