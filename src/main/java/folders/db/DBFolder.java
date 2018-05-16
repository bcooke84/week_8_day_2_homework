package folders.db;

import folders.models.File;
import folders.models.Folder;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFolder {

    private static Session session;

    public static List<File> getFiles(Folder folder) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        try {
            Criteria cr = session.createCriteria(File.class);
            cr.add(Restrictions.eq("folder", folder));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
