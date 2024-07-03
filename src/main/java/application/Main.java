package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n, nmenores;
        double alturaTotal, alturaMedia, percentualMenores;

        System.out.print("Quantas pessoas serão digitadas: ");
        n = sc.nextInt();

        Person[] vect = new Person[n];

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();
            System.out.printf("Dados da %da pessoa:\n", i + 1);
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura: ");
            double height = sc.nextDouble();

            vect[i] = new Person(name, age, height);
        }

        nmenores = 0;
        alturaTotal = 0;
        for (Person person : vect) {
            if (person.getAge() < 16) {
                nmenores++;
            }
            alturaTotal += person.getHeight();
        }

        alturaMedia = alturaTotal / n;
        percentualMenores = ((double) nmenores / n) * 100;

        System.out.printf("\nAltura média = %.2f\n", alturaMedia);
        System.out.printf("Pessoas com menos de 16 anos = %.1f%%\n", percentualMenores);

        for (Person person : vect) {
            if (person.getAge() < 16) {
                System.out.printf("%s\n", person.getName());
            }
        }


        sc.close();
    }
}
