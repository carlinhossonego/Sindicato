package controle;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import modelo.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;

@WebServlet(urlPatterns = {"/Controle", "/novo_user456", "/empresa456", "/principal", "/principalempregado", "/Pesquisauser", "/main5", "/pesquisaparaempresa", "/relatorios_para_root", "/pagamento", "/relatoriosroot", "/relatorios_para_empresa", "/relatorios", "/select_venda", "/main4", "/listarassociadonoservico", "/listarservicos", "/venda", "/select_associado_corte", "/main3", "/sair", "/update_dependente", "/select_dependente", "/setid2", "/insert_dependente", "/listar", "/update_user", "/select_user", "/insert_user", "/novousuario", "/update_empresa", "/select_empresa", "/abrirempresa", "/insert_empresa", "/empresa", "/setid", "/main", "/main2", "/insert_associado", "/select_associado", "/update_associado", "/delete_associado"})
public class Controle extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Conexao conexao = new Conexao();
    //Conexao_Pegar_IP conexao_pegar_ip = new Conexao_Pegar_IP();

    //Instancia das classes JAVABEANS
    JavaBeansAssociados associado = new JavaBeansAssociados();
    JavaBeans2 user = new JavaBeans2();
    JavaBeansGravarCortes cortes = new JavaBeansGravarCortes();
    JavaBeansDependentes dependentes = new JavaBeansDependentes();
    JavaBeansServicos servicos = new JavaBeansServicos();
    JavaBeansPegarData Data = new JavaBeansPegarData();
    JavaBeansRelatorios relatorios = new JavaBeansRelatorios();
    JavaBeansRelatorioRoot relatorioroot = new JavaBeansRelatorioRoot();
    Integer Quantidade_de_Dependentes;
    Integer Quantidade_Servicos_no_mes;
    //Importar_Imagem importar_imagem = new Importar_Imagem();

    //Variaveis Globais para pegar os dados para o lançamento de serviço
    String Global_idCortes;
    String Global_associado_id;
    String Global_associado_iddependente;
    String Global_associado_idAssociado;
    String Global_data_corte;
    String Global_id_empresa;
    String Global_PAGO;

    public Controle() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        //////JOptionPane.showMessageDialog(null, action);
        if (action.equals("/main")) {
            main(request, response);

        } else if (action.equals("/main4")) {
            main4(request, response);

        } else if (action.equals("/novo_user456")) {
            novo_user456(request, response);

        } else if (action.equals("/empresa456")) {
            empresa456(request, response);

        } else if (action.equals("/main5")) {
            main5(request, response);

        } else if (action.equals("/Pesquisauser")) {
            pesquisauser(request, response);
        } else if (action.equals("/principalempregado")) {
            principalempregado(request, response);
        } else if (action.equals("/principal")) {
            principal(request, response);
        } else if (action.equals("/pesquisaparaempresa")) {
            pesquisaparaempresa(request, response);
        } else if (action.equals("/relatorios_para_empresa")) {
            relatorios_para_empresa(request, response);
        } else if (action.equals("/relatorios_para_root")) {
            relatorios_para_root(request, response);
        } else if (action.equals("/pagamento")) {
            pagamento(request, response);
        } else if (action.equals("/relatoriosroot")) {
            relatoriosroot(request, response);
        } else if (action.equals("/relatorios")) {
            relatorios(request, response);
        } else if (action.equals("/select_venda")) {
            select_venda(request, response);
        } else if (action.equals("/listar")) {
            listarassociado(request, response);
        } else if (action.equals("/listarassociadonoservico")) {
            listarassociadonoservico(request, response);

        } else if (action.equals("/listarservicos")) {
            listarservicos(request, response);

        } else if (action.equals("/sair")) {
            sair(request, response);

        } else if (action.equals("/venda")) {
            venda(request, response);

        } else if (action.equals("/insert_dependente")) {
            novoDependente(request, response);
        } else if (action.equals("/main2")) {
            pesquisaassociado(request, response);
        } else if (action.equals("/main3")) {
            pesquisaassociadocorte(request, response);
        } else if (action.equals("/abrirempresa")) {
            abrirempresa(request, response);
        } else if (action.equals("/novousuario")) {
            novousuario(request, response);
        } else if (action.equals("/empresa")) {
            novaEmpresa(request, response);
        } else if (action.equals("/insert_associado")) {
            novoAssociado(request, response);
        } else if (action.equals("/insert_user")) {
            inserirnovouser(request, response);
        } else if (action.equals("/select_associado")) {
            listarAssociado(request, response);
        } else if (action.equals("/select_associado_corte")) {
            listarAssociadoCorte(request, response);
        } else if (action.equals("/select_empresa")) {
            listarEmpresa(request, response);
        } else if (action.equals("/select_dependente")) {
            listarDependente(request, response);
        } else if (action.equals("/select_user")) {
            listaruser(request, response);
        } else if (action.equals("/update_empresa")) {
            editarEmpresa(request, response);
        } else if (action.equals("/update_dependente")) {
            editarDependente(request, response);
        } else if (action.equals("/update_user")) {
            editarUser(request, response);
        } else if (action.equals("/update_associado")) {
            editarAssociado(request, response);
        } else if (action.equals("/delete_associado")) {
            //removerAssociado(request, response);
        } else if (action.equals("/setid")) {
            setid(request, response);
        } else if (action.equals("/setid2")) {
            setid2(request, response);
        } else {
            response.sendRedirect("index.html");
        }

        //teste de conexão
        conexao.testeConexao();
    }

    protected void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.resetBuffer();
        conexao.sair();
        //conexao_pegar_ip.sair();
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);

    }

    protected void empresa456(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);

        RequestDispatcher rd = request.getRequestDispatcher("empresa.jsp");
        rd.forward(request, response);
    }

    protected void novo_user456(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);

        RequestDispatcher rd = request.getRequestDispatcher("novo_user.jsp");
        rd.forward(request, response);
    }

    protected void erro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ////JOptionPane.showMessageDialog(null, "erro");

    }

    protected void pagamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Data_atual;
        conexao.PegarDataDoServidor(Data);

        Data_atual = Data.getData_Do_servidor();
        relatorioroot.setValor_pego(request.getParameterValues("ID"));
        conexao.pagamento(relatorioroot);

        request.setAttribute("data", "Data do Pagamento: " + Data_atual);

        ArrayList<JavaBeansRelatorioRoot> lista = conexao.sqlpagamento();

        //Listando no associado.jsp
        request.setAttribute("pagamento", lista);

        RequestDispatcher rd = request.getRequestDispatcher("pagamento.jsp");
        rd.forward(request, response);
    }

    protected void relatorios_para_empresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID;

        relatorios.setNome1(request.getParameter("Nome1"));
        relatorios.setNome2(request.getParameter("Nome2"));
        relatorios.setDataI1(request.getParameter("DataI1"));
        relatorios.setDataI2(request.getParameter("DataI2"));
        relatorios.setDataF1(request.getParameter("DataF1"));
        relatorios.setDataF2(request.getParameter("DataF2"));
        relatorios.setE_OU(request.getParameter("E_OU"));
        relatorios.setCampo(request.getParameter("campo"));
        relatorios.setCampo3(request.getParameter("campo3"));

        //relatorios.setPago1(request.getParameter("Pago1"));
        //relatorios.setPago2(request.getParameter("Pago2"));
        String valor_do_pago1;
        valor_do_pago1 = request.getParameter("Pago1");
        if (valor_do_pago1.equals("nao")) {
            valor_do_pago1 = "0";
        } else {
            valor_do_pago1 = "1";
        }

        String valor_do_pago2;
        valor_do_pago2 = request.getParameter("Pago2");
        if (valor_do_pago2.equals("nao")) {
            valor_do_pago2 = "0";
        } else {
            valor_do_pago2 = "1";
        }

        relatorios.setPago1(valor_do_pago1);
        relatorios.setPago2(valor_do_pago2);

        //TESTE DE RECEBIMENTO DOS DADOS 
        //////JOptionPane.showMessageDialog(null, request.getParameter("pesquisar_nome"));
        ID = associado.getId_empresa();
        relatorios.setID_Empresa(ID);

        ArrayList<JavaBeansRelatorios> lista = conexao.relatorios_nome(relatorios);

        //Listando no associado.jsp
        request.setAttribute("relatorios", lista);

        RequestDispatcher rd = request.getRequestDispatcher("relatorios.jsp");
        rd.forward(request, response);

    }

    //CLASSES DEPENDENTES  *************************************************************************** 
    protected void editarDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dependentes.setId_dependentes_real(request.getParameter("id"));
        dependentes.setNome_dependente(request.getParameter("nome"));
        dependentes.setNascimento_dependente(request.getParameter("nascimento"));

        //Teste
        //String Id_associado = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarDependente(dependentes);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("listar");

    }

    protected void listarDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        dependentes.setId_dependentes_real(id);

        // Executar o método selecionarAssociado
        conexao.selecionarDependente(dependentes);

        //teste
        //////JOptionPane.showMessageDialog(null, dependentes.getId_dependentes_real());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", dependentes.getId_dependentes_real());
        request.setAttribute("nome", dependentes.getNome_dependente());
        request.setAttribute("nascimento", dependentes.getNascimento_dependente());

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        //Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editardependente.jsp");
        rd.forward(request, response);

    }

    protected void novoDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        dependentes.setId_dependente(request.getParameter("id"));
        dependentes.setNome_dependente(request.getParameter("nome"));
        dependentes.setNascimento_dependente(request.getParameter("nascimento"));

        //////JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirDependentes(dependentes);

        //Redirecionar para o documento associado.jsp
        response.sendRedirect("setid2");

    }

    protected void setid2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Executar o método stid
        conexao.setid2conexao(associado);
        //////JOptionPane.showMessageDialog(null, associado.getId_associado());
        request.setAttribute("id", associado.getId_associado());
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        //redireciona para pagina html
        RequestDispatcher rd = request.getRequestDispatcher("novodependente.jsp");
        rd.forward(request, response);

    }
