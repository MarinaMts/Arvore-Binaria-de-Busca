public class Palavra {

    private String palavra;
    private int ocorrencias;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = 1;
    }

    public void adicionaOcorrencia(){
        ocorrencias++;
    }

    public String getPalavra(){
        return palavra;
    }


    public int getOcorrencias() {
        return this.ocorrencias;
    }

    public int compareToIgnoreCase(Palavra outraPalavra) {
        return this.palavra.compareTo(outraPalavra.getPalavra());
    }
}
