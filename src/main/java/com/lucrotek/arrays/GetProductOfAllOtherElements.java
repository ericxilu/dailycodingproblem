package com.lucrotek.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductOfAllOtherElements {
    static int[] prefixProducts(int[] numbers){
        int[] prefixProducts = new int[numbers.length];
        for (int i = 0; i <numbers.length; i++){
            if (i==0)
                prefixProducts[i]=numbers[i];
            else
                prefixProducts[i]=prefixProducts[i-1]*numbers[i];

        }
        return prefixProducts;
    }

    static int[] surfixProducts(int[] numbers){
        int[] suffixProducts = new int[numbers.length];
        for(int i=numbers.length-1; i>=0; i--){
            if(i==numbers.length-1)
                suffixProducts[i]=numbers[i];
            else
                suffixProducts[i]=suffixProducts[i+1]*numbers[i];
        }
        return suffixProducts;
    }

    static int[] productOfAllOtherElements(int[] numbers){
        int[] productofAllOtherElements = new int[numbers.length];
        int[] prefixProducts = prefixProducts(numbers);
        int[] surfixProducts = surfixProducts(numbers);
        for (int i=0; i<numbers.length; i++){
            if(i==0)
                productofAllOtherElements[i]=surfixProducts[1];
            else if(i==numbers.length-1)
                productofAllOtherElements[i]=prefixProducts[numbers.length-2];
            else
                productofAllOtherElements[i]=prefixProducts[i-1]*surfixProducts[i+1];

        }
        return productofAllOtherElements;
    }

    public static void main (String[] args){
        int[] numbers = {1,2,3,4,5};
        int[] prefixProducts = prefixProducts(numbers);

//        log.info("prefix products");
//        for(int i: prefixProducts){
//            log.info(String.valueOf(i));
//        }
//
//        log.info("surfix products");
//        int[] surfixProducts = surfixProducts(numbers);
//        for(int i: surfixProducts){
//            log.info(String.valueOf(i));
//        }

        log.info("product of all other elements");
        int[] productOfAllOtherElements=productOfAllOtherElements(numbers);
//        final Stream<int[]> productOfAllOtherElements1 = Stream.of(productOfAllOtherElements);
//        productOfAllOtherElements1.forEach(i->log.info(String.valueOf(i)));
        for(int i: productOfAllOtherElements){
            log.info(String.valueOf(i));
        }
    }
}
