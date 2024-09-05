package classes;

import java.util.Date;


public class Livro {

	private String titulo;
	private String autor;
	private int id;
	

	public Livro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}
	public Livro() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", id=" + id
				+ "]";
	}
	
	

}
