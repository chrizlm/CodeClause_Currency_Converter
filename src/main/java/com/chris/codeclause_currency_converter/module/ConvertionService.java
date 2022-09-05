package com.chris.codeclause_currency_converter.module;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertionService {
    /**
     * this class will handle the conversion of currencies
     */

    public Double convertAmount(ConvertData convertData) throws IOException {

        Double result = 0.00;


        OkHttpClient client = new OkHttpClient().newBuilder().build();


        Request request = new Request.Builder()
                .url("https://api.apilayer.com/currency_data/convert?to=" +
                        convertData.getTo_this_currency() +
                        "&from="+
                        convertData.getFrom_this_currency() +
                        "&amount=" +
                        convertData.getAmount_to_be_converted())
                .addHeader("apikey", "uJPHksKFu2qFXDZFMKF6iNDdT7iK0fls")
                .method("GET", null)
            .build();
        Response response = client.newCall(request).execute();
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(response.body().string());


        for (Map.Entry<String, Object> entry: map.entrySet()){
            if(entry.getKey().equalsIgnoreCase("Result")){
                result = (Double) entry.getValue();
            }
        }

        return result;
    }

    public Map<String, String> currencyData(){
        Map<String, String> currencies = new HashMap();
        currencies.put("AED", "United Arab Emirates Dirham");
        currencies.put("AFN", "Afghan Afghani");
        currencies.put("ALL", "Albanian Lek");
        currencies.put("AMD", "Armenian Dram");
        currencies.put("ANG", "Netherlands Antillean Guilder");
        currencies.put("AOA", "Angolan Kwanza");
        currencies.put("ARS", "Argentine Peso");
        currencies.put("AUD", "Australian Dollar");
        currencies.put("AWG", "Aruban Florin");
        currencies.put("AZN", "Azerbaijani Manat");
        currencies.put("BAM", "Bosnia-Herzegovina Convertible Mark");
        currencies.put("BBD", "Barbadian Dollar");
        currencies.put("BDT", "Bangladeshi Taka");
        currencies.put("BGN", "Bulgarian Lev");
        currencies.put("BHD", "Bahraini Dinar");
        currencies.put("BIF", "Burundian Franc");
        currencies.put("BMD", "Bermudan Dollar");
        currencies.put("BND", "Brunei Dollar");
        currencies.put("BOB", "Bolivian Boliviano");
        currencies.put("BRL", "Brazilian Real");
        currencies.put("BSD", "Bahamian Dollar");
        currencies.put("BTC", "Bitcoin");
        currencies.put("BTN", "Bhutanese Ngultrum");
        currencies.put("BWP", "Botswanan Pula");
        currencies.put("BYN", "New Belarusian Ruble");
        currencies.put("BYR", "Belarusian Ruble");
        currencies.put("BZD", "Belize Dollar");
        currencies.put("CAD", "Canadian Dollar");
        currencies.put("CDF", "Congolese Franc");
        currencies.put("CHF", "Swiss Franc");
        currencies.put("CLF", "Chilean Unit of Account (UF)");
        currencies.put("CLP", "Chilean Peso");
        currencies.put("CNY", "Chinese Yuan");
        currencies.put("COP", "Colombian Peso");
        currencies.put("CRC", "Costa Rican Col\u00f3n");
        currencies.put("CUC", "Cuban Convertible Peso");
        currencies.put("CUP", "Cuban Peso");
        currencies.put("CVE", "Cape Verdean Escudo");
        currencies.put("CZK", "Czech Republic Koruna");
        currencies.put("DJF", "Djiboutian Franc");
        currencies.put("DKK", "Danish Krone");
        currencies.put("DOP", "Dominican Peso");
        currencies.put("DZD", "Algerian Dinar");
        currencies.put("EGP", "Egyptian Pound");
        currencies.put("ERN", "Eritrean Nakfa");
        currencies.put("ETB", "Ethiopian Birr");
        currencies.put("EUR", "Euro");
        currencies.put("FJD", "Fijian Dollar");
        currencies.put("FKP", "Falkland Islands Pound");
        currencies.put("GBP", "British Pound Sterling");
        currencies.put("GEL", "Georgian Lari");
        currencies.put("GGP", "Guernsey Pound");
        currencies.put("GHS", "Ghanaian Cedi");
        currencies.put("GIP", "Gibraltar Pound");
        currencies.put("GMD", "Gambian Dalasi");
        currencies.put("GNF", "Guinean Franc");
        currencies.put("GTQ", "Guatemalan Quetzal");
        currencies.put("GYD", "Guyanaese Dollar");
        currencies.put("HKD", "Hong Kong Dollar");
        currencies.put("HNL", "Honduran Lempira");
        currencies.put("HRK", "Croatian Kuna");
        currencies.put("HTG", "Haitian Gourde");
        currencies.put("HUF", "Hungarian Forint");
        currencies.put("IDR", "Indonesian Rupiah");
        currencies.put("ILS", "Israeli New Sheqel");
        currencies.put("IMP", "Manx pound");
        currencies.put("INR", "Indian Rupee");
        currencies.put("IQD", "Iraqi Dinar");
        currencies.put("IRR", "Iranian Rial");
        currencies.put("ISK", "Icelandic Kr\u00f3na");
        currencies.put("JEP", "Jersey Pound");
        currencies.put("JMD", "Jamaican Dollar");
        currencies.put("JOD", "Jordanian Dinar");
        currencies.put("JPY", "Japanese Yen");
        currencies.put("KES", "Kenyan Shilling");
        currencies.put("KGS", "Kyrgystani Som");
        currencies.put("KHR", "Cambodian Riel");
        currencies.put("KMF", "Comorian Franc");
        currencies.put("KPW", "North Korean Won");
        currencies.put("KRW", "South Korean Won");
        currencies.put("KWD", "Kuwaiti Dinar");
        currencies.put("KYD", "Cayman Islands Dollar");
        currencies.put("KZT", "Kazakhstani Tenge");
        currencies.put("LAK", "Laotian Kip");
        currencies.put("LBP", "Lebanese Pound");
        currencies.put("LKR", "Sri Lankan Rupee");
        currencies.put("LRD", "Liberian Dollar");
        currencies.put("LSL", "Lesotho Loti");
        currencies.put("LTL", "Lithuanian Litas");
        currencies.put("LVL", "Latvian Lats");
        currencies.put("LYD", "Libyan Dinar");
        currencies.put("MAD", "Moroccan Dirham");
        currencies.put("MDL", "Moldovan Leu");
        currencies.put("MGA", "Malagasy Ariary");
        currencies.put("MKD", "Macedonian Denar");
        currencies.put("MMK", "Myanma Kyat");
        currencies.put("MNT", "Mongolian Tugrik");
        currencies.put("MOP", "Macanese Pataca");
        currencies.put("MRO", "Mauritanian Ouguiya");
        currencies.put("MUR", "Mauritian Rupee");
        currencies.put("MVR", "Maldivian Rufiyaa");
        currencies.put("MWK", "Malawian Kwacha");
        currencies.put("MXN", "Mexican Peso");
        currencies.put("MYR", "Malaysian Ringgit");
        currencies.put("MZN", "Mozambican Metical");
        currencies.put("NAD", "Namibian Dollar");
        currencies.put("NGN", "Nigerian Naira");
        currencies.put("NIO", "Nicaraguan C\u00f3rdoba");
        currencies.put("NOK", "Norwegian Krone");
        currencies.put("NPR", "Nepalese Rupee");
        currencies.put("NZD", "New Zealand Dollar");
        currencies.put("OMR", "Omani Rial");
        currencies.put("PAB", "Panamanian Balboa");
        currencies.put("PEN", "Peruvian Nuevo Sol");
        currencies.put("PGK", "Papua New Guinean Kina");
        currencies.put("PHP", "Philippine Peso");
        currencies.put("PKR", "Pakistani Rupee");
        currencies.put("PLN", "Polish Zloty");
        currencies.put("PYG", "Paraguayan Guarani");
        currencies.put("QAR", "Qatari Rial");
        currencies.put("RON", "Romanian Leu");
        currencies.put("RSD", "Serbian Dinar");
        currencies.put("RUB", "Russian Ruble");
        currencies.put("RWF", "Rwandan Franc");
        currencies.put("SAR", "Saudi Riyal");
        currencies.put("SBD", "Solomon Islands Dollar");
        currencies.put("SCR", "Seychellois Rupee");
        currencies.put("SDG", "Sudanese Pound");
        currencies.put("SEK", "Swedish Krona");
        currencies.put("SGD", "Singapore Dollar");
        currencies.put("SHP", "Saint Helena Pound");
        currencies.put("SLL", "Sierra Leonean Leone");
        currencies.put("SOS", "Somali Shilling");
        currencies.put("SRD", "Surinamese Dollar");
        currencies.put("STD", "S\u00e3o Tom\u00e9 and Pr\u00edncipe Dobra");
        currencies.put("SVC", "Salvadoran Col\u00f3n");
        currencies.put("SYP", "Syrian Pound");
        currencies.put("SZL", "Swazi Lilangeni");
        currencies.put("THB", "Thai Baht");
        currencies.put("TJS", "Tajikistani Somoni");
        currencies.put("TMT", "Turkmenistani Manat");
        currencies.put("TND", "Tunisian Dinar");
        currencies.put("TOP", "Tongan Pa\u02bbanga");
        currencies.put("TRY", "Turkish Lira");
        currencies.put("TTD", "Trinidad and Tobago Dollar");
        currencies.put("TWD", "New Taiwan Dollar");
        currencies.put("TZS", "Tanzanian Shilling");
        currencies.put("UAH", "Ukrainian Hryvnia");
        currencies.put("UGX", "Ugandan Shilling");
        currencies.put("USD", "United States Dollar");
        currencies.put("UYU", "Uruguayan Peso");
        currencies.put("UZS", "Uzbekistan Som");
        currencies.put("VEF", "Venezuelan Bol\u00edvar Fuerte");
        currencies.put("VND", "Vietnamese Dong");
        currencies.put("VUV", "Vanuatu Vatu");
        currencies.put("WST", "Samoan Tala");
        currencies.put("XAF", "CFA Franc BEAC");
        currencies.put("XAG", "Silver (troy ounce)");
        currencies.put("XAU", "Gold (troy ounce)");
        currencies.put("XCD", "East Caribbean Dollar");
        currencies.put("XDR", "Special Drawing Rights");
        currencies.put("XOF", "CFA Franc BCEAO");
        currencies.put("XPF", "CFP Franc");
        currencies.put("YER", "Yemeni Rial");
        currencies.put("ZAR", "South African Rand");
        currencies.put("ZMK", "Zambian Kwacha (pre-2013)");
        currencies.put("ZMW", "Zambian Kwacha");
        currencies.put("ZWL", "Zimbabwean Dollar");

        return currencies;
    }
}
