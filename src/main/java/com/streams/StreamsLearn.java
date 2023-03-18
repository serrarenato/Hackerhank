package com.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamsLearn {
    public static void main(String[] args) {
        // filter map foreach limit
        // foreach -> operação final
        // skip limit distinct -> operações intermediarias. -- para filtrar
        // filter -- filtro mais personalizado
        // map -- transformação
        // max, min, count, collect, reduce -> metodos finais
        // collect  -> conversao
        // reduce => reduzir

        List<Integer> lista = Arrays.asList(1, 5, 8, 7, 4, 6, 3, 2, 1, 8, 5, 7, 4);
        lista.stream().forEach(System.out::print);
        System.out.println("-----------------------------");
        lista.stream().skip(3).forEach(System.out::print);
        System.out.println("-----------------------------");
        lista.stream().limit(5).forEach(System.out::print);
        System.out.println("-----------------------------");
        lista.stream().distinct().forEach(System.out::print);
        System.out.println("-----------------------------");
        lista.stream().filter(e->e%2==1).forEach(System.out::print);
        System.out.println("-----------------------------");
        lista.stream().map(e->e-1).forEach(System.out::print);
        System.out.println("Count : " +lista.stream().count());
        System.out.println("Max : " +lista.stream().max(Comparator.naturalOrder()));
        System.out.println("Min : " +lista.stream().min(Comparator.naturalOrder()));
        System.out.println(lista.stream().limit(3).collect(Collectors.toList()));
        System.out.println(lista.stream().map(e->e*2).distinct().map(String::valueOf).collect(Collectors.joining("::")));
        System.out.println(lista.stream().distinct().limit(4).collect(Collectors.groupingBy(e->true)));

       /* 1 - Dada uma lista de números, encontre a média dos valores ímpares.
          2 - Dada uma lista de nomes, filtre os nomes que começam com a letra "A" e transforme-os para maiúsculas.
          3 - Dada uma lista de produtos, encontre o produto mais caro.
          4 - Dada uma lista de livros, filtre os livros que foram publicados após o ano 2000 e ordene-os por ordem alfabética.
          5- Dado um mapa que relaciona o nome de um país com sua população, filtre os países que têm população superior a 100 milhões de habitantes e ordene-os por ordem decrescente de população.
          */
        lista.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(n -> n)
                .average();
        System.out.println(lista.stream().filter(e->e%2==0).reduce(Integer::sum));
        List<String> nomes = Arrays.asList("Renato", "andre", "andrea", "silvia","aaa");
        System.out.println(nomes.stream().map(e->e.toUpperCase()).filter(e->e.startsWith("A")).sorted().collect(Collectors.toList()));
        //Dada uma lista de produtos, encontre o produto mais caro.
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("teste", 5d));
        produtos.add(new Produto("teste1", 50d));
        produtos.add(new Produto("teste2", 54d));
        Optional<Produto> value = produtos.stream().max(Comparator.comparing(Produto::getValue));
        System.out.println(value);

        List<Book> books = new ArrayList<>();
        books.add(new Book("teste", LocalDate.of(2000,02,05)));
        books.add(new Book("ateste1", LocalDate.of(2005,02,05)));
        books.add(new Book("bteste2",LocalDate.of(1999,02,05)));
        List <Book> books2 =books.stream().filter(e->e.getValue().isAfter(LocalDate.of(2000,1,1))).sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
        System.out.println(books2);
        //Dado um mapa que relaciona o nome de um país com sua população, filtre os países que têm população superior a 100 milhões de habitantes e ordene-os por ordem decrescente de população.
        List<Mapa> mapas = new ArrayList<>();
        mapas.add(new Mapa("Brasil", 200000L));
        mapas.add(new Mapa("Argentina", 50000L));
        mapas.add(new Mapa("EUA", 400000L));
        mapas.add(new Mapa("China", 1000000L));
        List<Mapa> mapas2 = mapas.stream().filter(e->e.getPopulation()>100000L).sorted(Comparator.comparing(Mapa::getPopulation).reversed()).collect(Collectors.toList());
        System.out.println(mapas2);
    }


}
class Book {
    String name;
    LocalDate date;

    Book(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public LocalDate getValue() {
        return this.date;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.date;
    }
}
class Produto{
    String name;
    Double value;
    Produto(String name, Double value){
        this.name=name;
        this.value=value;
    }
    public Double getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return this.name+" "+this.value;
    }

}
class Mapa{
    String name;
    Long population;
    public Mapa(String name, Long population){
        this.name= name;
        this.population=population;
    }

    public String getName() {
        return name;
    }
    public Long getPopulation(){
        return population;
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}


