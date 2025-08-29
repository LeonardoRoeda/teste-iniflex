package com.iniflex.main;

import com.iniflex.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;



public class Principal {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// 3.1 – Inserindo todos os funcionários
		System.out.println("3.1 - Inserindo todos os funcionários...");
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
		imprimirFuncionarios(funcionarios);
		System.out.println("------------------------------------------------------\n");


		// 3.2 – Removendo o funcionário “João” da lista
		System.out.println("3.2 - Removendo funcionário 'João'...");
		funcionarios.removeIf(f -> f.getNome().equals("João"));
		System.out.println(funcionarios);
		System.out.println("------------------------------------------------------\n");


		// 3.3 – Imprimir todos os funcionários com todas suas informações
		System.out.println("3.3 - Imprimindo  os funcionários (exceto João)com suas informações:");
		imprimirFuncionarios(funcionarios);
		System.out.println("------------------------------------------------------\n");


		// 3.4 – Aumento de 10% no salário
		System.out.println("3.4 - Aplicação de aumento em 10% no salário...");
		BigDecimal aumento = new BigDecimal("1.10");
		for (Funcionario f : funcionarios) {
			f.setSalario(f.getSalario().multiply(aumento));
		}
		System.out.println("Salários atualizados. Imprimindo novamente para atualizar:");
		imprimirFuncionarios(funcionarios);
		System.out.println("------------------------------------------------------\n");


		// 3.5 – Agrupar os funcionários por função em um MAP
		Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
						.collect(Collectors.groupingBy(Funcionario::getFuncao));


		// 3.6 – Imprimir os funcionários, agrupados por função
		System.out.println("3.6 - Imprimindo funcionários agrupados por função:");
		funcionariosPorFuncao.forEach((funcao, lista) -> {
			System.out.println("\nFunção: " + funcao);
			imprimirFuncionarios(lista);
		});
		System.out.println("------------------------------------------------------\n");


		// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12 da tabela
		System.out.println("3.8 - Imprimindo aniversariantes de Outubro (10) e Dezembro (12):");
		funcionarios.stream()
						.filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
						.forEach(f -> System.out.printf("Nome: %s, Data Nasc.: %s%n", f.getNome(), f.getDataNascimento().format(dateFormatter)));
		System.out.println("------------------------------------------------------\n");


		// 3.9 – Imprimir o funcionário com a maior idade da empresa
		System.out.println("3.9 - Imprimindo funcionário com maior idade:");
		Funcionario maisVelho = funcionarios.stream()
						.min(Comparator.comparing(Funcionario::getDataNascimento))
						.orElse(null);

		if (maisVelho != null) {
			int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
			System.out.printf("Nome: %s, Idade: %d anos%n", maisVelho.getNome(), idade);
		}
		System.out.println("------------------------------------------------------\n");


		// 3.10 – Imprimir a lista de funcionários por ordem alfabética
		System.out.println("3.10 - Imprimindo lista de funcionários em ordem alfabética:");
		List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
		funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
		imprimirFuncionarios(funcionariosOrdenados);
		System.out.println("------------------------------------------------------\n");


		// 3.11 – Imprimir o total dos salários dos funcionários
		System.out.println("3.11 - Imprimindo o total dos salários:");
		BigDecimal totalSalarios = funcionarios.stream()
						.map(Funcionario::getSalario)
						.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Total dos salários: " + formatarValor(totalSalarios));
		System.out.println("------------------------------------------------------\n");


		// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário
		System.out.println("3.12 - Imprimindo salários em termos de salários mínimos (R$1212.00):");
		BigDecimal salarioMinimo = new BigDecimal("1212.00");
		for (Funcionario f : funcionarios) {
			BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
			System.out.printf("Nome: %s, Salários Mínimos: %s%n", f.getNome(), formatarValor(qtdSalariosMinimos));
		}
		System.out.println("------------------------------------------------------\n");
	}

	private static void imprimirFuncionarios(List<Funcionario> lista) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.printf("%-10s %-15s %-15s %-15s%n", "Nome", "Data Nasc.", "Salário", "Função");
		System.out.println("------------------------------------------------------------");
		for (Funcionario f : lista) {
			System.out.printf("%-10s %-15s %-15s %-15s%n",
							f.getNome(),
							f.getDataNascimento().format(dateFormatter),
							formatarValor(f.getSalario()),
							f.getFuncao());
		}
	}

	/**
	 * Método auxiliar para formatar todos os valores do tipo BigDecimal para a Lingua Portuguesa.
	 */
	private static String formatarValor(BigDecimal valor) {
		return String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", valor);

	}
}