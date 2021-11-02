package modelo;

public class JavaBeansGravarCortes {

    private String idCortes;
    private String associado_id;
    private String associado_iddependente;
    private String data_corte;
    private String id_empresa;
    private String PAGO;
    private Integer controle;

//CONSTRUTOR
    public JavaBeansGravarCortes() {
        super();
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
     * @return the associado_iddependente
     */
    public String getAssociado_iddependente() {
        return associado_iddependente;
    }

    /**
     * @param associado_iddependente the associado_iddependente to set
     */
    public void setAssociado_iddependente(String associado_iddependente) {
        this.associado_iddependente = associado_iddependente;
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
     * @return the PAGO
     */
    public String getPAGO() {
        return PAGO;
    }

    /**
     * @param PAGO the PAGO to set
     */
    public void setPAGO(String PAGO) {
        this.PAGO = PAGO;
    }

    /**
     * @return the controle
     */
    public Integer getControle() {
        return controle;
    }

    /**
     * @param controle the controle to set
     */
    public void setControle(Integer controle) {
        this.controle = controle;
    }

}
