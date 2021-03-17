package ru.itis.printer.app;


import com.beust.jcommander.JCommander;
import ru.itis.printer.utils.Render;

/*
Start program: java -jar printer.jar --black=* --white=@
*/

// Class for start application
public class Program {
    public static void main(String[] args) {

        Arguments arguments = new Arguments();

        JCommander
                .newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        Render render = new Render();
        render.print(arguments.path, arguments.white, arguments.black);
    }
}