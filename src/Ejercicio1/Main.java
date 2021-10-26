package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {


        ProcessBuilder ProcessBuilder = new ProcessBuilder();
        Process process = null;
        int OpenTimesExecutable = 0;
        String navigator = "";

        System.out.println("Comienza el proceso...");

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

            ProcessBuilder.command("open","-n","-a",navigator);

            inputScanner.close();

        }else{

            /*
            * En este ha detectado los argumentos, pasaremos los argumentos a las variables que
            * hemos creado anterior mente y almacenamos el comando.
            */

            System.out.println("Args introduced");
            System.out.println("Args 0 -> "+ args[0]);
            System.out.println("Args 1 -> "+ args[1]);

            OpenTimesExecutable = parseInt(args[0]);
            navigator = args[1];

            ProcessBuilder.command("open","-n","-a",navigator);
        }

        try{

            /*
            * Se ha creado un bucle que abrirá cuantas veces se haya pedido
            * que se abra el programa, soltará también el código de error en caso de que algo pase
            */

            for(int i = 0; i < OpenTimesExecutable; i++){
                process = ProcessBuilder.start();
            }


            int exitCode = process.waitFor();
            System.out.println("Process error code -> " + exitCode);

        }catch(Error | IOException | InterruptedException e){
            e.printStackTrace();
            System.out.println("Le falta algún argumento o no ha introducido alguno de los datos correctamente.");
        }

    }

}
