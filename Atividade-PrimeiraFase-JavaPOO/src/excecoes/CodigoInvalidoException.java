package excecoes;

public class CodigoInvalidoException extends Exception {

    public CodigoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public CodigoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
