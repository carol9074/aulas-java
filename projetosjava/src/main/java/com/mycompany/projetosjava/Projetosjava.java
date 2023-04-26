package com.mycompany.projetosjava;

import java.util.Arrays;
import java.util.Scanner;

public class Projetosjava {

    public static String[] cadastro() {
        Scanner t = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        String dados[] = new String[10];
        int op = 0;
        long num = 0;

        System.out.println("Informe seu nome:");
        dados[0] = t.nextLine();

        while (op != 2) {
            System.out.println("Informe seu cpf:");
            dados[1] = s.nextLine();

            if (dados[1].length() == 11) {
                op = 2;

                try {
                    num = Long.parseLong(dados[1]);
                    System.out.println("\nCPF Valido\n" + dados[1]);
                } catch (NumberFormatException e) {
                    System.out.println("\nCPF inválido\n" + dados[1]);
                    op = 1;
                }
            }
        }
        System.out.println("Informe seu telefone:");
        dados[2] = s.nextLine();

        System.out.println(dados[0]);
        System.out.println(dados[1]);
        System.out.println(dados[2]);

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
        Scanner t = new Scanner(System.in);

        System.out.println("informe o nome para busca: ");
        nameSearch = t.nextLine();

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nameSearch)) {
                pos = i;
                return pos;
            } else {
                System.out.println("Não a cadrastro");
            }
        }
        return 15;
    }

    public static int searchCpf(String[] cpfs) {
        int pos;
        String Cpfsearch;
  
        Scanner s = new Scanner(System.in);
        System.out.println("informe o CPF para busca: ");
        String CpfSearch = s.nextLine();

        for (int i = 0; i < cpfs.length; i++) {
            if (cpfs[i].equals(CpfSearch)) {
                pos = i;
                return pos;              
            } else {
                 System.out.println("Não a cadrastro");
            }
        }
        return 15;
    }

    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        String nome[] = new String[10];
        float valor[] = new float[10];
        String cell[] = new String[10];
        String cpf[] = new String[10];
        String cliente[] = new String[2];
        float saque;
        int pos = 0;
        int op ;

        do {
            System.out.println(" 1-Cadastrar \n 2-Vizualizar Perfil \n 3-Debito \n 4-Credito \n 5-Saldo \n 6-Atualizar \n 0-Sair \n");
            op = s.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("---- Bem vindo ao cadrastro ---- \nPrecisamos que preencha algumas informações,logo abaixo.");
                    pos = vereficacao(nome);
                    if (pos == 15) {
                        System.out.println("Não temos vagas.");
                    } else {
                        cliente = cadastro();
                        nome[pos] = cliente[0];
                        cpf[pos] = cliente[1];
                        cell[pos] = cliente[2];
                        valor[pos] = 0;
                        System.out.println("\nSeu cadastro está concluido com sucesso!");
                        System.out.println("nome:" + nome[pos]);
                        System.out.println("cpf:" + cpf[pos]);
                        System.out.println("cell:" + cell[pos]);

                    }
                    break;
                }
                case 2 -> {
                    System.out.println("1-Buscar nome: \n 2-Buscar CPF:");
                    op = s.nextInt();

                    if (op == 1) {
                        pos = searchName(nome);
                        if (pos == 15) {
                            System.out.println("Não cadastrado.");
                        } else {
                            System.out.println("nome:" + nome[pos]);
                            System.out.println("cpf:" + cpf[pos]);
                            System.out.println("cell:" + cell[pos]);
                            System.out.println("saldo:" + valor[pos]);
                        }
                    }
                    else {
                        pos = searchCpf(cpf);
                        if (pos == 15) {
                            System.out.println("Não cadastrado.");
                        } else {
                            System.out.println("nome:" + nome[pos]);
                            System.out.println("cpf:" + cpf[pos]);
                            System.out.println("cell:" + cell[pos]);
                            System.out.println("saldo:" + valor[pos]);
                        }
                }
                    break;
                }
                case 3 -> {
                    pos = searchName(nome);
                    System.out.println("Saldo Atual:" + valor[pos]);
                    System.out.println("Informe o que deseja sacar:");
                    saque = s.nextFloat();
                    if (valor[pos] >= saque) {
                        valor[pos] = valor[pos] - saque;
                        System.out.println("Saque:" + saque);
                        System.out.println("Saldo:" + valor[pos]);
                    } else {
                        System.out.println("Saldo insuficiente\n");
                    }
                    break;
                }
                case 4 -> {
                    pos = searchName(nome);
                    System.out.println("Informe o valor de deposito:");
                    valor[pos] = valor[pos] + s.nextFloat();
                    break;
                }
                case 5 -> {
                    pos = searchName(nome);
                    System.out.println("saldo:" + valor[pos]);
                    break;
                }
                case 6 -> {
                    pos = searchName(nome);
                    System.out.println("Cell atual:" + cell[pos]);
                    cell[pos] = s.nextLine();
                    System.out.println("Informe o novo cell:");
                    cell[pos] = s.nextLine();
                    break;
                }
            }
        } while (op != 0);
    }

    private static int CpfSearch(String[] cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
