package jp.co.axa.apidemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axa.apidemo.entities.Role;
import jp.co.axa.apidemo.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<Role> retrieveRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles;
	}

	public Role getRole(Long roleId) {
		Optional<Role> optEmp = roleRepository.findById(roleId);
		return optEmp.get();
	}

	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	public void deleteRole(Long roleId) {
		roleRepository.deleteById(roleId);
	}

	public void updateRole(Role role) {
		roleRepository.save(role);
	}

}
