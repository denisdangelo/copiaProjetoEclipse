<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
    
    	//teste de recebimento 
    	for(int i = 0; i < lista.size(); i++){
    		out.print(lista.get(i).getId());
    		out.print(lista.get(i).getNome());
    		out.print(lista.get(i).getQtde());
    		out.print(lista.get(i).getValor_unit());
    		out.print(lista.get(i).getData_cad());
    	}
    %>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="shortcut icon" href="img/icon.png" type="image/x-icon">
<!-- boostrap css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!-- css -->
<link rel="stylesheet" href="style.css">

<title>Cadastro de Produtos</title>
</head>
<body>
	<div
		class="container d-flex justify-content-center align-items-center min-vh-100">
		<section class="card shadow-sm p-4 w-100" style="max-width: 500px;">
			<div class="text-left">
				<h1 class="text-dark mb-4">Cadastrar novo produto</h1>

				<form>
					<div class="form-group">
						<label for="nome_produto">Nome do Produto</label> <input
							type="text" class="form-control" name="nomeproduto" id="nome_produto"
							placeholder="Nome do Produto" required aria-required="true">
					</div>
					<div class="form-group">
						<label for="qtde">Quantidade</label> <input
							type="number" class="form-control"  name="qtde" id="qtde" min="1"
							placeholder="Quantidade do produto" required aria-required="true">
					</div>
					<div class="form-group">
						<label for="valor_unit">Valor do produto</label> <input
							type="text" class="form-control" name="valorunit" id="valor_unit"
							placeholder="Ex 12,99" required pattern="^\d+(,\d{1,2})?$" title= "Digite o valor com vírgula. Ex. 12,99" required aria-required="true">
					</div>
					<div class="form-group">
						<label for="data">Data do Cadastro</label> <input
							type="date" class="form-control" name="data_cad" id="data" required aria-required="true">
					</div>
					<button type="submit" class="btn btn-dark btn-block">Salvar</button>
				</form>
				
			</div>
		</section>
	</div>



	<!-- bostrap scripts -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>