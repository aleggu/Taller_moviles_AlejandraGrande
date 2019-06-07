package mx.edu.ittepic.json_recycler;

public class NumerosVo {
    String numerocontrol;
    String nombre;
    String cal1;
    String cal2;
    String cal3;
    public NumerosVo(String numerocontrol, String nombre, String cal1, String cal2, String cal3) {
        this.numerocontrol = numerocontrol;
        this.nombre = nombre;
        this.cal1 = cal1;
        this.cal2 = cal2;
        this.cal3 = cal3;
    }

    public String getNumerocontrol() {
        return numerocontrol;
    }

    public void setNumerocontrol(String numerocontrol) {
        this.numerocontrol = numerocontrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCal1() {
        return cal1;
    }

    public void setCal1(String cal1) {
        this.cal1 = cal1;
    }

    public String getCal2() {
        return cal2;
    }

    public void setCal2(String cal2) {
        this.cal2 = cal2;
    }

    public String getCal3() {
        return cal3;
    }

    public void setCal3(String cal3) {
        this.cal3 = cal3;
    }
}
