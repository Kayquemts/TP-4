package classes;

public class Cliente {
	
	private String email;
	private String nome;
	private String Telefone;
	private int id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public Cliente(String email, String nome, String telefone) {
		super();
		this.email = email;
		this.nome = nome;
		Telefone = telefone;
	}
	
	public Cliente() {
		
	}


	@Override
	public String toString() {
		return "Cliente{" +
				"email='" + email + '\'' +
				", nome='" + nome + '\'' +
				", Telefone='" + Telefone + '\'' +
				", id=" + id +
				'}';
	}
}
