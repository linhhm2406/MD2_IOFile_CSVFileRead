import java.io.*;

public class CopyFileTest {

    public boolean testCopyFile(String source, String target) {
        boolean conclude = false;
        try {
            File fileSource = new File(source);
            File fileTarget = new File(target);

            if (!fileSource.exists() || !fileTarget.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader brSource = new BufferedReader(new FileReader(fileSource));
            BufferedWriter brTarget = new BufferedWriter(new FileWriter(fileTarget,true));

            String line = "";

            while ((line = brSource.readLine()) != null) {
                brTarget.write(line+"\n");
                conclude = true;
            }
            brSource.close();
            brTarget.close();
        } catch (IOException e) {
            System.out.println("File khong tim thay hoac co loi");
        }
        return conclude;
    }

    public static void main(String[] args) {
        CopyFileTest copyFileTest = new CopyFileTest();

        if (copyFileTest.testCopyFile("source.txt","target.txt")){
            System.out.println("copy thanh cong");
        }
    }
}
