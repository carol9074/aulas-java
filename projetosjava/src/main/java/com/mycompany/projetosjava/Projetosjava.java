package com.mycompany.projetosjava;

import java.util.Arrays;
import java.util.Scanner;

public class Projetosjava {

    public static String[] cadastro() {
        Scanner t = new Scanner(System.in);
        Scanner s = new Scanner(System.in);

        String dados[] = new String[10];

        System.out.println("Informe seu nome:");
        dados[0] = t.nextLine();

        System.out.println("Informe seu cpf:");
        dados[1] = s.nextLine();

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
    
    public static int searchName (String[] nomes){
        
        int pos=0;
        String nameSearch;
         Scanner t = new Scanner(System.in);
        System.out.println("informe o nome para busca: ");
        nameSearch = t.nextLine();
        
        
        for(int i = 0; i < nomes.length ; i++){
            if(nomes[i].equals(nameSearch)){
                pos = i;
                return pos;
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
        int pos = 0;
        int op;
        String saque;
        String deposito;
        String cell2;
        

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
                    
                    pos = searchName(nome);
                    if(pos == 15){
                        System.out.println("Não cadastrado.");
                    }else{
                        System.out.println("nome:" + nome[pos]);
                        System.out.println("cpf:" + cpf[pos]);
                        System.out.println("cell:" + cell[pos]);
                        System.out.println("saldo:" + valor[pos]);
                    }
                      
                    break;
                }
                case 3 ->{
                     

                      
                }
                case 4 -> {
                    
                    System.out.println("Informe o valor de deposito:");
                    

                    
                }
                case 5 -> {
                    System.out.println("saldo:"+valor[pos]);
                }

                case 6 -> {
                   System.out.println("Cell atual:"+cell[pos]);
                   System.out.println("Informe o novo cell:"); 
                   cell2=cell[pos];
                   cell2=s.nextLine();
                   
                }
            }
        } while (op != 0);
    }
}
