# Challenge Project

## Getting Started
	O projeto foi desenvolvido utilizando o framework do spring (springboot, springDATA, springWEB).
	Para que o projeto possa ser testado foi realizado o deploy no site da heroku (https://www.heroku.com) 
	e o projeto pode ser testado a partir da url: https://clickbus-rafael.herokuapp.com/.
	O projeto funciona com o JSON, portanto é necessário que seja realizada as requisições enviado no formato de JSON
	os dados e também suas respostas são em formato JSON. Para o desenvolvimento foi utilizado o programa POSTMAN.
	O projeto possui como principais funcionalidades:
	
1.	[Criar objeto (PLACE)](https://clickbus-rafael.herokuapp.com/places/ "Criar objeto") (Metodo POST)
2.	[Editar objeto (PLACE)](https://clickbus-rafael.herokuapp.com/places/{id} "Editar objeto") (Metodo PUT)
3.	[Buscar por ID (PLACE)](https://clickbus-rafael.herokuapp.com/places/{id} "Buscar objeto") (Metodo GET)
4.	[Buscar por Nome (PLACE)](https://clickbus-rafael.herokuapp.com/places?name={name} "Buscar objeto por nome") (Metodo GET)
5.	[Buscar todos (PLACE)](https://clickbus-rafael.herokuapp.com/places/ "Buscar todos") (Metodo GET)


	A baixo iremos ver como funciona cada endpoint.

#### EndPoints:

#####  1 - Criação do objeto (Place)
URL: **https://clickbus-rafael.herokuapp.com/places/**  
METODO: **POST**  
Para que seja criado o objeto, será necessário enviar o JSON contendo os seguintes valores:
*   Name - Obrigatório
*   slug - Opcional
*   city - Obrigatório
*   state - Obrigatório

Outro ponto de atenção é que não deve ser envado os valores **createdAt ou updatedAt**, caso seja enviado a API irá retornar o erro **"InvalidFieldsSendException"**.  
Essa exceção é lançada para que o usuário não altere esses valores, sendo que a propria API realiza essa alteração automaticamente.

#####  2 - Update do objeto (Place)
URL: **https://clickbus-rafael.herokuapp.com/places/{id}**  
METODO: **PUT**  
O endpoint realiza a atualização dos dados passados em formato JSON.  
Nenhum campo é obrigatório, porém caso não seja passado nenhum dado, a API irá retornar o erro 400.  
Outro ponto de atenção é que não deve ser envado os valores **createdAt ou updatedAt**, caso seja enviado a API irá retornar o erro **"InvalidFieldsSendException"**.  
Essa exceção é lançada para que o usuário não altere esses valores, sendo que a propria API realiza essa alteração automaticamente.  
Nenhum campo será obrigatório para a alteração, pode ser enviado apenas o campo que será alterado ou todos os campos de uma vez.

#####  3 - Listagem pelo atributo "id" do objeto (Place)
URL: **https://clickbus-rafael.herokuapp.com/places/{id}**  
METODO: **GET**  
O endpoint irá retornar o objeto que tem o ID passado como parametro na URL.

##### 4 - Listagem de todos os itens (Place)
URL: **https://clickbus-rafael.herokuapp.com/places/**  
METODO:**GET**  
O endpoint irá retornar todos os objetos criados no banco de dados.    
   

#####  5 - Listagem pelo atributo "name" do objeto (Place)
URL: **https://clickbus-rafael.herokuapp.com/places?name={nome}**  
METODO: **GET**  
O endpoint irá retornar os lugares que tem em seu nome a string passada como parametro na URL

	

#### Authors

* **Rafael Klaczok** - *Initial work* - [GitRafael](https://github.com/klaczok)
	 
