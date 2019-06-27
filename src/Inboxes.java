import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Inboxes {

    public void getRecentInboxes(String content) {

            String fileNameToStoreEmails = "Driver/File";

            try {
                Writer writer = new FileWriter(fileNameToStoreEmails);
                writer.write(content);
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        /*Print subject and body of each inboxes*/
    }
}
