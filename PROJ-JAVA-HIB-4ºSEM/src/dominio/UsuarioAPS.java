package dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_dados_usuarios", schema="bd_placas")


public class UsuarioAPS implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="id_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="senha_user", length= 7)
	private String senha;
	
	@Column(name="nm_user",  length= 50)
	private String login;
	
	public UsuarioAPS(){}
	
	public int getId() {return id;}
	public void setId(int _id) {this.id = _id;}
	
	public String getSenha() {return senha;}
	public void setSenha(String _senha){this.senha = _senha;}
	
	public String getLogin() {return login;}
	public void setLogin(String _login) {this.login = _login;}
}
