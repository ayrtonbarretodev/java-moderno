package br.com.ayrton.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Datas {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Local Date - Datas");
        System.out.println("---------------------------------------------------------------------");

        System.out.println();

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate copaDoMundo = LocalDate.of(2022, Month.NOVEMBER,21);

        System.out.println();

        System.out.println("Quantos anos faltam para a copa do mundo: ");
        int anos = copaDoMundo.getYear() - hoje.getYear();
        int meses = copaDoMundo.getMonthValue() - hoje.getMonthValue();
        int dias = copaDoMundo.getDayOfMonth() - hoje.getDayOfMonth();
        System.out.println("Faltam " + anos + " anos " + meses + " meses " + " e " + dias + " para a copa do mundo de 2022");

        System.out.println();

        System.out.println("Outra forma");
        Period period = Period.between(hoje,copaDoMundo);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println();

        System.out.println("Somar 4 anos para verificar a possível data da próxima Copa do Mundo");
        LocalDate proximaCopa = copaDoMundo.plusYears(4L);
        System.out.println(proximaCopa);

        System.out.println();
        System.out.println("Date Time Formatter");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String valorFormatado = copaDoMundo.format(formatador);
        System.out.println(valorFormatado);

        System.out.println();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Local Date Time - Data e Hora");
        System.out.println("---------------------------------------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter novoFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(localDateTime.format(novoFormatador));
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        
    }
}