//*********************************************************************************************************************
//CLASSES DO ASSOCIADO
    //Listar Associados

    protected void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ArrayList<JavaBeansPegarData> lista2 = conexao.PegarDataDoServidor(PegarData);

        user.setLogin_user(request.getParameter("login_login"));
        user.setSenha_user(request.getParameter("senha_login"));

        associado.setLogin_empresa(request.getParameter("login_login"));
        associado.setSenha_empresa(request.getParameter("senha_login"));

        String NOME, NOMEX, Login_User, Senha_User, Login_Empresa, Senha_Empresa;
        Login_User = "";
        Senha_User = "";
        Login_Empresa = "";
        Senha_Empresa = "";
        NOME = "";
        NOMEX = "";

        //SQL
        conexao.validacao(user);
        conexao.validacao2(associado);

        Login_User = user.getLogin_user_sql();
        Senha_User = user.getSenha_user_sql();
        Login_Empresa = associado.getLogin_empresa();
        Senha_Empresa = associado.getSenha_empresa();

        if (!"".equals(Login_User) && !"".equals(Senha_User)) {
            NOMEX = user.getNome_menu();

            String[] texto2 = NOMEX.split(" ");
            request.setAttribute("nome_menu", "Olá " + texto2[0]);
            RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
            rd.forward(request, response);

        } else if (!"".equals(Login_Empresa) && !"".equals(Senha_Empresa)) {
            NOME = associado.getNome_empresa();
            String[] texto = NOME.split(" ");
            request.setAttribute("nome", "Olá " + texto[0]);
            RequestDispatcher rd = request.getRequestDispatcher("principalempregado.jsp");
            rd.forward(request, response);

        } else {
            response.sendRedirect("erro10.html");

        }

    }

    protected void principalempregado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String NOME;
        NOME = associado.getNome_empresa();
        String[] texto = NOME.split(" ");
        request.setAttribute("nome", "Olá " + texto[0]);
        RequestDispatcher rd = request.getRequestDispatcher("principalempregado.jsp");
        rd.forward(request, response);

    }

    protected void principal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
        rd.forward(request, response);

    }

    protected void relatorios_para_root(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        relatorioroot.setNomeempresa(request.getParameter("Empresa"));
        relatorioroot.setNome2(request.getParameter("Nome2"));
        relatorioroot.setDataI1(request.getParameter("DataI1"));
        relatorioroot.setDataI2(request.getParameter("DataI2"));
        relatorioroot.setDataF1(request.getParameter("DataF1"));
        relatorioroot.setDataF2(request.getParameter("DataF2"));
        relatorioroot.setPago1(request.getParameter("Pago1"));

        relatorioroot.setE_OU(request.getParameter("E_OU"));
        relatorioroot.setCampo(request.getParameter("campo"));
        relatorioroot.setCampo3(request.getParameter("campo3"));

        String valor_do_pago;
        valor_do_pago = request.getParameter("Pago2");
        if (valor_do_pago.equals("nao")) {
            valor_do_pago = "0";
        } else {
            valor_do_pago = "1";
        }
        relatorioroot.setPago2(valor_do_pago);

        //TESTE DE RECEBIMENTO DOS DADOS 
        ////JOptionPane.showMessageDialog(null, valor_do_pago);
        ArrayList<JavaBeansRelatorioRoot> lista = conexao.relatorios_root(relatorioroot);

        //Listando no associado.jsp
        request.setAttribute("relatoriotodo", lista);
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("relatorios_root.jsp");
        rd.forward(request, response);

    }

    protected void relatoriosroot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<JavaBeansRelatorioRoot> lista = conexao.relatoriotodo(relatorioroot);

        //Listando no associado.jsp
        request.setAttribute("relatoriotodo", lista);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("relatorios_root.jsp");
        rd.forward(request, response);
    }

    protected void relatorios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID;
        ID = associado.getId_empresa();
        relatorios.setID_Empresa(ID);

        ArrayList<JavaBeansRelatorios> lista = conexao.relatorio(relatorios);

        //Listando no associado.jsp
        request.setAttribute("relatorios", lista);

        String NOME;
        NOME = associado.getNome_empresa();
        String[] texto = NOME.split(" ");
        request.setAttribute("nome", "Olá " + texto[0]);
        RequestDispatcher rd = request.getRequestDispatcher("relatorios.jsp");
        rd.forward(request, response);
    }

