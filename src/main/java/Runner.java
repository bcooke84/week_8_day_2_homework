import folders.db.DBFolder;
import folders.db.DBHelper;
import folders.db.DBOwner;
import folders.models.File;
import folders.models.Folder;
import folders.models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("brian", "bc");
        Folder folder1 = new Folder("Job", owner1);
        Folder folder2 = new Folder("Private", owner1);
        File file1 = new File("cv", ".txt", 5, folder1);
        File file2 = new File("cover letter", ".doc", 5, folder1);
        File file3 = new File("addresses", ".txt", 5, folder2);

        DBHelper.save(owner1);
        DBHelper.save(folder1);
        DBHelper.save(folder2);
        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);

        List<File> allFiles = DBHelper.getAll(File.class);
        List<Folder> allFolders = DBHelper.getAll(Folder.class);

        DBHelper.delete(file3);
        DBHelper.delete(folder2);

        List<File> allFiles2 = DBHelper.getAll(File.class);
        List<Folder> allFolders2 = DBHelper.getAll(Folder.class);

        List<File> specifcFiles = DBFolder.getFiles(folder1);

        Folder foundFolder = DBHelper.find(Folder.class, folder1.getId());

        List<Folder> specificFolders = DBOwner.getFolders(owner1);

    }
}
