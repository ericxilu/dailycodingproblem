package com.lucrotek.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FindAnagramIndices {

    public static List<Integer> findAnagramIndices(String s, String word){
        List<Integer> anagramIndices = new ArrayList();
        for(int i=0; i<(s.length()- word.length()+1); i++){
            if(isAnagram(s.substring(i, i+word.length()), word))
                anagramIndices.add(i);

        }
        return anagramIndices;
    }

    public static boolean isAnagram(String s1, String s2){
        log.debug("compare s1 {} s2 {}", s1, s2);
        int[] s1Map = new int[256];
        int[] s2Map = new int[256];

        for (int i=0; i<s1.length(); i++){
            log.debug("s1Map[{}] is {}", s1.charAt(i), s1Map[s1.charAt(i)]);
            s1Map[s1.charAt(i)] = s1Map[s1.charAt(i)]+1;
            log.debug("s1Map[{}] is {}", s1.charAt(i), s1Map[s1.charAt(i)]);
        }

        for (int i=0; i<s2.length(); i++){
            s2Map[s2.charAt(i)] = s2Map[s2.charAt(i)]+1;
        }

        for (int i=0; i<s1.length(); i++){
            log.debug("s1Map[{}] is {}", s1.charAt(i), s1Map[s1.charAt(i)]);
            log.debug("s2Map[{}] is {}", s1.charAt(i), s2Map[s1.charAt(i)]);
            if(s1Map[s1.charAt(i)]!= s2Map[s1.charAt(i)])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s="abxaba";
        String word="ab";
        List<Integer> anagramIndices = findAnagramIndices(s, word);

        anagramIndices.stream().forEach(index ->{log.info(index.toString());});
    }

}
