Criação do app para gerar número aleatórios para jogos da Mega Sena. 
Nesse desenvolvimento o usuário terar que digitar um número entre 6 e 15 
Foi utilizado o comonado do Android Studio setOnClickListener: ele é usado para definir o que deve acontecer quando um usuário clica em um item da interface do aplicativo, como um botão. 
Em outras palavras, ele te permite programar uma reação específica para quando alguém interage com um elemento da tela.
Também utilizei o comando getSharedPreferences: no Android é usado para acessar um tipo de armazenamento interno que guarda dados em formato de pares chave-valor. 
Esse sistema é útil para salvar e recuperar informações pequenas e simples, como configurações do aplicativo ou preferências do usuário, e garantir que esses dados sejam mantidos mesmo após o aplicativo ser fechado e reaberto.
E por fim, utilizei o comando Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show(). Esse comando é uma forma prática de fornecer feedback imediato ao usuário em um aplicativo Android, exemplo, mensagem de erro
caso o usúario não digite um número que seja entre 6 e 15.
