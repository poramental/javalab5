package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static Scanner in = new Scanner(System.in);
    static List<Double> array = new ArrayList<>();
    static final String possibilities = "\nВыберете действие из меню.\n" +"\t1. заполнение массива случайным образом\n" +
            "\t\t(при этом пользователь с клавиатуры вводит количество элементов массива)\n"+
            "\t2. ввод элементов массива с клавиатуры\n" +
            "\t\t(при этом пользователь сначала вводит количестве элементов массива с клавиатуры, затем значения самих элементов массива)\n"+
            "\t3. вывод элементов массива на экран\n" +
            "\t\tв строку\n"+
            "\t4. обработка массива (сумма элементов массива от начала до первого элемента, удовлетворяющего условию: синус этого числа есть число положительное)\n"+
            "\t5. изменение массива (Удаление из массива всех элементов, модуль целой части которых - это число, все цифры которого чётные)\n"+
            "\t6. выход из программы\n" +
            "\t7. вывести массив на экран\n"+
            "\t7. показать возможности";

    static private void showPossibilities(){
        System.out.println(possibilities);
    }

    static private int getCountOfNumbers(){
        System.out.println("Введите количество чисел");
        while (true) {
            try {
                int count = Integer.parseInt(in.nextLine());
                if (count < 0)
                    throw new NumberFormatException();
                return count;
            } catch (NumberFormatException e) {
                System.out.println("Количество!");
            }
        }
    }
    static private void fillArrayWithRandomNumbers(){
        array.clear();
        int count = getCountOfNumbers();
        for (int i = 0; i < count; i++) {
            array.add((Double) (Math.random() * 12) - 15);
        }

    }
//    не робит доделать.
    static private void arrayChange(){
        for(int i = 0; i < array.size() - 1; i++){
            long numberRoundAbs = Math.abs( Integer.parseInt(String.valueOf(array.get(i)).split("[.]")[0]));
            System.out.println(numberRoundAbs);
            char[] charArr = Long.toString(numberRoundAbs).toCharArray();
            for(char c : charArr){

                if(Character.getNumericValue(c)%2 != 0 ){
                   array.remove(array.get(i));
                }
            }
        }

    }
    static private void fillArrayManually(){
        array.clear();
        int count = getCountOfNumbers();
        for(int i = 0; i < count; i++){
            try{
                System.out.print("число №" + (i + 1)+ "->");
                array.add(Double.parseDouble(in.nextLine()));
            }catch (NumberFormatException e) {
                System.out.println("В массиве только числа!");
            }
        }
    }

    static private void printArray(){
        System.out.println("Текущее состояние массива: ");
        System.out.println("\t"+array);
    }

    private static int input() throws NumberFormatException{
        System.out.print("->");
        return Integer.parseInt(in.nextLine().strip());
    }

    static private void arrayProcessing(){
        double sum = 0;

        for(double number : array){
            System.out.println("Sin = " + Math.sin(Math.toRadians(number)) +"\nnumber = " + number + "\nnumber in radians = " + Math.toRadians(number));
            if(Math.sin(Math.toRadians(number) ) < 0){
                sum += number;
            }
            else{
                System.out.println("Сумма равна:\t" + sum + "\nЧисло №" + array.indexOf(number)  +"подвело"+ "\nЗначение числа:\t");
                break;
            }

        }
        System.out.println("Сумма равна:\t" + sum + "\nПлохих чисел не было.");
    }

    public static void main(String[] args) {

        showPossibilities();
        while(true){
            try {
                int menuItem = input();



                if (menuItem == 1) {
                    fillArrayWithRandomNumbers();
                    printArray();
                }
                if (menuItem == 2) {
                    fillArrayManually();
                    printArray();
                }

                if (menuItem == 6) {
                    System.out.println("До встречи!\uD83D\uDE43");
                    break;
                }
                if (menuItem == 3){
                    printArray();
                }
                if(menuItem == 5 ){
                    arrayChange();
                    printArray();
                }
                if(menuItem == 4){
                    arrayProcessing();
                }
                if(menuItem == 7){
                    showPossibilities();
                }
                if(menuItem > 7 || menuItem < 1)
                    System.out.println("Таких вариантов не было(для подсказки введите 7).");
            }catch(NumberFormatException e){
                System.out.println("Вы не можете написать что-то не из меню :(.");
            }
        }



    }
}