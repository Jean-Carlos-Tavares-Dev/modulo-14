package Dao;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import Crud.Cliente;

public class ClienteMapDAO implements IClienteDAO{
	private Map<Long, Cliente> map;
	
	
	public ClienteMapDAO() {
		this.map = new HashMap<>();
	}

	@Override
	public Boolean cadastrar (Cliente cliente) {
		// TODO Auto-generated method stub
		if (this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		return true;
		
	}

	@Override
	public void excluir(Long cpf) {
		// TODO Auto-generated method stub
		Cliente clienteCadastrado = this.map.get(cpf);
		if (clienteCadastrado !=null) {
			this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
		}
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		Cliente clienteCadastrado =this.map.get(cliente.getCpf());
		if(clienteCadastrado !=null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setTel(cliente.getTel());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setEnd(cliente.getEnd());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEstado(cliente.getEstado());
			
		}
	}

	@Override
	public Cliente consultar(Long cpf) {
		// TODO Auto-generated method stub
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.map.values();
	}
	
	}

