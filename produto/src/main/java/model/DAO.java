package model;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
