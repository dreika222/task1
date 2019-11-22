package Andrew_Kuznichenko;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     private  static float a, b ,c;
     private static float discriminant ;


    public static void main(String[] args) {
        int exit = 0;
        do {
            input();
            countDiscriminant();
            if (discriminant > 0) {
                countTwoRoots();
            } else if (discriminant == 0) {
                countOneRoot();
            } else {
                System.out.println("Уравнение не имеет решений");
            }
            boolean error;
            Scanner input = new Scanner(System.in);
            do{
                try{
                    System.out.println("Если хотите решить уравнение ещё раз введите 1");
                    System.out.println("Если хотите выйти введите любую цифру");
                    exit = input.nextInt();
                    error = false;
                } catch (InputMismatchException e){
                    System.out.println("Вы ввели не число, повторите ввод");
                    input.next();
                    error = true;
                }
            } while (error);


        } while (exit == 1);
    }

    //Метод ввода коэфициентов квадратного уравнения
    private static void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите коэфициенты квадратного уравнения.");
        boolean error = true;
        do {
            try {
                System.out.println("Введите коэфициент а:");
                a = input.nextFloat();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, повторите ввод");
                input.next();
                error = true;
            }
        } while (error);
        do {
            try {
                System.out.println("Введите коэфициент b:");
                b = input.nextFloat();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, повторите ввод");
                input.next();
                error = true;
            }
        } while (error);
        do {
            try {
                System.out.println("Введите коэфициент c:");
                c = input.nextFloat();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, повторите ввод");
                input.next();
                error = true;
            }
        } while (error);
    }

    //Метод для подсчета дискриминанта
    private static void countDiscriminant(){
        discriminant = (b*b) - (4*a*c);
        System.out.println("Считаем дискриминант: D = b^2 - 4ac");
        System.out.printf("D = %.2f^2 - 4*%.2f*%.2f = %.2f \n", b, a, c, discriminant);
    }

    //Метод для подсчета двух корней уравнения
    private static void countTwoRoots(){
        float x1, x2;
        System.out.println("Уравнение имеет два корня");
        System.out.println("Считаем первый корень: x1 = (-b + √D) / (2a)");
        x1 = (-b + (float) Math.sqrt(discriminant)) / (2*a);
        System.out.printf("x1 = (-%.2f + √%.2f) / (2*%.2f) = %.2f \n", b, discriminant, a, x1);
        System.out.println("Считаем второй корень: x2 = (-b - √D) / (2a)");
        x2 = (-b - (float) Math.sqrt(discriminant)) / (2*a);
        System.out.printf("x2 = (-%.2f - √%.2f) / (2*%.2f) = %.2f \n", b, discriminant, a, x2);
    }

    //Метод для подсчета одного корня уравнения
    private static void countOneRoot(){
        float x;
        System.out.println("Уравнение имеет один корень");
        System.out.println("Считаем корень: x = -b / (2a)");
        x = -b / (2*a);
        System.out.printf("x = -%.2f  / (2%.2f) = %.2f \n", b, a, x);
    }

}
