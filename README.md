# Desafio Técnico - Gerenciamento de Funcionários Iniflex

Este é um projeto em Java desenvolvido como parte de um desafio técnico da Iniflex. A aplicação gerencia uma lista de funcionários, realizando diversas operações de inserção, remoção, consulta e manipulação de dados, demonstrando o uso de boas práticas de programação da linguagem Java.

## 📋 Funcionalidades

A aplicação executa as seguintes operações em sequência:

* ✅ **Inserção de Funcionários:** Carga inicial de uma lista pré-definida de funcionários.
* ✅ **Remoção de Funcionários:** Remove um funcionário específico ("João") da lista.
* ✅ **Impressão Formatada:** Exibe a lista completa de funcionários com datas (`dd/mm/aaaa`) e salários (formato monetário brasileiro `R$ 1.234,56`) devidamente formatados.
* ✅ **Aumento Salarial:** Aplica um aumento de 10% no salário de todos os funcionários.
* ✅ **Agrupamento por Função:** Agrupa os funcionários em um `Map` utilizando a função como chave, permitindo fácil consulta por cargo.
* ✅ **Filtro de Aniversariantes:** Lista os funcionários que fazem aniversário em meses específicos (outubro e dezembro).
* ✅ **Cálculo de Idade:** Encontra o funcionário com a maior idade e exibe seu nome e idade.
* ✅ **Ordenação Alfabética:** Imprime a lista de funcionários em ordem alfabética por nome.
* ✅ **Soma de Salários:** Calcula e exibe o valor total da folha salarial da empresa.
* ✅ **Análise Salarial:** Mostra quantos salários mínimos cada funcionário recebe, com base em um valor de referência.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** `Java 8+`
* **APIs Principais:**
    * `Java Streams API`: Utilizada para manipulação, filtro e agregação de dados de forma funcional e eficiente.
    * `java.time (LocalDate)`: Para o gerenciamento preciso de datas de nascimento.
    * `java.math.BigDecimal`: Para garantir a precisão nos cálculos monetários e evitar problemas de arredondamento com tipos primitivos.


## Autores

- [@leonardoroeda](https://github.com/LeonardoRoeda/teste-iniflex)

