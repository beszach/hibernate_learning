package com.alex.hibernate_learning.dao;

import com.alex.hibernate_learning.entity.Profile;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Sql(value = "/addData.sql")
@Import(DaoProfile.class)
@Rollback(value = false)
@Log4j2
public class DaoProfileTest2 {

    @Autowired
    DaoProfile daoProfile;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void should_get_4_users(){
        List<Profile> profiles = daoProfile.getAllProfiles();
        for(Profile profile : profiles){
            log.info("Profiles with id: "+ profile.getId()+"have firstname: "+profile.getFirstname());
        }
        log.info("Profiles: "+profiles);

    }

    @Test
    public void should_get_user_by_id(){
        Profile profile = testEntityManager.find(Profile.class, 1L);
        log.info(profile.getId());
    }


}
