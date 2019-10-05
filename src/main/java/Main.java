import exception.DBException;
import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) throws DBException {
        UserService service = new UserService();
        service.cleanUp();
        service.createTable();

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


        System.out.println(mick);

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
    }
}