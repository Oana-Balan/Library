package info.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import info.java.connection.ConectareBD;
import info.java.model.Carte;
import info.java.model.CarteImprumutata;

public class ClientDAO {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	
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
	
	public static int carte_imprumutata(int id_carte){
		int status = 0;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.carte WHERE id_carte=?");
			ps.setInt(1, id_carte);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = rs.getInt("carti_imprumutate");
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static boolean verificat_imprumutare(int id_carte){
		boolean status = false;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.carte WHERE id_carte=? AND cantitate>carti_imprumutate");
			ps.setInt(1, id_carte);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = true;
			}
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int imprumutare_carte(CarteImprumutata carte){
		int id_carte = carte.getId_carte();
		boolean verificat_status = verificat_imprumutare(id_carte);
		if(verificat_status){
			int status=0;
			try{
				Connection connection = ConectareBD.getConnection();
				PreparedStatement ps = connection.prepareStatement("INSERT INTO librarydb.carte_imprumutata (id_carte,id_client,data_imprumutare,status_returnare) VALUES (?,?,?,?)");
				ps.setInt(1,carte.getId_carte());
				ps.setInt(2,carte.getId_client());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(3,currentDate);
				ps.setString(4,"nu");
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2 = connection.prepareStatement("UPDATE librarydb.carte SET carti_imprumutate=? WHERE id_carte=?");
					ps2.setInt(1,carte_imprumutata(id_carte)+1);
					ps2.setInt(2,id_carte);
					status=ps2.executeUpdate();
				}
				connection.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	public static int returnare_carte(int id_carte, int id_client){
		int status=0;
			try{
				Connection connection = ConectareBD.getConnection();
				PreparedStatement ps=connection.prepareStatement("UPDATE librarydb.carte_imprumutata SET status_returnare='da' WHERE id_carte=? AND id_client=?");
				ps.setInt(1,id_carte);
				ps.setInt(2,id_client);
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=connection.prepareStatement("UPDATE librarydb.carte SET carti_imprumutate=? WHERE id_carte=?");
					ps2.setInt(1,carte_imprumutata(id_carte)-1);
					ps2.setInt(2,id_carte);
					status=ps2.executeUpdate();
				}
				connection.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	
	
	public static boolean logare(String email, String parola){
		boolean status = false;
		try{
			Connection connection = ConectareBD.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM librarydb.client WHERE email=? AND parola=?");
			ps.setString(1, email);
			ps.setString(2, parola);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = true;
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
}
