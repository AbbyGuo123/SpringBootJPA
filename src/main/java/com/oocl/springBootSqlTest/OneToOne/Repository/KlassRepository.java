package com.oocl.springBootSqlTest.OneToOne.Repository;

import com.oocl.springBootSqlTest.OneToOne.Enity.Klass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlassRepository extends JpaRepository<Klass,Long> {
}
