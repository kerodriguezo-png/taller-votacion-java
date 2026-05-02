package escrutinio;

import votacion.Votacion;
import votacion.Resultado;

public class MayoriaSimple implements Escrutinio {
    @Override
    public Resultado calcularGanador(Votacion votacion) {
        Resultado res = new Resultado();
        for (int[] voto : votacion.getVotosValidos()) {
            res.sumarVoto(voto[0]);
        }
        res.definirGanador();
        return res;
    }
}