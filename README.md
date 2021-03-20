# MarsAir

Projeto criado para processo seletivo da ThoughtWorks no papel de pessoa Analista de Qualidade.

## Estratégia
	Estratégias para criação dos testes:

	1. Para auxiliar na visualização dos cenários de teste, foi criado o BDD para cada história de usuário, com os correspondentes cenários de teste.  
	2. Foi realizado um teste exploratório para conhecer a aplicação e validar regras de negócio relatadas nas histórias de usuário. 
	3. Este teste foi feito nos navegadores Chrome, Firefox e Microsoft Edge em desktop e mobile (Android). 
	4. Criado issues e board no github para acompanhar o desenvolvimento dos testes e levantamento de métricas
	5. A partir dos cenários levantados e a contextualização da aplicação através do teste exploratório, foi realizado a automação dos principais cenários de teste. 

## Abaixo seguem os detalhes da automação desenvolvida:

## Objetivo do projeto:

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
	`mvn clean test site`
	```

	o relatório em HTML será gerado no caminho `target/site/index.html`.
    
## Cenários de Teste UI que estão cobertos

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
    
História de usuário: Promotional codes

	Cenário 1: Utilizar código promocional válido
	Dado que o usuário deseje reservar um ticket
	E ele utilize o campo “departing” e "returning" válidos
	E use um código promocional válido
	E haja assentos livres
	Quando ele clicar no botão Search
	Então o site deve mostrar a mensagem: “Assentos disponíveis! Ligue para 0800   MARSAIR para reservar!”
	E mostrar a seguinte mensagem: “Promotional code [code] used: [discount]% discount!”

	Cenário 2: Utilizar código promocional inválido
	Dado que o usuário deseje reservar um ticket
	E ele utilize o campo “departing” e "returning" válidos
	E use um código promocional inválido
	E haja assentos livres
	Quando ele clicar no botão Search
	Então o site deve mostrar a mensagem: “Assentos disponíveis! Ligue para 0800   MARSAIR para reservar!”
	E mostrar a seguinte mensagem: “Sorry, code [invalid promo code] is not valid”
	
História de usuário: Link to Home Page

	Cenário 1: Direcionar para a home page ao clicar no logo
	Dado o usuário está no site MarsAir
	e deseja acessar a home page
	Quando o ele clicar logo
	Então o site deve direcioná-lo para a  tela inicial

História de usuário: Not valid Return Date

	Cenário 1: Retornar erro ao usar datas inválidas
	Dado que o usuário tente reservar um ticket
	E insira datas que não correspondem ao período de 1 ano a partir da “departing”
	Quando o usuário clicar em Search
	Então deve ser exibida a mensagem: “Unfortunately, this schedule is not possible. Please try again.”
    

## Nota

	Os bugs encontrados estão nas issues do githug e foram reportados diretamente na plataforma. 


