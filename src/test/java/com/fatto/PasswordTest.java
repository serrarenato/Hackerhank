package com.fatto;



import com.fattoRabobank.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PasswordTest {
    @Test
    public void successFindAnagrams(){
        List <String> passwords = new ArrayList<>();
        List <String> common_words = new ArrayList<>();
        passwords.add("133333234");
        passwords.add("abdefdssdc");
        passwords.add("ABDGHGDHG");
        passwords.add("ABDG");
        passwords.add("ABDGHvsG");
        passwords.add("xpto1234");

        common_words.add("xpto1234");
        passwords.add("xpto123456");

        List results = Result.getPasswordStrength(passwords,common_words);
        System.out.println(results);
    }
    @Test
    public void successFindAnagrams3(){
        List <String> passwords = new ArrayList<>();
        List <String> common_words = new ArrayList<>();
        passwords.add("iliketoCoDe");
        passwords.add("teaMAKEsmehappy");
        passwords.add("pasSword");
        passwords.add("abracaDabra");
        passwords.add("blackcoffeeISthebest");


        common_words.add("coffee");
        common_words.add("coding");
        common_words.add("happy");


        List results = Result.getPasswordStrength(passwords,common_words);
        System.out.println(results);
        /*
strong
weak
strong
strong
weak
         */
    }




}
