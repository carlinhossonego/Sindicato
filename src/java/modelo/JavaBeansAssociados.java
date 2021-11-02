package modelo;

public class JavaBeansAssociados {

    //********************************************************
    //EMCAPSULAMENTO DOS CAMPOS DA TABELA DO BANCO DE DADOS
    //DEPOIS QUE DIGITOU OS PRIVATE CLIQUE COM O BOTÃO DIREITO
    //NA CLASSE, VAI EM REFATORAR E EM ENCAPSULAR CAMPOS.
    //********************************************************
    private String id_associado;
    private String nome_associado;
    private String endereco_associado;
    private String telefone_associado;
    private String empresa_associado;
    private String cidade_associado;
    private String validade_associado;
    private String dependentes_associado;
    private String cargo_associado;
    private String pesquisar;
    private String nome;
    private String nascimento;
    private String iddependentes;
    private String controle;
    private String Login_associado;
    private String Senha_associado;
    private String Login_associado_sql;
    private String Senha_associado_sql;

    //VARIAVEIS DO BANCO CADASTRO DE EMPRESA   
    private String id_empresa;
    private String nome_empresa;
    private String endereco_empresa;
    private String telefone_empresa;
    private String login_empresa;
    private String senha_empresa;
    private String cnpj_empresa;
    private String id_do_associano;
    private String id2;
    private String id3;

    //PEGAR DATA SERVER
    private String data;

    //CONSTRUTOR
    public JavaBeansAssociados() {
        super();
    }

    public JavaBeansAssociados(String id_associado, String nome_associado, String empresa_associado, String validade_associado) {
        super();
        this.id_associado = id_associado;
        this.nome_associado = nome_associado;
        this.empresa_associado = empresa_associado;
        this.validade_associado = validade_associado;
    }

    public JavaBeansAssociados(String iddependentes, String id_do_associano, String nome, String nascimento, String id2, String id3) {
        super();
        this.iddependentes = iddependentes;
        this.id_do_associano = id_do_associano;
        this.nome = nome;
        this.nascimento = nascimento;
        this.id2 = id2;
        this.id3 = id3;

    }

    public JavaBeansAssociados(String id_empresa, String nome_empresa, String endereco_empresa, String cnpj_empresa, String telefone_empresa) {
        super();
        this.id_empresa = id_empresa;
        this.nome_empresa = nome_empresa;
        this.endereco_empresa = endereco_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.telefone_empresa = telefone_empresa;
    }

    /**
     * @return the id_associado
     */
    public String getId_associado() {
        return id_associado;
    }

    /**
     * @param id_associado the id_associado to set
     */
    public void setId_associado(String id_associado) {
        this.id_associado = id_associado;
    }

    /**
     * @return the id_associado
     */
    public String id_do_associano() {
        return getId_associado();
    }

    /**
     * @param id_associado the id_associado to set
     */
    public void id_do_associano(String id_associado) {
        this.setId_associado(id_associado);
    }

    /**
     * @return the nome_associado
     */
    public String getNome_associado() {
        return nome_associado;
    }

    /**
     * @param nome_associado the nome_associado to set
     */
    public void setNome_associado(String nome_associado) {
        this.nome_associado = nome_associado;
    }

    /**
     * @return the endereco_associado
     */
    public String getEndereco_associado() {
        return endereco_associado;
    }

    /**
     * @param endereco_associado the endereco_associado to set
     */
    public void setEndereco_associado(String endereco_associado) {
        this.endereco_associado = endereco_associado;
    }

    /**
     * @return the telefone_associado
     */
    public String getTelefone_associado() {
        return telefone_associado;
    }

    /**
     * @param telefone_associado the telefone_associado to set
     */
    public void setTelefone_associado(String telefone_associado) {
        this.telefone_associado = telefone_associado;
    }

    /**
     * @return the empresa_associado
     */
    public String getEmpresa_associado() {
        return empresa_associado;
    }

    /**
     * @param empresa_associado the empresa_associado to set
     */
    public void setEmpresa_associado(String empresa_associado) {
        this.empresa_associado = empresa_associado;
    }

    /**
     * @return the cidade_associado
     */
    public String getCidade_associado() {
        return cidade_associado;
    }

    /**
     * @param cidade_associado the cidade_associado to set
     */
    public void setCidade_associado(String cidade_associado) {
        this.cidade_associado = cidade_associado;
    }

    /**
     * @return the validade_associado
     */
    public String getValidade_associado() {
        return validade_associado;
    }

    /**
     * @param validade_associado the validade_associado to set
     */
    public void setValidade_associado(String validade_associado) {
        this.validade_associado = validade_associado;
    }

