package Persona;


public class Persona {


    private String cedula;
    private String nombre;
    private int edad;
    private String direccion;
    private String correo;
    private String telefono;
    private String genero;
    private String perfil;
    private String formacion;
    private String experiencia;
    private String competencias;
    private String idiomas;

    public Persona() {
    }

    public Persona(String cedula, String nombre, int edad, String direccion, String correo, String telefono,
                   String genero, String perfil, String formacion, String experiencia, String competencias, String idiomas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.perfil = perfil;
        this.formacion = formacion;
        this.experiencia = experiencia;
        this.competencias = competencias;
        this.idiomas = idiomas;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    public String getCompetencias() {
        return competencias;
    }
    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String mostrarInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DATOS PERSONALES ===\n");
        sb.append("Cédula: ").append(cedula).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Dirección: ").append(direccion).append("\n");
        sb.append("Correo: ").append(correo).append("\n");
        sb.append("Teléfono: ").append(telefono).append("\n");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("--------------------------\n\n");

        sb.append("==== PERFIL PROFESIONAL ====\n").append(perfil).append("\n");
        sb.append("--------------------------\n\n");

        sb.append("==== FORMACIÓN ACADÉMICA ====\n").append(formacion).append("\n");
        sb.append("---------------------------\n\n");

        sb.append("==== EXPERIENCIA LABORAL ====\n").append(experiencia).append("\n");
        sb.append("---------------------------\n\n");

        sb.append("==== COMPETENCIAS ====\n").append(competencias).append("\n");
        sb.append("--------------------\n\n");

        sb.append("==== IDIOMAS ====\n").append(idiomas).append("\n");
        sb.append("-----------------\n");

        return sb.toString();
    }
}
