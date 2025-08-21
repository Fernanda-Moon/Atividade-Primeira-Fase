package excecoes;

public class ErroSaidaException extends Exception {

    public ErroSaidaException(String mensagem) {
        super(mensagem);
    }

    public ErroSaidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}