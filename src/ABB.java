public class ABB {

    private Node root; // raiz da árvore

    ABB() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node root() {
        return root;
    }

    public void inicializaPalavra(Palavra palavra){
        root = inserirPalavraNaArvore(root, palavra);
    }

    public Node inserirPalavraNaArvore(Node node, Palavra palavra){

        if (node == null) {
            return new Node(palavra);
        }

        if (palavra.compareToIgnoreCase(node.getNode()) < 0) {
            node.setLeft(inserirPalavraNaArvore(node.getLeft(), palavra));
        } else if (palavra.compareToIgnoreCase(node.getNode()) > 0) {
            node.setRight(inserirPalavraNaArvore(node.getRight(), palavra));
        } else {
            node.getNode().adicionaOcorrencia();
        }

        return node;
    }

    public Node busca(String teste) {
        Palavra palavra = new Palavra(teste);
        Node y = root();
        while (y != null) {
            if ((palavra.compareToIgnoreCase(y.getNode()) == 0)) {
                return y;
            } else if (palavra.compareToIgnoreCase(y.getNode()) > 0) {
                y = y.getRight();
            } else {
                y = y.getLeft();
            }
        }
        return null;
    }

    public void exibirEmOrdem(Node no) {
        if(no !=null) {
            exibirEmOrdem(no.getLeft());
            String palavra = no.getNode().getPalavra();
            int ocorrencias = no.getNode().getOcorrencias();
            System.out.printf("%-15s %5d%n", palavra, ocorrencias);
            exibirEmOrdem(no.getRight());

        }
    }

    public void exibirPorFrequencia() {

    }
}
