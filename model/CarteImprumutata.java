package info.java.model;

import java.sql.Date;

public class CarteImprumutata {
	private int id_carte, id_client;
	private Date data_imprumutare;
	private String status_returnare;
	
	public CarteImprumutata() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarteImprumutata(int id_carte, int id_client) {
		super();
		this.id_carte = id_carte;
		this.id_client = id_client;
	}

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public Date getData_imprumutare() {
		return data_imprumutare;
	}

	public void setData_imprumutare(Date data_imprumutare) {
		this.data_imprumutare = data_imprumutare;
	}


	public String getStatus_returnare() {
		return status_returnare;
	}

	public void setStatus_returnare(String status_returnare) {
		this.status_returnare = status_returnare;
	}
}
