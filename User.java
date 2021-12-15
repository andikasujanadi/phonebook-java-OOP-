import java.util.ArrayList;
public class User extends Account{
    private String password;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    int contact;
    public User(int id, String nama, String password){
        super(id,nama);
        this.password = password;
        contact=1;
    }
    public boolean login(String nama, String password){
        if(nama.equals(super.get_nama())&&password.equals(this.password)){
            return true;
        }
        return false;
    }

    public void add_contact(Contact contact){
        contacts.add(contact);
        this.contact++;
    }

    public void delete_contact(int a){
        contacts.remove(get_contact_list_by_id(a));
    }

    public void edit_contact(int id, String nama, String password){
        int index = get_contact_list_by_id(id);
        get_contact(index).update(nama,password);
    }

    public Contact get_contact(int a){
        return contacts.get(a);
    }

    public int get_contact_list_by_id(int a){
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).get_id()==a)
                return i;
        }
        return 0;
    }

    public int contact_id(){
        return contact;
    }

    public int contact_size(){
        return contacts.size();
    }
}