package jp.co.axa.apidemo.services;

import java.util.List;

import jp.co.axa.apidemo.entities.Role;

public interface RoleService {
	public List<Role> retrieveRoles();

	public Role getRole(Long roleId);

	public void saveRole(Role role);

	public void deleteRole(Long roleId);

	public void updateRole(Role role);

}
