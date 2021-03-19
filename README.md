# MarsAir

Projeto criado para processo seletivo projeto da ThoughtWorks no papel de pessoa Analista de Qualidade.

## Descriçao do projeto:

Desenvolver automação de teste para o processo de reserva de tickets para o planeta vermelho. 

```bash
`Link para teste de UI`
`https://marsair.thoughtworks-labs.net/DanielSilva`
```

## Tecnologias

* Java 8
* Maven
* Junit 4.13
* Selenium 3.141.59
* Google Chrome

## Executar todos os testes
```bash
`mvn test`
```

## Executar única classe de testes
```bash
`mvn -Dtest=NomeDaClasse test`
```

## Executar único método da classe de testes
```bash
`mvn -Dtest=NomeDaClasse#NomeDoMetodo test`
```
## Relatórios de testes

Para gerar relatório de test, deve ser executado o comando descrito abaixo:
```bash
`mvn surefire-report:report`
```

o relatório em HTML será gerado no caminho `target/site`.
    
## Cenários de Teste UI

História de usuário: Basic Search flow

Cenário 1: Mostrar campos de filtro na tela inicial
	Dado que eu acesso o site MarsAir
	E o site se encontrar disponível
	Quando a tela abrir
	Então deve apresentar os campos "departing" e “returning”

Cenário 2: Solicitar uma reserva de tickets disponíveis com sucesso
    Dado que o cenário 1 seja verdadeiro
    E o cliente filtrar o mês de viagem no campo “departing”
    E filtrar, no campo “returning”, o mês maior que o campo “departing”
    E houver tickets disponíveis
    Quando o cliente clicar o botão search
    Então o site deve mostrar a mensagem: “Assentos disponíveis! Ligue para 0800 MARSAIR para reservar!”

Cenário 3: Solicitar uma reserva de tickets disponíveis sem sucesso
    Dado que o cenário 1 seja verdadeiro
    E o cliente filtrar o mês de viagem no campo “departing”
    E filtrar, no campo “returning”, o mês maior que o campo “departing”
    E não houver tickets disponíveis
    Quando o cliente clicar o botão search
    Então o site deve mostrar a mensagem: “Sorry, there are no more seats available.”

História de usuário: Not valid Return Date


Cenário 1: Retornar erro ao usar datas inválidas
	Dado que o usuário tente reservar um ticket
	E insira datas que não correspondem ao período de 1 ano a partir da “departing”
	Quando o usuário clicar em Search
	Então deve ser exibida a mensagem: “Unfortunately, this schedule is not possible. Please try again.”
    
## Nota






