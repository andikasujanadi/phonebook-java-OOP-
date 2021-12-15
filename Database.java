import java.util.ArrayList;
public class Database{
    private ArrayList<User> users = new ArrayList<User>();
    private int user;
    public Database(){
        user=1;
    }
    public void add_user(User user){
        users.add(user);
        this.user++;
    }
    public int user_size(){
        return users.size();
    }
    public int user_id(){
        return user;
    }
    public boolean login(String nama, String password){
        for(int i=0; i<users.size();i++){
            if(users.get(i).login(nama, password))
            return true;
        }
        return false;
    }
    public User get_user(String nama, String password){
        for(int i=0; i<users.size();i++){
            if(users.get(i).login(nama, password))
            return users.get(i);
        }
        return users.get(0);
    }
}