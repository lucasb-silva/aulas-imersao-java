![imersaothumb](https://user-images.githubusercontent.com/59655760/230459219-3572b0ed-3489-40d7-9acd-4019c598d183.png)
  
# Alura Stickers e LinguagensAPI

Projetos desenvolvidos durante o envento Imersão Java da Alura. A aplicação Alura Stickers consiste em consumir uma API e gerar uma imagem com uma mensagem
personalizada num formato de figurinha do WhatsApp. O projeto LinguagensAPI tem como objetivo criar e publicar uma API na nuvem que pode ser consumida por qualquer
aplicação.

## 🔨 Resultados

<details>
  <summary><b>Aula 1</b></summary>

Consumindo a API do IMDb e exibindo resultados:

![](https://user-images.githubusercontent.com/59655760/230469849-a85f38d4-ae73-4bf6-8bcd-4003add7599f.gif)

<b>Desafios da aula</b>
- Consumir outros endpoints da mesma API ✔
- Melhorar a exibição dos resultados no terminal ✔
- Proteger a chave da API retirando do código, como um arquivo ou variavel de ambiente. (Feito na aula seguinte) ✔

OBS: Devido alto acesso, a API real do IMDb ficou fora do ar, então foi usada a API criada pelo curso. Nesse primeiro momento a ideia era utilizar o minimo de
bibliotecas externas.

</details>

<details>
  <summary><b>Aula 2</b></summary>

Gerando as figurinhas com as imagens da API e adicionando uma mensagem personalizada com base na avaliação.

![](https://user-images.githubusercontent.com/59655760/230479090-7aa40316-c565-40a9-a91e-5dcadfe3e380.gif)

Uso da figurinha no WhatsApp:

![](https://user-images.githubusercontent.com/59655760/230479168-8af4cd93-99e6-4616-ab71-9f58d591e634.png)

<b>Desafios da aula</b>
- Criar diretório de saída das imagens. ✔
- Centralizar o texto na figurinha. ✔
- Colocar outra fonte como a Comic Sans ou a Impact. ✔
- Colocar contorno (outline) no texto da imagem. ✔
- Fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB. ✔

OBS: Uma das imagens não condiz com os resultados exibidos no terminal, é apenas um erro da API fornecida pelo curso.

</details>

<details>
  <summary><b>Aula 3</b></summary>

Refatoração do código e melhorias, a aplicação pode agora usar diferentes APIs:

![](https://user-images.githubusercontent.com/59655760/230522010-8266d5b9-5bd2-4fbc-9080-2a013c574dbe.gif)

<b>Desafios da aula</b>
- Transformar a classe que representa os conteúdos em um Record. ✔
- Criar as suas próprias exceções e usá-las na classe que implementa o cliente HTTP. ✔
- Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra. ✔
- Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado. ✔

</details>

<details>
  <summary><b>Aula 4 e 5</b></summary>

Criando uma API com Spring e armazenando num banco de dados NoSQL:

Executando localmente:
![](https://user-images.githubusercontent.com/59655760/230532697-40f1e60e-c7c7-4969-b4c8-7e293306e88c.gif)
![](https://user-images.githubusercontent.com/59655760/230533079-58b8014f-498f-4313-b045-2661274c586e.gif)

Executando na nuvem:
![](https://user-images.githubusercontent.com/59655760/230538066-f4004e34-91b7-4fc7-b734-b6f17ebf1aab.gif)

<b>Desafios da aula</b>
- Finalizar o CRUD (Create, Read, Update e Delete) para que se possa atualizar e excluir uma linguagem cadastrada. ✔
- Devolver a listagem ordenada pelo ranking. ✔
- Retornar o status 201 quando um recurso for cadastrado através do POST. ✔

</details>

## 📁 Acesso ao projeto

<b>Aula 1</b>

A versão do código da Aula 1 pode ser encontrado na branch [aula1](https://github.com/lucasb-silva/aulas-imersao-java/tree/aula1).

<b>Aula 2</b>

A versão do código da Aula 2 pode ser encontrado na branch [aula2](https://github.com/lucasb-silva/aulas-imersao-java/tree/aula2).

<b>Aula 3</b>

A versão do código da Aula 3 pode ser encontrado na branch [aula3](https://github.com/lucasb-silva/aulas-imersao-java/tree/aula3).

<b>Aula 4 e 5</b>

A versão do código da Aula 4 e 5 pode ser encontrado na branch [aula4-5](https://github.com/lucasb-silva/aulas-imersao-java/) nos diretórios `alura-stickers` 
e `linguagens-api`.
