#  Informações sobre Threads em Java

### Em Java

* A própria **main** de java é um Processo sequêncial.
* Para criarmos vários Processos em Java, utilizamos a Classe Thread que já existe implementada em Java.
* Com a classe Thread podemos criar outros Processos e podemos também executar diferentes Processos.
* Algumas Funções para usar:

Função|Para que serve
|---|---|
**getId()**| Retorna o Identificador da Thread
**getName()**| Retorna o nome da Thread
**getPriority()**|Retorna a prioridade da Thread
**interrupt()**| Interrompe a Thread
**start()**|Inicia a Execução da Thread
**sleep(long milisegundos)**|Faz a thread parar por um tempo
**toString()**|Imprime as informações da Thread
**currentThread()**|Apresenta as informações da Thread atual
**activeCount()**| Retorna uma estimativa de threads ativas