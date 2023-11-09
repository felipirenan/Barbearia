package model;

public class AgendamentoBean {
		int id;
		String barbeiro;
		String servico;
		String dia;
		String horario;
		String statusAgen;
		int idUser;
		
		public AgendamentoBean() {
			
		}

		
		
		public AgendamentoBean(String barbeiro, String dia, String horario) {
			super();
			this.barbeiro = barbeiro;
			this.dia = dia;
			this.horario = horario;
		}



		public AgendamentoBean(String barbeiro, String servico, String dia, String horario, String statusAgen, int idUser) {
			super();
			this.barbeiro = barbeiro;
			this.servico = servico;
			this.dia = dia;
			this.horario = horario;
			this.statusAgen = statusAgen;
			this.idUser = idUser;
		}


		public AgendamentoBean(int id, String barbeiro, String servico, String dia, String horario, String statusAgen,
				int idUser) {
			super();
			this.id = id;
			this.barbeiro = barbeiro;
			this.servico = servico;
			this.dia = dia;
			this.horario = horario;
			this.statusAgen = statusAgen;
			this.idUser = idUser;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getBarbeiro() {
			return barbeiro;
		}


		public void setBarbeiro(String barbeiro) {
			this.barbeiro = barbeiro;
		}


		public String getServico() {
			return servico;
		}


		public void setServico(String servico) {
			this.servico = servico;
		}


		public String getDia() {
			return dia;
		}


		public void setDia(String dia) {
			this.dia = dia;
		}


		public String getHorario() {
			return horario;
		}


		public void setHorario(String horario) {
			this.horario = horario;
		}


		public String getStatusAgen() {
			return statusAgen;
		}


		public void setStatusAgen(String statusAgen) {
			this.statusAgen = statusAgen;
		}


		public int getIdUser() {
			return idUser;
		}


		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		
		
		
		
		
		
		
		
}
