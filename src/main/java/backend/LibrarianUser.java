package backend;

public class LibrarianUser  implements Record {
    
    private String librarianId,Name,Email,Address,PhoneNumber;

    public LibrarianUser(String librarianId, String Name, String Email, String Address, String PhoneNumber) {
        this.librarianId = librarianId;
        this.Name = Name;
        this.Email=Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }
    
    public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
    public String lineRepresentation()
	{
		String data;
		data= librarianId+","+Name+","+Email+","+Address+","+PhoneNumber;
		return data;
	}
    @Override
    public String getSearchKey()
	{
		return (this.librarianId);
	}
    
}