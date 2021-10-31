package Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        * En este ejercicio, se le ha pedido que se introduzca por consola el path de donde está el archivo que se desea leer.
        * Se verifica si es un archivo y si existe, en caso de que si exista, se crea las variables para leer el archivo
        * y el otro que cuenta las líneas, palabras y letras, a continuación, procedemos a ejecutar los dos comandos con una
        * tubería de por medio con el "startPipeLine", obtenemos el resultado que almacenamos en un buffer y lo imprimimos.
        * */
        Scanner inputScanner = new Scanner(System.in);

        System.out.printf("Please introduce the path of the file: ");
        String path = inputScanner.nextLine();

        File newFile = new File(path);

        if(!newFile.exists()){
            System.out.println("ERROR: The file you are searching for doesn't exists.");
        }else if(!newFile.isFile()){
            System.out.println("ERROR: The file you introduced is not a file.");
        }else{
            try{
                ProcessBuilder catCommand = new ProcessBuilder("cat", path);
                ProcessBuilder wcCommand = new ProcessBuilder("wc");

                List<Process> process = ProcessBuilder.startPipeline(Arrays.asList(catCommand,wcCommand));

                Process getProcess = process.get(process.size() - 1);

                BufferedReader readFromCommand = new BufferedReader(new InputStreamReader(getProcess.getInputStream()));

                System.out.println("*****************************************************");
                System.out.println(readFromCommand.readLine());
                System.out.println("******************************************************");

            }catch (IOException e) {
                e.printStackTrace();
            }




        }




    }
}
