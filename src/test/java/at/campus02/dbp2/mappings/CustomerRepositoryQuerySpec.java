package at.campus02.dbp2.mappings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CustomerRepositoryQuerySpec {

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    private Customer customer5;
    private Customer customer6;
    private Customer customer7;

    private void setupCommonTestData() {
        customer1 = new Customer();
        customer1.setFirstname("Albert");
        customer1.setLastname("Aarhus");
        customer1.setAccountType(AccountType.BASIC);
        customer1.setRegisteredSince(LocalDate.of(2022,1,1));
    }


    private EntityManagerFactory factory;
    private EntityManager manager;
    private CustomerRepository repository;

    @BeforeEach
    public void beforeEach() {
        factory = Persistence.createEntityManagerFactory("persistenceUnitName");
        manager = factory.createEntityManager();
        repository = new CustomerRepositoryJpa(factory);
    }

    @AfterEach
    public void afterEach() {
        if (manager.isOpen())
            manager.close();
        if (factory.isOpen())
            factory.close();
    }
}
