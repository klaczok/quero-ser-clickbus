# Challenge Project


#### EndPoints:


##### 1 - Listagem de todos os itens (Place)

	Para realizar a pesquisa, é necessário acessar a url: localhost:8080/places/
	Dessa forma o retorno dos itens será exibido no formato JSON. 
	Não é necessário enviar nenhum 	parametro para a pesquisa.	

#####  2 - Listagem pelo atributo "name" do objeto (Place)
	Para realizar a pesquisa passando o filtro do nome, é necessário acessar a URL:  
	**** localhost:8080/places?name={nome}  
	Dessa forma, passando o nome completo ou apenas uma parte, será retornado em formato JSON os itens encontrados.
	
#####  3 - Update do objeto (Place)
	Para realiza o update, é necessário acessar a url: localhost:8080/places/{id} e passar como parametro o id do objeto que será alterado.  
	Nenhum campo será obrigatório para a alteração, pode ser enviado apenas o campo que será alterado ou todos os campos de uma vez.
	Não deve ser enviado o valor createdAt e updatedAt, pois a propria aplicação irá realizar a alteração do campo UpdatedAt e irá desconsiderar o createdAt, pois ele é preenchido apenas na criação.
	Caso o usuário envie, o sistema irá retornar uma exceção: "InvalidFieldsSendException".
	
#####  4 - Criação do objeto (Place)
	Para que seja criado o objeto, será necessário acessar a URL: localhost:8080/places, e enviar o JSON contendo os seguintes valores:
	*   Name - Obrigatório
	*   slug - Opcional
	*   city - Obrigatório
	*   state - Obrigatório
	Não deve ser enviado o valor createdAt e updatedAt, pois a propria aplicação irá realizar a alteração do campo createdAt no momento da criação e não irá modificar o valor updatedAt.
	Caso o usuário envie, o sistema irá retornar uma exceção: "InvalidFieldsSendException".
	
&copy; Rafael Klaczok
	 
