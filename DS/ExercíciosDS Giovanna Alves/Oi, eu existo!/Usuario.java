public class Usuario {
    private String nome;
    private String email;
    private String login;
    private String senha;
    
    public Usuario() {
    this("","","","");
    }
    public Usuario(String email, String login, String senha, String nome){
     this.email = email;
     this.login = login;
     this.nome = nome;
     this.senha = senha;
  }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

   public void provarExistencia() {
        System.out.println("Oi, eu existo!");
   }
}