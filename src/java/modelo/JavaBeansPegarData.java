package modelo;

public class JavaBeansPegarData {

    private String Data_Do_servidor;

    //CONSTRUTOR
    public JavaBeansPegarData() {
        super();
    }

    public JavaBeansPegarData(String Data_Do_servidor) {
        super();
        this.Data_Do_servidor = Data_Do_servidor;

    }

    /**
     * @return the Data_Do_servidor
     */
    public String getData_Do_servidor() {
        return Data_Do_servidor;
    }

    /**
     * @param Data_Do_servidor the Data_Do_servidor to set
     */
    public void setData_Do_servidor(String Data_Do_servidor) {
        this.Data_Do_servidor = Data_Do_servidor;
    }
}
