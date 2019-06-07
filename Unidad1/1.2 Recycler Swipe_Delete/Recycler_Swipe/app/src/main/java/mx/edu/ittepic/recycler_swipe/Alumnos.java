package mx.edu.ittepic.recycler_swipe;

public class Alumnos {
    private String nombre;
    private String nocontrol;
    private String carrera;
    private int imagen;
    private int basura;

    public Alumnos(String nombre, String nocontrol, String carrera, int imagen, int basura) {
        this.nombre = nombre;
        this.nocontrol = nocontrol;
        this.carrera = carrera;
        this.imagen = imagen;
        this.basura= basura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setBasura(int basura) {
        this.basura = basura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getImagen() {
        return imagen;
    }

    public int getBasura() {
        return basura;
    }
}
