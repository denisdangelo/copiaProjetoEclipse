package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO; //importação da classe do banco de dados
import model.JavaBeans;
/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/main" , "/insert"})


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//criando o objeto dentro da classe do controller para importar e usar como metodo no doGET
	DAO dao = new DAO();//testar o banco
       JavaBeans produto = new JavaBeans();
       
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
		/*criando o objeto que ira listar os dados JavaBeans ArrayList que estamos usando no DAO*/
		/*precisa importar o metodo ArrayList (Ctrl+Shift+o)*/
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		
		//teste de recebimento  da lista
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getQtde());
			System.out.println(lista.get(i).getValor_unit());
			System.out.println(lista.get(i).getData_cad());
		}
		
	}
	//novo produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do formulário
		//aqui coloco o name da tag
		System.out.println(request.getParameter("nome_produto"));
		System.out.println(request.getParameter("qtde"));
		System.out.println(request.getParameter("valorunit"));
		System.out.println(request.getParameter("data_cad"));
		
		/*Setar as variaveis JavaBeans*/
		int qtde = Integer.parseInt(request.getParameter("qtde"));
		String valorUnitStr = request.getParameter("valorunit").replace(",",".");
		float valorUnit = Float.parseFloat(valorUnitStr);
		String dataTexto = request.getParameter("data_cad");
		LocalDate data = LocalDate.parse(dataTexto);
		
		produto.setNome(request.getParameter("nome_produto"));
		produto.setQtde(qtde);
		produto.setValor_unit(valorUnit);
		produto.setData_cad(data);
		
		dao.inserirProduto(produto);
		
		//redirecionar para o documento
		response.sendRedirect("main");
	}
}
