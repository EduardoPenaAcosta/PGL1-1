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

                System.out.println("-----------------------------------------------------");
                System.out.println(readFromCommand.readLine());
                System.out.println("-----------------------------------------------------");

            }catch (IOException e) {
                e.printStackTrace();
            }




        }




    }
}
