package dto;

public class SolDTO {
	public String solid;
	public String solpw;
	public String solclass;
	public String solposition;
	public String solname;
	public String solbirth;
	public int gunnum;
	public int basenum;
	public String regdate;
	public String state;
	
	public SolDTO() {}

	public SolDTO(String solid, String solpw, String solclass, String solposition, String solname,
			String solbirth, int gunnum, int basenum) {
		this.solid = solid;
		this.solpw = solpw;
		this.solclass = solclass;
		this.solposition = solposition;
		this.solname = solname;
		this.solbirth = solbirth;
		this.gunnum = gunnum;
		this.basenum = basenum;
	}
	public SolDTO(String solid, String solpw, String solclass, String solposition, String solname,
			String solbirth,String state, int gunnum, int basenum) {
		this.solid = solid;
		this.solpw = solpw;
		this.solclass = solclass;
		this.solposition = solposition;
		this.solname = solname;
		this.solbirth = solbirth;
		this.state = state;
		this.gunnum = gunnum;
		this.basenum = basenum;
	}
	
	
}
