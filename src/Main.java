import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Desktop desktop=Desktop.getDesktop();
        Tesseract tesseract=new Tesseract();
        try {
            String outfile = "D:\\java project\\OCR\\src\\output";
            tesseract.setDatapath("D:\\Tesseract\\Tess4J\\tessdata");

            System.out.println("enter image path:");
            String path = in.nextLine();


            String out = tesseract.doOCR(new File(path));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outfile, true));
            bufferedWriter.newLine();
            bufferedWriter.write(out);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println(" 1.see the photo \n 2.output file");
            int off = in.nextInt();


            if (off == 1) {
                // Image image= ImageIO.read(new File(path));
                String[] commands = {
                        "cmd.exe", "/c", "start", "\"DummyTitle\"", "\"" + path + "\""
                };
                Process p = Runtime.getRuntime().exec(commands);
                p.waitFor();
            } else if (off == 2) {


                 desktop.open(new File(outfile));
            }





            desktop.open(new File(outfile));


        }catch (TesseractException | IOException | InterruptedException e){
        e.printStackTrace();

        }




    }

}
