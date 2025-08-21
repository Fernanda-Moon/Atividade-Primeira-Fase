package casasBahia;

import java.util.Scanner;
import java.util.InputMismatchException;

import excecoes.CodigoInvalidoException;
import excecoes.ErroSaidaException;
import excecoes.PrecoInvalidoException;
import excecoes.OpcaoInvalidaException;

public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner scan = new Scanner(System.in);

        int opcao = 0;

        do {
            try {
                System.out.println("---Menu----");
                System.out.println("1- Adicionar");
                System.out.println("2- Listar");
                System.out.println("3- Buscar");
                System.out.println("4- Remover");
                System.out.println("5- Sair");
                System.out.print("Digite sua opção: ");
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        try {
                            sistema.adicionarProduto(scan);
                        } catch (PrecoInvalidoException | CodigoInvalidoException | OpcaoInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        sistema.listarProdutos();
                        break;
                    case 3:
                        try {
                            sistema.buscarProduto(scan);
                        } catch (CodigoInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        sistema.removerProduto(scan);
                        break;
                    case 5:
                        try {
                            sistema.finalizarSistema();
                        } catch (ErroSaidaException e) {
                            System.out.println("Erro ao sair do sistema: " + e.getMessage());
                            opcao = 0;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Informe apenas números!");
                scan.nextLine();
                opcao = 0;
            }

        } while (opcao != 5);
        System.out.println("Saindo do Sistema!");
        scan.close();
    }
}




