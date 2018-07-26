package com.oocl.springBootSqlTest.NToN.Repository;

import com.oocl.springBootSqlTest.NToN.Enity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {
}
