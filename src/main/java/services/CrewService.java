package services;

import jakarta.persistence.EntityManager;
import model.CrewMember;

import java.util.List;
import java.util.Scanner;

public interface CrewService {
    public CrewMember create(Scanner scanner, EntityManager entityManager);
    public List<CrewMember> getAll(EntityManager entityManager);
    public void delete(CrewMember crew, EntityManager entityManager);
    public void update(Scanner scanner, EntityManager entityManager);
}
