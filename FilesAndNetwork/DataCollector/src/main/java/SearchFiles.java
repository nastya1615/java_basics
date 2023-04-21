import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles {

    List<File> files = new ArrayList<>();

    public List<File> searchFilesCSV(File rootFile) {

        if (rootFile.isDirectory()) {
            File[] directoryFile = rootFile.listFiles();

            if (directoryFile != null) {

                for (File file : directoryFile) {


                    if (file.isDirectory()) {
                        searchFilesCSV(file);

                    } else {

                        if (file.getName().toLowerCase().endsWith(".csv")) {

                            files.add(file);

                        }

                    }
                }
            }
        }

        return files;

    }


    public List<File> searchFilesJSON(File rootFile) {

        if (rootFile.isDirectory()) {
            File[] directoryFile = rootFile.listFiles();

            if (directoryFile != null) {

                for (File file : directoryFile) {


                    if (file.isDirectory()) {
                        searchFilesJSON(file);

                    } else {

                        if (file.getName().toLowerCase().endsWith(".json")) {


                            files.add(file);
                        }

                    }
                }
            }
        }

        return files;

    }
}
