package model;

/*Shift + Ctrl + o - importar a bibilioteca*/
import java.time.LocalDate;
	
public class JavaBeans {

		private int id;
		private String nome;
		private int qtde;
		private float valor_unit;
		private LocalDate data_cad;
		
		
			/*Construtor - ajuda a acessar o banco de dados */
		public JavaBeans() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		/*Constutor Field*/
		public JavaBeans(int id, String nome, int qtde, float valor_unit, LocalDate data_cad) {
				super();
				this.id = id;
				this.nome = nome;
				this.qtde = qtde;
				this.valor_unit = valor_unit;
				this.data_cad = data_cad;
			}



		/*dentro da chave Source>> add gettings and settings*/
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getQtde() {
			return qtde;
		}
		public void setQtde(int qtde) {
			this.qtde = qtde;
		}
		public float getValor_unit() {
			return valor_unit;
		}
		public void setValor_unit(float valor_unit) {
			this.valor_unit = valor_unit;
		}
		public LocalDate getData_cad() {
			return data_cad;
		}
		public void setData_cad(LocalDate data_cad) {
			this.data_cad = data_cad;
		}
		
		
	
}
