package jp.co.axa.apidemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Getter
	@Setter
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(name = "USER_NAME")
	private String name;

	@Getter
	@Setter
	@Column(name = "EMAIL")
	private String email;

	@Getter
	@Setter
	@Column(name = "PASSWORD")
	private String password;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

}
