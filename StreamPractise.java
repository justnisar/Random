package com.ebay.standards.registry.lc;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.*;
import java.util.List;
import java.util.Date;

public class Example {

  public static void main(String[] args){

    // using of build a stream from 1 to 9 and print them using forEach
    Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
    stream.forEach(element -> System.out.print(element + " "));
    System.out.println();

    // using of build a stream of integer objects from 1 to 9
    stream = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9});
    stream.forEach(element -> System.out.print(element + " "));
    System.out.println();

    // create a list of integers from 1 to 9 and convert them to stream and print using for each
    List<Integer> list = new ArrayList<>();
    for(int i = 1 ; i < 10 ; i++){
      list.add(i);
    }
    list.stream().forEach(element -> System.out.print(element + " "));
    System.out.println();

    // using IntStream and chars print all chars of a string
    IntStream intStream = "12345_abcdefg".chars();
    intStream.forEach(e -> System.out.print(e + " "));
    System.out.println();

    // using split on stream print all words in a sentence
    Stream<String> strStream = Stream.of("This is my life".split(" "));
    strStream.forEach(word -> System.out.print(word + "  : "));
    System.out.println();

    // Define a stream of numbers from 1 to 9, filter all even numbers and using collect convert to list


    // using the same approach convert to array of integers
    Stream<Integer> integerStream = list.stream().filter(number -> number%2==0);
    List<Integer> integerList = integerStream.collect(Collectors.toList());
    for(int i : integerList){
      System.out.println(i);
    }



  }

}