//Classes para serviços **********************************************************************
    protected void main4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ArrayList<JavaBeansPegarData> lista2 = conexao.PegarDataDoServidor(PegarData);

        user.setLogin_user(request.getParameter("login_login"));
        user.setSenha_user(request.getParameter("senha_login"));

        associado.setLogin_empresa(request.getParameter("login_login"));
        associado.setSenha_empresa(request.getParameter("senha_login"));

        String Login_User, Senha_User, Login_Empresa, Senha_Empresa;
        Login_User = "";
        Senha_User = "";
        Login_Empresa = "";
        Senha_Empresa = "";

        //SQL
        conexao.validacao(user);
        conexao.validacao2(associado);

        Login_User = user.getLogin_user_sql();
        Senha_User = user.getSenha_user_sql();
        Login_Empresa = associado.getLogin_empresa();
        Senha_Empresa = associado.getSenha_empresa();

        String AssociadoID;
        String IDDependente;
        String Data_do_corte;

        String IdEmpresa;
        String PAGO;

        AssociadoID = associado.getId_associado();
        IDDependente = Global_associado_iddependente;
        Data_do_corte = Data.getData_Do_servidor();

        IdEmpresa = associado.getId_empresa();
        PAGO = "0";

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Data_do_corte2 = LocalDate.parse(Data_do_corte, formato);

        ////JOptionPane.showMessageDialog(null, Data_do_corte2);
        cortes.setAssociado_id(AssociadoID);
        cortes.setAssociado_iddependente(IDDependente);
        cortes.setData_corte(String.valueOf(Data_do_corte2));
        cortes.setId_empresa(IdEmpresa);
        cortes.setPAGO(PAGO);

        if (!"".equals(Login_User) && !"".equals(Senha_User)) {
            response.sendRedirect("principal.html");

        } else if (!"".equals(Login_Empresa) && !"".equals(Senha_Empresa)) {

            //conexao.inserircortes(cortes);
            //response.sendRedirect("finalizarCorte.html");
            response.sendRedirect("login_de_corte_cliente.jsp");

        } else {
            response.sendRedirect("erro10.html");

        }

    }

    protected void main5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        associado.setLogin_associado(request.getParameter("login_login"));
        associado.setSenha_associado(request.getParameter("senha_login"));

        //SQL
        conexao.validacao3(associado);
        String Login_Associado_get = associado.getLogin_associado();
        String Senha_Associado_get = associado.getSenha_associado();
        String Login_Associado = associado.getLogin_associado_sql();
        String Senha_Associado = associado.getSenha_associado_sql();

        if ("".equals(Login_Associado_get) || "".equals(Senha_Associado_get)) {
            response.sendRedirect("erro10.html");
        } else if (Login_Associado.equals(Login_Associado_get) && Senha_Associado.equals(Senha_Associado_get)) {

            //JOptionPane.showMessageDialog(null, cortes.getAssociado_id());
            if ("-1".equals(cortes.getAssociado_id())) {

                //FINALIZA O PROGRAMA INTEIRO
                System.exit(0);

            } else {
                conexao.inserircortes(cortes);
            }
            cortes.setAssociado_id("-1");

            response.sendRedirect("finalizarCorte.html");
        } else {
            response.sendRedirect("erro10.html");

        }

    }

    protected void listarservicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID, NOME;
        NOME = associado.getNome_associado();
        ID = associado.getId_associado();
        servicos.setAssociado_id(ID);
        servicos.setNome(NOME);

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansServicos> lista = conexao.listarServicos(servicos);

        Quantidade_Servicos_no_mes = lista.size();
        //////JOptionPane.showMessageDialog(null, Quantidade_Servicos_no_mes);
        //////JOptionPane.showMessageDialog(null, Quantidade_de_Dependentes);

        if ((Quantidade_Servicos_no_mes) < (Quantidade_de_Dependentes + 1)) {
            request.setAttribute("servicos", lista);
            RequestDispatcher rd = request.getRequestDispatcher("listarservicos.jsp");
            rd.forward(request, response);
        } else {

            RequestDispatcher rd = request.getRequestDispatcher("erro11.jsp");
            rd.forward(request, response);
        }

        //Listando no associado.jsp
    }

    protected void select_venda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("".equals(request.getParameter("id_corte2"))) {
            //Selecionar exclusivo do Associado
            Global_associado_idAssociado = request.getParameter("id_corte2");
            associado.setId_associado(Global_associado_idAssociado);

            //Selecionar exclusivo do Dependente
            Global_associado_iddependente = "0";
            associado.setIddependentes("0");
        } else {
            //Selecionar exclusivo do Dependente
            Global_associado_iddependente = request.getParameter("id_corte");
            associado.setIddependentes(Global_associado_iddependente);
        }

        response.sendRedirect("venda");
    }

    protected void venda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Data_atual;
        String Data_atual_do_campo_validade;
        String id = request.getParameter("id");

        //Setar Variavel JavaBeasn
        servicos.setAssociado_id(id);
        associado.setValidade_associado(request.getParameter("validade"));
        servicos.setNome(request.getParameter("nome"));

        conexao.PegarValidade(associado);
        conexao.PegarDataDoServidor(Data);
        //Data do Servidor
        Data_atual = Data.getData_Do_servidor();
        //Data da Validade do Associado
        Data_atual_do_campo_validade = associado.getValidade_associado();

        //Definindo o formado de data para a Validade
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Data_atual_do_campo_validade_c = LocalDate.parse(Data_atual_do_campo_validade, formato);
        LocalDate Data_atual_server = LocalDate.parse(Data_atual, formato);

        //////JOptionPane.showMessageDialog(null, Data_atual_server + " Data do servidor");
        //////JOptionPane.showMessageDialog(null, Data_atual_do_campo_validade_c + " Validade");
        if (Data_atual_do_campo_validade_c.isAfter(Data_atual_server)) {
            //////JOptionPane.showMessageDialog(null, "OK");
            response.sendRedirect("listarservicos");
        } else {
            //////JOptionPane.showMessageDialog(null, "VEncida");
            RequestDispatcher rd = request.getRequestDispatcher("erro12.jsp");
            rd.forward(request, response);
        }

        //Atribuir campos nas Globais de corte
        Global_associado_id = id;

        //////JOptionPane.showMessageDialog(null, associado.getData());
        //////JOptionPane.showMessageDialog(null, associado.getValidade_associado());
    }

    protected void listarAssociadoCorte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        associado.setId_associado(id);

        // Executar o método selecionarAssociado
        conexao.selecionarAssociadoCorte(associado);

        //teste
        // ////JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", associado.getId_associado());
        request.setAttribute("nome", associado.getNome_associado());
        request.setAttribute("endereco", associado.getEndereco_associado());
        request.setAttribute("cidade", associado.getCidade_associado());
        request.setAttribute("validade", associado.getValidade_associado());

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarDependentes(associado);
        Quantidade_de_Dependentes = lista.size();

        //Listando no editar.jsp
        request.setAttribute("editar", lista);

        //Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("cortesdecabelo.jsp");
        rd.forward(request, response);

    }

    protected void pesquisaassociadocorte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TESTE DE RECEBIMENTO DOS DADOS 
        //////JOptionPane.showMessageDialog(null, request.getParameter("pesquisar"));
        associado.setPesquisar(request.getParameter("pesquisar"));

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista2 = conexao.pesquisaAssociado(associado);

        //Listando no associado.jsp
        request.setAttribute("associado", lista2);
        RequestDispatcher rd = request.getRequestDispatcher("listarassociadoparacorte.jsp");
        rd.forward(request, response);

    }

    protected void novoAssociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //setar as variaveis JavaBeans
        associado.setId_associado(request.getParameter("id"));
        associado.setNome_associado(request.getParameter("nome"));
        associado.setEndereco_associado(request.getParameter("endereco"));
        associado.setTelefone_associado(request.getParameter("contato"));
        associado.setEmpresa_associado(request.getParameter("empresa"));
        associado.setCidade_associado(request.getParameter("cidade"));
        associado.setValidade_associado(request.getParameter("validade"));
        associado.setDependentes_associado(request.getParameter("dependentes"));
        associado.setCargo_associado(request.getParameter("cargo"));
        associado.setLogin_associado(request.getParameter("login"));
        associado.setSenha_associado(request.getParameter("senha"));

        associado.setControle(request.getParameter("controle"));

        //////JOptionPane.showMessageDialog(null, associado.getControle());
        // invocar o metodo inserir associado
        conexao.inserirAssociado(associado);

        if (!associado.getControle().equals("1")) {
            response.sendRedirect("principal.jsp");
        } else {
            response.sendRedirect("setid2");
        }
        //Redirecionar para o documento associado.jsp

    }

    //EDITAR Associado
    protected void listarAssociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        associado.setId_associado(id);

        // Executar o método selecionarAssociado
        conexao.selecionarAssociado(associado);

        //teste
        // ////JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", associado.getId_associado());
        request.setAttribute("nome", associado.getNome_associado());
        request.setAttribute("endereco", associado.getEndereco_associado());
        request.setAttribute("telefone", associado.getTelefone_associado());
        request.setAttribute("empresa", associado.getEmpresa_associado());
        request.setAttribute("cidade", associado.getCidade_associado());
        request.setAttribute("validade", associado.getValidade_associado());
        request.setAttribute("dependentes", associado.getDependentes_associado());
        request.setAttribute("cargo", associado.getCargo_associado());
        request.setAttribute("login", associado.getLogin_associado());
        request.setAttribute("senha", associado.getSenha_associado());

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarDependentes(associado);

        //Listando no editar.jsp
        request.setAttribute("editar", lista);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        //Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);

    }

    protected void editarAssociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        associado.setId_associado(request.getParameter("id"));
        associado.setNome_associado(request.getParameter("nome"));
        associado.setEndereco_associado(request.getParameter("endereco"));
        associado.setTelefone_associado(request.getParameter("telefone"));
        associado.setEmpresa_associado(request.getParameter("empresa"));
        associado.setCidade_associado(request.getParameter("cidade"));
        associado.setValidade_associado(request.getParameter("validade"));
        associado.setDependentes_associado(request.getParameter("dependentes"));
        associado.setCargo_associado(request.getParameter("cargo"));
        associado.setLogin_associado(request.getParameter("login"));
        associado.setSenha_associado(request.getParameter("senha"));

        //Teste
        //String Id_associado = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarAssociado(associado);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("listar");

    }

    protected void pesquisaparaempresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TESTE DE RECEBIMENTO DOS DADOS 
        //////JOptionPane.showMessageDialog(null, request.getParameter("pesquisar"));
        associado.setPesquisar(request.getParameter("pesquisar"));

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarEmpresapesquisar(associado);

        //Listando no empresa.jsp
        request.setAttribute("empresa", lista);
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("listarempresa.jsp");
        rd.forward(request, response);

    }

    protected void pesquisauser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TESTE DE RECEBIMENTO DOS DADOS 
        //////JOptionPane.showMessageDialog(null, request.getParameter("pesquisar"));
        user.setPesquisa(request.getParameter("pesquisar"));

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeans2> lista = conexao.listarUserPesquisa(user);

        //Listando no empresa.jsp
        request.setAttribute("user", lista);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("listaruser.jsp");
        rd.forward(request, response);

    }

    protected void pesquisaassociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TESTE DE RECEBIMENTO DOS DADOS 
        //////JOptionPane.showMessageDialog(null, request.getParameter("pesquisar"));
        associado.setPesquisar(request.getParameter("pesquisar"));

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista2 = conexao.pesquisaAssociado(associado);

        //Listando no associado.jsp
        request.setAttribute("associado", lista2);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("pesquisarassociado.jsp");
        rd.forward(request, response);

    }

    protected void listarassociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarAssociado();

        //Listando no associado.jsp
        request.setAttribute("associado", lista);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("pesquisarassociado.jsp");
        rd.forward(request, response);

    }

    protected void listarassociadonoservico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarAssociado();

        //Listando no associado.jsp
        request.setAttribute("associado", lista);

        String NOME;
        NOME = associado.getNome_empresa();
        String[] texto = NOME.split(" ");
        request.setAttribute("nome", "Olá " + texto[0]);
        RequestDispatcher rd = request.getRequestDispatcher("listarassociadoparacorte.jsp");
        rd.forward(request, response);

    }

    protected void setid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Executar o método stid
        conexao.setidconexao(associado);
        //////JOptionPane.showMessageDialog(null, associado.getId_associado());
        request.setAttribute("id", associado.getId_associado());

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("novo.jsp");
        rd.forward(request, response);

    }

