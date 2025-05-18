package br.com.myproject.currency.converter;

import java.util.Scanner;

public class CurrencyConverterMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter =]\n");

       /* // Creation of currency objects with conversion rate
        CurrencyType dollar = new CurrencyType("Dollar", 5.67);
        CurrencyType real = new CurrencyType("Real", 6.42);
        CurrencyType rmb = new CurrencyType("Rmb", 6.00);
        CurrencyType swedishKrona = new CurrencyType("Swedish Krona", 0.05);*/

        int optionToConvert = 0;

        while (optionToConvert != 9) {
            System.out.println("Choose the option: \n" +
                    "1) Dollar >> Real \n" +
                    "2) Real >> Dollar \n" +
                    "3) Rmb >> Swedish Krona \n" +
                    "4) Swedish Krona >> Rmb \n" +
                    "5) Real >> Rmb \n" +
                    "6) Rmb >> Real \n" +
                    "7) Swedish Krona >> Real \n" +
                    "8) Real >> Swedish Krona \n" +
                    "9) Exit");

            try {
                optionToConvert = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.\n");
                continue; // return to the menu without breaking the program
            }

            if (optionToConvert == 9){
                System.out.println("Exiting the currency converter...");
                break;
            }

            System.out.println("Enter the amount to be converted: ");
            double amountToConvert = scanner.nextDouble();

            double convertedValue = 0;
            double rate = 0;

            switch (optionToConvert) {
                case 1: //Dollar to Real
                    rate = ExchangeRateAPIClient.getExchangeRate("USD", "BRL");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [USD] corresponds to final amount: %.2f [BRL]%n", amountToConvert, convertedValue);
                    break;
                case 2: //Real to Dollar
                    rate = ExchangeRateAPIClient.getExchangeRate("BRL", "USD");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [BRL] corresponds to final amount: %.2f [USD]%n", amountToConvert, convertedValue);
                    break;
                case 3: //Rmb to Swedish Krona
                    rate = ExchangeRateAPIClient.getExchangeRate("CNY", "SEK");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [CNY] corresponds to final amount: %.2f [SEK]%n", amountToConvert, convertedValue);
                    break;
                case 4: //Swedish Krona to Rmb
                    rate = ExchangeRateAPIClient.getExchangeRate("SEK", "CNY");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [SEK] corresponds to final amount: %.2f [CNY]%n", amountToConvert, convertedValue);
                    break;
                case 5: //Real to Rmb
                    rate = ExchangeRateAPIClient.getExchangeRate("BRL", "CNY");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [BRL] corresponds to final amount: %.2f [CNY]%n", amountToConvert, convertedValue);
                    break;
                case 6: //Rmb to Real
                    rate = ExchangeRateAPIClient.getExchangeRate("CNY", "BRL");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [CNY] corresponds to final amount: %.2f [BRL]%n", amountToConvert, convertedValue);
                    break;
                case 7: //Swedish Krona to Real
                    rate = ExchangeRateAPIClient.getExchangeRate("SEK", "BRL");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [SEK] corresponds to final amount: %.2f [BRL]%n", amountToConvert, convertedValue);
                    break;
                case 8: //Real to Swedish Krona
                    rate = ExchangeRateAPIClient.getExchangeRate("BRL", "SEK");
                    convertedValue = amountToConvert * rate;
                    System.out.printf("The value %.2f [BRL] corresponds to final amount: %.2f [SEK]%n", amountToConvert, convertedValue);
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();

        }
        scanner.close();

    }
}