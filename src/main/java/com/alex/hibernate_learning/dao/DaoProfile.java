package com.alex.hibernate_learning.dao;

import com.alex.hibernate_learning.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@Repository("daoProfile")
//@Transactional
public class DaoProfile {

    @PersistenceContext
    EntityManager entityManager;

    public void addProfile(Profile profile){
        entityManager.merge(profile);
    }

    public void updateProfile(Profile profile){
        entityManager.merge(profile);
    }

    public List<Profile> getAllProfiles(){
        return entityManager.createQuery("""
select p
from Profile p
""", Profile.class).getResultList();

    }

    public List<Profile> getAllProfilesWithReviews(){
        return entityManager.createQuery("""
select p
from Profile p
left join fetch p.reviews
""", Profile.class).getResultList();
    }
}
