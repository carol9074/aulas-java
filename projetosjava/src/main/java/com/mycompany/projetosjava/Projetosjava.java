package com.mycompany.projetosjava;

import java.awt.Component;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Projetosjava {

    public static String[] cadastro() {
        String dados[] = new String[10];
        int op = 0;
        long num = 0;
        Component parentComponent;

        JOptionPane.showMessageDialog(null, "Bem vindo ao cadastro de usuario!");
        dados[0] = JOptionPane.showInputDialog("Informe seu nome:");

        while (op != 2) {
            dados[1] = JOptionPane.showInputDialog("Informe seu CPF:");

            if (dados[1].length() == 11) {
                op = 2;

                try {
                    num = Long.parseLong(dados[1]);
                    JOptionPane.showMessageDialog(null, "CPF valido");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "CPF inválido");
                    op = 1;
                }
            }
        }
        dados[2] = JOptionPane.showInputDialog("Informe seu telefone:");
        return dados;
    }

    public static int vereficacao(String[] nomes) {
        int i;

        for (i = 0; i <= 9; i++) {
            if (nomes[i] == null) {
                return i;
            }
        }
        return 15;
    }

    public static int searchName(String[] nomes) {
        int pos = 0;
        String nameSearch;

        nameSearch = JOptionPane.showInputDialog("Informe o nome para busca:");

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nameSearch)) {
                pos = i;
                return pos;
            } else {
                JOptionPane.showMessageDialog(null, "Não possui cadastro!");
            }
        }
        return 15;
    }

    public static int searchCpf(String[] cpfs) {
        int pos;

        String CpfSearch = JOptionPane.showInputDialog("Informe o nome para busca:");

        for (int i = 0; i < cpfs.length; i++) {
            if (cpfs[i].equals(CpfSearch)) {
                pos = i;
                return pos;
            } else {
                JOptionPane.showMessageDialog(null, "Não possui cadastro!");
            }
        }
        return 15;
    }

    public static void main(String[] args) {
        String nome[] = new String[10];
        float valor[] = new float[10];
        String cell[] = new String[10];
        String cpf[] = new String[10];
        String cliente[] = new String[2];
        float saque;
        int pos = 0;
        int op;
        float aux = 0;

        do {
            JOptionPane.showMessageDialog(null, "Escolha uma das opções abaixo.");
            op = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastrar \n 2-Vizualizar Perfil\n 3-Debito \n 4-Credito \n 5-Saldo \n 6-Atualizar \n 0-Sair "));
            switch (op) {
                case 1 -> {
                    pos = vereficacao(nome);
                    if (pos == 15) {
                        JOptionPane.showMessageDialog(null, "Não temos vagas.");
                    } else {
                        cliente = cadastro();
                        nome[pos] = cliente[0];
                        cpf[pos] = cliente[1];
                        cell[pos] = cliente[2];
                        valor[pos] = 0;
                        JOptionPane.showMessageDialog(null, "\nSeu cadastro está concluido com sucesso!.");
                        JOptionPane.showMessageDialog(null, "Nome:" + nome[pos]);
                        JOptionPane.showMessageDialog(null, "CPF:" + cpf[pos]);
                        JOptionPane.showMessageDialog(null, "Celular:" + cell[pos]);
                    }
                    break;
                }
                case 2 -> {
                    op = Integer.parseInt(JOptionPane.showInputDialog("1-Buscar nome: \\n 2-Buscar CPF:"));

                    if (op == 1) {
                        pos = searchName(nome);
                        if (pos == 15) {
                            JOptionPane.showMessageDialog(null, "Não  cadastrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome:" + nome[pos]);
                            JOptionPane.showMessageDialog(null, "CPF:" + cpf[pos]);
                            JOptionPane.showMessageDialog(null, "Celular:" + cell[pos]);
                            JOptionPane.showMessageDialog(null, "Saldo" + valor[pos]);

                        }
                    } else {
                        pos = searchCpf(cpf);
                        if (pos == 15) {
                            JOptionPane.showMessageDialog(null, "Não  cadastrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome:" + nome[pos]);
                            JOptionPane.showMessageDialog(null, "CPF:" + cpf[pos]);
                            JOptionPane.showMessageDialog(null, "Celular:" + cell[pos]);
                            JOptionPane.showMessageDialog(null, "Saldo" + valor[pos]);

                        }
                    }
                    break;
                }
                case 3 -> {
                    pos = searchName(nome);
                    JOptionPane.showMessageDialog(null, "Saldo atual:" + valor[pos]);
                    saque = Float.parseFloat(JOptionPane.showInputDialog("Informe o que deseja sacar:"));
                    if (valor[pos] >= saque) {
                        valor[pos] = valor[pos] - saque;
                        JOptionPane.showMessageDialog(null, "Saque:" + saque);
                        JOptionPane.showMessageDialog(null, "Saldo:" + valor[pos]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                    }
                    break;
                }
                case 4 -> {
                    pos = searchName(nome);
                    aux = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor de deposito:"));
                    valor[pos] = valor[pos]+aux;                   
                    break;
                }
                case 5 -> {
                    pos = searchName(nome);
                    JOptionPane.showMessageDialog(null, "Saldo:" + valor[pos]);
                    break;
                }
                case 6 -> {
                    pos = searchName(nome);
                    JOptionPane.showMessageDialog(null, "Cell atual:" + cell[pos]);
                    cell[pos] = JOptionPane.showInputDialog("Informe o novo cell:");
                    JOptionPane.showMessageDialog(null, "Cell novo:" + cell[pos]);
                    break;
                }
            }
        } while (op != 0);
    }

}
