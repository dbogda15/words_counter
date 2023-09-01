package service;

import java.util.*;
import java.util.stream.Collectors;

public class words_counter_service {

    public static void printHello() {
        System.out.println("\nHello! What do you want? " +
                "\n1. I want to know the TOP 10 most frequently mentioned words." +
                "\n2. I want to count the words in my sentence. " +
                "\n0. I want to close this app.");
    }
    public static void topOfWords(){
        System.out.println("Enter your sentence, please: ");
        Scanner scanner1 = new Scanner(System.in).useDelimiter("\n");
        String initialSentence = scanner1.nextLine();
        String clearSentence = removePunctuations(initialSentence)
                .toLowerCase();

        Map<String, Integer> wordsMap = new HashMap<>(getWordsHashMap(clearSentence));

        wordsMap = wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("\n TOP 10 words: \n");

        for (HashMap.Entry<String, Integer> words : wordsMap.entrySet()) {
            System.out.println(words.getValue() + " " + words.getKey());
        }
    }

    public static void total() {
        System.out.println("Enter your sentence for new task: ");
        Scanner scanner2 = new Scanner(System.in).useDelimiter("\\n");
        String initialSentence = scanner2.nextLine();
        String clearSentence = removePunctuations(initialSentence);
        List<String> text = getWordsList(clearSentence);

        System.out.println("\nThe total number of words in this sentence: " + text.size());
    }
    public static String removePunctuations(String sentence) {
        return sentence.replaceAll("\\p{Punct}", "");
    }

    public static HashMap<String, Integer> getWordsHashMap (String sentence) {
        Scanner scanner2 = new Scanner(sentence);
        HashMap<String, Integer> mapOfWords = new HashMap<>();
        while (scanner2.hasNext()) {
            String word = scanner2.next();
            if (!mapOfWords.containsKey(word)) {
                mapOfWords.put(word,1);
            } else {
                int countWord = mapOfWords.get(word) + 1;
                mapOfWords.remove(word);
                mapOfWords.put(word, countWord);
            }
        }
        return mapOfWords;
    }

    public static List<String> getWordsList (String sentence) {
        Scanner scanner = new Scanner(sentence);
        List<String> listOfWords = new ArrayList<>();
        while (scanner.hasNext()) {
                String word = scanner.next();
                listOfWords.add(word);
        }
        return listOfWords;
    }
}


