package casasBahia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import excecoes.CodigoInvalidoException;
import excecoes.ErroSaidaException;
import excecoes.OpcaoInvalidaException;
import excecoes.PrecoInvalidoException;

public class Sistema {

    private ArrayList<Produto> produtos;

    public Sistema() {
        this.produtos = new ArrayList<Produto>();
    }


    public void adicionarProduto(Scanner scanner) throws PrecoInvalidoException, OpcaoInvalidaException, CodigoInvalidoException {
        try {
            System.out.println("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o código: ");
            String codigo = scanner.nextLine();
            if (codigo.length() != 3) {
                throw new CodigoInvalidoException("Erro: O código deve ter exatamente 3 caracteres!");
            }

            System.out.println("Digite o preço do produto: ");
            Double preco = scanner.nextDouble();
            scanner.nextLine();

            if (preco <= 0) {
                throw new PrecoInvalidoException("O preço precisa ser maior que 0");
            }

            System.out.println("Qual o tipo do produto: ");
            System.out.println("1 - Móvel ");
            System.out.println("2 - Eletro ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                adicionarMovel(scanner, nome, codigo, preco);
            } else if (opcao == 2) {
                adicionarEletro(scanner, nome, codigo, preco);
            } else {
                throw new OpcaoInvalidaException("Opção inválida! Digite 1(Móvel) ou 2(Eletro).");
            }

        } catch (InputMismatchException e) {
            throw new OpcaoInvalidaException("Erro: Digite um número válido para a opção!", e);
        }
    }


    private void adicionarMovel(Scanner scanner, String nome, String codigo, double preco) {
        System.out.println("Digite o material:");
        String material = scanner.nextLine();

        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();

        Movel movel = new Movel(codigo, nome, preco, categoria, material);
        produtos.add(movel);

        System.out.println("Produto adicionado");

    }


    private void adicionarEletro(Scanner scanner, String nome, String codigo, double preco) {
        CategoriaEletro categoriaEletro = null;
        System.out.println("Qual a categoria do eletrodomestico cadastrado?");
        System.out.println("1 - Cozinha");
        System.out.println("2 - Quarto");
        System.out.println("3 - Lavanderia");

        int opcaoCategoria = scanner.nextInt();
        scanner.nextLine();
        if (opcaoCategoria == 1) {
            categoriaEletro = CategoriaEletro.COZINHA;
        } else if (opcaoCategoria == 2) {
            categoriaEletro = CategoriaEletro.QUARTO;
        } else if (opcaoCategoria == 3) {
            categoriaEletro = CategoriaEletro.LAVANDERIA;
        }
        System.out.println("Digite a voltagem: ");
        int voltagem = scanner.nextInt();
        scanner.nextLine();
        Eletrodomestico eletro = new Eletrodomestico(codigo, nome, preco, categoriaEletro, voltagem);
        produtos.add(eletro);
        System.out.println("Produto adicionado com sucesso!");

    }


    public void listarProdutos() {
        if (produtos.size() == 0) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }

    }


    public Produto buscarProduto(Scanner scanner) throws CodigoInvalidoException {
        System.out.println("Informe o código (3 caracteres): ");
        String codigoProcurado = scanner.nextLine().trim();

        if (codigoProcurado.length() != 3) {
            throw new CodigoInvalidoException("Código inválido! Digite exatamente 3 caracteres.");
        }

        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigoProcurado)) {
                System.out.println("Produto encontrado!");
                System.out.println(produto);
                return produto;
            }
        }
        System.out.println("Produto não encontrado!");
        return null;
    }


    public void removerProduto(Scanner scanner) {
        System.out.println("Digite o código do produto: ");
        String codigoProcurado = scanner.nextLine();
        for(int i=0; i < produtos.size(); i++) {
            if(produtos.get(i).getCodigo().equals(codigoProcurado)) {
                produtos.remove(i);
                System.out.println("Produto removido");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }


    public void finalizarSistema() throws ErroSaidaException {
        try {
            System.out.println("Finalizando operações...");

            if (Math.random() < 0.2) {
                throw new IOException("Erro ao salvar dados finais");
            }

            System.out.println("Sistema finalizado com sucesso!");

        } catch (IOException e) {
            throw new ErroSaidaException("Falha ao salvar dados durante a saída", e);
        } catch (Exception e) {
            throw new ErroSaidaException("Erro inesperado durante a finalização: " + e.getMessage(), e);
        }
    }
}




