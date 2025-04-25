package sistemapagamento;

public class CalculoPagamento {
    public double valorDoPagamento;
 
    public CalculoPagamento() {
    }
 
    public double AssalariadoCalc(Funcionarios var1) {
       this.valorDoPagamento = var1.salarioFixo;
       return this.valorDoPagamento;
    }
 
    public double HoristaCalc(Funcionarios var1) {
       this.valorDoPagamento = var1.valorPorHora * (double)var1.horasTrabalhadas;
       if (this.valorDoPagamento > 10000.0) {
          throw new IllegalArgumentException("\nO valor do pagamento não pode ser maior que 10.000.");
       } else {
          return this.valorDoPagamento;
       }
    }
 
    public double ComissionadoCalc(Funcionarios var1) {
       double var2 = (double)var1.totalDeVendas * ((double)var1.percentualComissao / 100.0) + var1.salarioFixo;
       if (var2 > 10000.0) {
          throw new IllegalArgumentException("\nO valor do pagamento não pode ser maior que 10.000.");
       } else {
          return var2;
       }
    }
 }
 