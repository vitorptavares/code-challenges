package br.hackerrank;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
   //     final String fileName = System.getenv("OUTPUT_PATH");
    //    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
//        String _substr;
//        try {
//            _substr = in.nextLine();
//        } catch (Exception e) {
//            _substr = null;
//        }

        res = getMovieTitles("spiderman");


    }

    static int getMovieTitles(String substr) {
        String response;
        int startPage = 1;
        int totalPages = Integer.MAX_VALUE;
        List<String> titles = new ArrayList<>();
        while (startPage <= totalPages) {
            try {
                URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                in.close();
                startPage++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        Collections.sort(titles);
        return 1;
    }
}



