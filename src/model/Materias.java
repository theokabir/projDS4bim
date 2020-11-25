package model;
public class Materias {
    public Materias(){
        
    }
    
    private int id;
    private String nome;
    private int carga_horaria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
