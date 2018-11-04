package dominio;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
	@Table(name="tb_dados_motoristas", schema="bd_placas")
	
	public class DadosMotoristaAPS implements java.io.Serializable
	{
	    private static final long serialVersionUID = 1L;
	    
	    @Id
	    @Column(name="cod_motorista",nullable= false,length= 5)
	    private int cod;
	    
	    @Column(name="nm_motorista", nullable= false, length= 30)
	    private String nome;
	    
	    @Column(name="cpf_motorista", nullable= false, length= 12)
	    private String cpf;
	    
	    @Column(name="tel_motorista", nullable= false, length= 11)
	    private String tel;
	    
	    @Column(name="cel_motorista", nullable= false, length= 12)
	    private String cel;
	    
	    @Column(name="emplacamento", nullable= false, length= 8)
	    private String numero;
	     
	    public DadosMotoristaAPS(){}
	    
	    public int getCod(){
	    	return cod;
	    }
	    
	    public void setCod(int _cod){
	    	this.cod = _cod;
	    }
	    
	    public String getNome(){
	    	return nome;
	    }
	    
	    public void setNome(String _nome){
	    	this.nome = _nome;
	    }
	    public String getCpf(){
	    	return cpf;
	    }
	    
	    public void setCpf(String  _cpf){
	    	this.cpf = _cpf;
	    }
	    
	    public 	String getTel(){
	    	return tel;
	    }
	    
	    public void setTel(String  _tel){
	    	this.tel = _tel;
	    }
	    public String getCel(){
	    	return tel;
	    }
	    
	    public void setCel(String _cel){
	    	this.cel = _cel;
	    }
	    public String getNumero(){
	    	return numero;
	    }
	    
	    public void setNumero(String  _numero){
	    	this.numero = _numero;
	    }
}
