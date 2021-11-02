package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexao_Pegar_IP {

    //Módulo de conexão
//Parametros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";

//Método de conexão
    private Connection conectar2() {
        Connection conpegarip = null;
        try {
            Class.forName(driver).newInstance();

            //Server Hostgator
            conpegarip = DriverManager.getConnection("jdbc:mysql://br1016.hostgator.com.br:3306/cadgeo82_SINDICATO?useSSL=false", "cadgeo82_carlim", "Car91151185!");

            return conpegarip;

        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public void PegarIp(JavaBeansPegarIp pegarip) {

        String create = "select NOME from IP";

        try {
            Connection con2 = conectar2();
            PreparedStatement pst = con2.prepareStatement(create);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pegarip.setIp(rs.getString(1));

                //JOptionPane.showMessageDialog(null, rs.getString(1));

            }
            con2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void sair() {

        try {
            Connection con = conectar2();
            //JOptionPane.showMessageDialog(null, "sair");
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
