package mx.edu.ittepic.recycler;

public class Utilidades {

    public static final String TABLA_ALUMNOS="alumnos";
    public static final String CAMPO_NOCONTROL="nocontrol";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CARRERA="carrera";

    public static final String CREAR_TABLA_ALUMNOS="CREATE TABLE " +
            ""+TABLA_ALUMNOS+" ("+CAMPO_NOCONTROL+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CARRERA+" TEXT)";
}
