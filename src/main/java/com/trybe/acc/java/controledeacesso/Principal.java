package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {
  /**
   * Mostra pergunta e opções para iniciar o programa.
   */
  private static void displayOptions() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Acessar o estabelecimento");
    System.out.println("2 - Finalizar sistema e mostrar relatório");
  }

  /**
   * Mostra uma mensagem baseada na idade do cliente.

   * @param age Um Integer que representa a idade do cliente.
   */
  private static void printMessage(int age) {
    String minorMessage = "Pessoa cliente menor de idade, catraca liberada!";
    String adultMessage = "Pessoa adulta, catraca liberada!";
    String oldMessage = "Pessoa adulta a partir de 50, catraca liberada!";

    if (age < 18) {
      System.out.println(minorMessage);
    } else if (age >= 18 && age < 50) {
      System.out.println(adultMessage);
    } else {
      System.out.println(oldMessage);
    }
  }

  /**
   * Retorna o número de clientes baseado na idade especificada pelo filtro.

   * @param ageList Um ArrayList contendo as idades dos clientes.
   * @param filter Uma String especificando o filtro de idade ("minor", "adult", or "old")
   * @return um Integer representando o número de clientes baseado no filtro
   */
  private static int getNumberOfClientsBasedOnAge(ArrayList<Integer> ageList, String filter) {
    ArrayList<Integer> filteredAgeList = new ArrayList<Integer>();

    for (int i = 0; i < ageList.size(); i++) {
      int age = (int) ageList.get(i);

      if (filter == "minor" && age < 18) {
        filteredAgeList.add(age);
      } else if (filter == "adult" && age >= 18 && age < 50) {
        filteredAgeList.add(age);
      } else if (filter == "old" && age >= 50) {
        filteredAgeList.add(age);
      }
    }

    return filteredAgeList.size();
  }

  /**
   * Gera um relatório com base na lista de idades fornecida. O relatório contém a quantidade e o
   * percentual de clientes classificados em cada faixa etária.

   * @param ageList a lista de idades dos clientes
   */
  private static void generateReport(ArrayList<Integer> ageList) {
    DecimalFormat decimalFormat = new DecimalFormat("0.0%");

    int totalClient = ageList.size();
    int minor = getNumberOfClientsBasedOnAge(ageList, "minor");
    int adult = getNumberOfClientsBasedOnAge(ageList, "adult");
    int old = getNumberOfClientsBasedOnAge(ageList, "old");

    float minorPercentage = (float) minor / totalClient;
    float adultPercentage = (float) adult / totalClient;
    float oldPercentage = (float) old / totalClient;

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + minor);
    System.out.println("adultas: " + adult);
    System.out.println("a partir de 50: " + old);

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + decimalFormat.format(minorPercentage));
    System.out.println("adultas: " + decimalFormat.format(adultPercentage));
    System.out.println("a partir de 50: " + decimalFormat.format(oldPercentage));
  }

  /**
   * Solicita a idade do usuário através do Scanner e adiciona o valor informado em uma lista de
   * idades.

   * @param scanner o objeto Scanner para leitura da entrada do usuário
   * @param ageList a lista de idades onde será adicionada a idade informada pelo usuário
   */
  private static void getClientAge(Scanner scanner, ArrayList<Integer> ageList) {
    System.out.println("Entre com a sua idade:");
    int age = scanner.nextInt();
    ageList.add(age);
    printMessage(age);
  }

  /**
   * Método principal do programa, responsável por solicitar a idade do usuário e gerar um
   * relatório.

   * @param args argumentos passados na linha de comando (não utilizado neste programa)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ageList = new ArrayList<Integer>();

    displayOptions();
    int option = scanner.nextInt();

    if (option != 1 && option != 2) {
      System.out.println("Entre com uma opção válida");
    } else if (option == 1) {
      while (option != 2) {
        getClientAge(scanner, ageList);
        displayOptions();
        option = scanner.nextInt();
      }
    }

    if (option == 2) {
      generateReport(ageList);
    }

    scanner.close();
  }
}
