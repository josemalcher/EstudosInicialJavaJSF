package br.com.rlsystem.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.rlsystem.DAO.ClienteDAO;
import br.com.rlsystem.VO.ClienteVO;

@ManagedBean(name = "cliBean")
public class ClienteBean {

	private ClienteVO clienteVO = new ClienteVO();
	private DataModel<ClienteVO> clientes;

	public DataModel<ClienteVO> getClientes() {
		ClienteDAO dao = new ClienteDAO();
		try {
			List<ClienteVO> lista = dao.getALL();
			clientes = new ListDataModel<ClienteVO>(lista);
		} catch (Exception e) {
			System.out.println("Erro ao Listar ");
		}

		return clientes;
	}

	public void setClientes(DataModel<ClienteVO> clientes) {
		this.clientes = clientes;
	}

	public ClienteVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public String addUser() {

		String retorno = "erro";

		try {
			ClienteDAO dao = new ClienteDAO();
			if (dao.insert(clienteVO)) {
				retorno = "sucesso";
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return retorno;
	}

}
