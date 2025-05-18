package br.com.myproject.currency.converter;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ExchangeRateAPIClient {

    private static final String API_KEY = "198cbf8f6d0d9a319870b2c1";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            String urlString = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, baseCurrency);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("conversion_rates");

            return rates.getDouble(targetCurrency);

        } catch (Exception e) {
            System.out.println("Error to fetching exchange rate: " + e.getMessage());
            return -1;
        }

    }

}
