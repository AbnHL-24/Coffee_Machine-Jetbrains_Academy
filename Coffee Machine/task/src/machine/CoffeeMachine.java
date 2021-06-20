package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        MaquinaCaffe maquinaCaffe = new MaquinaCaffe();
        Scanner sc = new Scanner(System.in);

        maquinaCaffe.imprimirMenu();
        do {
            maquinaCaffe.procesarEntrada(sc.nextLine());
        } while (maquinaCaffe.getEstadoMaquina() != EstadoMaquina.EXIT);
    }
}

class MaquinaCaffe {
    EstadoMaquina estadoMaquina = EstadoMaquina.MENU;
    long agua = 400;
    long leche = 540;
    long cafe = 120;
    long vasos = 9;
    long dinero = 550;

    final String BUY = "buy";
    final String FILL = "fill";
    final String TAKE = "take";
    final String REMAINING = "remaining";
    final String EXIT = "exit";
    final String UNO = "1";
    final String DOS = "2";
    final String TRES = "3";
    final String ATRAS = "back";

    Scanner sc = new Scanner(System.in);

    public void procesarEntrada(String entrada) {
        if (estadoMaquina == EstadoMaquina.MENU) {
            if (BUY.equals(entrada)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                        "3 - cappuccino, back - to main menu:");
                estadoMaquina = EstadoMaquina.BUY;
            } else if (FILL.equals(entrada)) {
                fill();
            } else if (TAKE.equals(entrada)) {
                take();
            } else if (REMAINING.equals(entrada)) {
                remaining();
            } else if (EXIT.equals(entrada)) {
                estadoMaquina = EstadoMaquina.EXIT;
            }
        } else if (estadoMaquina == EstadoMaquina.BUY) {
            if (UNO.equals(entrada)) {
                hacerExpresso();
            } else if (DOS.equals(entrada)) {
                hacerLatte();
            } else if (TRES.equals(entrada)) {
                hacerCapuccino();
            } else if (ATRAS.equals(entrada)) {
                //Regresa al menu
            }
            imprimirMenu();
            estadoMaquina = EstadoMaquina.MENU;
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        agua = agua + sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        leche = leche + sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        cafe = cafe + sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        vasos = vasos + sc.nextInt();
        System.out.println();
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(agua + " of water");
        System.out.println(leche + " of milk");
        System.out.println(cafe + " of coffee beans");
        System.out.println(vasos + " of disposable cups");
        System.out.println("$" + dinero + " of money");
        System.out.println();
    }

    private void take() {
        final int CERO = 0;

        System.out.println("I gave you $" + dinero);
        System.out.println();
        dinero = CERO;
    }

    private void hacerCapuccino() {
        if(agua < 200){
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
        else if(leche < 100){
            System.out.println("Sorry, not enough milk!");
            System.out.println();
        }
        else if(cafe < 12){
            System.out.println("Sorry, not enough coffee!");
            System.out.println();
        }
        else if(vasos < 1){
            System.out.println("Sorry, not enough cups!");
            System.out.println();
        }
        else{
            agua = agua - 200;
            leche = leche - 100;
            cafe = cafe - 12;
            vasos = vasos - 1;
            dinero = dinero + 6;

            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
        }
    }

    private void hacerLatte() {
        if(agua < 350){
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
        else if(leche < 75){
            System.out.println("Sorry, not enough coffee!");
            System.out.println();
        }
        else if(cafe < 20){
            System.out.println("Sorry, not enough coffee!");
            System.out.println();
        }
        else if(vasos < 1){
            System.out.println("Sorry, not enough cups!");
            System.out.println();
        }
        else{
            agua = agua - 350;
            leche = leche - 75;
            cafe = cafe - 20;
            vasos = vasos - 1;
            dinero = dinero + 7;

            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
        }
    }

    private void hacerExpresso() {
        if(agua < 250){
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
        else if(cafe < 16){
            System.out.println("Sorry, not enough coffee!");
            System.out.println();
        }
        else if(vasos < 1){
            System.out.println("Sorry, not enough cups!");
            System.out.println();
        }
        else{
            agua = agua - 250;
            cafe = cafe - 16;
            vasos = vasos - 1;
            dinero = dinero + 4;

            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
        }
    }

    public EstadoMaquina getEstadoMaquina() {
        return estadoMaquina;
    }

    public void imprimirMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}

enum EstadoMaquina {
    BUY, EXIT, MENU
}