package controle;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Conexao;
import modelo.Conexao_Pegar_IP;
import modelo.JavaBeans2;
import modelo.JavaBeansAssociados;
import modelo.JavaBeansDependentes;
import modelo.JavaBeansPegarIp;

@WebServlet(urlPatterns = {"/Controle", "/sair", "/update_dependente", "/select_dependente", "/setid2", "/insert_dependente", "/listar", "/update_user", "/select_user", "/insert_user", "/novousuario", "/update_empresa", "/select_empresa", "/abrirempresa", "/insert_empresa", "/empresa", "/setid", "/main", "/main2", "/insert_associado", "/select_associado", "/update_associado", "/delete_associado"})
public class Controle extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Conexao conexao = new Conexao();
    Conexao_Pegar_IP conexao_pegar_ip = new Conexao_Pegar_IP();

    //Instancia das classes JAVABEANS
    JavaBeansAssociados associado = new JavaBeansAssociados();
    JavaBeans2 user = new JavaBeans2();
    JavaBeansDependentes dependentes = new JavaBeansDependentes();

    public Controle() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        //JOptionPane.showMessageDialog(null, action);
        if (action.equals("/main")) {
            associado(request, response);

        } else if (action.equals("/listar")) {
            listarassociado(request, response);

        } else if (action.equals("/sair")) {
            sair(request, response);

        } else if (action.equals("/insert_dependente")) {
            novoDependente(request, response);
        } else if (action.equals("/main2")) {
            pesquisaassociado(request, response);
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
        conexao_pegar_ip.sair();
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);

    }

    //CLASSES DEPENDENTES   
    protected void editarDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dependentes.setId_dependentes_real(request.getParameter("id"));
        dependentes.setNome_dependente(request.getParameter("nome"));
        dependentes.setNascimento_dependente(request.getParameter("nascimento"));

        //Teste
        //String Id_associado = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarDependente(dependentes);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("listar");

    }

    protected void listarDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        dependentes.setId_dependentes_real(id);

        // Executar o método selecionarAssociado
        conexao.selecionarDependente(dependentes);

        //teste
        //JOptionPane.showMessageDialog(null, dependentes.getId_dependentes_real());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", dependentes.getId_dependentes_real());
        request.setAttribute("nome", dependentes.getNome_dependente());
        request.setAttribute("nascimento", dependentes.getNascimento_dependente());

        //Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editardependente.jsp");
        rd.forward(request, response);

    }

    protected void novoDependente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        dependentes.setId_dependente(request.getParameter("id"));
        dependentes.setNome_dependente(request.getParameter("nome"));
        dependentes.setNascimento_dependente(request.getParameter("nascimento"));

        //JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirDependentes(dependentes);

        //Redirecionar para o documento associado.jsp
        response.sendRedirect("setid2");
    }

    protected void setid2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Executar o método stid
        conexao.setid2conexao(associado);
        //JOptionPane.showMessageDialog(null, associado.getId_associado());
        request.setAttribute("id", associado.getId_associado());

        //redireciona para pagina html
        RequestDispatcher rd = request.getRequestDispatcher("novodependente.jsp");
        rd.forward(request, response);

    }
