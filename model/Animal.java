package model;

public class Animal {

    // Atributos da classe Animal.
    private int id;
    private String nome;
    // Cada Animal possui uma Jaula.
    Jaula jaula;

    // Método construtor de Animal.
    public Animal(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Jaula getJaula() {
        return jaula;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }
    
    // Método para comparar objeto com Animal:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }

        Animal animal = (Animal) o;
        return this.getId() == animal.getId();
    }

    // ToString da classe Animal.
    @Override
    public String toString() {
        return 
        "Animal! \n" +
        "ID: " + this.getId() + "\n" +
        "Nome: " + this.getNome();
    }

}
