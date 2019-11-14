package ma.ompic.restdemo.dto;

import java.util.Date;
import java.util.List;

public class Party {

	private Date date;
	private String titre;
	private List<Personne> invites;	
	
	public Party(Date date, String titre, List<Personne> invites) {
		super();
		this.date = date;
		this.titre = titre;
		this.invites = invites;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Personne> getInvites() {
		return invites;
	}
	public void setInvites(List<Personne> invites) {
		this.invites = invites;
	}
	
	
}
