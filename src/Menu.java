import java.util.Scanner;

public class Menu {
    public static void iniciaMenu(){
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        Scanner scanner = new Scanner(System.in);

        boolean textoCarregado = false;
        int codigo = 0;

        do {
            try {
                System.out.println("""
                        1- Carregar o texto                           \s
                        2- Estatísticas                               \s
                        3- Busca por palavra                          \s
                        4- Exibição do texto                          \s
                        5- Exibição por ordem de frequencia de palavra\s
                        6- Encerrar""");
                codigo = scanner.nextInt();
                scanner.nextLine();

                switch (codigo) {
                    case 1:
                        leituraArquivo.lerArquivo();
                        textoCarregado = true;
                        break;
                    case 2:
                        if(textoCarregado){
                            leituraArquivo.exibeEstatisticas();
                        }else{
                            System.out.println("Carregue o texto antes de executar esta função");
                        }
                        break;
                    case 3:
                        if(textoCarregado){
                            leituraArquivo.buscarPalavra();
                        }else{
                            System.out.println("Carregue o texto antes de executar esta função");
                        }
                        break;
                    case 4:
                        if(textoCarregado){
                            leituraArquivo.exibirEmORdemAlfabetica();
                        }else{
                            System.out.println("Carregue o texto antes de executar esta função");
                        }
                        break;
                    case 5:
                        if(textoCarregado){
                            leituraArquivo.exibirPorFrequencia();
                        }else{
                            System.out.println("Carregue o texto antes de executar esta função");
                        }
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Digite uma opção válida");
                        break;
                }

            }catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();
                codigo = 0;
            }
        }while (codigo != 6);

    }
}
