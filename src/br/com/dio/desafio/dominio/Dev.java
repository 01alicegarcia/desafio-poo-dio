package br.com.dio.desafio.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Optional; // Importação adicionada para a classe Optional

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /**
     * Inscreve o Dev em um Bootcamp.
     * Adiciona os conteúdos do Bootcamp à lista de inscritos do Dev.
     * Adiciona o Dev à lista de devs inscritos do Bootcamp.
     */
    public void inscreverBootcamp(Bootcamp bootcamp){
        // Adiciona todos os conteúdos do Bootcamp aos conteúdos inscritos do Dev
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        
        // Adiciona o Dev ao Set de devsInscritos do Bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    /**
     * Marca o primeiro conteúdo da lista de inscritos como concluído e calcula o XP.
     */
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            // Usa System.err para indicar um erro/alerta, seguindo a convenção
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    /**
     * Calcula a soma total do XP dos conteúdos concluídos.
     * Usa o Iterator (abordagem tradicional) e o método polimórfico calcularXp().
     */
    public double calcularTotalXp() {
        // Opção 1: Usando Iterator (como você implementou)
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            // Chamada polimórfica: chama calcularXp() de Curso ou Mentoria
            soma += iterator.next().calcularXp();
        }
        return soma;

        /* Opção 2: Usando Stream API (mais moderna e concisa)
        return this.conteudosConcluidos
                 .stream()
                 .mapToDouble(Conteudo::calcularXp)
                 .sum();
        */
    }


    // --- Getters e Setters (Encapsulamento) ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // --- equals e hashCode (Importantes para o uso de Sets/Collections) ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        // Na prática, seria mais comum comparar apenas o 'nome' ou um ID único, 
        // mas o uso das coleções na comparação está tecnicamente correto para este desafio.
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}