package base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Personajes")
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="vida")
	private int vida;
	@Column(name="ataque")
	private int ataque;	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="personaje")
	private List<Arma> armas;
	
	@ManyToMany(cascade = CascadeType.DETACH)	
	@JoinTable(name="Personajes_Clases",
	joinColumns= {@JoinColumn(name="id_personaje")},
	inverseJoinColumns = {@JoinColumn(name="id_clase")})
	private List<Clase> clases;
	
	public Personaje() {
		armas = new ArrayList<>();
		clases = new ArrayList<>();
	}	
		
	public List<Clase> getClases() {
		return clases;
	}
	
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	public List<Arma> getArmas() {
		return armas;
	}
	public void setArmas(List<Arma> armas) {
		this.armas = armas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Personaje))
			return false;
		
		Personaje personaje = (Personaje) o;
		
		if(nombre.equals(personaje.getNombre()))
			return true;
		
		return false;
	}
}
