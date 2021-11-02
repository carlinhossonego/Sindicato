package modelo;

public class JavaBeansRelatorioRoot {

    private String ID_cortes;
    private String Associado_ID;
    private String Associado_Id_Dependente;
    private String Data_Corte;
    private String ID_Empresa;
    private String Pago;
    private String Nome;
    private String Nome1;
    private String Nome2;
    private String DataI1;
    private String DataI2;
    private String DataF1;
    private String DataF2;
    private String Pago1;
    private String Pago2;
    private String E_OU;
    private String Campo;
    private String Campo3;
    private String Nomeempresa;
    private String[] Valor_pego;

    //CONSTRUTOR
    public JavaBeansRelatorioRoot() {
        super();
    }

    public JavaBeansRelatorioRoot(String ID_cortes, String Associado_ID, String Associado_Id_Dependente, String Data_Corte, String ID_Empresa, String Pago) {
        super();
        this.ID_cortes = ID_cortes;
        this.Associado_ID = Associado_ID;
        this.Associado_Id_Dependente = Associado_Id_Dependente;
        this.Data_Corte = Data_Corte;
        this.ID_Empresa = ID_Empresa;
        this.Pago = Pago;

    }

    public JavaBeansRelatorioRoot(String ID_cortes, String Associado_ID, String Associado_Id_Dependente, String Data_Corte, String ID_Empresa, String Pago, String Nomeempresa) {
        super();
        this.ID_cortes = ID_cortes;
        this.Associado_ID = Associado_ID;
        this.Associado_Id_Dependente = Associado_Id_Dependente;
        this.Data_Corte = Data_Corte;
        this.ID_Empresa = ID_Empresa;
        this.Pago = Pago;
        this.Nomeempresa = Nomeempresa;

    }

    /**
     * @return the Nomeempresa
     */
    public String getNomeempresa() {
        return Nomeempresa;
    }

    /**
     * @param Nomeempresa the Nomeempresa to set
     */
    public void setNomeempresa(String Nomeempresa) {
        this.Nomeempresa = Nomeempresa;
    }

    /**
     * @return the Campo
     */
    public String getCampo() {
        return Campo;
    }

    /**
     * @param Campo the Campo to set
     */
    public void setCampo(String Campo) {
        this.Campo = Campo;
    }

    /**
     * @return the Campo3
     */
    public String getCampo3() {
        return Campo3;
    }

    /**
     * @param Campo3 the Campo3 to set
     */
    public void setCampo3(String Campo3) {
        this.Campo3 = Campo3;
    }

    /**
     * @return the ID_cortes
     */
    public String getID_cortes() {
        return ID_cortes;
    }

    /**
     * @param ID_cortes the ID_cortes to set
     */
    public void setID_cortes(String ID_cortes) {
        this.ID_cortes = ID_cortes;
    }

    /**
     * @return the Associado_ID
     */
    public String getAssociado_ID() {
        return Associado_ID;
    }

    /**
     * @param Associado_ID the Associado_ID to set
     */
    public void setAssociado_ID(String Associado_ID) {
        this.Associado_ID = Associado_ID;
    }

    /**
     * @return the Associado_Id_Dependente
     */
    public String getAssociado_Id_Dependente() {
        return Associado_Id_Dependente;
    }

    /**
     * @param Associado_Id_Dependente the Associado_Id_Dependente to set
     */
    public void setAssociado_Id_Dependente(String Associado_Id_Dependente) {
        this.Associado_Id_Dependente = Associado_Id_Dependente;
    }

    /**
     * @return the Data_Corte
     */
    public String getData_Corte() {
        return Data_Corte;
    }

    /**
     * @param Data_Corte the Data_Corte to set
     */
    public void setData_Corte(String Data_Corte) {
        this.Data_Corte = Data_Corte;
    }

    /**
     * @return the ID_Empresa
     */
    public String getID_Empresa() {
        return ID_Empresa;
    }

    /**
     * @param ID_Empresa the ID_Empresa to set
     */
    public void setID_Empresa(String ID_Empresa) {
        this.ID_Empresa = ID_Empresa;
    }

    /**
     * @return the Pago
     */
    public String getPago() {
        return Pago;
    }

    /**
     * @param Pago the Pago to set
     */
    public void setPago(String Pago) {
        this.Pago = Pago;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Nome1
     */
    public String getNome1() {
        return Nome1;
    }

    /**
     * @param Nome1 the Nome1 to set
     */
    public void setNome1(String Nome1) {
        this.Nome1 = Nome1;
    }

    /**
     * @return the Nome2
     */
    public String getNome2() {
        return Nome2;
    }

    /**
     * @param Nome2 the Nome2 to set
     */
    public void setNome2(String Nome2) {
        this.Nome2 = Nome2;
    }

    /**
     * @return the DataI1
     */
    public String getDataI1() {
        return DataI1;
    }

    /**
     * @param DataI1 the DataI1 to set
     */
    public void setDataI1(String DataI1) {
        this.DataI1 = DataI1;
    }

    /**
     * @return the DataI2
     */
    public String getDataI2() {
        return DataI2;
    }

    /**
     * @param DataI2 the DataI2 to set
     */
    public void setDataI2(String DataI2) {
        this.DataI2 = DataI2;
    }

    /**
     * @return the DataF1
     */
    public String getDataF1() {
        return DataF1;
    }

    /**
     * @param DataF1 the DataF1 to set
     */
    public void setDataF1(String DataF1) {
        this.DataF1 = DataF1;
    }

    /**
     * @return the DataF2
     */
    public String getDataF2() {
        return DataF2;
    }

    /**
     * @param DataF2 the DataF2 to set
     */
    public void setDataF2(String DataF2) {
        this.DataF2 = DataF2;
    }

    /**
     * @return the Pago1
     */
    public String getPago1() {
        return Pago1;
    }

    /**
     * @param Pago1 the Pago1 to set
     */
    public void setPago1(String Pago1) {
        this.Pago1 = Pago1;
    }

    /**
     * @return the Pago2
     */
    public String getPago2() {
        return Pago2;
    }

    /**
     * @param Pago2 the Pago2 to set
     */
    public void setPago2(String Pago2) {
        this.Pago2 = Pago2;
    }

    /**
     * @return the E_OU
     */
    public String getE_OU() {
        return E_OU;
    }

    /**
     * @param E_OU the E_OU to set
     */
    public void setE_OU(String E_OU) {
        this.E_OU = E_OU;
    }

    /**
     * @return the Valor_pego
     */
    public String[] getValor_pego() {
        return Valor_pego;
    }

    /**
     * @param Valor_pego the Valor_pego to set
     */
    public void setValor_pego(String[] Valor_pego) {
        this.Valor_pego = Valor_pego;
    }

   

}
