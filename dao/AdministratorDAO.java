package info.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import info.java.connection.ConectareBD;
import info.java.model.*;

public class AdministratorDAO {
	protected static final Logger LOGGER = Logger.getLogger(AdministratorDAO.class.getName());
	
	public static int adaugare_carte(Carte carte){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO librarydb.carte (id_carte,nume,autor,editor,cantitate,carti_imprumutate) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, carte.getId_carte());
			ps.setString(2, carte.getNume());
			ps.setString(3, carte.getAutor());
			ps.setString(4, carte.getEditor());
			ps.setInt(5, carte.getCantitate());
			ps.setInt(6, 0);
			status = ps.executeUpdate();
			connection.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static List<Carte> stoc_carti(){
		List<Carte> list=new ArrayList<Carte>();
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.carte");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Carte c = new Carte();
				c.setId_carte(rs.getInt("id_carte"));
				c.setNume(rs.getString("nume"));
				c.setAutor(rs.getString("autor"));
				c.setEditor(rs.getString("editor"));
				c.setCantitate(rs.getInt("cantitate"));
				c.setCarti_imprumutate(rs.getInt("carti_imprumutate"));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return list;
	}
	
	public static int stergere_carte(int id_carte){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM librarydb.carte WHERE id_carte=?");
			ps.setInt(1, id_carte);
			status = ps.executeUpdate();
			connection.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static List<CarteImprumutata> stoc_carti_imprumutate(){
		List<CarteImprumutata> list=new ArrayList<CarteImprumutata>();
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM librarydb.carte_imprumutata ORDER BY data_imprumutare DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CarteImprumutata c = new CarteImprumutata();
				c.setId_carte(rs.getInt("id_carte"));
				c.setId_client(rs.getInt("id_client"));
				c.setData_imprumutare(rs.getDate("data_imprumutare"));
				c.setStatus_returnare(rs.getString("status_returnare"));
				list.add(c);
			}
			connection.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	public static int adaugare_client(Client client){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO librarydb.client (id_client,nume,parola,email,telefon) VALUES (?,?,?,?,?)");
			ps.setInt(1, client.getId_client());
			ps.setString(2, client.getNume());
			ps.setString(3, client.getParola());
			ps.setString(4, client.getEmail());
			ps.setString(5, client.getTelefon());
			status = ps.executeUpdate();
			connection.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int update(Client client){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE librarydb.client SET nume=?,parola=?,email=?,telefon=? WHERE id_client=?");
			ps.setString(1, client.getNume());
			ps.setString(2, client.getParola());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getTelefon());
			ps.setInt(5, client.getId_client());
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static List<Client> stoc_clienti(){
		List<Client> list=new ArrayList<Client>();
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.client");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Client c = new Client();
				c.setId_client(rs.getInt("id_client"));
				c.setNume(rs.getString("nume"));
				c.setParola(rs.getString("parola"));
				c.setEmail(rs.getString("email"));
				c.setTelefon(rs.getString("telefon"));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return list;
	}
	
	public static Client cautare_dupa_id(int  id_client){
		Client client = new Client();
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.client WHERE id_client=?");
			ps.setInt(1, id_client);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				client.setId_client(rs.getInt(1));
				client.setNume(rs.getString(2));
				client.setParola(rs.getString(3));
				client.setEmail(rs.getString(4));
				client.setTelefon(rs.getString(5));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return client;
	}
	
	public static int stergere_client(int id_client){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM librarydb.client WHERE id_client=?");
			ps.setInt(1, id_client);
			status = ps.executeUpdate();
			connection.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}

}
