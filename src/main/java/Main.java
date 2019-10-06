import exception.DBException;
import model.User;
import service.Service;
import service.UserService;

public class Main {
//    private static final SessionFactory ourSessionFactory;

//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            System.out.println("ALL WORKS!!!!!!!!!");
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

//    public static Session getSession() throws HibernateException {
//        System.out.println("START getSession!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        return ourSessionFactory.openSession();
//    }
//
//    public static void getUsersThroughHibernate() {
//        System.out.println("START getUsersThroughHibernate!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }

    public static void main(String[] args) throws DBException {
        System.out.println("START MAIN!!!!!!!!!!!!!!!!!!!!!!!");

        Service service = UserService.getInstance();
//        service.cleanUp();
//        service.createTable();

        service.addUser("nick", 18);
        service.addUser("dick", 28);
        service.addUser("quick", 68);
        service.addUser("vick", 38);
        service.addUser("brick", 81);
        service.addUser("kick", 9);
        service.addUser("pick", 999);
        service.addUser("frick", 77);

        service.getAllUsers().forEach(System.out::println);

        User mick = service.getUserByName("mick");


        System.out.println(mick + "\n");

//        service.updateUser(service.getUserByName("nick"), 1);
//        service.updateUser(service.getUserByName("dick"), 1);
//        service.updateUser(service.getUserByName("quick"), 1);
//        service.updateUser(service.getUserByName("vick"), 1);
//        service.updateUser(service.getUserByName("brick"), 1);
//        service.updateUser(service.getUserByName("kick"), 1);
//        service.updateUser(service.getUserByName("pick"), 1);
//        service.updateUser(service.getUserByName("frick"), 1);
//
//        service.deleteUser("nick");
//        service.getAllUsers().forEach(System.out::println);
//
//        service.updateUser(service.getUserByName("nick"), "1");
//        service.updateUser(service.getUserByName("dick"), "2");
//        service.updateUser(service.getUserByName("quick"), "3");
//        service.updateUser(service.getUserByName("vick"), "4");
//        service.updateUser(service.getUserByName("brick"), "5");
//        service.updateUser(service.getUserByName("kick"), "6");
//        service.updateUser(service.getUserByName("pick"), "7");
//        service.updateUser(service.getUserByName("frick"), "8");



//        service.cleanUp();
//        getUsersThroughHibernate();
    }
}