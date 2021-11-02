package modelo;


public class JavaBeansDependentes {
    //VARIAVEIS DO BANCO DEPENDENTES  
    
    private String id_dependente;
    private String nome_dependente;
    private String nascimento_dependente;
    private String id_dependentes_real;
    
    
    //CONSTRUTOR
    public JavaBeansDependentes() {
        super();
    }

    public JavaBeansDependentes(String id_dependente, String nome_dependente, String nascimento_dependente) {
        super();
        this.id_dependente = id_dependente;
        this.nome_dependente = nome_dependente;
        this.nascimento_dependente = nascimento_dependente;
        

    }

    /**
     * @return the id_dependente
     */
    public String getId_dependente() {
        return id_dependente;
    }

    /**
     * @param id_dependente the id_dependente to set
     */
    public void setId_dependente(String id_dependente) {
        this.id_dependente = id_dependente;
    }

    /**
     * @return the nome_dependente
     */
    public String getNome_dependente() {
        return nome_dependente;
    }

    /**
     * @param nome_dependente the nome_dependente to set
     */
    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    /**
     * @return the nascimento_dependente
     */
    public String getNascimento_dependente() {
        return nascimento_dependente;
    }

    /**
     * @param nascimento_dependente the nascimento_dependente to set
     */
    public void setNascimento_dependente(String nascimento_dependente) {
        this.nascimento_dependente = nascimento_dependente;
    }

    /**
     * @return the id_dependentes_real
     */
    public String getId_dependentes_real() {
        return id_dependentes_real;
    }

    /**
     * @param id_dependentes_real the id_dependentes_real to set
     */
    public void setId_dependentes_real(String id_dependentes_real) {
        this.id_dependentes_real = id_dependentes_real;
    }
}
