public class Contact extends Account{
    private String hp;

    public Contact(int id, String nama, String hp){
        super(id,nama);
        this.hp = hp;
    }

    public void update(String nama, String hp){
        super.set_nama(nama);
        this.hp=hp;
    }

    public String get_hp(){
        return hp;
    }
}