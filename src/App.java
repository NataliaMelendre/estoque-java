import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Estoque _dadosEstoque = new Estoque();
        Scanner _capturarDados = new Scanner(System.in);
        int escolha = 1;

        while(escolha > 0) {
            System.out.println("\n==================== Controle de Estoque ==================== \n");   
            System.out.println("1 - Listar estoque");
            System.out.println("2 - Cadastrar novo produto no estoque");
            System.out.println("3 - Excluir produto do estoque");
            System.out.println("4 - Editar produto do estoque");
            System.out.println("0 - Sair do programa");
            System.out.println("Escolha qual opção deseja:");
            escolha =  _capturarDados.nextInt();

            switch(escolha) {
                case 1:
                    System.out.println(_dadosEstoque.listarProdutos());
                    break;

                case 2:
                    System.out.println("Digite nome do produto:");
                    String nome = _capturarDados.next();

                    System.out.println(String.format("Digite o preço do produto - %s:", nome));
                    Double preco = _capturarDados.nextDouble();

                    System.out.println(String.format("Digite a quantidade do produto - %s:", nome));
                    int quantia = _capturarDados.nextInt();

                    System.out.println(String.format("Digite a marca do produto - %s:", nome));
                    String marca = _capturarDados.next();

                    System.out.println(String.format("Digite a descrição do produto - %s:", nome));
                    String descricao = _capturarDados.next();

                    System.out.println(_dadosEstoque.cadastrarProduto(nome, preco, quantia, marca, descricao));
                    break;

                case 3:
                    System.out.println("Digite o id do produto:");
                    int id = _capturarDados.nextInt();
                    System.out.println(_dadosEstoque.exluirProduto(id));
                    break;

                case 4:
                    System.out.println("Digite o id do produto:");
                    int id2 = _capturarDados.nextInt();

                    System.out.println("Digite a alteração do nome produto:");
                    String nomeAlterado = _capturarDados.next();

                    System.out.println("Digite o preço a ser alterado:");
                    Double precoAlterado = _capturarDados.nextDouble();

                    System.out.println("Digite a quantidade a ser alterada:");
                    int quantiaAlterado = _capturarDados.nextInt();

                    System.out.println("Digite a marca a ser alterada:");
                    String marcaAlterado = _capturarDados.next();

                    System.out.println("Digite a descrição a ser alterada:");
                    String decricaoAlterado = _capturarDados.next();
                    
                    System.out.println(_dadosEstoque.alterarProduto(id2, nomeAlterado, precoAlterado, quantiaAlterado, marcaAlterado, decricaoAlterado));
                    escolha = 1;
                    break;

                default:
                    if (escolha > 0) {
                        System.out.println("Opção inválida, verificar opções do menu.");
                        break;
                    }
                    else {
                        System.out.println("Programa finalizado, até mais.");
                        break;
                    }
            }
        }
        _capturarDados.close();
    }
}