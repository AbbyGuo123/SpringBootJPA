package com.oocl.springBootSqlTest.OneToN.Repository;

import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void findAllTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        testEntityManager.persist(new Company("c2"));
        //when
        List<Company> companies = companyRepository.findAll();
        //then
        assertThat(companies.size(),is(2));
        assertThat(companies.get(0).getCompanyName(),is("c1"));
        assertThat(companies.get(1).getCompanyName(),is("c2"));
    }

    @Test
    public void findByPageTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        testEntityManager.persist(new Company("c2"));
        //when
        Page<Company> companies = companyRepository.findAll(PageRequest.of(1,1));
        //then
        assertThat(companies.getContent().size(),is(1));
        assertThat(companies.getContent().get(0).getCompanyName(),is("c2"));
    }


    @Test
    public void findByIdTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        //when
        Long id = Long.valueOf(testEntityManager.persistAndGetId(new Company("c2")).toString());
        Company company = companyRepository.findById(id).get();
        //then
        assertThat(company.getCompanyName(),is("c2"));
    }

    @Test
    public void deleteByIdTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        //when
        Long id = Long.valueOf(testEntityManager.persistAndGetId(new Company("c2")).toString());
        companyRepository.deleteById(id);
        //then
        assertThat(companyRepository.findAll().size(),is(1));
    }

    @Test
    public void saveTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        //when
        companyRepository.save(new Company("c2"));
        //then
        assertThat(companyRepository.findAll().size(),is(2));
    }

    @Test
    public void updateTest(){
        //given
        testEntityManager.persist(new Company("c1"));
        //when
        companyRepository.save(new Company("c2"));
        //then
        assertThat(companyRepository.findAll().size(),is(2));
    }


}