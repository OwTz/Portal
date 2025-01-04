package com.asyncsupport.repository;

import com.asyncsupport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<User, Integer> {

}
