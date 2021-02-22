package eu.ricardocabral.algorithm;

import javax.swing.*;

public class Permutation {


    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation("123");

;
    }







    void permutation(String str){
        System.out.println("permutation: " + str);
        permutation(str, "");
    }
    void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        } else{
            System.out.println("To solve: " + str);
            for(int i = 0; i < str.length(); i++){
                //System.out.println(i + " - " + str);
                String rem = str.substring(0, i) + str.substring(i +1);
                //System.out.println("permutation: " + rem + ", " + prefix + str.charAt(i));
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
