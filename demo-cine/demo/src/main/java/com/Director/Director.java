package com.Director;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Pelicula.Pelicula;

@Entity
@Table(name = "director")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_DIRECTOR")
    private int id_director;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @OneToMany(mappedBy = "director", cascade = CascadeType.PERSIST)
    private List<Pelicula> peliculas = new ArrayList<>();

    public Director() {
    }

    public Director(int id, String nombre, String nacionalidad) {
        super();
        this.id_director = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getId_director() {
        return this.id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public boolean equals(Object elOtro) {
        if (elOtro instanceof Director) {
            Director d = (Director) elOtro;
            return this.id_director == d.id_director;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.id_director;
    }

    @Override
    public String toString() {
        return String.format("id=%d, nombre=%s, nacionalidad=%s", this.id_director,
                this.nombre, this.nacionalidad);
    }

    // Método para poder imprimir por pantalla solo el nombre del director
    public String toStringPelicula() {
        return String.format("%s", this.nombre);
    }

}
