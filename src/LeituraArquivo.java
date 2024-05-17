import java.io.*;
import java.util.*;

public class LeituraArquivo {

    Scanner sc;
    List<String> palavrasDistintas;
    private int quantidadeDeLinhas;
    private int quantidadeDePalavras;
    private int quantidadeDePalavrasDistintas;
    private String palavraMaisLonga;
    ABB arvore;

    public LeituraArquivo() {
        this.sc = new Scanner(System.in);
        this.palavrasDistintas = new ArrayList<>();;
        this.quantidadeDeLinhas = 0;
        this.quantidadeDePalavras = 0;
        this.quantidadeDePalavrasDistintas = 0;
        this.palavraMaisLonga = "";
        this.arvore = new ABB();;
    }

    public void lerArquivo(){

        try(BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("musica.txt")))) {
            String linha;
            while ((linha = buf.readLine()) != null) {
                String [] palavrasDaLinha = linha.split(" ");
                for (String palavra : palavrasDaLinha) {
                    arvore.inicializaPalavra(new Palavra(palavra));
                    verificaPalavraMaisLonga(palavra);
                    adicionaQuantidadeDePalavras(palavra);
                }
                quantidadeDeLinhas++;
            }
            System.out.println("TEXTO CARREGADO");

        }catch(FileNotFoundException erro){
            System.out.println(">> Arquivo não encontrado");
        }catch(IOException erro){
            System.out.println(">> Erro na leitura");
        }
    }

    public void verificaPalavraMaisLonga(String novaPalavra){
        if (novaPalavra.length() > palavraMaisLonga.length()) {
            palavraMaisLonga = novaPalavra;
        }
    }

    public void adicionaQuantidadeDePalavras(String palavra){
        quantidadeDePalavras++;
        if (!palavrasDistintas.contains(palavra)) {
            palavrasDistintas.add(palavra);
            quantidadeDePalavrasDistintas++;
        }
    }

    public void exibeEstatisticas(){
        System.out.println("Estatísticas:");
        System.out.printf("Quantidade de linhas no texto: %d%n", quantidadeDeLinhas);
        System.out.printf("Quantidade de palavras no texto: %d%n", quantidadeDePalavras);
        System.out.printf("Quantidade de palavras distíntas no texto: %d%n", quantidadeDePalavrasDistintas);
        System.out.printf("Palavra mais longa do texto: %s%n", palavraMaisLonga);
    }

    public void buscarPalavra(){
        System.out.println("Digite a palavra que deseja buscar ");
        String palavra = sc.nextLine();
        Node palavraBuscada = arvore.busca(palavra);
        if (palavraBuscada != null){
            System.out.println("A quantidade de ocorrencias é: " + palavraBuscada.getNode().getOcorrencias());
        }else {
            System.out.println("A palavra nao foi encontrada");
        }
        System.out.println();
    }

    public void exibirEmORdemAlfabetica(){
        System.out.println("Palavra      N° de ocorrências");
        arvore.exibirEmOrdem(arvore.root());
        System.out.println();
    }

    public void exibirPorFrequencia() {
        List<Node> no = new ArrayList<>();
        armazenarNo(arvore.root(), no);

        no.sort(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.getNode().getOcorrencias() - n1.getNode().getOcorrencias();
            }
        });


        System.out.println("Palavra      N° de ocorrências");
        for (Node node : no) {
            System.out.printf("%-15s %5d%n", node.getNode().getPalavra(), node.getNode().getOcorrencias());
        }
        System.out.println();
    }

    private void armazenarNo(Node root, List<Node> nodes) {
        if (root != null) {
            armazenarNo(root.getLeft(), nodes);
            nodes.add(root);
            armazenarNo(root.getRight(), nodes);
        }
    }

}
