package comfirebasestudentapp.example.a15056158.medicinereminder;

/**
 * Created by 15056158 on 5/8/2017.
 */

public class medication {

    private int id;
    private String med_name;
    private String med_dosage;
    private String med_time;
    private String med_date;
    private String med_to_take;
    private String remarks;


    public medication(){
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getmed_name() {
        return  med_name;
    }
    public void setmed_name(String  med_name) {
        this.med_name =  med_name;
    }

    public String getmed_dosage() {
        return  med_dosage;
    }
    public void setmed_dosage(String  med_dosage) {
        this.med_dosage =  med_dosage;
    }

    public String getmed_time() {
        return  med_time;
    }
    public void setmed_time(String  med_time) {
        this.med_time =  med_time;
    }

    public String getMed_date() {
        return  med_date;
    }
    public void setmed_date(String  med_date) {
        this.med_date =  med_date;
    }

    public String getremarks() {
        return  remarks;
    }
    public void setremarks(String  remarks) {
        this.remarks =  remarks;
    }



    public String toString(){
        return getmed_name() + " " + getmed_dosage() + " " + getmed_time() + " " + getMed_date()  + " " + getremarks() ;
    }

}
