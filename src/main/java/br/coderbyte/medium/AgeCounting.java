package br.coderbyte.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class AgeCounting {

    /*
Java Age Counting

In the Java file, write a program to perform a GET request on the route
https://coderbyte.com/api/challenges/json/age-counting
which contains a data key and the value is a string which contains items in the format:
key=STRING, age=INTEGER. Your goal is to count how many items exist that have an age equal to or greater than 50, and print this final value.

Example Input
{"data":"key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47"}

Example Output
2




*/
    public static void main (String[] args) throws IOException {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();

            String jsonText = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            String [] splittedJson = jsonText.split(":");
            String [] dataAndKeyStr = splittedJson[1].replaceAll("\"}", "").replace("\"", "").split(",");
            Integer result = 0;
            for (String str :
                    dataAndKeyStr) {
                if(str.contains("age")){
                    String [] age = str.split("=");
                    if(Integer.parseInt(age[1]) >=50)
                        result++;
                }
            }
            System.out.println(result);

        }
        catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}
