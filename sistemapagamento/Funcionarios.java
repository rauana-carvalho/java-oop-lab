package sistemapagamento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Funcionarios {
   public String tipoDeFuncionario;
   public String nome;
   public int ID;
   public int horasTrabalhadas;
   public int totalDeVendas;
   public int percentualComissao;
   public double salarioFixo = 1500.0;
   public double valorPorHora;
   CalculoPagamento calculoPagamento;
   Funcionarios funcionario;
   Scanner scanner;

   public Funcionarios() {
      this.scanner = new Scanner(System.in);
   }

   public void setID(int var1, ArrayList<Funcionarios> var2) {
      Iterator<Funcionarios> var3 = var2.iterator();

      Funcionarios var4;
      do {
         if (!var3.hasNext()) {
            if (Integer.toString(var1).length() != 4) {
               System.out.print("\n");
               throw new IllegalArgumentException("O número deve conter exatamente 4 dígitos.");
            }

            this.ID = var1;
            return;
         }

         var4 = (Funcionarios)var3.next();
      } while(var4.getID() != var1);

      System.out.print("\n");
      throw new IllegalArgumentException("O ID já está em uso por outro funcionário.");
   }

   public int getID() {
      return this.ID;
   }

   public void lerHorasTrabalhadas() {
      System.out.println("Digite as horas trabalhadas: ");

      try {
         this.horasTrabalhadas = this.scanner.nextInt();
         if (this.horasTrabalhadas < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.\n");
         }
      } catch (IllegalArgumentException var2) {
         System.out.println("Erro: " + var2.getMessage());
         System.out.println("\n");
         this.scanner.nextLine();
         this.lerHorasTrabalhadas();
      }

   }

   public void lerTotalDeVendas() {
      System.out.println("Digite o total de vendas: ");

      try {
         this.totalDeVendas = this.scanner.nextInt();
         if (this.totalDeVendas < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
         }
      } catch (IllegalArgumentException var2) {
         System.out.println("\n");
         System.out.println("Erro: " + var2.getMessage());
         System.out.println("\n");
         this.scanner.nextLine();
         this.lerTotalDeVendas();
      }

   }

   public void lerPercentualComissao() {
      System.out.println("Digite o percentual de comissão: ");

      try {
         this.percentualComissao = this.scanner.nextInt();
         if (this.percentualComissao < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
         }
      } catch (IllegalArgumentException var2) {
         System.out.println("");
         System.out.println("Erro: " + var2.getMessage());
         System.out.println("");
         this.scanner.nextLine();
         this.lerPercentualComissao();
      }

   }

   public void lerValorPorHora() {
      System.out.println("Digite o valor por hora: ");

      try {
         this.valorPorHora = this.scanner.nextDouble();
         if (this.valorPorHora < 0.0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
         }
      } catch (IllegalArgumentException var2) {
         System.out.println("");
         System.out.println("Erro: " + var2.getMessage());
         System.out.println("");
         this.scanner.nextLine();
         this.lerValorPorHora();
      }

   }
}