//*********************************************************************************************************************
//CLASSES DE NOVO USUARIO
    protected void novousuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeans2> lista = conexao.listarUser();

        //Listando no empresa.jsp
        request.setAttribute("user", lista);
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("listaruser.jsp");
        rd.forward(request, response);
    }

    protected void inserirnovouser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        user.setLogin_user(request.getParameter("login"));
        user.setSenha_user(request.getParameter("senha"));
        user.setNome_user(request.getParameter("nome"));

        //////JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirUser(user);

        //Redirecionar para o documento associado.jsp
        response.sendRedirect("principal.html");
    }

    protected void listaruser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        user.setId_user(id);

        // Executar o método selecionarAssociado
        conexao.selecionarUser(user);

        //teste
        // ////JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", user.getId_user());
        request.setAttribute("login", user.getLogin_user());
        request.setAttribute("senha", user.getSenha_user());
        request.setAttribute("nome", user.getNome_user());

        //Encaminhar ao documento editar.jsp
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("editaruser.jsp");
        rd.forward(request, response);

    }

    protected void editarUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user.setId_user(request.getParameter("id"));
        user.setLogin_user(request.getParameter("login"));
        user.setSenha_user(request.getParameter("senha"));
        user.setNome_user(request.getParameter("nome"));

        //Teste
        //String Id_associado = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarUser(user);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("novousuario");

    }
    //************************************************************************************************************************

    //CLASSES DE EMPRESA 
    protected void abrirempresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarEmpresa();

        //Listando no empresa.jsp
        request.setAttribute("empresa", lista);

        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("listarempresa.jsp");
        rd.forward(request, response);

    }

    protected void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        associado.setId_empresa(request.getParameter("id"));
        associado.setNome_empresa(request.getParameter("nome"));
        associado.setEndereco_empresa(request.getParameter("endereco"));
        associado.setTelefone_empresa(request.getParameter("contato"));
        associado.setLogin_empresa(request.getParameter("login"));
        associado.setSenha_empresa(request.getParameter("senha"));
        associado.setCnpj_empresa(request.getParameter("cnpj"));

        //////JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirEmpresa(associado);

        //Redirecionar para o documento associado.jsp
        RequestDispatcher rd = request.getRequestDispatcher("principal.html");
        rd.forward(request, response);

    }

    protected void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        associado.setId_empresa(id);

        // Executar o método selecionarAssociado
        conexao.selecionarEmpresa(associado);

        //teste
        // ////JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", associado.getId_empresa());
        request.setAttribute("nome", associado.getNome_empresa());
        request.setAttribute("endereco", associado.getEndereco_empresa());
        request.setAttribute("telefone", associado.getTelefone_empresa());
        request.setAttribute("login", associado.getLogin_empresa());
        request.setAttribute("senha", associado.getSenha_empresa());
        request.setAttribute("cnpj", associado.getCnpj_empresa());

        //Encaminhar ao documento editar.jsp
        String NOMEX;
        NOMEX = user.getNome_menu();
        String[] texto2 = NOMEX.split(" ");
        request.setAttribute("nome_menu", "Olá " + texto2[0]);
        RequestDispatcher rd = request.getRequestDispatcher("editarempresa.jsp");
        rd.forward(request, response);

    }

    protected void editarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        associado.setId_empresa(request.getParameter("id"));
        associado.setNome_empresa(request.getParameter("nome"));
        associado.setEndereco_empresa(request.getParameter("endereco"));
        associado.setTelefone_empresa(request.getParameter("telefone"));
        associado.setLogin_empresa(request.getParameter("login"));
        associado.setSenha_empresa(request.getParameter("senha"));
        associado.setCnpj_empresa(request.getParameter("cnpj"));

        //Teste
        //String Id_associado = request.getParameter("id");
        //////JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarEmpresa(associado);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("abrirempresa");

    }
    /**
     * protected void removerAssociado(HttpServletRequest request,
     * HttpServletResponse response) throws ServletException, IOException {
     * //recebimento do id a ser excluido confirmador.js String Id_associado =
     * request.getParameter("Id_associado");
     *
     * //Teste // ////JOptionPane.showMessageDialog(null, Id_associado);
     *
     * //Setar a variavel id JavaBeans associado.setId_associado(Id_associado);
     *
     * //Executar o Método deletarAssociado
     * conexao.deletarAssociado(associado);
     *
     * //redirecionar para o documento associado.jsp (atualizando as
     * alterações) response.sendRedirect("main"); }
     *
     *
     */
}
