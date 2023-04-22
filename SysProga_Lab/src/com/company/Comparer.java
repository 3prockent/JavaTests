package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Comparer {
    private String data="";
    private ArrayList<String> wordsList = new ArrayList<>();
    private ArrayList<ArrayList<String>> maxPairs;
    public Comparer(String fileName) throws Exception{
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        this.data = data;
    }

    private void validText()
    {
        this.data = this.data.replaceAll("[^A-Za-zА-Яа-я\\і\\І\\Ї\\ї\\Є\\є\\']", " ");
    }
    public void wordsList()
    {
        String[] arr = this.data.split("\\s+");
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++){
            if (arr[i].length() > 30){
                arr[i] = arr[i].substring(0,29);
            }
            result.add(arr[i]);
        }
        this.wordsList = result;
    }

    public void createMaxPairs()
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int max = 1;
        var words = this.wordsList;
        for(int i = 0; i < (words.size()); i++){
            for(int j = (i + 1); j < words.size(); j++){
                String shorter = (words.get(i).length() <= words.get(j).length()) ? words.get(i) : words.get(j);
                int counter = 0;
                for(int k = 0; k < shorter.length(); k++){
                    if (words.get(i).charAt(k) != words.get(j).charAt(k)){
                        counter ++;
                    }
                }
                if (counter == max){
                    ArrayList<String> currentPair = new ArrayList<String>();
                    currentPair.add(words.get(i));
                    currentPair.add(words.get(j));
                    result.add(currentPair);
                } else if (counter > max) {
                    result.clear();
                    max = counter;
                    ArrayList<String> currentPair = new ArrayList<String>();
                    currentPair.add(words.get(i));
                    currentPair.add(words.get(j));
                    result.add(currentPair);
                } else {

                }
            }
        }
        maxPairs = result;
    }

    public ArrayList<String> getWordsList() {
        return wordsList;
    }

    public ArrayList<ArrayList<String>> getMaxPairs() {
        return maxPairs;
    }


    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
