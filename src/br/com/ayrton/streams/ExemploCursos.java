package br.com.ayrton.streams;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        //cursos.forEach(curso -> System.out.println(curso.getNome()));

        //exemplo1
        System.out.println("Mostra o nome dos alunos em cada curso que tem quantidade >= 100");
        cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .forEach(curso -> System.out.println(curso.getNome()));

        System.out.println();

        //exemplo2
        System.out.println("Mostra o número de alunos em cada curso que tem quantidade >= 100");
        cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .map(curso -> curso.getAlunos())
                .forEach(total -> System.out.println(total));

        System.out.println();

        //exemplo2
        System.out.println("Mostra o número de alunos em cada curso que tem quantidade >= 100 - Com Method References");
        cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        System.out.println();

        //exemplo3
        System.out.println("Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos.");
        System.out.println("Depois disso faça um forEach no resultado. ");
        cursos.stream().filter(curso -> curso.getAlunos() > 50).forEach(curso -> System.out.println(curso.getNome()));


        System.out.println();
        //exemplo4
        System.out.println("O código a seguir cria um Stream<Integer> com a quantidade de alunos dos cursos e em seguida imprime todos eles.");
        cursos.stream().map(curso -> curso.getAlunos()).forEach(total -> System.out.println(total));


        System.out.println();
        //exemplo4
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100) //filta os alunos >= 100
                .findAny() // entre os cursos pesquisados no filtro acima, devolve qualquer um curso
                .ifPresent(curso -> System.out.println(curso.getNome()));
        //O if present verifica se o curso existe
        //Se existir, imprima o nome dele
        //Se nao existir, ele não faz nada (é uma vantagem, pois de outras maneiras lançam alguma exceção, e aqui ele ñ imprime caso n exista.


        System.out.println();
        //exemplo5 - De Stream p/ Collection (nesse caso, List)

        List<Curso> resultado = cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .collect(Collectors.toList());

        resultado.forEach(curso -> System.out.println(curso.getNome()));

        System.out.println();
        //exemplo5 - De Stream p/ Map

        Map<String, Integer> map = cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos()));

        System.out.println(map);


        System.out.println();
        //ou
        cursos.stream()
                .filter(curso -> curso.getAlunos() >= 100)
                .collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));


        System.out.println();
        //exempo 6 - pegando o primeiro elemento da lista

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .findFirst()
                .stream().collect(Collectors.toList())
                .forEach(curso -> System.out.println(curso.getNome()));

        System.out.println();
        //exempo 7 - Calcule a quantidade média de alunos de todos os seus cursos utilizando a API de Stream.
        OptionalDouble average = cursos.stream()
                .mapToInt(value -> value.getAlunos())
                .average();

        System.out.println(average);


    }
}
