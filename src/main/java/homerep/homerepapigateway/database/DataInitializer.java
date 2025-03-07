package homerep.homerepapigateway.database;

import homerep.homerepapigateway.models.*;
import homerep.homerepapigateway.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CityRepository cityRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;
    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final GeoPairRepository geoPairRepository;
    private final PaymentTypeRepository paymentTypeRepository;


    public DataInitializer(CategoryRepository categoryRepository, CityRepository cityRepository, EmployeeRepository employeeRepository, EmployerRepository employerRepository, AddressRepository addressRepository, ClientRepository clientRepository, GeoPairRepository geoPairRepository, PaymentTypeRepository paymentTypeRepository) {
        this.categoryRepository = categoryRepository;
        this.cityRepository = cityRepository;
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
        this.geoPairRepository = geoPairRepository;
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category santeh = new Category();
            santeh.setName("Сантехника");
            categoryRepository.save(santeh);

            Category gasEquipment = new Category();
            gasEquipment.setName("Уборка");
            categoryRepository.save(gasEquipment);

            Category householdAppliances = new Category();
            householdAppliances.setName("Бытовая техника");
            categoryRepository.save(householdAppliances);

            Category electricity = new Category();
            electricity.setName("Электрика");

            log.info("Предварительные категории созданы.");
        }
        if (cityRepository.count() == 0) {
            City city1 = new City();
            city1.setName("Ростов-на-Дону");
            cityRepository.save(city1);
            log.info("Предварительные города созданы.");
        }
        if (employerRepository.count() == 0) {
            Employer habibiBoss = new Employer();


        }
        if (employeeRepository.count() == 0) {
            Employee habibi = new Employee();
            habibi.setAge(28);
            habibi.setGender("M");
            habibi.setFirstName("Ashab");
            habibi.setLastName("Tamaev");
            habibi.setEmail("ashab@gmail.com");
            habibi.setPhone("+192812232");
            habibi.setEmployer(employerRepository.findByEmail("ashabBoss@gmail.com"));
            employeeRepository.save(habibi);
        }

    }
}