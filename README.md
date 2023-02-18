# Projeto final do módulo Testes Automatizados I do curso da Ada Tech

## 📋 Entendendo o projeto

Este é um conjunto de testes de unidade para a classe CustomerServiceImpl e OrdemDeServicoServiceImpl que fornece implementações para os métodos de gerenciamento de um sistema de Ordem de Serviço.

## Métodos testados
Os seguintes métodos da clase CustomerService foram testados:

- public Customer register(String cpf, String nome, String telefone) throws Exception;
- public void update(String cpf, String nome, String telefone);
- public void delete(String cpf);
- public Customer search(String cpf);

Os seguintes métodos da clase OrdemDeServicoService foram testados:

- public double valorTotal(OrdemDeServico ordemDeServico);
- public void registraServicos(OrdemDeServico ordemDeServico, List<Servico> servicos);

## Como executar os testes
Para executar os testes, siga estas etapas:

Certifique-se de ter a biblioteca JUnit 5 adicionada às suas dependências.
Copie e cole o código da classe de teste na sua IDE ou ambiente de desenvolvimento.
Execute a classe de teste como uma classe de teste JUnit.
Os resultados dos testes serão exibidos na interface da sua IDE ou ambiente de desenvolvimento, indicando se os testes passaram ou falharam.

## Relatório de Coverage
Certifique-se de ter a biblioteca do Jococo adicionada às suas dependências, assim como no build do pom.xml.
Ter instalado também o Maven, para poder executar o comando ```mvn test``` assim gerando o relatório com o coverage dos testes.

## Conclusão
Ao executar estes testes de unidade, você tem uma garantia maior de que a classe CustomerServiceImpl está funcionando corretamente e gerenciando o objeto Customer da maneira esperada. O mesmo vale para a classeOrdemDeServicoServiceImpl. Isso ajuda a garantir a qualidade e a confiabilidade do seu código.

## ✒️ Autor

* **Samir Hamadé Rocha** - *Desenvolvimento* - [hamadecd](https://github.com/hamadecd)

## 

Exercício dado pelo professor do módulo sobre Testes Automatizados I - **Igor Santos Mascarenhas** - [igorsmasc](https://github.com/igorsmasc)
