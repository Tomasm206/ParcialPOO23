package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlataformaTerapia {
    public static final int CAPACIDAD = 80;
    private String nombre;
    private List<Terapeuta> terapia;
    public PlataformaTerapia() {this.terapia = new ArrayList<>();}

    public boolean registrarTerapeuta(String nombre, int tarifa){ //1
        if (!buscarParaValidar(nombre).isEmpty() && terapia.size()<CAPACIDAD){
            Terapeuta agregarTerapeuta = new Terapeuta(nombre,tarifa);
            this.terapia.add(agregarTerapeuta);
            return true;
        }else{
            return false;
        }
    }
    public void eliminarTerapeuta(String nombre){ //2
        if (!buscarParaValidar(nombre).isEmpty()){
            this.terapia.remove(buscarParaValidar(nombre));
            System.out.println("El contacto ha sido eliminado.");
        }else {
            System.out.println("El terapeuta no existe en la plataforma.");
        }
    }
    public Terapeuta buscar(String nombre){
        return this.terapia.stream()
                .filter(tera -> tera.getNombre() == nombre)
                .findFirst().orElse(null);
    }
    public List<Terapeuta> buscarParaValidar(String terapeuta) {
        return this.terapia.stream()
                .filter(contact -> contact.getNombre().equalsIgnoreCase(terapeuta)).toList();
    }

    public List<Terapeuta> buscar(int tarifa){
        return this.terapia.stream()
                .filter(contact -> contact.getTarifa() <= tarifa).toList();
    }
    ////
    ////public List<Terapeuta> buscarPorEspecialidad(String especialidad){
    ////    return this.especialidad.stream()
    ////            .filter(contact -> contact.getNombre() == especialidad).toList();
    ////}
    ////public List<Terapeuta> getTerapeutasConMasDeDosEspecialidades(){
    //
    ////
    public void ordenarTerapeutasPorTarifa(){
        this.terapia.sort(Comparator.comparingLong(Terapeuta::getTarifa).reversed());
    }
}
