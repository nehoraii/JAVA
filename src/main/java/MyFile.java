import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class MyFile {
    private File _file;
    public MyFile(String path){
        _file=new File(path);
    }
    public  File getFile(){
        return _file;
    }

    public  void getDate(){
        try {
            FileTime creationTime = (FileTime) Files.getAttribute(Path.of(getFile().getAbsolutePath()), "creationTime");
            System.out.println(creationTime);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public String getText(){

        try {
            Scanner scanner=new Scanner(getFile());
            String list="";
            while(scanner.hasNextLine()){
                list+=scanner.nextLine();
                list+="\n";
            }
            return list;
        } catch (FileNotFoundException e) {
            System.out.println(e + "   ERROR!!!!");
        }
        return null;
    }
    public void cleanText(){
        try {
            PrintWriter printWriter=new PrintWriter(getFile());
            printWriter.print("");
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean deleteFile(){
        getFile().delete();
        return getFile().exists();
    }
    public void replaceChar(char oldChar,char newChar){

        try {
            String save=getText();
            PrintWriter myWrite= new PrintWriter(getFile());
            cleanText();
            myWrite.print(save.replace(oldChar,newChar));
            myWrite.close();
            System.out.println("replaced "+oldChar+" in "+newChar);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int hashCode(){
        return getText().hashCode();
    }
    public void printToFile(String str){
        try {
            PrintWriter printWriter=new PrintWriter(getFile());
            printWriter.print(str);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
