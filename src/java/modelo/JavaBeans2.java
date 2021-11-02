package modelo;

public class JavaBeans2 {
//VARIAVEIS DO BANCO CADASTRO DE EMPRESA   

    private String id_user;
    private String nome_user;
    private String login_user;
    private String senha_user;
    private String login_user_sql;
    private String senha_user_sql;
    private String nome_user_sql;
    private String pesquisa;
    private String nome_menu;

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

    public JavaBeans2(String login_user, String senha_user, String nome_user) {
        super();
        this.login_user = login_user;
        this.senha_user = senha_user;
        this.nome_user = nome_user;

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

    /**
     * @return the login_user_sql
     */
    public String getLogin_user_sql() {
        return login_user_sql;
    }

    /**
     * @param login_user_sql the login_user_sql to set
     */
    public void setLogin_user_sql(String login_user_sql) {
        this.login_user_sql = login_user_sql;
    }

    /**
     * @return the senha_user_sql
     */
    public String getSenha_user_sql() {
        return senha_user_sql;
    }

    /**
     * @param senha_user_sql the senha_user_sql to set
     */
    public void setSenha_user_sql(String senha_user_sql) {
        this.senha_user_sql = senha_user_sql;
    }

    /**
     * @return the nome_user_sql
     */
    public String getNome_user_sql() {
        return nome_user_sql;
    }

    /**
     * @param nome_user_sql the nome_user_sql to set
     */
    public void setNome_user_sql(String nome_user_sql) {
        this.nome_user_sql = nome_user_sql;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the nome_menu
     */
    public String getNome_menu() {
        return nome_menu;
    }

    /**
     * @param nome_menu the nome_menu to set
     */
    public void setNome_menu(String nome_menu) {
        this.nome_menu = nome_menu;
    }

}
