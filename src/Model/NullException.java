package Model;

public class NullException extends RuntimeException {

    @Override
    public String getMessage() {
        return ("O campo deve conter conteúdo diferente de vazio.");
    }
}
