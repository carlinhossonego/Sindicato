package modelo;


public class JavaBeansServicos {
    private String idCortes;
    private String associado_id;
    private String associado_iddependentes;
    private String data_corte;
    private String id_empresa;
    private String nome;

    //CONSTRUTOR
    public JavaBeansServicos() {
        super();
    }

    public JavaBeansServicos(String idCortes, String associado_id, String associado_iddependentes, String data_corte, String id_empresa) {
        super();
        this.idCortes = idCortes;
        this.associado_id = associado_id;
        this.associado_iddependentes = associado_iddependentes;
        this.data_corte = data_corte;
        this.id_empresa = id_empresa;

    }
    
       public JavaBeansServicos(String idCortes) {
        super();
        this.idCortes = idCortes;


    }
    
    
    
    
    
    
    
    /**
     * @return the idCortes
     */
    public String getIdCortes() {
        return idCortes;
    }

    /**
     * @param idCortes the idCortes to set
     */
    public void setIdCortes(String idCortes) {
        this.idCortes = idCortes;
    }

    /**
     * @return the associado_id
     */
    public String getAssociado_id() {
        return associado_id;
    }

    /**
     * @param associado_id the associado_id to set
     */
    public void setAssociado_id(String associado_id) {
        this.associado_id = associado_id;
    }

    /**
     * @return the associado_iddependentes
     */
    public String getAssociado_iddependentes() {
        return associado_iddependentes;
    }

    /**
     * @param associado_iddependentes the associado_iddependentes to set
     */
    public void setAssociado_iddependentes(String associado_iddependentes) {
        this.associado_iddependentes = associado_iddependentes;
    }

    /**
     * @return the data_corte
     */
    public String getData_corte() {
        return data_corte;
    }

    /**
     * @param data_corte the data_corte to set
     */
    public void setData_corte(String data_corte) {
        this.data_corte = data_corte;
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
    
}
