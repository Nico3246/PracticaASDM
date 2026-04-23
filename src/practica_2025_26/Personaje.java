package practica_2025_26;

public interface Personaje {
    void subirNivel();
    
    public String getNombre();
    public void setNombre(String nombre);
    
    public String getTipo();
    
    public int gethab();
    public void sethab(int hab);
    
    public int getNivel();
    public void setNivel(int nivel);
    
    public double getPrecio();
    public void setPrecio(double precio);
    
    public String getArmas();
    public void setArmas(String armas);
    
    public Personaje clonar();//metodo para aplicar el Prototype
    
}
