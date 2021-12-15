import java.util.Scanner;
public class App{
    public static void main(String a[]){
        Scanner scan = new Scanner(System.in);
        String pilih, page="logout";
        String nama, password, hp;
        int id;
        Database db = new Database();
        User session = new User(9999,"dummy","dummy");

        while(!page.equals("keluar")){
            switch(page){
                case "logout":
                    cetak("\n=== Kontak ===");
                    cetak("1. Masuk");
                    cetak("2. Daftar");
                    cetak("3. Keluar");
                    cetak("pilih:","");
                    pilih=scan.nextLine();
                    switch(pilih){
                        case "1":
                            page="login";
                            break;
                        case "2":
                            page="daftar";
                            break;
                        case "3":
                            page="keluar";
                            break;
                        default:
                            cetak("pilihan salah");
                            break;
                    }
                    break;
                case "daftar":
                    cetak("\n=== daftar ===");
                    cetak("Masukkan nama:","");
                    nama = scan.nextLine();
                    cetak("Masukkan password:","");
                    password = scan.nextLine();
                    db.add_user(new User(db.user_id(),nama,password));
                    page="login";
                    break;
                case "login":
                    cetak("\n=== login ===");
                    cetak("Masukkan nama:","");
                    nama = scan.nextLine();
                    cetak("Masukkan password:","");
                    password = scan.nextLine();
                    if(db.login(nama,password)){
                        page="masuk";
                        session=db.get_user(nama,password);
                    }
                    else{
                        cetak("Nama atau password salah!");
                        page="logout";
                    }
                    break;
                case "masuk":
                    System.out.format("\n=== buku telpon %s ===\n",session.get_nama());
                    cetak("1. lihat kontak");
                    cetak("2. tambah kontak");
                    cetak("3. edit kontak");
                    cetak("4. hapus kontak");
                    cetak("5. logout");
                    cetak("pilih:","");
                    pilih=scan.nextLine();
                    switch(pilih){
                        case "1":
                            cetak("\n=== lihat kontak ===");
                            for(int i=0; i<session.contact_size();i++){
                                System.out.format("%d. %s - %s\n",session.get_contact(i).get_id(),session.get_contact(i).get_nama(),session.get_contact(i).get_hp());
                            }
                            cetak("\n[tekan enter untuk kembali]");
                            scan.nextLine();
                            break;
                        case "2":
                            cetak("\n=== tambah kontak ===");
                            cetak("Masukkan nama:","");
                            nama = scan.nextLine();
                            cetak("Masukkan hp:","");
                            hp = scan.nextLine();
                            session.add_contact(new Contact(session.contact_id(),nama,hp));
                            break;
                        case "3":
                            cetak("\n=== edit kontak ===");
                            for(int i=0; i<session.contact_size();i++){
                                System.out.format("%d. %s - %s\n",session.get_contact(i).get_id(),session.get_contact(i).get_nama(),session.get_contact(i).get_hp());
                            }
                            cetak("\nMasukkan id:","");
                            id = scan.nextInt();
                            System.out.format("%d. %s - %s\n",session.get_contact(session.get_contact_list_by_id(id)).get_id(),session.get_contact(session.get_contact_list_by_id(id)).get_nama(),session.get_contact(session.get_contact_list_by_id(id)).get_hp());
                            scan.nextLine();
                            cetak("Masukkan nama:","");
                            nama = scan.nextLine();
                            cetak("Masukkan hp:","");
                            hp = scan.nextLine();
                            session.edit_contact(id,nama,hp);
                            break;
                        case "4":
                            cetak("\n=== hapus kontak ===");
                            for(int i=0; i<session.contact_size();i++){
                                System.out.format("%d. %s - %s\n",session.get_contact(i).get_id(),session.get_contact(i).get_nama(),session.get_contact(i).get_hp());
                            }
                            cetak("\nMasukkan id:","");
                            id = scan.nextInt();
                            session.delete_contact(id);
                            break;
                        case "5":
                            page="logout";
                            break;
                        default:
                            cetak("pilihan salah!");
                            break;
                    }
                    break;
                case "default":
                    break;
            }
        }
    }
    private static void cetak(String a){
        System.out.println(a);
    }
    private static void cetak(String a, String b){
        System.out.format("%s %s",a,b);
    }
}