//*********************************************************************************************************************
//CLASSES DO ASSOCIADO
    //Listar Associados

    protected void associado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JavaBeansPegarIp Pegar_IP = new JavaBeansPegarIp();
        
        
        //SQL
        conexao_pegar_ip.PegarIp(Pegar_IP);

        //JOptionPane.showMessageDialog(null, Pegar_IP.getIp());

        response.resetBuffer();
        response.reset();
        response.sendRedirect("principal.html");
        //RequestDispatcher rd = request.getRequestDispatcher("principal.html");
        //rd.forward(request, response);

    }

    protected void novoAssociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, n);
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

        //JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirAssociado(associado);

        //Redirecionar para o documento associado.jsp
        response.sendRedirect("setid2");
    }

    //EDITAR Associado
    protected void listarAssociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        associado.setId_associado(id);

        // Executar o método selecionarAssociado
        conexao.selecionarAssociado(associado);

        //teste
        // JOptionPane.showMessageDialog(null, associado.getId_associado());
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

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarDependentes(associado);

        //Listando no editar.jsp
        request.setAttribute("editar", lista);

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

        //Teste
        //String Id_associado = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, Id_associado);
        //executar o metodo arterar associado
        conexao.alterarAssociado(associado);

        //redirecionar para o documento associado.jsp (atualizando as alterações)
        response.sendRedirect("listar");

    }

    protected void pesquisaassociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TESTE DE RECEBIMENTO DOS DADOS 
        //JOptionPane.showMessageDialog(null, request.getParameter("pesquisar"));
        associado.setPesquisar(request.getParameter("pesquisar"));

        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista2 = conexao.pesquisaAssociado(associado);

        //Listando no associado.jsp
        request.setAttribute("associado", lista2);
        RequestDispatcher rd = request.getRequestDispatcher("pesquisarassociado.jsp");
        rd.forward(request, response);

    }

    protected void listarassociado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Criar objeto que ira receber os Dados JavaBeans
        ArrayList<JavaBeansAssociados> lista = conexao.listarAssociado();

        //Listando no associado.jsp
        request.setAttribute("associado", lista);

        RequestDispatcher rd = request.getRequestDispatcher("pesquisarassociado.jsp");
        rd.forward(request, response);

    }

    protected void setid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Executar o método stid
        conexao.setidconexao(associado);
        //JOptionPane.showMessageDialog(null, associado.getId_associado());
        request.setAttribute("id", associado.getId_associado());

        //redireciona para pagina html
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
        RequestDispatcher rd = request.getRequestDispatcher("listaruser.jsp");
        rd.forward(request, response);
    }

    protected void inserirnovouser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        user.setLogin_user(request.getParameter("login"));
        user.setSenha_user(request.getParameter("senha"));
        user.setNome_user(request.getParameter("nome"));

        //JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirUser(user);

        //Redirecionar para o documento associado.jsp
        response.sendRedirect("novo_user.jsp");
    }

    protected void listaruser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        user.setId_user(id);

        // Executar o método selecionarAssociado
        conexao.selecionarUser(user);

        //teste
        // JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", user.getId_user());
        request.setAttribute("login", user.getLogin_user());
        request.setAttribute("senha", user.getSenha_user());
        request.setAttribute("nome", user.getNome_user());

        //Encaminhar ao documento editar.jsp
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
        //JOptionPane.showMessageDialog(null, Id_associado);
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
        RequestDispatcher rd = request.getRequestDispatcher("listarempresa.jsp");
        rd.forward(request, response);

    }

    protected void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getParameter("nome"));

        //String n = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, n);
        //setar as variaveis JavaBeans
        associado.setId_empresa(request.getParameter("id"));
        associado.setNome_empresa(request.getParameter("nome"));
        associado.setEndereco_empresa(request.getParameter("endereco"));
        associado.setTelefone_empresa(request.getParameter("contato"));
        associado.setLogin_empresa(request.getParameter("login"));
        associado.setSenha_empresa(request.getParameter("senha"));
        associado.setCnpj_empresa(request.getParameter("cnpj"));

        //JOptionPane.showMessageDialog(null, request.getParameter("telefone2"));
        // invocar o metodo inserir associado
        conexao.inserirEmpresa(associado);

        //Redirecionar para o documento associado.jsp
        RequestDispatcher rd = request.getRequestDispatcher("empresa.jsp");
        rd.forward(request, response);

    }

    protected void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //JOptionPane.showMessageDialog(null, id);

        //Setar Variavel JavaBeasn
        associado.setId_empresa(id);

        // Executar o método selecionarAssociado
        conexao.selecionarEmpresa(associado);

        //teste
        // JOptionPane.showMessageDialog(null, associado.getId_associado());
        //Setar os dados do formulario com o conteudo do javabeasns
        request.setAttribute("id", associado.getId_empresa());
        request.setAttribute("nome", associado.getNome_empresa());
        request.setAttribute("endereco", associado.getEndereco_empresa());
        request.setAttribute("telefone", associado.getTelefone_empresa());
        request.setAttribute("login", associado.getLogin_empresa());
        request.setAttribute("senha", associado.getSenha_empresa());
        request.setAttribute("cnpj", associado.getCnpj_empresa());

        //Encaminhar ao documento editar.jsp
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
        //JOptionPane.showMessageDialog(null, Id_associado);
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
     * //Teste // JOptionPane.showMessageDialog(null, Id_associado);
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
