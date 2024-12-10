package com.quest.java8;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FiDemo
{
    public static void main(String[] args)
    {
        //supplier - random no b/w 1-100
        Supplier<Integer> randomNumber=()->new Random().nextInt(100);
        int num= randomNumber.get();
        System.out.println("random number between 1 and 100 : "+num);

        //predicate - check if generated no is even
//        Predicate<Integer> isEven=(n)->n%2==0;
        Predicate<Integer> isEven=FiDemo::isEven;
        boolean even= isEven.test(num);
        System.out.println("is the random number even? : "+even);

        //function - square generated no if even, else double
        int fnResult=0;
        if(even)
        {
            Function<Integer, Integer> calculateSquare = (n) ->  n*n;
            fnResult= calculateSquare.apply(num);
        }
        else
        {
            Function<Integer, Integer> calculateDouble = (n) -> n * 2;
            fnResult = calculateDouble.apply(num);
        }
//        System.out.println("result after processing : "+fnResult);

        //optional - store result and generate empty optional if integer is odd (predicate fails)
        Optional<Integer> opResult=Optional.of(fnResult);

        //consumer - print final result if optional not null
        Consumer<String> printResult=System.out::println;
        opResult.ifPresent(result->printResult.accept("Result after processing : "+result));
    }

    public static boolean isEven(int i)
    {
        return i%2==0;
    }
}
