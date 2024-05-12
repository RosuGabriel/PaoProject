package repositories;

import jakarta.persistence.EntityManager;
import model.AppUser;

import java.util.List;

public interface UserRepository {
    public void create(AppUser user, EntityManager em);
    public AppUser findByName(String username, EntityManager em);
    public List<AppUser> allUsers(EntityManager em);
    public void delete(int id, EntityManager em);
    public void update(AppUser user, EntityManager em);
}
