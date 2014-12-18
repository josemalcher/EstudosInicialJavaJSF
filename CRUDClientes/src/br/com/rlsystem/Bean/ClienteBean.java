package br.com.rlsystem.Bean;

import javax.faces.bean.ManagedBean;

import br.com.rlsystem.DAO.ClienteDAO;
import br.com.rlsystem.VO.ClienteVO;

@ManagedBean(name="cliBean")
public class ClienteBean extends ClienteVO {

	public String addUser() {

		String retorno = "erro";
		
		try {
			ClienteDAO dao = new ClienteDAO();
			if(dao.insert(this)){
				retorno = "sucesso";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return retorno;
	}

}
