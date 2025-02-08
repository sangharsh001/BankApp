package com.bank.app;

import java.util.Random;

public class Transactiono {
    
    public static Long genTransaction() {
        Random random = new Random();
//        long randomLong = 1_000_000_000_000_000L + (long) (random.nextDouble() * 9_000_000_000_000_000L);
        int num=0;
        long ans=0;
//        System.out.println("Generated 15-digit number: " + randomLong);

        
       Long val=random.nextLong(); 
     
       if(val<0) {
       val=val*-1;
       }
        
//        long res = 0;
//        long temp = randomLong;

        while (num <15) {
            long rem = val % 10;
            ans = (ans * 10) + rem;
            val = val / 10;
            num+=1;
        }
        return ans;
//      System.out.println(ans);
//      System.out.println(val);
//        System.out.println("Reversed number: " + res);
    }
    

}
