package br.coderbyte.easy;

public class Solution {
}

interface OnlineAccount {
    int basePrice = 120;
    int regularMoviePrice = 45;
    int exclusiveMoviePrice = 80;
}

class Account implements OnlineAccount, Comparable<Account> {

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    // 1) Add a parameterized constructor that initializes the attributes noOfRegularMovies and noOfExclusiveMovies.


    public Account(int noOfRegularMovies, int noOfExclusiveMovies, String ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
       return basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;

    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.

    @Override


    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";

    }

    @Override
    public int compareTo(Account account) {
        if(account.monthlyCost() > this.monthlyCost()){
            return 1;
        }else if(account.monthlyCost() < this.monthlyCost()){
            return -1;
        }else{
            return 0;
        }

    }
}
