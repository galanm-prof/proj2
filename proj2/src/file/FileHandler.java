package file;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private static FileWriter f;
    private static int blanks; // A blank counter for pretty writing

    public FileHandler(){  f=null; blanks = -1;}

    public void increase_blanks(int amount){
        blanks+=amount;
    }

    public void decrease_blanks(int amount){
        blanks-=amount;
    }

    ////////////// FILE METHODS /////////////////

    // Method for writing in the output file
    public void write(String s){
        try{
            write_blanks();
            f.write(s);
        }catch(IOException e){}
    }

    // Method for writing blanks in the output file
    public void write_blanks(){
        try{
            for(int i=0;i<=blanks;i++)
                f.write(" ");
        }catch(IOException e){}
    }

    // Open the output file
    public void open_file(String path,String service_id){
        try{
            f = new FileWriter(path+service_id+".txt");
        }catch(IOException e){System.out.println("-->"+e.getMessage());}
    }

    // Close the output file
    public void close_file(){
        try{
            f.close();
        }catch(IOException e){}
    }
}
