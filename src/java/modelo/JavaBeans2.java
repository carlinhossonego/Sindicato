package modelo;

public class JavaBeans2 {
//VARIAVEIS DO BANCO CADASTRO DE EMPRESA   

    private String id_user;
    private String nome_user;
    private String login_user;
    private String senha_user;

    //CONSTRUTOR
    public JavaBeans2() {
        super();
    }

    public JavaBeans2(String id_user, String nome_user, String login_user, String senha_user) {
        super();
        this.id_user = id_user;
        this.nome_user = nome_user;
        this.login_user = login_user;
        this.senha_user = senha_user;

    }

    /**
     * @return the id_user
     */
    public String getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the login_user
     */
    public String getLogin_user() {
        return login_user;
    }

    /**
     * @param login_user the login_user to set
     */
    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    /**
     * @return the senha_user
     */
    public String getSenha_user() {
        return senha_user;
    }

    /**
     * @param senha_user the senha_user to set
     */
    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }

    /**
     * @return the nome_user
     */
    public String getNome_user() {
        return nome_user;
    }

    /**
     * @param nome_user the nome_user to set
     */
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

}
