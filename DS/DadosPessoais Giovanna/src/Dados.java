 public class Dados {
    private String nome;
    private int idade;
    private String sexo;
    private String interesses;
    private String estadoCivil;

    public Dados() {
        this("", 0 , "", "", "");
    }

    
    public Dados(String nome, int idade, String sexo, String interesses, String estadoCivil) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.interesses = interesses;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
