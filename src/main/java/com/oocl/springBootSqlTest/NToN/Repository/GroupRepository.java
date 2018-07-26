package com.oocl.springBootSqlTest.NToN.Repository;

import com.oocl.springBootSqlTest.NToN.Enity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
