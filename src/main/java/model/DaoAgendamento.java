package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoAgendamento extends DAO {
	
	public ArrayList<AgendamentoBean> listarAgendamento(int idFiltro) {
		
		ArrayList<AgendamentoBean> agendamentos = new ArrayList<>();
		String read = "select A.id, B.nome as barbeiro, S.descricao as servico, A.dia as dia, A.horario as horario, A.statusAgen as statusAgen, A.idUser as usuario "+
		"from agendamentos as A " +
		"inner join barbeiros as B " +
		"on  A.barbeiro = B.id " +
		"inner join servicos as S " + 
		"on A.servico = S.id " + 
		"where  A.idUser = ? " +
		"order by A.dia;";
		//String read = "select * from agendamentos";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setInt(1, idFiltro);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String barbeiro = rs.getString(2);
				String servico = rs.getString(3);
				String dia = rs.getString(4);
				String horario = rs.getString(5);
				String statusAgen = rs.getString(6);
				int idUser = rs.getInt(7);
				
				
				agendamentos.add(new AgendamentoBean(id, barbeiro, servico, dia, horario,statusAgen, idUser));
			}
			con.close();
			return agendamentos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void gravaAgendamento(AgendamentoBean agendamento) {
	String sql =  "insert into agendamentos(barbeiro, servico, dia, horario, statusAgen, idUser) values (?,?,?,?,?,?);";
	
	try {
		
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, Integer.parseInt(agendamento.getBarbeiro()));
		pst.setInt(2, Integer.parseInt(agendamento.getServico()));
		pst.setString(3, agendamento.getDia());
		pst.setString(4, agendamento.getHorario());
		pst.setString(5, agendamento.getStatusAgen()); //1 = Pendente
		pst.setInt(6, agendamento.getIdUser());
		
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	}
	
	public ArrayList<AgendamentoBean> listaHorarios(AgendamentoBean agendamento) {
		
		ArrayList<AgendamentoBean> horarios = new ArrayList<>();
		String read = "select barbeiro, dia, horario from agendamentos where barbeiro=? and dia=?";
		
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setInt(1, agendamento.getId());
			pst.setString(2, agendamento.getDia());
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				
				String barbeiro = Integer.toString(rs.getInt(1));
				String dia = rs.getString(2);
				String horario = rs.getString(3);
				
				
				horarios.add(new AgendamentoBean( barbeiro, dia, horario));
			}
			con.close();
			return horarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void deleteAgend(AgendamentoBean agendamento) {
			String sql = "DELETE FROM agendamentos WHERE id = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, agendamento.getId());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	
	
	}
	
	

