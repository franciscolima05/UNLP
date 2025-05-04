package OO2.Ejercicio17_Patrones_AccesoALaBaseDeDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseRealAccessTest {
    private DatabaseAccess database;
    private Usuario user;
    private Proxy proxy;

    @BeforeEach
    void setUp() throws Exception {
        this.database = new DatabaseRealAccess();
        this.user = new Usuario();
        this.proxy = new Proxy(database, 100, user);
        this.user.conectarse(proxy);
    }

    @Test
    void testGetSearchResults() {
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.database.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.database.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testInsertNewRow() {
        assertEquals(3, this.database.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.database.getSearchResults("select * from comics where id=3"));
    }
    
    
    @Test
    void testGetSearchProxy() {
    	assertThrows(IllegalArgumentException.class, () -> { 
    		user.request();
    	});
        this.user.identificarse();
    	assertEquals(Arrays.asList("Spiderman", "Marvel"), this.user.request());
    }
    
    @Test
    void testInsertProxy() {
    	assertThrows(IllegalArgumentException.class, () -> { 
    		user.post();
    	});
        this.user.identificarse();
    	assertEquals(3, this.user.post());
    }
}