package excecoes;

public class OpcaoInvalidaException extends RuntimeException {

    public OpcaoInvalidaException(String message) {
        super(message);
    }

    public OpcaoInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
