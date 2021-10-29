package Ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {


        ProcessBuilder processBuilder = new ProcessBuilder();
        int OpenTimesExecutable = 0;
        String navigator = "";

        if (args.length == 0) {

            /*
             * No hemos detectado argumentos junto a la ejecución del comando, así que
             * mando una notificación, se abren scanners, se piden datos y se almacena el comando.
             */

            System.out.println("No args introduced, please type in in the console the times you want to open the app.");
            Scanner inputScanner = new Scanner(System.in);

            System.out.print("Choose the times you want to open the App: ");
            OpenTimesExecutable = inputScanner.nextInt();
            //Volvemos a hacer el inputScanner para limpiar la línea.
            inputScanner.nextLine();

            System.out.print("Choose web browser: ");
            navigator = inputScanner.nextLine();

            processBuilder.command("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

            inputScanner.close();

        } else {

            /*
             * En este ha detectado los argumentos, pasaremos los argumentos a las variables que
             * hemos creado anterior mente y almacenamos el comando.
             */

            System.out.println("Args introduced");
            System.out.println("Args 0 -> " + args[0]);
            System.out.println("Args 1 -> " + args[1]);

            OpenTimesExecutable = parseInt(args[0]);
            navigator = args[1];

            //processBuilder.command("open", "-n", "-a", navigator);

            processBuilder.command("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");


        }

        try {

            /*
             * Se ha creado un bucle que abrirá cuantas veces se haya pedido, se almacenará el proceso mediante un
             * ArrayList, se arrancará las veces indicadas, donde almacenaremos a la vez el proceso en ArrayList
             * comprobará si está arrancado y cuando termine
             */

            ArrayList<Process> processList = new ArrayList<Process>();
            System.out.println("The process is starting...");

            for (int i = 0; i < OpenTimesExecutable; i++) {
                Process process = processBuilder.start();
                processList.add(process);

            }

            //System.out.println("El número de procesos en ejecución es: " + processList.size());

            System.out.println("The process is working");
            for(Process process : processList){
                while(process.isAlive()){
                }
            }

            System.out.println("The process has finished");

    } catch (Error | IOException e) {
            e.printStackTrace();
            System.out.println("Somehow is.");
        }
    }

}
