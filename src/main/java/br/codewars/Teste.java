package br.codewars;

import java.util.*;
import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Teste {
    public static void main (String[] args) {
        String jsonFileStr;
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String age = "age";
                int finalResponse = 0;
                jsonFileStr = in.readLine();
                while((jsonFileStr = in.readLine()) != null ){
                    char [] resp = jsonFileStr.toCharArray();
                    System.out.println(jsonFileStr);
                    int lastIndex = 0;
                    int count = 0;

                    while(lastIndex != -1){

                        lastIndex = jsonFileStr.indexOf(age,lastIndex);

                        if(lastIndex != -1){
                            StringBuilder number = new StringBuilder();

                            StringBuilder append = number.append(resp[lastIndex + 4]);
                            if(String.valueOf(resp[lastIndex + 5]).matches(("-?\\d+(\\.\\d+)?"))){
                                append.append(number.append(resp[lastIndex + 5]));
                            }
                            if(Integer.valueOf(String.valueOf(append)) >= 50){
                                finalResponse ++;
                            }
                            count ++;
                            lastIndex += age.length();
                        }
                    }
                    System.out.println(finalResponse);
                }


            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}