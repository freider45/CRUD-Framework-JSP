
package Modelo;

public class Persona {
    int atrId;
    String atrDni;
    String atrName;
    String atrLstName;
    String atrPhone;
    String atrEmail;
    String atrResid;

    public Persona() {
    }

    public Persona(String prmDni, String prmName, String prmLstName, String prmPhone, String prmEmail, String prmResid) {
        this.atrDni = prmDni;
        this.atrName = prmName;
        this.atrLstName = prmLstName;
        this.atrPhone = prmPhone;
        this.atrEmail = prmEmail;
        this.atrResid = prmResid;
    }

    public int getAtrId() {
        return atrId;
    }

    public void setAtrId(int atrId) {
        this.atrId = atrId;
    }

    public String getAtrDni() {
        return atrDni;
    }

    public void setAtrDni(String atrDni) {
        this.atrDni = atrDni;
    }

    public String getAtrName() {
        return atrName;
    }

    public void setAtrName(String atrName) {
        this.atrName = atrName;
    }

    

    public String getAtrLstName() {
        return atrLstName;
    }

    public void setAtrLstName(String atrLstName) {
        this.atrLstName = atrLstName;
    }

    public String getAtrPhone() {
        return atrPhone;
    }

    public void setAtrPhone(String prmPhone) {
        this.atrPhone = prmPhone;
    }

    public String getAtrEmail() {
        return atrEmail;
    }

    public void setAtrEmail(String prmEmail) {
        this.atrEmail = prmEmail;
    }

    public String getAtrResid() {
        return atrResid;
    }

    public void setAtrResid(String prmResid) {
        this.atrResid = prmResid;
    }
}
