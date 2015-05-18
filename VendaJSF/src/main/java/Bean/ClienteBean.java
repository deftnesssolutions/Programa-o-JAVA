package Bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import RN.ClienteRN;
import modelo.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean 
{
	private Cliente clienteSelecionado = new Cliente();
	private List<Cliente> lista =  null;

	public void salvar()
	{
		ClienteRN clienteRN = new ClienteRN();
		clienteSelecionado.setDataCadastro(new Date());
		clienteRN.salvar(clienteSelecionado);
		FacesMessage msg= new FacesMessage("Cliente cadastrado com sucesso !!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
		this.lista = null;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	public List<Cliente> getLista() {
		ClienteRN clienteRN = new ClienteRN();
		if(lista==null)
		{
			lista=clienteRN.listar();
		}
		return lista;
	}
	
	public void excluir()
	{
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.excluir(this.clienteSelecionado);
		this.lista = null;
	}
}
