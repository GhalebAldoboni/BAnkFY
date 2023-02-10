package com.example.banknewsys;


public class UserOps {

public static String Username="Ghaleb Aldoobni";
public String cardNumber = "5272 3641 1219 1812";
private static Double balance= 98769.69;
public String cardValid="10/25";
public static  String AccountType="Premium Investment Account ";
public static Double income= 0.5;
public static Double expense= 0.02;
private static String username="Ghaleb";
private static   String  password = "123";
public static Double incomePercentage= (income/balance)*100;
public static Double expensePercentage= (expense/balance)*100;
// method to check if the entered credentials are right or wrong
public static boolean validCredentials(String user, String pass){
    if (user.equals(username )&& pass.equals(password)){
        return true;
    } else return false;
}
// methods to topup and withdraw
public static double topup(double amount){
    balance+=amount;
    income+=amount;
    return balance;
}public static double withdraw(double amount){
        balance-=amount;
        expense+=amount;
        return balance;

    }
    // balance getter
    public static Double getBalance (){
    return balance;
    }

    public static void updatePass(String newPass){
    password=newPass;
    }
    public static boolean validPass(String oldPass){
        if (oldPass.equals(password)){
            return true;
        } return false;
    }



}


