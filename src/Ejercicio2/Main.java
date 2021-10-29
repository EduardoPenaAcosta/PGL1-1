package Ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        ProcessBuilder ProcessBuilder = new ProcessBuilder();
        int OpenTimesExecutable = 0;
        String navigator = "";

        System.out.println("Start the process...");

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

            ProcessBuilder.command("open", "-n", "-a", navigator);

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

            ProcessBuilder.command("open", "-n", "-a", navigator);
        }

        try {
            ArrayList<Process> processList = new ArrayList<>();
            /*
             * Se ha creado un bucle que abrirá cuantas veces se haya pedido
             * que se abra el programa, soltará también el código de error en caso de que algo pase
             * Y dentro del bucle se ha agregado un nuevo bucle donde esperaremos que el proceso se termine.
             */

            System.out.println("The process is working");
            for (int i = 0; i < OpenTimesExecutable; i++) {
                processList.add(ProcessBuilder.start());
            }

            TimeUnit.MILLISECONDS.sleep(500);
            for( Process process: processList){
                while(process.isAlive()){
                    process.destroy();
                    process.waitFor();
                }
            }
            System.out.println("The process has finished");

        } catch (Error | IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Le falta algún argumento o no ha introducido alguno de los datos correctamente.");
        }
    }

}