    /**
     * @return the dependentes_associado
     */
    public String getDependentes_associado() {
        return dependentes_associado;
    }

    /**
     * @param dependentes_associado the dependentes_associado to set
     */
    public void setDependentes_associado(String dependentes_associado) {
        this.dependentes_associado = dependentes_associado;
    }

    /**
     * @return the cargo_associado
     */
    public String getCargo_associado() {
        return cargo_associado;
    }

    /**
     * @param cargo_associado the cargo_associado to set
     */
    public void setCargo_associado(String cargo_associado) {
        this.cargo_associado = cargo_associado;
    }

    /**
     * @return the pesquisar
     */
    public String getPesquisar() {
        return pesquisar;
    }

    /**
     * @param pesquisar the pesquisar to set
     */
    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
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
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the iddependentes
     */
    public String getIddependentes() {
        return iddependentes;
    }

    /**
     * @param iddependentes the iddependentes to set
     */
    public void setIddependentes(String iddependentes) {
        this.iddependentes = iddependentes;
    }

    /**
     * @return the id_empresa
     */
    public String getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the nome_empresa
     */
    public String getNome_empresa() {
        return nome_empresa;
    }

    /**
     * @param nome_empresa the nome_empresa to set
     */
    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    /**
     * @return the endereco_empresa
     */
    public String getEndereco_empresa() {
        return endereco_empresa;
    }

    /**
     * @param endereco_empresa the endereco_empresa to set
     */
    public void setEndereco_empresa(String endereco_empresa) {
        this.endereco_empresa = endereco_empresa;
    }

    /**
     * @return the telefone_empresa
     */
    public String getTelefone_empresa() {
        return telefone_empresa;
    }

    /**
     * @param telefone_empresa the telefone_empresa to set
     */
    public void setTelefone_empresa(String telefone_empresa) {
        this.telefone_empresa = telefone_empresa;
    }

    /**
     * @return the login_empresa
     */
    public String getLogin_empresa() {
        return login_empresa;
    }

    /**
     * @param login_empresa the login_empresa to set
     */
    public void setLogin_empresa(String login_empresa) {
        this.login_empresa = login_empresa;
    }

    /**
     * @return the senha_empresa
     */
    public String getSenha_empresa() {
        return senha_empresa;
    }

    /**
     * @param senha_empresa the senha_empresa to set
     */
    public void setSenha_empresa(String senha_empresa) {
        this.senha_empresa = senha_empresa;
    }

    /**
     * @return the cnpj_empresa
     */
    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    /**
     * @param cnpj_empresa the cnpj_empresa to set
     */
    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the id_do_associano
     */
    public String getId_do_associano() {
        return id_do_associano;
    }

    /**
     * @param id_do_associano the id_do_associano to set
     */
    public void setId_do_associano(String id_do_associano) {
        this.id_do_associano = id_do_associano;
    }

    /**
     * @return the id2
     */
    public String getId2() {
        return id2;
    }

    /**
     * @param id2 the id2 to set
     */
    public void setId2(String id2) {
        this.id2 = id2;
    }

    /**
     * @return the id3
     */
    public String getId3() {
        return id3;
    }

    /**
     * @param id3 the id3 to set
     */
    public void setId3(String id3) {
        this.id3 = id3;
    }

    /**
     * @return the controle
     */
    public String getControle() {
        return controle;
    }

    /**
     * @param controle the controle to set
     */
    public void setControle(String controle) {
        this.controle = controle;
    }

    /**
     * @return the Login_associado
     */
    public String getLogin_associado() {
        return Login_associado;
    }

    /**
     * @param Login_associado the Login_associado to set
     */
    public void setLogin_associado(String Login_associado) {
        this.Login_associado = Login_associado;
    }

    /**
     * @return the Senha_associado
     */
    public String getSenha_associado() {
        return Senha_associado;
    }

    /**
     * @param Senha_associado the Senha_associado to set
     */
    public void setSenha_associado(String Senha_associado) {
        this.Senha_associado = Senha_associado;
    }

    /**
     * @return the Login_associado_sql
     */
    public String getLogin_associado_sql() {
        return Login_associado_sql;
    }

    /**
     * @param Login_associado_sql the Login_associado_sql to set
     */
    public void setLogin_associado_sql(String Login_associado_sql) {
        this.Login_associado_sql = Login_associado_sql;
    }

    /**
     * @return the Senha_associado_sql
     */
    public String getSenha_associado_sql() {
        return Senha_associado_sql;
    }

    /**
     * @param Senha_associado_sql the Senha_associado_sql to set
     */
    public void setSenha_associado_sql(String Senha_associado_sql) {
        this.Senha_associado_sql = Senha_associado_sql;
    }

}
