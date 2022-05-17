package br.com.ayrton;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ayrton da Silva Barreto");
        nomes.add("Ana Maria da Silva Hilário");
        nomes.add("Amanda Mayara da Silva Melo");
        nomes.add("Alana Larissa da Silva Gomes");
        nomes.add("Hilton Barreto Filho");
        nomes.add("Robson Barreto");

        System.out.println("Comparando por tamanho da Strings");

        //Sem Lambda
        Comparator<String>comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(),s2.length());
            }
        };
        nomes.sort(comparator);


        //Com Lambda

        /* Sintaxe do Lambda
        *
        * parâmetros -> expressão
        *
        * */
        nomes.sort((s1, s2) -> s1.compareTo(s2));
        nomes.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        //Passo a Passo
        Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Comparator<String> comparador = Comparator.comparing(funcao);
        nomes.sort(comparador);


        nomes.sort(Comparator.comparingInt(s -> s.length())); //modo utilizado atualmente

        //Resumido -> Com Method Reference
        nomes.sort(Comparator.comparingInt(String::length)); //modo utilizado atualmente
        System.out.println(nomes);

        System.out.println();

        System.out.println("Imprimindo a lista de nomes");
        nomes.forEach(s -> System.out.println("Nome: " + s + " \nTamanho: " + s.length()));

        //Resumido -> Com Method Reference
        nomes.forEach(System.out::println);

    }
}

