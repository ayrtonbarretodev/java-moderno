package br.com.ayrton.defaultmethods;

interface Veiculo{
    String getModelo();
    void acelerar();
    void desacelerar();

    /*
    Quando um método é default, não somos obrigados a fazer a sobrescrita

    Porém, nada impede que eles sejam sobrescritos
    */

    default String ligarAlarme() {
        return "Ligando o alarme do veículo";
    }

    default String desligarAlarme(){
        return "Desligando o alarme do veículo";
    }

    static int calcularCavaloDePotencia(int rpm, int torque){
        return (rpm*torque)/5252;
    }
}

interface Alarme{
    default String ligarAlarme() {
        return "Ligando o alarme";
    }

    default String desligarAlarme(){
        return "Desligando o alarme";
    }
}

//caso em que a classe implementa interfaces com métodos de nomes iguais
class Carro implements Veiculo, Alarme{

    private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando");
    }

    @Override
    public void desacelerar() {
        System.out.println("O carro está desacelerando");
    }

    /*
    Nesse caso, é necessário sobrescrever os métodos, pois por possuirem nomes iguais nas duas interfaces, a IDE
    não sabe qual das interfaces você deseja utilizar, e por isso, você deverá fazer referência no return de cada método
    de acordo com sua necessidade
    */

    @Override
    public String ligarAlarme() {
        return Veiculo.super.ligarAlarme();
    }

    @Override
    public String desligarAlarme() {
        return Alarme.super.desligarAlarme();
    }
}

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Porshe");
        System.out.println(carro.getModelo());

        carro.acelerar();
        carro.desacelerar();

        System.out.println(carro.ligarAlarme()); //interface Veiculo
        System.out.println(carro.desligarAlarme()); //interface Alarme

        System.out.println(Veiculo.calcularCavaloDePotencia(2500,480));
    }
}
