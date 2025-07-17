package org.selcuk.helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JsonReadHelper {
    public static String existingUser(String data) throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\ExistingUser.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String)existingUser.get(data);
    }

    public static String accountDetails(String data) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\AccountDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject accountDetails = (JSONObject) obj;
        return (String)accountDetails.get(data);
    }

    public static String paymentDetails(String data) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\PaymentDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject paymentDetails = (JSONObject) obj;
        return (String)paymentDetails.get(data);
    }

    public static String poloBrandProducts(String data) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\PoloBrandProducts.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject poloBrandProducts = (JSONObject) obj;
        return (String)poloBrandProducts.get(data);
    }

    public static String madameBrandProducts(String data) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\MadameBrandProducts.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject madameBrandProducts = (JSONObject) obj;
        return (String)madameBrandProducts.get(data);
    }
}
