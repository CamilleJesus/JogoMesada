package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.connection.Conexao;
import br.uefs.ecomp.jm_c.view.TelaJogoController;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.connection.TrataJogador;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.swing.JOptionPane;

/**
 * Classe que escuta a acao dos adversarios e atualiza a tela
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class AtualizaJogo implements Runnable {

    private TelaJogoController jogo;
    
    public AtualizaJogo(TelaJogoController jogo) {
        this.jogo = jogo;
    }

    @Override
    public void run() {
        System.out.println("entrou run AtualizaJogo");
        ConexaoCliente conexaoCliente = ConexaoCliente.getInstancia();
        SorteGrande sorteGrande = SorteGrande.getInstance();
        Jogador jogador = Jogador.getInstance();
        TrataJogador trataJogador = new TrataJogador();

        boolean condicao = true;
        while (condicao) {
            String requisicao = null;

            final String ordem;
            final String sorteio;
            final String valor;
            final String nome;

            try {
                requisicao = conexaoCliente.recebe();

                switch (requisicao) {

                    case "movePeao":
                        ordem = conexaoCliente.recebe();
                        sorteio = conexaoCliente.recebe();
                        System.out.println("movePeao");

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.1 AtualizaJogo");
                                jogo.movePeao(Integer.parseInt(ordem), Integer.parseInt(sorteio));
                            }
                        });
                        break;
                    case "aumentaSorteGrande":
                        valor = conexaoCliente.recebe();
                        sorteGrande.aumentaSorteGrande(Double.parseDouble(valor));
                        System.out.println("aumentaSorteGrande");

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.2 AtualizaJogo");
                                jogo.atualizaSorteGrande();
                            }
                        });
                        break;
                    case "zeraSorteGrande":
                        sorteGrande.setValor(0.0);
                        System.out.println("zeraSorteGrande");

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.3 AtualizaJogo");
                                jogo.atualizaSorteGrande();
                            }
                        });
                        break;
                    case "felizAniversario":
                        nome = conexaoCliente.recebe();
                        JOptionPane.showMessageDialog(null, nome + " está na casa Feliz Aniverário!\nDê R$ 100 para ele(a).", "Casa Feliz Aniversário", JOptionPane.INFORMATION_MESSAGE);
                        jogador.getConta().diminuiSaldo(100.0);
                        System.out.println("avisa");

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.4 AtualizaJogo");
                                jogo.atualizaSaldo();
                            }
                        });
                        break;
                    case "maratonaBeneficente":
                        int numeroDado = jogo.rolaDado();
                        JOptionPane.showMessageDialog(null, "Número sorteado: " + numeroDado + ".", "Rolagem de Dado", JOptionPane.INFORMATION_MESSAGE);
                        double valor2 = (numeroDado * 100.0);
                        double saldo = jogador.getConta().getSaldo();

                        if (saldo < valor2) {
                            jogador.pegaEmprestimo(valor2 - saldo);
                        }
                        jogador.getConta().diminuiSaldo(valor2);
                        sorteGrande.aumentaSorteGrande(valor2);
                        JOptionPane.showMessageDialog(null, "Você colocou R$ " + (numeroDado * 100) + " no Sorte Grande!", "Casa Maratona Beneficente", JOptionPane.INFORMATION_MESSAGE);

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.4 AtualizaJogo");
                                jogo.atualizaSaldo();
                                jogo.enviaSorteGrande(valor2);
                                jogo.atualizaSorteGrande();
                            }
                        });
                        break;
                    case "pagueVizinho":
                        nome = conexaoCliente.recebe();
                        valor = conexaoCliente.recebe();
                        JOptionPane.showMessageDialog(null, nome + " lhe pagou R$ " + valor + ".", "Carta Pague um Vizinho Agora", JOptionPane.INFORMATION_MESSAGE);
                        jogador.getConta().aumentaSaldo(Double.parseDouble(valor));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.5 AtualizaJogo");
                                jogo.atualizaSaldo();
                                jogo.atualizaDivida();
                            }
                        });
                        break;
                    case "dinheiroExtra":
                        nome = conexaoCliente.recebe();
                        valor = conexaoCliente.recebe();
                        JOptionPane.showMessageDialog(null, "Pague R$ " + valor + " a " + nome + ".", "Carta Dinheiro Extra", JOptionPane.INFORMATION_MESSAGE);
                        jogador.getConta().diminuiSaldo(Double.parseDouble(valor));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("entrou run2.5 AtualizaJogo");
                                jogo.atualizaSaldo();
                                jogo.atualizaDivida();
                            }
                        });
                        break;
                    case "finalizarTurno":
                        int vez = jogo.mudaVez();

                        if (vez == conexaoCliente.getOrdem()) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println("entrou run2.6 AtualizaJogo");

                                    if (jogo.acabouTempoPartida() == true) {
                                        jogo.mudaVez();
                                        trataJogador.enviaString("finalizarTurno");

                                        if (jogo.acabouJogo() == true) {
                                            System.out.println("Jogo acabou!");
                                            
                                        }
                                        jogo.desabilitaInterface();
                                    } else {
                                        jogo.habilitaInterface();
                                    }
                                }
                            });

                            if (jogo.acabouJogo() == true) {
                                System.out.println("Acabou jogo");

                                Conexao cliente = Conexao.getInstancia();

                                if (cliente.conecta()) {
                                    cliente.envia("vencedor");
                                    cliente.envia(conexaoCliente.getNickname());
                                    cliente.envia("" + jogador.getConta().getSaldo());

                                    String resposta = cliente.recebe();
                                    try {
                                        cliente.desconecta();
                                    } catch (IOException ex) {
                                        Logger.getLogger(AtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    System.out.println(resposta);
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            TelaJogo.getStage().close();
                                            JOptionPane.showMessageDialog(null, resposta, "Classificação", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    });
                                }

                                try {
                                    ConexaoCliente.getInstancia().desconecta();
                                } catch (IOException ex) {
                                    Logger.getLogger(AtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                condicao = false;//Envia para Servidor que o jogo acabou
                            }
                        }
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(AtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
