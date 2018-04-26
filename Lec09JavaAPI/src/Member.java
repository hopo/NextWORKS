
// Volume Object
public class Member {

	private String id;
	private String name;
	private int age;
	private String phone;

	Member() {
	}

	Member(String id, String name, int age, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;

	}
	
	
	@Override
	public String toString() {
		return name + "(" + id + ") " + age + "세" + phone;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Member) {
			Member m = (Member) obj;
			if (this.id.equals(m.id) &&
				this.name.equals(m.name) &&
				this.age == m.age &&
				this.phone.equals(m.phone)) {
				return true;
			}
		}

		return false;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
