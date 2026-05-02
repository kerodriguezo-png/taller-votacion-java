package escrutinio;

import votacion.Votacion;
import votacion.Resultado;

public interface Escrutinio {
    Resultado calcularGanador(Votacion votacion);
}