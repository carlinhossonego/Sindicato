package modelo;

import controle.Controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.JavaBeansAssociados;

public class Conexao {

//Módulo de conexão
//Parametros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    JavaBeansPegarIp ClassePegarIP = new JavaBeansPegarIp();
    Conexao_Pegar_IP ConexaoPegarIP = new Conexao_Pegar_IP();

//Método de conexão
    private Connection conectar() {
        String IP2 = null;
        IP2 = ClassePegarIP.getIp();
        //JOptionPane.showMessageDialog(null, IP2);

        if (IP2 == null) {
            ConexaoPegarIP.PegarIp(ClassePegarIP);
            IP2 = ClassePegarIP.getIp();
            //JOptionPane.showMessageDialog(null, "vedadeiro");
        } else {
           // JOptionPane.showMessageDialog(null, "Falso");
        }

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
            con = DriverManager.getConnection("jdbc:mysql://" + IP2 + "/Sindicato?useSSL=false", "teste", "teste123");
            return con;

        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    //Teste de conexão
    public void testeConexao() {
        try {
            Connection con = conectar();
            //System.out.println(con);
            //JOptionPane.showMessageDialog(null, con);
            con.close();
        } catch (Exception e) {
            //System.out.println(e);
            // JOptionPane.showMessageDialog(null, e);
        }
    }

    // ASSOCIADO
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansAssociados> listarAssociado() {

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> associado = new ArrayList<>();

        String read = "select id, nome, empresa, validade from Associado order by nome limit 10";
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
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList<JavaBeansAssociados> pesquisaAssociado(JavaBeansAssociados associado) {

        String pesquisa = associado.getPesquisar();
        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> pesquisaassociado = new ArrayList<>();

        String read = "select id, nome, empresa, validade from Associado where nome like '%" + pesquisa + "%' order by nome limit 10";
        //String read = "select id, nome, empresa, validade from Associado where nome like '%Ne%' order by nome limit 10";

        //TESTE DE RECEBIMENTO DOS DADOS 
        // JOptionPane.showMessageDialog(null, pesquisa);
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
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void selecionarAssociado(JavaBeansAssociados associado) {
        String read2 = "select * from Associado where id = ?";
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarAssociado(JavaBeansAssociados associado) {
        String create = "update Associado set nome=?, endereco=?, telefone=?, empresa=?, cidade=?, validade=?, dependentes=?, cargo=? where id=?";
        //String id = associado.getId_associado();
        //JOptionPane.showMessageDialog(null, id);
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<JavaBeansAssociados> listarDependentes(JavaBeansAssociados associado) {
        String id = associado.getId_associado();
        //JOptionPane.showMessageDialog(null, id);

        //Criar objeto para acessar a classe JavaBeans
        ArrayList<JavaBeansAssociados> listarDependentes = new ArrayList<>();

        String read = "select id, nome, nascimento from Dependentes where iddependentes = " + id + " order by nome;";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // Sera executato enquanto tiver associado
            while (rs.next()) {
                //Variaveis que recebem os dados do banco
                String iddependentes = rs.getString(1);
                String nome = rs.getString(2);
                String nascimento = rs.getString(3);

                //colocando no Arraylist
                listarDependentes.add(new JavaBeansAssociados(iddependentes, nome, nascimento));
            }
            con.close();
            return listarDependentes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarDependente(JavaBeansDependentes dependentes) {
        String create = "update Dependentes set nome=?, nascimento=? where id=?";
        //String id = associado.getId_associado();
        //JOptionPane.showMessageDialog(null, id);
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, dependentes.getNome_dependente());
            pst.setString(2, dependentes.getNascimento_dependente());
            pst.setString(3, dependentes.getId_dependentes_real());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void sair() {

        try {
            Connection con = conectar();

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
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
                String login_user = rs.getString(2);
                String senha_user = rs.getString(3);
                String nome_user = rs.getString(4);

                //colocando no Arraylist
                user.add(new JavaBeans2(id_user, login_user, senha_user, nome_user));
            }
            con.close();
            return user;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarUser(JavaBeans2 user) {
        String create = "update Usuario set login=?, senha=?, nome=? where id=?";
        //String id = associado.getId_associado();
        //JOptionPane.showMessageDialog(null, id);
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarEmpresa(JavaBeansAssociados associado) {
        String create = "update Empresa set nome=?, endereco=?, telefone=?, login=?, senha=?, cnpj=? where id=?";
        //String id = associado.getId_associado();
        //JOptionPane.showMessageDialog(null, id);
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
            JOptionPane.showMessageDialog(null, e);
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

                //JOptionPane.showMessageDialog(null, id_associado);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

                //JOptionPane.showMessageDialog(null, id_associado);
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
