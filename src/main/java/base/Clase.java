package base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Clases")
public class Clase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="defensa")
	private int defensa;
	@Column(name="mana")
	private int mana;
	@Column(name="magia")
	private int magia;
	
	@ManyToMany(cascade = CascadeType.DETACH, mappedBy = "clases")
	private List<Personaje> personajes;
	
	public Clase() {
		personajes = new ArrayList<>();
	}	

	public List<Personaje> getPersonajes() {
		return personajes;
	}


	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Clase))
			return false;
		
		Clase clase = (Clase) o;
		
		if(nombre.equals(clase.getNombre()))
			return true;
		
		return false;
	}
}
