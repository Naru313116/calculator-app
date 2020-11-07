package pl.naru;

import pl.naru.workers.DataWorker;
import pl.naru.workers.FileWorker;

import java.io.*;
import java.util.List;


public class Run {

    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();
        DataWorker dataWorker;
        if (args.length < 1) {
            System.out.println("Type in your file path");
            System.exit(0);
        }
        try {

            final List<String> lines = fileWorker.retrieveFileData(args[0]);
            dataWorker = new DataWorker(lines);
            if (lines == null || !dataWorker.isStatementValid()) {
                System.out.println("invalid statement. Please make sure you have typed in at the end of your statement: \"apply\"<space><number>");
                System.exit(0);
            }
            try {
                System.out.println(dataWorker.executeStatement());
            } catch (UnsupportedOperationException uoe) {
                System.out.println(uoe.getMessage());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find a file in the given path");
        }

    }
}
