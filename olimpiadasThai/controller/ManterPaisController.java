package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pNome = request.getParameter("id");
        String pFone = request.getParameter("nome");
        String pEmail = request.getParameter("name");

        //instanciar o javabean
        Pais pais = new Pais();
        pais.setId(pId);
        pais.seteNome(pNome);
        cliente.setName(pName);

        //instanciar o service
        PaisService ps = new PaisService();
        ps.criar(pais);
        pais = ps.carregar(pais.getId());

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
        out.println(	"id: "+pais.getId()+"<br>");
        out.println(	"nome: "+pais.getNome()+"<br>");
        out.println(	"fone: "+pais.getName()+"<br>");
        out.println("</body></html>");

    }

}
