package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String[] words = {"sandalye", "kitap", "masa", "bilgisayar", "koltuk"};
        List<Character> charList = new ArrayList<>();
        int aranankelime = 0;


        for (String word : words) {
            if (hasRepeatedChars(word)) {
                System.out.println("Tekrarlı harf içeren kelime: " + word);
                for (char c : word.toCharArray()) {
                    charList.add(c);
                }
                aranankelime++;
                if (aranankelime == 2) {
                    break;
                }
            }
        }

        if (aranankelime< 2) {
            System.out.println("Tekrarlı harf içeren kelime bulunamadı.");
        } else {
            System.out.println("Oluşturulan harf listesi: " + charList);
            String randomText = createRandomText(charList, 5);
            System.out.println("Rastgele oluşturulan metin: " + randomText);
        }
    }


    private static boolean hasRepeatedChars(String word) {
        Set<Character> charSet = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (!charSet.add(c)) {
                return true;
            }
        }
        return false;
    }

    private static String createRandomText(List<Character> charList, int length) {
        Random random = new Random();
        String randomText = "";
        for (int i = 0; i < length; i++) {
            randomText += charList.get(random.nextInt(charList.size()));
        }
        return randomText;
    }
}