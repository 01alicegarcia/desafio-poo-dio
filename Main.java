package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ----------------------------------------------------
        // NOVOS CONTEÚDOS COM NOMES E DADOS DE TESTE ALTERADOS
        // ----------------------------------------------------
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java para Iniciantes: Básico ao Avançado"); // Título Alterado
        cursoJava.setDescricao("Domine os fundamentos da linguagem e inicie sua carreira.");
        cursoJava.setCargaHoraria(8); 

        Curso cursoEstruturas = new Curso();
        cursoEstruturas.setTitulo("Estruturas de Dados Essenciais"); // Título Alterado
        cursoEstruturas.setDescricao("Implementação de listas, pilhas e filas em Java.");
        cursoEstrutura.setCargaHoraria(4); 

        Mentoria mentoriaGit = new Mentoria();
        mentoriaGit.setTitulo("Mentoria de Git e Colaboração"); // Título Alterado
        mentoriaGit.setDescricao("Boas práticas para trabalho em equipe com versionamento.");
        mentoriaGit.setData(LocalDate.now().plusDays(15)); // Data Alterada


        // ----------------------------------------------------
        // CRIAÇÃO DO BOOTCAMP
        // ----------------------------------------------------
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Formação Fullstack Java e DevOps");
        bootcamp.setDescricao("Jornada de aprendizado completa em desenvolvimento.");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoEstruturas);
        bootcamp.getConteudos().add(mentoriaGit);


        // ----------------------------------------------------
        // SIMULAÇÃO DEV 1 (Felipe)
        // ----------------------------------------------------
        Dev devFelipe = new Dev();
        devFelipe.setNome("Felipe Antunes"); // Nome Alterado
        devFelipe.inscreverBootcamp(bootcamp);
        System.out.println("--- Dev Felipe (" + devFelipe.getNome() + ") ---");
        System.out.println("Conteúdos Inscritos Felipe:" + devFelipe.getConteudosInscritos());

        // Sequência de progresso diferente (progrediu 2 vezes)
        devFelipe.progredir(); // Conclui Java Básico/Avançado
        devFelipe.progredir(); // Conclui Estruturas de Dados

        System.out.println("Conteúdos Inscritos Felipe (Após progredir 2x):" + devFelipe.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Felipe:" + devFelipe.getConteudosConcluidos());
        System.out.println("XP Total:" + devFelipe.calcularTotalXp());


        // ----------------------------------------------------
        System.out.println("----------------------------------------------");
        // ----------------------------------------------------


        // ----------------------------------------------------
        // SIMULAÇÃO DEV 2 (Julia)
        // ----------------------------------------------------
        Dev devJulia = new Dev();
        devJulia.setNome("Julia Miranda"); // Nome Alterado
        devJulia.inscreverBootcamp(bootcamp);
        System.out.println("--- Dev Julia (" + devJulia.getNome() + ") ---");
        System.out.println("Conteúdos Inscritos Julia:" + devJulia.getConteudosInscritos());

        // Sequência de progresso diferente (progrediu 3 vezes)
        devJulia.progredir(); // Conclui Java Básico/Avançado
        devJulia.progredir(); // Conclui Estruturas de Dados
        devJulia.progredir(); // Conclui Mentoria Git

        System.out.println("Conteúdos Inscritos Julia (Após progredir 3x):" + devJulia.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Julia:" + devJulia.getConteudosConcluidos());
        System.out.println("XP Total:" + devJulia.calcularTotalXp());
    }
}