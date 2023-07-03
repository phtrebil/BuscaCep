# BuscaCep
Este repositório contém um projeto de exemplo que utilizei para estudar o Retrofit e as diferenças entre o uso de Callbacks e Coroutines para fazer requisições assíncronas. O objetivo é demonstrar como realizar uma busca de endereço utilizando a API de CEPs.

<h3>Funcionamento</h3>

A classe principal do projeto é MainActivity, que estende AppCompatActivity. O fluxo principal do aplicativo é o seguinte:

1. O layout da atividade é inflado a partir do arquivo activity_main.xml.
2. Ao clicar no botão "Buscar", é obtido o CEP digitado pelo usuário.
3. É iniciada uma coroutine na Dispatchers.Main para executar a busca de endereço de forma assíncrona.
4. Utilizando o Retrofit, é feita uma chamada à API de CEPs, passando o CEP informado.
5. Se a resposta for bem-sucedida, o layout com as informações de endereço é exibido, preenchendo os campos com os dados obtidos.
6. Caso ocorra algum erro na requisição ou o endereço não seja encontrado, uma mensagem de erro é exibida.

<h3>Callback vs. Coroutines</h3>

Neste projeto, explorei as duas abordagens para lidar com requisições assíncronas: Callbacks e Coroutines. Utilizei Coroutines para aproveitar a sintaxe mais limpa e concisa que elas proporcionam.

No código presente na MainActivity, utilizei a função launch para iniciar uma coroutine na Dispatchers.Main. Isso permite que as operações de rede sejam executadas em um contexto não bloqueante, mantendo a interface do usuário responsiva.

Para o tratamento de erros, utilizei um bloco try-catch. Caso ocorra uma exceção, a mensagem de erro é exibida e o layout com as informações de endereço é ocultado.

Mas aqui também pode como ficou o código utilizando [Callback](https://github.com/phtrebil/BuscaCep/tree/utilizando_callback).

<h3>Considerações Finais</h3>
Este projeto é apenas um exemplo básico de como utilizar o Retrofit para fazer requisições assíncronas utilizando Callbacks e Coroutines. Sinta-se à vontade para explorar e adaptar o código de acordo com as suas necessidades.

Espero que este repositório seja útil para você entender e experimentar as diferenças entre Callbacks e Coroutines no contexto de requisições assíncronas com Retrofit.

Se tiver alguma dúvida ou sugestão, fique à vontade para entrar em contato.
