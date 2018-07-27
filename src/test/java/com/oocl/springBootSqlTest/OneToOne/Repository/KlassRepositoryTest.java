package com.oocl.springBootSqlTest.OneToOne.Repository;

import com.oocl.springBootSqlTest.OneToOne.Enity.Klass;
import com.oocl.springBootSqlTest.OneToOne.Enity.Leader;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KlassRepositoryTest {
    @Autowired
    private KlassRepository klassRepository;

    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void findAll_returnKlassList() throws Exception{

        Klass klass1 = new Klass();
        klass1.setKlass_name("11111");

        Klass saveKlass = entityManager.persistFlushFind(klass1);
        Klass klass = klassRepository.findAll().get(0);

        Assertions.assertThat(klass.getKlass_name()).isEqualTo(saveKlass.getKlass_name());
    }

    @Test
    public void save_return_Klass() throws Exception{
        Klass klass1 = new Klass();
        klass1.setKlass_name("11111");

    }

}