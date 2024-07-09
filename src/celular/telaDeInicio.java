package celular;

import Iphone.appMusica.reprodutorMusical;
import Iphone.appMusica.spotify;
import Iphone.multiFuncional.funcoes;

public class telaDeInicio {
    public static void main(String[] args) {
        reprodutorMusical appMusica = new spotify();

        appMusica.selecionandoMusica();
    }
}
