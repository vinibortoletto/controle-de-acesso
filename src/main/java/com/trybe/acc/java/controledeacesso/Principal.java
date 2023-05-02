package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {
  /**
   * Método displayOptions.
   */
  public static void displayOptions() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Acessar o estabelecimento");
    System.out.println("2 - Finalizar sistema e mostrar relatório");
  }

  /**
   * Método printMessage.
   */
  public static void printMessage(int age) {
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
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ageList = new ArrayList<Integer>();

    displayOptions();
    int option = scanner.nextInt();

    if (option == 2) {
      System.out.println(ageList);
    }

    while (option != 2) {
      System.out.println("Entre com a sua idade:");
      int age = scanner.nextInt();
      ageList.add(age);
      printMessage(age);

      displayOptions();
      option = scanner.nextInt();
    }

    scanner.close();
  }
}
