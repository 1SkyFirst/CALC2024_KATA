import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Input ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String result = calc (input);
        System.out.println(result);
    }

    public static String calc (String input){

        boolean n1rome = false, n2rome = false;
        int n1real = 0, n2real = 0, rezultrim = 0;
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        char[] zadacha1 = new char[10];
        String[] outRim = new String[10];
        String[] rim = new String[13];
        rim[0] = "I";
        rim[1] = "II";
        rim[2] = "III";
        rim[3] = "IV";
        rim[4] = "V";
        rim[5] = "VI";
        rim[6] = "VII";
        rim[7] = "VIII";
        rim[8] = "IX";
        rim[9] = "X"; //stop check
        rim[10] = "XL";
        rim[11] = "L";
        rim[12] = "C";

//System.out.println("Вы ввели " +input);
        String [] strings = input.split(" ");
// первый оператор
        String first = strings[0];
//знак
        String second = strings[1];
        if (strings[1].length()>1) {System.exit(0);}
//второй оператор
        String third = strings[2];



//парсинг
        try {
            num1 = Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            n1rome = true;
        }
        try {
            num2 = Integer.parseInt(strings[2]);
        } catch (NumberFormatException e) {
            n2rome = true;
        }
        if (n2rome != n1rome) {
            System.out.println("используются одновременно разные системы счисления");
            System.exit(0);
        } else if (n1rome) {
            if (strings[0].equals(rim[3])) n1real = 4;
            else if (strings[0].equals(rim[8])) n1real = 9;
            else {
                char[] romechar1 = strings[0].toCharArray();


//    System.out.println(romechar1);
//    System.out.println(romechar2);



                for (i = 0; i < romechar1.length; i++) {
                    switch (romechar1[i]) {
                        case 'I':
                            n1real = n1real + 1;
                            break;
                        case 'V':
                            n1real = n1real + 5;
                            break;
                        case 'X':
                            n1real = n1real + 10;
                            break;

                    }
//          System.out.println(n1real);
                }
            }
            if (strings[2].equals(rim[3])) n2real = 4;
            else if (strings[2].equals(rim[8])) n2real = 9;
            else {
                char[] romechar2 = strings[2].toCharArray();
                for (i = 0; i < romechar2.length; i++) {
                    switch (romechar2[i]) {
                        case 'I':
                            n2real = n2real + 1;
                            break;
                        case 'V':
                            n2real = n2real + 5;
                            break;
                        case 'X':
                            n2real = n2real + 10;
                            break;

                    }
//            System.out.println(n2real);
                }
            }
            if (n1real < 0) ;
            else if (n1real > 10.1) ;
            else if (n2real < 0) ;
            else if (n2real > 10.1) ;
            else {
                zadacha1 = input.toCharArray();
                for (int b = 0, n = zadacha1.length; b < n; b++) {
                    switch (zadacha1[b]) {
                        case '+':
                            rezultrim = n1real + n2real;
                            break;
                        case '-':
                            rezultrim = n1real - n2real;
                            break;
                        case '*':
                            rezultrim = n1real * n2real;
                            break;
                        case '/':
                            rezultrim = n1real / n2real;
                            break;
                    }
                }
            }
            if (rezultrim > 0) {
                if (rezultrim <= 10)
                    System.out.println(rim[rezultrim - 1]); //!!!

                else {
                    //преобразование в римские
                    char[] convert = (String.valueOf(rezultrim)).toCharArray();
                    String[] rezultrimbig = new String[10];
                    if (convert.length == 100) System.out.println(rim[12]); //!!!
                    else {
                        switch (convert[0]) {
                            case '1':
                                rezultrimbig[0] = rim[9];
                                break;
                            case '2':
                                rezultrimbig[0] = rim[9];
                                rezultrimbig[1] = rim[9];
                                break;
                            case '3':
                                rezultrimbig[0] = rim[9];
                                rezultrimbig[1] = rim[9];
                                rezultrimbig[3] = rim[9];
                                break;
                            case '4':
                                rezultrimbig[0] = rim[10];
                                break;
                            case '5':
                                rezultrimbig[0] = rim[11];
                                break;
                            case '6':
                                rezultrimbig[0] = rim[11];
                                rezultrimbig[1] = rim[9];
                                break;
                            case '7':
                                rezultrimbig[0] = rim[11];
                                rezultrimbig[1] = rim[9];
                                rezultrimbig[2] = rim[9];
                                break;
                            case '8':
                                rezultrimbig[0] = rim[11];
                                rezultrimbig[1] = rim[9];
                                rezultrimbig[2] = rim[9];
                                rezultrimbig[3] = rim[9];
                                break;
                            case '9':
                                rezultrimbig[0] = rim[11];
                                rezultrimbig[1] = rim[10];
                                break;

                        }
                        for (i = 0; i < rezultrimbig.length; i++) {
                            if (rezultrimbig[i] != null)
//                                outRim[i]=(rezultrimbig[i]); //!!!!
                            System.out.print(rezultrimbig[i]);
                        }
//            System.out.println(convert[1]);
                        i = Character.getNumericValue(convert[1]);
                        i = i - 1;
//            System.out.println(i);
                        if (i > 0)
//                            outRim[i]=(rim[i]); //!!!
                        System.out.print(rim[i]);
                    }

                }
            } else
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            System.exit(0);
        } else


//фильтр ввода,поиск знака, рассчет арабских
            if (num1 < 0) ;
            else if (num1 > 10.1) ;
            else if (num2 < 0) ;
            else if (num2 > 10.1) ;
            else {
                zadacha1 = input.toCharArray();
                for (int b = 0, n = zadacha1.length; b < n; b++) {
                    switch (zadacha1[b]) {
                        case '+':
                            input = String.valueOf(num1 + num2);
                            break;
                        case '-':
                            input = String.valueOf(num1 - num2);
                            break;
                        case '*':
                            input = String.valueOf(num1 * num2);
                            break;
                        case '/':
                            input = String.valueOf(num1 / num2);
                            break;
                    }
                }
            }

        //финальный рассчёт
        String resultOut = input;
/*
        String str = null;

        if (n1rome != true) {
                if (n2rome != true) {
                    for (i = 0; i < outRim.length; i++) {;
                     str = str + outRim[i];

                }
                    resultOut = str;
                ;}
*/
        return resultOut;

    }

}
