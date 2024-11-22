import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int pos = 0;

        System.out.print("Quantos contribuintes você deseja digitar? ");
        int n = sc.nextInt();

        List<TaxPayer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            System.out.println("Digite os dados do contribuinte nº " + (i+1));
            System.out.print("Renda atual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer tax = new TaxPayer(salaryIncome,servicesIncome,capitalIncome,healthSpending,educationSpending);
            list.add(tax);

        }

        System.out.println();

        for(TaxPayer tax  : list ){
            pos++;
            System.out.printf("Resumo do %do contribuinte: \n",pos);
            System.out.printf("Imposto bruto total: %.2f\n",tax.grossTax());
            System.out.printf("Abatimento: %.2f\n",tax.taxRebate());
            System.out.printf("Imposto devido: %.2f\n",tax.netTax());
            System.out.println();
        }


        sc.close();



    }
}