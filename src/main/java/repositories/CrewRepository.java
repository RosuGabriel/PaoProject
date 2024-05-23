package repositories;

import jakarta.persistence.EntityManager;
import model.Actor;
import model.CrewMember;
import model.Director;

import java.util.List;

public interface CrewRepository {
    void addCrew(CrewMember crew, EntityManager em);
    void addActor(Actor actor, EntityManager em);
    void addDirector(Director director, EntityManager em);
    List<CrewMember> getAllCrew(EntityManager em);
    CrewMember getCrewById(int id, EntityManager em);
    void updateCrew(CrewMember crew, EntityManager em);
    void deleteCrew(int id, EntityManager em);

    List<CrewMember> getCrewContaining(String str, EntityManager entityManager);
}
