public class Account{
    private int id;
    private String nama;

    public Account(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    public String get_nama(){
        return nama;
    }
    public void set_nama(String nama){
        this.nama=nama;
    }
    public int get_id(){
        return id;
    }
}