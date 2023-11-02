package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {

    public static void calculate(List<String> numList){
        List<String> list = new ArrayList<String>();
        Integer temp = null; // Используется для умножения и вычисления деления временных переменных
        for (int i = 1; i <numList.size (); i += 2) {// здесь только циклические символы
            if("+".equals(numList.get(i))||"-".equals(numList.get(i))){
                if (null!= temp) {// Временная переменная существует, что указывает на предыдущее умножение и деление
                    list.add(temp.toString());
                    temp = null;
                } else {
                    list.add(numList.get(i-1));
                }
                list.add (numList.get (i)); // добавить символ
                if (i == numList.size () - 2) {// Прямая обработка встречается в конце обработки

                    list.add(numList.get(i+1));


                }
            }else if("*".equals(numList.get(i))){
                if(null == temp){
                    temp = Integer.parseInt(numList.get(i-1)) * Integer.parseInt(numList.get(i+1));
                }else{
                    temp = temp * Integer.parseInt(numList.get(i+1));
                }
                if (i == numList.size () - 2) {// Прямая обработка встречается в конце обработки
                    list.add(temp.toString());
                    temp = null;
                }
            }else if("/".equals(numList.get(i))){
                if(null == temp){
                    temp = Integer.parseInt(numList.get(i-1)) / Integer.parseInt(numList.get(i+1));
                }else{
                    temp = temp / Integer.parseInt(numList.get(i+1));
                }
                if (i == numList.size () - 2) {// Прямая обработка встречается в конце обработки
                    list.add(temp.toString());
                    temp = null;
                }
            }
        }

        // Делаем дополнительные расчеты
        Integer sum = Integer.parseInt (list.get (0)); // Первый бит не будет обработан в цикле
        for (int i = 1; i <list.size (); i += 2) {// здесь только циклические символы
            if("+".equals(list.get(i))){
                sum += Integer.parseInt(list.get(i+1));
            }else if("-".equals(list.get(i))){
                sum -= Integer.parseInt(list.get(i+1));
            }
        }
        System.out.println(" Ответ : " +sum);


    }





    public static void createAction(String userIn) {
        List<String> numList = new ArrayList<String>();
        int splitIndex = 0;
        for (int i = 0; i < userIn.length(); i++) {
            char c = userIn.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                numList.add(userIn.substring(splitIndex, i));
                numList.add(c + "");
                splitIndex = i + 1;


            }
        }
        numList.add(userIn.substring(splitIndex, userIn.length()));
        System.out.println(numList);
        calculate(numList);
    }
    public static void main(String[] args) {
        System.out.println(" Введите выражение в котором :  " +
                            "/ - деление, " +
                            "* - Умножение, " +
                            "- - вычитание,  " +
                            "+ - сложение,  ");

        Scanner scanner = new Scanner(System.in);
        String userIn = scanner.next();
        System.out.println("Пользователь ввел : " + userIn);

        createAction(userIn);





    }

}