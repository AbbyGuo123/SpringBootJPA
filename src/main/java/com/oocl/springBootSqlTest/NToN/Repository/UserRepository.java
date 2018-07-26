package com.oocl.springBootSqlTest.NToN.Repository;

import com.oocl.springBootSqlTest.NToN.Enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
