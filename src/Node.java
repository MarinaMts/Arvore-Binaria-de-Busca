public class Node {
    private Palavra palavra;
    private Node left, right, parent;

    Node(Palavra palavra) {
        this.palavra = palavra;
        left = right = parent = null;
    }
    public Palavra getNode() { return this.palavra; }

    public Node getLeft() { return this.left; }

    public Node getRight() { return this.right; }

    public Node getParent() { return this.parent; }

    public void setPalavra(Palavra p) { this.palavra = p; }

    public void setLeft(Node n) { this.left = n; }

    public void setRight(Node n) { this.right = n; }

    public void setParent(Node n) { this.parent = n; }

    public void mostraNo(){
        System.out.print(palavra.getPalavra() + " ");
    }

}
