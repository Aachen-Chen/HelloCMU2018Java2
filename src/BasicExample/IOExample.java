package BasicExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class IOExample {

}

class Print3Example{
    public static void main(String[] args) {
        String name;
        System.out.println("Enter your name");
        name = (new Scanner(System.in)).nextLine(); //take user input from keyboard

        // 180914
        // Three print-methods.
        System.out.println(sayHello(name));
        System.out.print(sayHello(name));
        System.out.printf("%s", sayHello(name));

    }
    private static String sayHello(String name) { return ("Hello " + name);}
}

class ScannerExample1{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int    m = s.nextInt();
//        String n = s.nextLine();
//        String o = s.next();
        String n = s.next();
        String o = s.nextLine();
        String p = s.nextLine();
        System.out.println("nextInt |"+m+"|");
        System.out.println("next    |"+n+"|");
        System.out.println("nextLine|"+o+"|");
        System.out.println("nextLine|"+p+"|");
    }
}


class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("path separator      " + File.pathSeparator);
        System.out.println("path separator char:" + File.pathSeparatorChar);
        System.out.println("separator:          " + File.separator);
        System.out.println("separator char:     " + File.separatorChar);

//        File f = new File("D:/test.txt");
//        File dir = new File("D:");
        File f = new File("D:","test.txt");
//        File f3 = new File(f1,"test.txt");
//        File f4 = new File("file://D:/Java/test.txt");
//
//
        File dir = new File("C:\\Users\\Kaichen\\Documents\\IdeaProjects\\HelloCMU2018Java\\src\\BasicExample\\demo folder");
        File f2 = new File(dir, "ZIdeaIDExample.java");
        File path = new File("C:/Users/Kaichen/Documents/IdeaProject/HelloCMU2018Java/src/BasicExample/demo folder/ZIdeaIDExample.java");
//         uri of File
//        File f = new File("file:/C:/Users/Kaichen/Documents/IdeaProject/HelloCMU2018Java/src/BasicExample/demo folder/ZIdeaIDExample.java");

        System.out.println("");
        System.out.println(f);
        System.out.println("exist:              " + f.exists());
        System.out.println("name:               " + f.getName());
        System.out.println("path:               " + f.getPath());
        System.out.println("abosolute path:     " + f.getAbsolutePath());
        System.out.println("parent:             " + f.getParent());
        System.out.println("is a file :         " + f.isFile());
        System.out.println("is a directory:     " + f.isDirectory());
        System.out.println("length:             " + f.length());
        System.out.println("can read:           " + f.canRead());
        System.out.println("can write :         " + f.canWrite());
        System.out.println("last modified:      " + f.lastModified());
        f.setLastModified(f.lastModified() + 1102304);
        System.out.println("last modified:      " + f.lastModified());
        System.out.println("Canonical Path:" + f.getCanonicalPath());
        File newF = new File("newFile.class");
        System.out.println("-----Rename " + f + "-------");
        f.renameTo(newF);
        System.out.println("name :             " + newF.getName());
        System.out.println(f + " exist?           " + f.exists());
        System.out.println(newF + " exist?           " + f.exists());
        System.out.println("convert to URI:" + f.toURI());
        System.out.println("compare f to path:" + f.compareTo(path));
        System.out.println("compare f to f2:" + f.compareTo(f2));
        System.out.println("-----delete " + newF + "-------");
        newF.delete();
        System.out.println(newF + " exist? " + newF.exists());
    }

}


class FileExample{
    public static void main(String[] args){
        File f = new File("C:\\Users\\Kaichen\\Documents\\IdeaProjects\\HelloCMU2018Java\\src\\BasicExample\\ZIdeaIDExample.java");
        System.out.println(f.getPath());
        System.out.println(f.getAbsoluteFile());
//        System.out.println(f.getCanonicalPath());
    }
}

class FileInputStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        int size;
        FileInputStream f = new FileInputStream("C:\\Users\\Kaichen\\Documents\\IdeaProjects\\HelloCMU2018Java\\src\\BasicExample\\ZIdeaIDExample.java");

        System.out.println("Total Available Bytes: "
                + (size = f.available()))
        ;
        int n = size / 30;

        // read()
        System.out.print((char) f.read());
        System.out.println("\nStill Available: " + f.available());

        // read(byte[]b )
        byte b[] = new byte[n];
        f.read(b);
        System.out.println(new String(b, 0, n));

        System.out.println("\nStill Available: " + (size = f.available()));

        // Skipping half of remaining bytes with skip()"
        f.skip(size / 2);
        System.out.println("Still Available: " + f.available());
        System.out.println("Reading " + n / 2 + " into the end of array");

        // read(b,offset,len)
        f.read(b, n / 2, n / 2);
        System.out.println(new String(b, 0, b.length));

        System.out.println("\nStill Available: " + f.available());
        f.close();
    }
}
