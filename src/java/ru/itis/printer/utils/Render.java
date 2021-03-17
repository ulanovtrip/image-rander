package ru.itis.printer.utils;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Class with bisness logic of application
public class Render {
    public void print(String fileName, String white, String black) {

        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLUE)
                .build();

        try {
            // подключаемся к файлу
            File imageFile = new File(fileName);
            // получаем информацию о содержимом картинки
            BufferedImage image = ImageIO.read(imageFile);

            // получаем высоту и ширину картинки
            int height = image.getHeight();
            int width = image.getWidth();

            // т.к. картинка это двумерный массив, то проходим двумя циклами
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // проверим цвет конкретного пикселя в данной позиции
                    if (image.getRGB(j, i) == Color.BLACK.getRGB()) {
                        // если цвет чёрный
                        cp.print("*", Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.GREEN);

                    } else {
                        cp.print("+", Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.RED);

                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}