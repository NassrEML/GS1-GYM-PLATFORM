import control.DDBBConection;
import model.Exercise;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DDBBConectionTest {
    private DDBBConection con;
    
    public DDBBConectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        con = new DDBBConection();
        con.connect();
    }
    
    @After
    public void tearDown() {
        con.closeConnection();
        con = null;
    }

    @Test
    public void add_user_with_obligated_data() {
        String name = "pepe";
        String lastname = "birola";
        int age = 44;
        String genre = "Masculino";
        String mail = "prueba2@prueba.com";
        String rol = "Deportista";
        String password = "1234";
        con.addUser(name, lastname, age, genre, mail, rol, password);
        User u = con.getUserByMail(mail);
        assertEquals(name, u.getName());
        assertEquals(lastname, u.getLastname());
        assertEquals(age, u.getAge());
        assertEquals(genre, u.getGenre());
        assertEquals(mail, u.getMail());
        assertEquals(rol, u.getRol());
        assertEquals(password, u.getPassword());
        con.deleteUserByMail(mail);
        u=null;
    }
    
    @Test
    public void add_user_with_all_data() {
        String name = "pepe";
        String lastname = "birola";
        int age = 44;
        float weight = 82.5f;
        float height = 1.8f;
        String genre = "Masculino";
        String mail = "prueba2@prueba.com";
        String rol = "Deportista";
        String password = "1234";
        con.addUser(name, lastname, age, weight, height, genre, mail, rol, password);
        User u = con.getUserByMail(mail);
        assertEquals(name, u.getName());
        assertEquals(lastname, u.getLastname());
        assertEquals(age, u.getAge());
        assertEquals(weight, u.getWeight(), 0);
        assertEquals(height, u.getHeight(), 0);
        assertEquals(genre, u.getGenre());
        assertEquals(mail, u.getMail());
        assertEquals(rol, u.getRol());
        assertEquals(password, u.getPassword());
        con.deleteUserByMail(mail);
        u=null;
    }
    
    @Test
    public void add_user_with_obligated_data_and_the_weight() {
        String name = "pepe";
        String lastname = "birola";
        int age = 44;
        float weight = 82.5f;
        String genre = "Masculino";
        String mail = "prueba2@prueba.com";
        String rol = "Deportista";
        String password = "1234";
        con.addUser(name, lastname, age, weight, 0.0f, genre, mail, rol, password);
        User u = con.getUserByMail(mail);
        assertEquals(name, u.getName());
        assertEquals(lastname, u.getLastname());
        assertEquals(age, u.getAge());
        assertEquals(weight, u.getWeight(), 0);
        assertEquals(0.0f, u.getHeight(), 0);
        assertEquals(genre, u.getGenre());
        assertEquals(mail, u.getMail());
        assertEquals(rol, u.getRol());
        assertEquals(password, u.getPassword());
        con.deleteUserByMail(mail);
        u=null;
    }
    
    @Test
    public void add_user_with_obligated_data_and_the_height() {
        String name = "pepe";
        String lastname = "birola";
        int age = 44;
        float height = 1.8f;
        String genre = "Masculino";
        String mail = "prueba2@prueba.com";
        String rol = "Deportista";
        String password = "1234";
        con.addUser(name, lastname, age, 0.0f, height, genre, mail, rol, password);
        User u = con.getUserByMail(mail);
        assertEquals(name, u.getName());
        assertEquals(lastname, u.getLastname());
        assertEquals(age, u.getAge());
        assertEquals(0.0f, u.getWeight(), 0);
        assertEquals(height, u.getHeight(), 0);
        assertEquals(genre, u.getGenre());
        assertEquals(mail, u.getMail());
        assertEquals(rol, u.getRol());
        assertEquals(password, u.getPassword());
        con.deleteUserByMail(mail);
        u=null;
    }
    
    @Test
    public void add_exercise() {
        String title = "Ejercicio primero";
        String description = "Se explica como será el primer ejercicio.";
        String category = "Sin categoria";
        String owner = "prueba@prueba.com";
        con.addExercise(title, description, category, owner);
        Exercise e = con.getExeciseByTitle(title);
        assertEquals(title, e.getTitle());
        assertEquals(description, e.getDescription());
        assertEquals(category, e.getCategory());
        assertEquals(owner, e.getOwner());
        con.deleteExerciseTitle(title);
        e=null;
    }
    
}
