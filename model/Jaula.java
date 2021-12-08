package model;

public class Jaula {

    // Atributos da classe Jaula.
    private int idJaula;
    private String descricao;
    // Cada Jaula possui um Animal.
    Animal animal;

    // Método construtor de Jaula.
    public Jaula(
        int idJaula,
        String descricao
    ) {
        this.idJaula = idJaula;
        this.descricao = descricao;
    }

    // Getters
    public int getIdJaula() {
        return idJaula;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setters
    public void setIdJaula(int idJaula) {
        this.idJaula = idJaula;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método para comparar objeto com Golfinho:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jaula)) {
            return false;
        }

        Jaula jaula = (Jaula) o;
        return this.getIdJaula() == jaula.getIdJaula();
    }

    // Trazendo Jaula em forma de texto.
    @Override
    public String toString() {
        return
            "Jaula! \n" +
            "ID: " + this.getIdJaula() + "\n" +
            "Descrição: " + this.getDescricao();
    }

}
