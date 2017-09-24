/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd_comparison;

import java.util.ArrayList;
import java.util.List;

public class Gcd_Comparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(gcdPrimeFactors(3,6) == gcdEucledian(3,6))
            System.out.print("True\n");
        else System.out.print("False\n");
        
        if(gcdPrimeFactors(2748,13437) == gcdEucledian(2748,13437))
            System.out.print("True\n");
        else System.out.print("False\n");
        
        if(gcdPrimeFactors(14783,2473) == gcdEucledian(14783,2473))
            System.out.print("True\n");
        else System.out.print("False\n");
        
        if(gcdPrimeFactors(1245,29475) == gcdEucledian(1245,29475))
            System.out.print("True\n");
        else System.out.print("False\n");
    }
    
    public static int gcdPrimeFactors(int a, int b) {

        List<Integer> aList = getFactors(a);
        List<Integer> bList = getFactors(b);
        int gcd = 1;
        int ai = 0;
        int bi = 0;
        int aNum;
        int bNum;
        while(ai < aList.size() && bi < bList.size()) {
            aNum = aList.get(ai);
            bNum = bList.get(bi);
            if(aNum == bNum) {
                gcd *= aNum;
                ai++;
                bi++;
            }
            else if(aNum < bNum)
                ai++;
            else 
                bi++;
        }
        return gcd;
    }
    
    private static List<Integer> getFactors(int num) {
        int factor = 1;
        List<Integer> numList = new ArrayList<Integer>();
        while(num != 1) {
            factor = getNextPrime(factor);
            while(num % factor == 0) {
                numList.add(factor);
                num /= factor;
            }
        }
        return numList;
    }
    
    private static int getNextPrime(int current) {
        Boolean notPrime = true;
        while(notPrime) {
            notPrime = false;
            current++;
            for(int i = 2; i <= current / 2 && !notPrime; i++) {
                if(current % i == 0)
                    notPrime = true;
            }
        }
        return current;
    }
    
    public static int gcdEucledian(int a, int b) {
        if(b == 0)
            return a;
        return gcdEucledian(b, a % b);
    }
}
