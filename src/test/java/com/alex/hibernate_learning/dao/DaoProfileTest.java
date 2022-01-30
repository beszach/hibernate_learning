package com.alex.hibernate_learning.dao;

import com.alex.hibernate_learning.entity.Profile;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Sql(value = "/addData.sql")
@Log4j2
public class DaoProfileTest {

    @Autowired
    DaoProfile daoProfile;

    @Test
    public void should_add_profile(){
        Profile profile = new Profile("profileTest");
        daoProfile.addProfile(profile);
        log.info("Profile: "+profile);
    }

}
