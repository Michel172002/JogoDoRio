public class Personagem {
    private int id;
    private String nome;

    public Personagem(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public boolean podePilotar(){
        return id < 3;
    }

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
}
