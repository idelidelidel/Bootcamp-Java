package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

  
    public double calcularXp() {
        return XP_PADRAO * getCargaHoraria();
    }

    public Curso() {
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + getCargaHoraria() +
                '}';
    }
}
