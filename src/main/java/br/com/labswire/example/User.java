package br.com.labswire.example;

/**
 * @author jpereira
 *
 */
public class User {

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome do user e " + this.getName();
	}

}
