package sistemapagamento;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SistemaPagamentoFuncionarios {
   ArrayList<Funcionarios> funcionariosList = new ArrayList<>();
   Scanner scanner;
   CalculoPagamento calculoPagamento;

   public SistemaPagamentoFuncionarios() {
      this.scanner = new Scanner(System.in);
      this.calculoPagamento = new CalculoPagamento();
   }

   public void cadastrarFuncionario() {
      Funcionarios var1 = new Funcionarios();
      System.out.println("Digite o nome do funcionário: ");
      var1.nome = this.scanner.nextLine();
      System.out.println("Digite o ID do funcionário (4 dígitos): ");

      try {
         var1.setID(this.scanner.nextInt(), this.funcionariosList);
      } catch (IllegalArgumentException var3) {
         System.out.println("Erro: " + var3.getMessage());
         this.scanner.nextLine();
         return;
      }

      this.scanner.nextLine();
      System.out.println("Digite o tipo de funcionário (Assalariado, Horista, Comissionado): ");
      String var2 = this.scanner.nextLine();
      if (!var2.equals("Assalariado") && !var2.equals("Horista") && !var2.equals("Comissionado")) {
         System.out.println("Tipo de funcionário inválido. Por favor, insira um tipo válido.");
      } else {
         var1.tipoDeFuncionario = var2;
         this.funcionariosList.add(var1);
         System.out.println("-------------------------------------");
         System.out.println("Funcionário cadastrado com sucesso!");
         System.out.println("-------------------------------------");
      }
   }

   public void calcularPagamento() {
      System.out.println("Digite o ID do funcionário para calcular o pagamento: ");
      String var1 = this.scanner.nextLine();

      int var2;
      try {
         var2 = Integer.parseInt(var1);
      } catch (NumberFormatException var6) {
         System.out.println("Erro: ID deve ser numérico.");
         return;
      }

      Funcionarios var3 = null;
      Iterator<Funcionarios> var4 = this.funcionariosList.iterator();

      while(var4.hasNext()) {
         Funcionarios var5 = (Funcionarios)var4.next();
         if (var5.getID() == var2) {
            var3 = var5;
            break;
         }
      }

      if (var3 == null) {
         System.out.println("\nFuncionário não encontrado.");
      } else {
         PrintStream var10000;
         double var10001;
         switch (var3.tipoDeFuncionario) {
            case "Assalariado":
               var10000 = System.out;
               var10001 = this.calculoPagamento.AssalariadoCalc(var3);
               var10000.println("Pagamento: " + var10001);
               break;
            case "Horista":
               var3.lerValorPorHora();
               var3.lerHorasTrabalhadas();
               var10000 = System.out;
               var10001 = this.calculoPagamento.HoristaCalc(var3);
               var10000.println("Pagamento: " + var10001);
               break;
            case "Comissionado":
               var3.lerTotalDeVendas();
               var3.lerPercentualComissao();
               var10000 = System.out;
               var10001 = this.calculoPagamento.ComissionadoCalc(var3);
               var10000.println("Pagamento: " + var10001);
               break;
            default:
               System.out.println("\nTipo de funcionário inválido.");
         }

      }
   }

   public void InfoFuncionarios() {
      System.out.println("Digite o ID do funcionário para mostrar as informações: ");
      int var1 = this.scanner.nextInt();
      this.scanner.nextLine();
      boolean var2 = false;
      Iterator<Funcionarios> var3 = this.funcionariosList.iterator();

      while(var3.hasNext()) {
         Funcionarios var4 = (Funcionarios)var3.next();
         if (var4.getID() == var1) {
            System.out.println("nome: " + var4.nome);
            System.out.println("ID: " + var4.getID());
            System.out.println("Tipo de Funcionário: " + var4.tipoDeFuncionario);
            PrintStream var10000;
            double var10001;
            if (var4.tipoDeFuncionario.equals("Horista")) {
               System.out.println("Valor por Hora: " + var4.valorPorHora);
               System.out.println("Horas Trabalhadas: " + var4.horasTrabalhadas);
               var10000 = System.out;
               var10001 = this.calculoPagamento.HoristaCalc(var4);
               var10000.println("Pagamento Total: " + var10001);
            } else if (var4.tipoDeFuncionario.equals("Comissionado")) {
               System.out.println("Total de Vendas: " + var4.totalDeVendas);
               System.out.println("Percentual de Comissão: " + var4.percentualComissao);
               var10000 = System.out;
               var10001 = this.calculoPagamento.ComissionadoCalc(var4);
               var10000.println("Pagamento Total: " + var10001);
            } else if (var4.tipoDeFuncionario.equals("Assalariado")) {
               System.out.println("Pagamento Total: " + var4.salarioFixo);
            }

            var2 = true;
            break;
         }
      }

      if (!var2) {
         System.out.println("\nFuncionário não encontrado.");
      }

   }

   public void menu() {
      while(true) {
         System.out.println("\nSistema de Pagamento de Funcionários");
         System.out.println("1. Cadastrar Funcionário");
         System.out.println("2. Calcular Pagamento");
         System.out.println("3. Mostrar Informações dos Funcionários");
         System.out.println("4. Sair");
         System.out.println("Escolha uma opção: ");
         String var1 = this.scanner.nextLine();

         int var2;
         try {
            var2 = Integer.parseInt(var1.trim());
         } catch (NumberFormatException var4) {
            System.out.println("Opção inválida, por favor digite um número.");
            continue;
         }

         switch (var2) {
            case 1:
               this.cadastrarFuncionario();
               break;
            case 2:
               this.calcularPagamento();
               break;
            case 3:
               this.InfoFuncionarios();
               break;
            case 4:
               System.out.println("Saindo...");
               return;
            default:
               System.out.println("Opção inválida!");
         }
      }
   }

   public static void main(String[] var0) {
      SistemaPagamentoFuncionarios var1 = new SistemaPagamentoFuncionarios();
      var1.menu();
   }
}
