package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO{
	private String firstName;
	private String lastName;
	private String password;
	private long userStatus;
	private String phone;
	private long id;
	private String email;
	private String username;
}
