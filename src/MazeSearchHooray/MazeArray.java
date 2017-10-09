package MazeSearchHooray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mmcalvarez on 10/9/2017.
 */
public class MazeArray {
    private String fileName;


    public void readFile(String fileName){
        this.fileName = fileName;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null){
                System.out.println(sCurrentLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
