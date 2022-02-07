package MyProject.WebTestEntityGenerator.util.apkentity.filehandler;

import MyProject.WebTestEntityGenerator.util.apkentity.APKEntityProjectProperties;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class MSOfficeWordDocumentParagraphHandler {

    public void test(InputStream in)  {
        try(XWPFDocument document = new XWPFDocument(in)){
            document.getParagraphs().forEach(p -> {
                p.getRuns().forEach(r -> {
                    r.setFontSize(Integer.parseInt(APKEntityProjectProperties.getProperties().getProperty("MainFontTextFize")));

                        r.setFontFamily(APKEntityProjectProperties.getProperties().getProperty("MainFontType"));
                });
            });

            File resultFolder = new File("C:\\Users\\dsharko\\Desktop\\Новая папка (2)");
            if(!resultFolder.exists()) resultFolder.mkdirs();
            OutputStream out = new FileOutputStream(resultFolder.getPath() + File.separator + "test.docx");

            document.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
