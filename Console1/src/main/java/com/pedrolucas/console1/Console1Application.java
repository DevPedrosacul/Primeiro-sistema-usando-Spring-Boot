package com.pedrolucas.console1;

import com.pedrolucas.console1.entidades.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Console1Application implements CommandLineRunner {

    @Autowired
    private ContatoRepositorio contatoRepositorio;
    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        while (true) {

            System.out.println("\n1- ADICIONAR RECLAMAÇÕES");
            System.out.println("2- LISTAR CONTATOS");
            System.out.println("3- SAIR");

            int opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) {

                System.out.print("DIGITE O NOME: ");
                String nome = teclado.nextLine();

                System.out.print("DIGITE O E-MAIL: ");
                String email = teclado.nextLine();

                System.out.print("DIGITE O TELEFONE: ");
                String telefone = teclado.nextLine();

                Contato contato1 = new Contato();

                contato1.setNome(nome);
                contato1.setEmail(email);
                contato1.setTelefone(telefone);

                contatoRepositorio.save(contato1);

                System.out.println("Contato Adicionado com sucesso!");
            } else if (opcao == 2) {

                for (Contato i : contatoRepositorio.findAll()) {
                    System.out.println("\n-IDENTIFICADOR : " + i.getId()  + "\n-NOME: " + i.getNome() + "\n-TELEFONE: " + i.getTelefone());
                }
            } else if (opcao == 3) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Console1Application.class, args);
    }

}
