package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAO {
//paremetros de conexão
	//driver do mysql
	private String driver = "com.mysql.cj.jdbc.Driver";
	//conexão com o servidor, ip do servidor, porta de acesso, nome do banco, fuso horário
	private String url = "jdbc:mysql://127.0.0.1:3306/cadastro?useTimezone=true&serverTimezone=UTC";
	//usurário do banco
	private String user = "root";
	//senha do banco
	private String password = "";
	
//Metodo de conexão
	//Conecction az parte do pacote JDBC 9 e cima da palavra control shift o para importar a class
	private Connection conectar() {
		Connection con = null;
		
		//escreve try + Ctrl + space
		try {
			//classe que lê a classe banco de dados
			Class.forName(driver);
			//DriverManager - classe que gerencia o acesso ao bando com os parametros de conexão
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
		System.out.println(e);
		return null;
		}
	}
	//teste de conexão
	//void metodo que não tem retorno
	/*public void testeConexao() {
		try {
			Connection con = conectar();
			//imprimir algo (parametro)
			System.out.println(con);
			//fechar a conexão
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
	/*=================Crud Create=============*/
	
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produto(nome, qtde, valor_unit,data_cad) values (?,?,?,?)";
		
		try {
			//Abrir conexão
			Connection con = conectar();
			
			//Preparar a Querry para conexão no banco
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituir os parametros ????
			pst.setString(1, produto.getNome());
			pst.setInt(2, produto.getQtde());
			pst.setFloat(3, produto.getValor_unit());
			pst.setDate(4, java.sql.Date.valueOf(produto.getData_cad()));
			
			//Executar a Querry
			pst.executeUpdate();
			
			//encerrar conexão com o banco
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*=================Fim Crud Create=========*/
	
	/*=================Crud Read=============*/
	
	public ArrayList<JavaBeans> listarProdutos(){
		
		//criando um bjeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		
		String read = "select * from produto order by nome";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read); /*prepara a Querry*/
			ResultSet rs = pst.executeQuery();
			
			//laço de repetição para buscar todos os objetos do banco. Será executado enquanto houver produtos
			while(rs.next()) {
				//variaveis de apoio
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int qtde = rs.getInt(3);
				float valorunit = rs.getFloat(4);
				LocalDate data_cadastro = rs.getDate("data_cad").toLocalDate();
				
				//populando a ArrayList
				produtos.add(new JavaBeans(id,nome,qtde,valorunit,data_cadastro));
				
			}
			
			con.close();
			return produtos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/*=================FIMCrud Read==========*/
}

 

