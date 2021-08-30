package net.ufjnet.joppool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.joppool.models.Permission;

public interface PermissionDAO extends JpaRepository<Permission, Integer> {
	


}