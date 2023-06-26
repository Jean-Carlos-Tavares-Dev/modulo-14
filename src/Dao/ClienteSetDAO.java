package Dao;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import Crud.Cliente;

public class ClienteSetDAO implements IClienteDAO {
	private Set<Cliente> set;
	
	public ClienteSetDAO() {
		this.set = new HashSet<>();
	}

	
	@Override
	public Boolean cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.set.add(cliente);
		
	}

	@Override
	public void excluir(Long cpf) {
		Cliente clienteEncontrado = null;
		for (Cliente cliente :this.set) {
			if (cliente.getCpf().equals(cpf)) {
				clienteEncontrado=cliente;
				break;
			}
			
		}
		if ( clienteEncontrado != null) {
			this.set.remove(clienteEncontrado);
		}
		
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		if (this.set.contains(cliente)) {
			for (Cliente clienteCadastrado : this.set) {
				if (clienteCadastrado.equals(cliente)) {
					clienteCadastrado.setNome(cliente.getNome());
					clienteCadastrado.setTel(cliente.getTel());
					clienteCadastrado.setNumero(cliente.getNumero());
					clienteCadastrado.setEnd(cliente.getEnd());
					clienteCadastrado.setCidade(cliente.getCidade());
					clienteCadastrado.setEstado(cliente.getEstado());
					break;
				}
			}
		}
	}

	@Override
	public Cliente consultar(Long cpf) {
		for (Cliente clienteCadastrado : this.set) {
			if (clienteCadastrado.getCpf().equals(cpf)) {
				return clienteCadastrado;
			}
		
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.set;
	}

}
