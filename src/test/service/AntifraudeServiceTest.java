package service;

import model.Transacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AntifraudeServiceTest {

    private AntifraudeService service;

    @BeforeEach
    void setup() {
        service = new AntifraudeService();
    }

    @Test
    void deveAprovarTransacaoSemRisco() {
        Transacao t = new Transacao(100, "Brasil", "Brasil", true);

        boolean resultado = service.processar(t);

        assertTrue(resultado);
        assertEquals(20, t.getScoreRisco()); // só histórico
    }

    @Test
    void deveReprovarPorScoreAlto() {
        Transacao t = new Transacao(15000, "Brasil", "Rússia", true);

        boolean resultado = service.processar(t);

        assertFalse(resultado);
        assertTrue(t.getScoreRisco() >= 50);
    }

    @Test
    void deveBloquearPorFaltaDeAutenticacao() {
        Transacao t = new Transacao(100, "Brasil", "Brasil", false);

        boolean resultado = service.processar(t);

        assertFalse(resultado);
    }

    @Test
    void deveAprovarQuandoScoreBaixoMesmoComValorAlto() {
        Transacao t = new Transacao(15000, "Brasil", "Brasil", true);

        boolean resultado = service.processar(t);

        assertTrue(resultado);
        assertEquals(50, t.getScoreRisco());
    }

    @Test
    void deveReprovarQuandoLocalizacaoSuspeitaMesmoSemValorAlto() {
        Transacao t = new Transacao(100, "Brasil", "EUA", true);

        boolean resultado = service.processar(t);

        assertFalse(resultado);
        assertTrue(t.getScoreRisco() >= 50);
    }

    @Test
    void deveAcumularScoreCorretamente() {
        Transacao t = new Transacao(20000, "Brasil", "China", true);

        service.processar(t);

        int esperado = 30 + 40 + 20;

        assertEquals(esperado, t.getScoreRisco());
    }

    @Test
    void devePararChainQuandoAutenticacaoFalha() {
        Transacao t = new Transacao(20000, "Brasil", "China", false);

        boolean resultado = service.processar(t);

        assertFalse(resultado);
    }

    @Test
    void testeLimiteScoreExato() {
        Transacao t = new Transacao(10000, "Brasil", "Brasil", true);

        boolean resultado = service.processar(t);

        assertTrue(resultado);
        assertEquals(20, t.getScoreRisco());
    }
}