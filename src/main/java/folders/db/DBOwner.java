package folders.db;

import folders.models.Folder;
import folders.models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {

    private static Session session;

    public static List<Folder> getFolders(Owner owner) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Folder> results = null;
        try {
            Criteria cr = session.createCriteria(Folder.class);
            cr.add(Restrictions.eq("owner", owner));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
