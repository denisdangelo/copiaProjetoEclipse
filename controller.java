package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.DAO; //importação da classe do banco de dados
/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/main" , "/insert"})


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//criando o objeto dentro da classe do controller para importar e usar como metodo no doGET
	DAO dao = new DAO();//testar o banco
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*testeConexao();//fazer teste com o banco*/
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main" )) {
			produtos(request,response);
			}else if (action.equals("/insert")){
				novoProduto(request,response);
			}else {
				response.sendRedirect("index.html");
			}
		}
	protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("cadastro.jsp");
	}
	//novo produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do formulário
		//aqui coloco o name da tag
		System.out.println(request.getParameter("nome_produto"));
		System.out.println(request.getParameter("qtde"));
		System.out.println(request.getParameter("valorunit"));
		System.out.println(request.getParameter("data_cad"));
		
	}
}
