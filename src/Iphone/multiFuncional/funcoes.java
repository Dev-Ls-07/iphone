package Iphone.multiFuncional;

import Iphone.appMusica.reprodutorMusical;
import Iphone.appNavegador.navegadorDeInternet;
import Iphone.appTelefone.aparelhoTelefonico;

public class funcoes implements reprodutorMusical, navegadorDeInternet, aparelhoTelefonico{

    public void selecionanadoMusica() {
        System.out.println("Selecionando musica via Spotify");
    }
    public void tocar() {
        System.out.println("Tocando musica via Spotify");
    }
    public void pausar() {
        System.out.println("Pausando Musica via Spotify");
    }
    


    public void exibirPaginsa() {
        System.out.println("Exibindo pagina via chrome");
    }
    public void adicionarNovaAba() {
        System.out.println("Adicionando aba via chrome");
    }
    public void atualizarPagina() {
        System.out.println("Atualizando pagina via chrome");
    }


    
    public void ligar() {
        System.out.println("Ligando via Whatssap");
    }
    public void atender() {
        System.out.println("Atendendo via Whatssap");
     }
    public void iniciarCorreioDeVoz() {
        System.out.println("Iniciando correio de voz via Whatssap");
    }
    @Override
    public void selecionandoMusica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecionandoMusica'");
    }

     
}