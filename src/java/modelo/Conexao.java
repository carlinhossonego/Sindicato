package modelo;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Conexao {

//Módulo de conexão
//Parametros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    String texto;

//Método de conexão
    private Connection conectar() {
        String IP2 = null;
        IP2 = "sindmotrope.ddns.net:3306";
        Connection con = null;
        try {
            Class.forName(driver).newInstance();
            /**
             * con - estabelece uma seção com o banco DriverManager - gerencia o
             * driver do banco .getConnection - obtem os parametros de conexao
             * url, user, password - as minhas variaveis
             *
             */

            //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Sindicato?useTimezone=true&serverTimezone=UTC", "root", "root");
            //con = DriverManager.getConnection("jdbc:mysql://br1016.hostgator.com.br:3306/cadgeo82_SINDICATO?useTimezone=true&serverTimezone=UTC", "cadgeo82_carlim", "Car91151185!");
            //Server Hostgator
            //con = DriverManager.getConnection("jdbc:mysql://br1016.hostgator.com.br:3306/cadgeo82_SINDICATO?useSSL=false", "cadgeo82_carlim", "Car91151185!");
            //Server Online Carlim
            //con = DriverManager.getConnection("jdbc:mysql://201.33.203.234:3306/Sindicato?useSSL=false", "teste", "teste123");
            con = DriverManager.getConnection("jdbc:mysql://" + IP2 + "/Sindicato?useSSL=false", "teste", "teste123");
            return con;

        } catch (Exception e) {
            System.out.print(e);
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    //Teste de conexão
    public void testeConexao() {
        try {
            Connection con = conectar();
            //System.out.println(con);
            ////JOptionPane.showMessageDialog(null, con);
            con.close();
        } catch (Exception e) {
            //System.out.println(e);
            // //JOptionPane.showMessageDialog(null, e);
        }
    }

    //Perquisar Para empresa
    public ArrayList<JavaBeansRelatorioRoot> relatorios_root(JavaBeansRelatorioRoot relatorios_root) {
        String Empresa = relatorios_root.getNomeempresa();
        String DataI2 = relatorios_root.getDataI2();
        String DataF2 = relatorios_root.getDataF2();
        String Pago2 = relatorios_root.getPago2();
        String E_OU = relatorios_root.getE_OU();
        String Campo3 = relatorios_root.getCampo3();
        String read = "";

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansRelatorioRoot> relatorios_rootc = new ArrayList<>();

        if ("-".equals(E_OU)) {
            read = "SELECT Cortes.idCortes,Cortes.associado_id,Cortes.associado_iddependente,date_format(str_to_date(Cortes.data_corte, '%Y-%m-%d'), '%d/%m/%Y') as Data_Corte,Cortes.id_empresa,Cortes.PAGO, Associado.nome as nome_associado,Dependentes.nome,Empresa.nome as nome_empresa from Cortes\n"
                    + "inner join Associado on Associado.id = Cortes.associado_id\n"
                    + "inner join Empresa on Empresa.id = Cortes.id_empresa\n"
                    + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                    + " where Empresa.nome like '%" + Empresa + "%'";

        } else {

            if ("pago2".equals(Campo3)) {
                read = "SELECT Cortes.idCortes,Cortes.associado_id,Cortes.associado_iddependente,date_format(str_to_date(Cortes.data_corte, '%Y-%m-%d'), '%d/%m/%Y') as Data_Corte,Cortes.id_empresa,Cortes.PAGO, Associado.nome as nome_associado,Dependentes.nome,Empresa.nome as nome_empresa from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Empresa on Empresa.id = Cortes.id_empresa\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Empresa.nome like '%" + Empresa + "%' and Cortes.PAGO= '" + Pago2 + "'";
            }

            if ("data2".equals(Campo3)) {
                read = "SELECT Cortes.idCortes,Cortes.associado_id,Cortes.associado_iddependente,date_format(str_to_date(Cortes.data_corte, '%Y-%m-%d'), '%d/%m/%Y') as Data_Corte,Cortes.id_empresa,Cortes.PAGO, Associado.nome as nome_associado,Dependentes.nome,Empresa.nome as nome_empresa from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Empresa on Empresa.id = Cortes.id_empresa\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Empresa.nome like '%" + Empresa + "%' and Cortes.data_corte between '" + DataI2 + "' and '" + DataF2 + "'";
            }

        }

        //TESTE DE RECEBIMENTO DOS DADOS 
        ////JOptionPane.showMessageDialog(null, read);
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String ID_cortes = rs.getString(1);
                String Associado_ID = rs.getString(7);
                String Associado_Id_Dependente = rs.getString(8);
                String Data_Corte = rs.getString(4);
                String ID_Empresa = rs.getString(5);
                String Pago = rs.getString(6);
                String Nomeempresa = rs.getString(9);

                //colocando no Arraylist
                relatorios_rootc.add(new JavaBeansRelatorioRoot(ID_cortes, Associado_ID, Associado_Id_Dependente, Data_Corte, ID_Empresa, Pago, Nomeempresa));
            }
            con.close();
            return relatorios_rootc;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansRelatorioRoot> relatoriotodo(JavaBeansRelatorioRoot relatoriotodo2) {

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansRelatorioRoot> relatoriotodo = new ArrayList<>();

        String read = "SELECT Cortes.idCortes,Cortes.associado_id,Cortes.associado_iddependente,date_format(str_to_date(Cortes.data_corte, '%Y-%m-%d'), '%d/%m/%Y') as Data_Corte,Cortes.id_empresa,Cortes.PAGO, Associado.nome as nome_associado,Dependentes.nome,Empresa.nome as nome_empresa from Cortes\n"
                + "inner join Associado on Associado.id = Cortes.associado_id\n"
                + "inner join Empresa on Empresa.id = Cortes.id_empresa\n"
                + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente limit 100";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco

                String ID_cortes = rs.getString(1);
                String Associado_ID = rs.getString(7);
                String Associado_Id_Dependente = rs.getString(8);
                String Data_Corte = rs.getString(4);
                String ID_Empresa = rs.getString(5);
                String Pago = rs.getString(6);
                String Nomeempresa = rs.getString(9);

                String nome;
                nome = rs.getString(8);
                if (nome.equals("Principal")) {
                    Associado_Id_Dependente = "";
                } else {
                    Associado_Id_Dependente = rs.getString(7);

                }

                //colocando no Arraylist
                relatoriotodo.add(new JavaBeansRelatorioRoot(ID_cortes, Associado_ID, Associado_Id_Dependente, Data_Corte, ID_Empresa, Pago, Nomeempresa));
            }
            con.close();
            return relatoriotodo;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansRelatorios> relatorio(JavaBeansRelatorios relatorios) {
        String id = relatorios.getID_Empresa();

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansRelatorios> relatorio = new ArrayList<>();

        String read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                + "inner join Associado on Associado.id = Cortes.associado_id\n"
                + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                + "where Cortes.id_empresa = " + id + "";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String ID_cortes = rs.getString(1);
                String Associado_ID = rs.getString(7);
                String Associado_Id_Dependente = rs.getString(8);
                String Data_Corte = rs.getString(4);
                String ID_Empresa = rs.getString(5);
                String Pago = rs.getString(6);

                //colocando no Arraylist
                relatorio.add(new JavaBeansRelatorios(ID_cortes, Associado_ID, Associado_Id_Dependente, Data_Corte, ID_Empresa, Pago));
            }
            con.close();
            return relatorio;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansRelatorios> relatorios_nome(JavaBeansRelatorios relatorios) {
        String Nome1 = relatorios.getNome1();
        String Nome2 = relatorios.getNome2();
        String DataI1 = relatorios.getDataI1();
        String DataI2 = relatorios.getDataI2();
        String DataF1 = relatorios.getDataF1();
        String DataF2 = relatorios.getDataF2();
        String Pago1 = relatorios.getPago1();
        String Pago2 = relatorios.getPago2();
        String E_OU = relatorios.getE_OU();
        String Campo = relatorios.getCampo();
        String Campo3 = relatorios.getCampo3();
        String id = relatorios.getID_Empresa();
        String read = "";

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansRelatorios> relatorios_nome = new ArrayList<>();

        ////JOptionPane.showMessageDialog(null, Campo);
        if ("-".equals(E_OU)) {
            if ("nome".equals(Campo)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Associado.nome like '%" + Nome1 + "%'";
            }
            if ("data".equals(Campo)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Cortes.data_corte between '" + DataI1 + "' and '" + DataF1 + "'";
            }
            if ("pago".equals(Campo)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Cortes.PAGO= '" + Pago1 + "'";
            }
        } else {
            if ("nome".equals(Campo) && "data2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Associado.nome like '%" + Nome1 + "%' and Cortes.data_corte between '" + DataI2 + "' and '" + DataF2 + "'";
            }
            if ("nome".equals(Campo) && "pago2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Associado.nome like '%" + Nome1 + "%' and Cortes.PAGO= '" + Pago2 + "'";
            }
            if ("data".equals(Campo) && "nome2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Associado.nome like '%" + Nome2 + "%' and Cortes.data_corte between '" + DataI1 + "' and '" + DataF1 + "'";
            }
            if ("data".equals(Campo) && "pago2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Cortes.data_corte between '" + DataI1 + "' and '" + DataF1 + "' and Cortes.PAGO= '" + Pago2 + "'";
            }
            if ("pago".equals(Campo) && "nome2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Associado.nome like '%" + Nome2 + "%' and Cortes.PAGO= '" + Pago1 + "'";
            }
            if ("pago".equals(Campo) && "data2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " and Cortes.data_corte between '" + DataI2 + "' and '" + DataF2 + "' and Cortes.PAGO= '" + Pago1 + "'";
            }
            if ("pago".equals(Campo) && "pago2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " ";
            }
            if ("nome".equals(Campo) && "nome2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " ";
            }
            if ("data".equals(Campo) && "data2".equals(Campo3)) {
                read = "SELECT Cortes.*,Associado.nome as nome_associado,Dependentes.nome from Cortes\n"
                        + "inner join Associado on Associado.id = Cortes.associado_id\n"
                        + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n"
                        + "where Cortes.id_empresa = " + id + " ";
            }
        }

        //TESTE DE RECEBIMENTO DOS DADOS 
        ////JOptionPane.showMessageDialog(null, read);
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String ID_cortes = rs.getString(1);
                String Associado_ID = rs.getString(7);
                String Associado_Id_Dependente = rs.getString(8);
                String Data_Corte = rs.getString(4);
                String ID_Empresa = rs.getString(5);
                String Pago = rs.getString(6);

                //colocando no Arraylist
                relatorios_nome.add(new JavaBeansRelatorios(ID_cortes, Associado_ID, Associado_Id_Dependente, Data_Corte, ID_Empresa, Pago));
            }
            con.close();
            return relatorios_nome;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    // ASSOCIADO
    //Primeira tabela Acesso total
    public void validacao(JavaBeans2 user) {
        String read = "select * from Usuario where login = ? and senha = ?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setString(1, user.getLogin_user());
            pst.setString(2, user.getSenha_user());
            ResultSet rs = pst.executeQuery();

            //Saber se encontrou registros com o SQL
         

            /**
             * while (rs.next()) { user.setLogin_user_sql(rs.getString(2));
             * user.setSenha_user_sql(rs.getString(3));
             * user.setNome_user_sql(rs.getString(4));
             *
             * ////JOptionPane.showMessageDialog(null, rs.getString(4)); }
             *
             */
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }

    }

    public void validacao2(JavaBeansAssociados empresa) {
        String read = "select * from Empresa where login = ? and senha = ?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setString(1, empresa.getLogin_empresa());
            pst.setString(2, empresa.getSenha_empresa());
            ResultSet rs = pst.executeQuery();

            //Saber se encontrou registros com o SQL
            if (rs.next()) {
                int rows;
                rows = rs.getRow();
                // Move to beginning
                if (rows == 1) {
                    empresa.setId_empresa(rs.getString(1));
                    empresa.setLogin_empresa(rs.getString(5));
                    empresa.setSenha_empresa(rs.getString(6));
                    empresa.setNome_empresa(rs.getString(2));
                }
            } else {
                empresa.setLogin_empresa("");
                empresa.setSenha_empresa("");
                empresa.setNome_empresa("");
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }

    }

    public void inserirAssociado(JavaBeansAssociados associado) {
        String create = "insert into Associado (id,nome,endereco,telefone,empresa,cidade,validade,dependentes,cargo) values (?,?,?,?,?,?,?,?,?)";
        try {

            //Abrir a conexão
            Connection con = conectar();

            // Preparar a query
            PreparedStatement pst = con.prepareCall(create);

            // Substitur os ? pelos valores
            pst.setString(1, associado.getId_associado());
            pst.setString(2, associado.getNome_associado());
            pst.setString(3, associado.getEndereco_associado());
            pst.setString(4, associado.getTelefone_associado());
            pst.setString(5, associado.getEmpresa_associado());
            pst.setString(6, associado.getCidade_associado());
            pst.setString(7, associado.getValidade_associado());
            pst.setString(8, associado.getDependentes_associado());
            pst.setString(9, associado.getCargo_associado());

            //Executar a query
            pst.executeUpdate();

            //Encerrar a conexão
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansAssociados> listarAssociado() {

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> associado = new ArrayList<>();

        String read = "select id, nome, empresa, date_format(str_to_date(validade, '%Y-%m-%d'), '%d/%m/%Y')as validade from Associado order by nome limit 10";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_associado = rs.getString(1);
                String nome_associado = rs.getString(2);
                String empresa_associado = rs.getString(3);
                String validade_associado = rs.getString(4);

                //colocando no Arraylist
                associado.add(new JavaBeansAssociados(id_associado, nome_associado, empresa_associado, validade_associado));
            }
            con.close();
            return associado;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansAssociados> pesquisaAssociado(JavaBeansAssociados associado) {

        String pesquisa = associado.getPesquisar();
        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> pesquisaassociado = new ArrayList<>();

        String read = "select id, nome, empresa, date_format(str_to_date(validade, '%Y-%m-%d'), '%d/%m/%Y')as validade from Associado where nome like '%" + pesquisa + "%' order by nome";
        //String read = "select id, nome, empresa, validade from Associado where nome like '%Ne%' order by nome limit 10";

        //TESTE DE RECEBIMENTO DOS DADOS 
        // //JOptionPane.showMessageDialog(null, pesquisa);
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_associado = rs.getString(1);
                String nome_associado = rs.getString(2);
                String empresa_associado = rs.getString(3);
                String validade_associado = rs.getString(4);

                //colocando no Arraylist
                pesquisaassociado.add(new JavaBeansAssociados(id_associado, nome_associado, empresa_associado, validade_associado));
            }
            con.close();
            return pesquisaassociado;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void selecionarAssociado(JavaBeansAssociados associado) {
        String read2 = "select Associado.id,Associado.nome,Associado.endereco,Associado.telefone,Associado.empresa,\n"
                + "Associado.cidade, date_format(str_to_date(Associado.validade, '%Y-%m-%d'), '%d/%m/%Y')as validade, Associado.dependentes,Associado.cargo from Associado where id = ?";

//String read2 = "select * from Associado where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, associado.getId_associado());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                associado.setId_associado(rs.getString(1));
                associado.setNome_associado(rs.getString(2));
                associado.setEndereco_associado(rs.getString(3));
                associado.setTelefone_associado(rs.getString(4));
                associado.setEmpresa_associado(rs.getString(5));
                associado.setCidade_associado(rs.getString(6));
                associado.setValidade_associado(rs.getString(7));
                associado.setDependentes_associado(rs.getString(8));
                associado.setCargo_associado(rs.getString(9));
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void selecionarAssociadoCorte(JavaBeansAssociados associado) {
        String read2 = "select Associado.id,Associado.nome,Associado.endereco,Associado.telefone,Associado.empresa,\n"
                + "Associado.cidade, date_format(str_to_date(Associado.validade, '%Y-%m-%d'), '%d/%m/%Y')as validade, Associado.dependentes,Associado.cargo from Associado where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, associado.getId_associado());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                associado.setId_associado(rs.getString(1));
                associado.setNome_associado(rs.getString(2));
                associado.setEndereco_associado(rs.getString(3));
                associado.setCidade_associado(rs.getString(6));
                associado.setValidade_associado(rs.getString(7));

            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void PegarDataDoServidor(JavaBeansPegarData data) {
        String read2 = "SELECT DATE_FORMAT(NOW(),'%d/%m/%Y') AS hoje";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.setData_Do_servidor(rs.getString(1));
                ////JOptionPane.showMessageDialog(null, data.getData_Do_servidor());
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void inserircortes(JavaBeansGravarCortes cortes) {

        String create = "insert into Cortes (associado_id,associado_iddependente,data_corte,id_empresa,PAGO) values (?,?,?,?,?)";
        try {

            //Abrir a conexão
            Connection con = conectar();

            // Preparar a query
            PreparedStatement pst = con.prepareCall(create);

            // Substitur os ? pelos valores
            pst.setString(1, cortes.getAssociado_id());

            if (cortes.getAssociado_iddependente() == null) {
                pst.setString(2, "0");
            } else {
                pst.setString(2, cortes.getAssociado_iddependente());
            }

            pst.setString(3, cortes.getData_corte());
            pst.setString(4, cortes.getId_empresa());
            pst.setString(5, cortes.getPAGO());

            //Executar a query
            pst.executeUpdate();

            //Encerrar a conexão
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void PegarValidade(JavaBeansAssociados validade) {
        String ID, IDAssociado;
        String read2 = "";
        ID = validade.getIddependentes();
        IDAssociado = validade.getId_associado();
        ////JOptionPane.showMessageDialog(null, ID + "ID do Dependente");

        read2 = "select Associado.id,Associado.nome,Associado.endereco,Associado.telefone,Associado.empresa,\n"
                + "Associado.cidade, date_format(str_to_date(Associado.validade, '%Y-%m-%d'), '%d/%m/%Y')as validade, Associado.dependentes,Associado.cargo from Associado where id = " + IDAssociado + "";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validade.setId_associado(rs.getString(1));
                validade.setValidade_associado(rs.getString(7));

                ////JOptionPane.showMessageDialog(null, validade.getId_associado());
                ////JOptionPane.showMessageDialog(null, validade.getValidade_associado());
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarAssociado(JavaBeansAssociados associado) {
        String create = "update Associado set nome=?, endereco=?, telefone=?, empresa=?, cidade=?, validade=?, dependentes=?, cargo=? where id=?";
        //String id = associado.getId_associado();
        ////JOptionPane.showMessageDialog(null, id);
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, associado.getNome_associado());
            pst.setString(2, associado.getEndereco_associado());
            pst.setString(3, associado.getTelefone_associado());
            pst.setString(4, associado.getEmpresa_associado());
            pst.setString(5, associado.getCidade_associado());
            pst.setString(6, associado.getValidade_associado());
            pst.setString(7, associado.getDependentes_associado());
            pst.setString(8, associado.getCargo_associado());
            pst.setString(9, associado.getId_associado());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    //******************************************************************************************************
    // DEPENDENTES
    public void inserirDependentes(JavaBeansDependentes dependentes) {
        String create = "insert into Dependentes (iddependentes,nome,nascimento) values (?,?,?)";
        try {

            //Abrir a conexão
            Connection con = conectar();

            // Preparar a query
            PreparedStatement pst = con.prepareCall(create);

            // Substitur os ? pelos valores
            pst.setString(1, dependentes.getId_dependente());
            pst.setString(2, dependentes.getNome_dependente());
            pst.setString(3, dependentes.getNascimento_dependente());

            //Executar a query
            pst.executeUpdate();

            //Encerrar a conexão
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansAssociados> listarDependentes(JavaBeansAssociados associado) {
        String id = associado.getId_associado();
        ////JOptionPane.showMessageDialog(null, id);

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> listarDependentes = new ArrayList<>();

        //String read = "select id, nome, nascimento from Dependentes where iddependentes = " + id + " order by nome;";
        String read = "select Dependentes.id as id, Dependentes.iddependentes as id_do_associano, Dependentes.nome as nome, date_format(str_to_date(Dependentes.nascimento, '%Y-%m-%d'), '%d/%m/%Y') as nascimento, Dependentes.id as id, Dependentes.id as id from Dependentes where iddependentes = " + id + " order by nome;";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String iddependentes = rs.getString(1);
                String id_do_associano = rs.getString(2);
                String nome = rs.getString(3);
                String nascimento = rs.getString(4);
                String id2 = rs.getString(5);
                String id3 = rs.getString(6);

                //colocando no Arraylist
               
            }
            con.close();
            return listarDependentes;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void selecionarDependente(JavaBeansDependentes dependente) {
        String read2 = "select * from Dependentes where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, dependente.getId_dependentes_real());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dependente.setId_dependentes_real(rs.getString(1));
                dependente.setNome_dependente(rs.getString(2));
                dependente.setNascimento_dependente(rs.getString(3));

            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarDependente(JavaBeansDependentes dependentes) {
        String create = "update Dependentes set nome=?, nascimento=? where id=?";
        //String id = associado.getId_associado();
        ////JOptionPane.showMessageDialog(null, id);
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, dependentes.getNome_dependente());
            pst.setString(2, dependentes.getNascimento_dependente());
            pst.setString(3, dependentes.getId_dependentes_real());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void sair() {

        try {
            Connection con = conectar();

            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    //******************************************************************************************************
    //  USER ******************************************************************************************************
    public void inserirUser(JavaBeans2 user) {
        String create = "insert into Usuario (login,senha,nome) values (?,?,?)";
        try {

            //Abrir a conexão
            Connection con = conectar();

            // Preparar a query
            PreparedStatement pst = con.prepareCall(create);

            // Substitur os ? pelos valores
            pst.setString(1, user.getLogin_user());
            pst.setString(2, user.getSenha_user());
            pst.setString(3, user.getNome_user());

            //Executar a query
            pst.executeUpdate();

            //Encerrar a conexão
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansServicos> listarServicos(JavaBeansServicos servicos2) {

        String id = servicos2.getAssociado_id();

        String idDependente = servicos2.getAssociado_iddependentes();

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansServicos> servicos = new ArrayList<>();

        //String read = "select idCortes, associado_id, associado_iddependente, data_corte,id_empresa from Cortes order by data_corte limit 10";
        //String read = "select count(Cortes.idcortes) as totaldecortedomes, associado_iddependente, id_empresa, PAGO, data_corte from Cortes where Cortes.associado_id = 5551 and month(Cortes.data_corte) = month(now()) and year (Cortes.data_corte) = year (Cortes.data_corte) and Cortes.pago = 0";
        String read = "select Cortes.associado_iddependente as Dependente, Cortes.data_corte,Cortes.id_empresa,Empresa.nome as Nome_da_Empresa,Dependentes.nome as nome_Dependente from Cortes \n"
                + "INNER JOIN Empresa on Empresa.id = Cortes.id_empresa \n"
                + "INNER JOIN Dependentes on Dependentes.id = Cortes.associado_iddependente \n"
                + "where  Cortes.associado_id = " + id + " and month(Cortes.data_corte) = month(now()) and year (Cortes.data_corte) = year (Cortes.data_corte) and Cortes.pago = 0;";
        ////JOptionPane.showMessageDialog(null, read);
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String idCortes = rs.getString(1);
                String associado_id = rs.getString(5);
                String associado_iddependentes = rs.getString(2);
                String data_corte = rs.getString(4);
                String id_empresa = rs.getString(5);

                String nome = servicos2.getNome();
                if ("Principal".equals(associado_id)) {
                    associado_id = nome;
                }

                //colocando no Arraylist
                //servicos.add(new JavaBeansServicos(idCortes));
                servicos.add(new JavaBeansServicos(idCortes, associado_id, associado_iddependentes, data_corte, id_empresa));
            }
            con.close();
            return servicos;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    public ArrayList<JavaBeans2> listarUser() {

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeans2> user = new ArrayList<>();

        String read = "select id, login, senha, nome from Usuario order by nome limit 10";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_user = rs.getString(1);
                String nome_user = rs.getString(4);
                String login_user = rs.getString(2);
                String senha_user = rs.getString(3);

                //colocando no Arraylist
                user.add(new JavaBeans2(id_user, nome_user, login_user, senha_user));
            }
            con.close();
            return user;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeans2> listarUserPesquisa(JavaBeans2 pesquisa) {
        
       
        //JOptionPane.showMessageDialog(null, p);

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeans2> user = new ArrayList<>();

        String read = "select id, login, senha, nome from Usuario where nome like order by nome";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_user = rs.getString(1);
                String nome_user = rs.getString(4);
                String login_user = rs.getString(2);
                String senha_user = rs.getString(3);

                //colocando no Arraylist
                user.add(new JavaBeans2(id_user, nome_user, login_user, senha_user));
            }
            con.close();
            return user;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void selecionarUser(JavaBeans2 user) {
        String read2 = "select * from Usuario where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, user.getId_user());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user.setId_user(rs.getString(1));
                user.setLogin_user(rs.getString(2));
                user.setSenha_user(rs.getString(3));
                user.setNome_user(rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarUser(JavaBeans2 user) {
        String create = "update Usuario set login=?, senha=?, nome=? where id=?";
        //String id = associado.getId_associado();
        ////JOptionPane.showMessageDialog(null, id);
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, user.getLogin_user());
            pst.setString(2, user.getSenha_user());
            pst.setString(3, user.getNome_user());
            pst.setString(4, user.getId_user());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }
//******************************************************************************************************
//  EMPRESA ******************************************************************************************************

    public void inserirEmpresa(JavaBeansAssociados associado) {
        String create = "insert into Empresa (nome,endereco,telefone,login,senha,cnpj) values (?,?,?,?,?,?)";
        try {

            //Abrir a conexão
            Connection con = conectar();

            // Preparar a query
            PreparedStatement pst = con.prepareCall(create);

            // Substitur os ? pelos valores
            pst.setString(1, associado.getNome_empresa());
            pst.setString(2, associado.getEndereco_empresa());
            pst.setString(3, associado.getTelefone_empresa());
            pst.setString(4, associado.getLogin_empresa());
            pst.setString(5, associado.getSenha_empresa());
            pst.setString(6, associado.getCnpj_empresa());

            //Executar a query
            pst.executeUpdate();

            //Encerrar a conexão
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansAssociados> listarEmpresa() {

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> empresa = new ArrayList<>();

        String read = "select id, nome, endereco, cnpj, telefone from Empresa order by nome limit 10";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_empresa = rs.getString(1);
                String nome_empresa = rs.getString(2);
                String endereco_empresa = rs.getString(3);
                String cnpj_empresa = rs.getString(4);
                String telefone_empresa = rs.getString(5);

                //colocando no Arraylist
                empresa.add(new JavaBeansAssociados(id_empresa, nome_empresa, endereco_empresa, cnpj_empresa, telefone_empresa));
            }
            con.close();
            return empresa;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansAssociados> listarEmpresapesquisar(JavaBeansAssociados pesquisa) {
        String p = pesquisa.getPesquisar();

        //Criar objeto para acessar a classe JavaBeans
        ArrayList< JavaBeansAssociados> empresa = new ArrayList<>();

        String read = "select id, nome, endereco, cnpj, telefone from Empresa where nome like '%" + p + "%' order by nome";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String id_empresa = rs.getString(1);
                String nome_empresa = rs.getString(2);
                String endereco_empresa = rs.getString(3);
                String cnpj_empresa = rs.getString(4);
                String telefone_empresa = rs.getString(5);

                //colocando no Arraylist
                empresa.add(new JavaBeansAssociados(id_empresa, nome_empresa, endereco_empresa, cnpj_empresa, telefone_empresa));
            }
            con.close();
            return empresa;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void selecionarEmpresa(JavaBeansAssociados associado) {
        String read2 = "select * from Empresa where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, associado.getId_empresa());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                associado.setId_empresa(rs.getString(1));
                associado.setNome_empresa(rs.getString(2));
                associado.setEndereco_empresa(rs.getString(3));
                associado.setTelefone_empresa(rs.getString(4));
                associado.setLogin_empresa(rs.getString(5));
                associado.setSenha_empresa(rs.getString(6));
                associado.setCnpj_empresa(rs.getString(7));
            }
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarEmpresa(JavaBeansAssociados associado) {
        String create = "update Empresa set nome=?, endereco=?, telefone=?, login=?, senha=?, cnpj=? where id=?";
        //String id = associado.getId_associado();
        ////JOptionPane.showMessageDialog(null, id);
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, associado.getNome_empresa());
            pst.setString(2, associado.getEndereco_empresa());
            pst.setString(3, associado.getTelefone_empresa());
            pst.setString(4, associado.getLogin_empresa());
            pst.setString(5, associado.getSenha_empresa());
            pst.setString(6, associado.getCnpj_empresa());
            pst.setString(7, associado.getId_empresa());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

//******************************************************************************************************
//  PEGA O ILTIMO ID ******************************************************************************************************
    public void setidconexao(JavaBeansAssociados associado) {
        //Criar objeto para acessar a classe JavaBeans

        String read = "select max(id)+1 from Associado";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {

                //Variaveis que recebem os dados do banco
                String id_associado = rs.getString(1);

                if (id_associado == null) {
                    id_associado = "1";
                } else {

                }
                associado.setId_associado(id_associado);

                ////JOptionPane.showMessageDialog(null, id_associado);
            }

            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setid2conexao(JavaBeansAssociados associado) {
        //Criar objeto para acessar a classe JavaBeans

        String read = "select * from Associado where id = 0";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {

                //Variaveis que recebem os dados do banco
                String id_associado = rs.getString(1);

                if (id_associado == null) {
                    id_associado = "1";
                } else {

                }
                associado.setId_associado(id_associado);

                ////JOptionPane.showMessageDialog(null, id_associado);
            }

            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansRelatorioRoot> sqlpagamento() {

        String sql;
        sql = "SELECT Cortes.idCortes,Cortes.associado_id,Cortes.associado_iddependente,date_format(str_to_date(Cortes.data_corte, '%Y-%m-%d'), '%d/%m/%Y') as Data_Corte,Cortes.id_empresa,Cortes.PAGO, Associado.nome as nome_associado,Dependentes.nome,Empresa.nome as nome_empresa from Cortes\n"
                + "inner join Associado on Associado.id = Cortes.associado_id\n"
                + "inner join Empresa on Empresa.id = Cortes.id_empresa\n"
                + "inner join Dependentes on Dependentes.id = Cortes.associado_iddependente\n "
                + "where " + texto;

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansRelatorioRoot> pagamento = new ArrayList<>();

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String ID_cortes = rs.getString(1);
                String Associado_ID = rs.getString(7);
                String Associado_Id_Dependente = rs.getString(8);
                String Data_Corte = rs.getString(4);
                String ID_Empresa = rs.getString(5);
                String Pago = rs.getString(1);
                String Nomeempresa = rs.getString(9);

                //colocando no Arraylist
                pagamento.add(new JavaBeansRelatorioRoot(ID_cortes, Associado_ID, Associado_Id_Dependente, Data_Corte, ID_Empresa, Pago, Nomeempresa));
            }
            con.close();
            texto = null;
            return pagamento;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void pagamento(JavaBeansRelatorioRoot pagamento) {

        String[] Valores;
        String sql2 = "";
        Valores = pagamento.getValor_pego();
        ////JOptionPane.showMessageDialog(null, Valores);

        String create = "update Cortes set PAGO = ? where";

        for (int i = 0; i < Valores.length; i++) {

            sql2 = sql2 + " idCortes =" + Valores[i] + " or ";

        };

        create = create + " " + sql2.substring(1, (sql2.length() - 3));
        ////JOptionPane.showMessageDialog(null, create);

        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, "1");

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        texto = (sql2.substring(1, (sql2.length() - 3)));
    }

}

/**
 * //Deletar o Associado public void deletarAssociado(JavaBeansAssociados
 * associado) { String delete = "delete from Associado where id"; try {
 * Connection con = conectar(); PreparedStatement pst =
 * con.prepareStatement(delete); pst.setString(1, associado.getId_associado());
 * pst.executeUpdate();
 *
 * } catch (Exception e) { }
 *
 */
