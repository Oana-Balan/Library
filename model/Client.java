package info.java.model;

public class Client {
	private int id_client;
	private String nume, parola, email, telefon;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id_client, String nume, String parola, String email, String telefon) {
		super();
		this.id_client = id_client;
		this.nume = nume;
		this.parola = parola;
		this.email = email;
		this.telefon = telefon;
	}
	
	public Client(String nume, String parola, String email, String telefon) {
		super();
		this.nume = nume;
		this.parola = parola;
		this.email = email;
		this.telefon = telefon;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
