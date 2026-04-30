import model.Transacao;
import service.AntifraudeService;

public class Main {

    public static void main(String[] args) {

        Transacao transacao = new Transacao(15000, "Brasil", "Rússia", true);

        AntifraudeService service = new AntifraudeService();

        boolean aprovada = service.processar(transacao);

        System.out.println("Resultado final: " + (aprovada ? "APROVADA" : "REPROVADA"));
    }
}