package jp.co.axa.apidemo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aarti 
 * This class denotes User Roles.
 *
 */
@Entity
public class Role {

	@Getter
	@Setter
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(name = "ROLE_NAME")
	private String name;

	@Getter
	@Setter
	@OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> users;

}
