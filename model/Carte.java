package info.java.model;

public class Carte {
	private int id_carte;
	private String nume, autor, editor;
	private int cantitate, carti_imprumutate;
	
	
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carte(int id_carte, String nume, String autor, String editor, int cantitate) {
		super();
		this.id_carte = id_carte;
		this.nume = nume;
		this.autor = autor;
		this.editor = editor;
		this.cantitate = cantitate;
	}

	public int getCarti_imprumutate() {
		return carti_imprumutate;
	}

	public void setCarti_imprumutate(int carti_imprumutate) {
		this.carti_imprumutate = carti_imprumutate;
	}

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
}
