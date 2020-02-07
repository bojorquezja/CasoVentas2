package pe.edu.utp.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pe.edu.utp.entity.CabFactura;

/**
 *
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CabFacturaDaoTest {
    
    public CabFacturaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CabFacturaDao instance = new CabFacturaDao();
        CabFactura cf = new CabFactura("G00001", LocalDate.of(2018, Month.DECEMBER, 30), 
                "GR001", "99999", "Emp XYZ", "2033245", "Cliente 1", "av 123", 
                "frank", 100.0, 18.0, 118.0);
        
        if (!instance.insert(cf)){
            fail("No se pudo crear entidades de prueba");
        }
        cf = new CabFactura("G00002", LocalDate.of(2019, Month.JANUARY, 31), 
                "GR002", "88888", "Emp ABC", "2033245", "Cliente 1", "av 123", 
                "robert", 1000.0, 180.0, 1180.0);
        
        if (!instance.insert(cf)){
            fail("No se pudo crear entidades de prueba");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        CabFacturaDao instance = new CabFacturaDao();
        String pk = "G00001";
        instance.getEntity(pk).ifPresent((t) -> {
            instance.delete(t.getCodigoFac());
        });
        pk = "G00002";
        instance.getEntity(pk).ifPresent((t) -> {
            instance.delete(t.getCodigoFac());
        });
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void whenTest_GetEntity__ThenReturnEntity() {
        CabFacturaDao instance = new CabFacturaDao();
        Optional<CabFactura> expResult = Optional.ofNullable(new CabFactura("G00001", LocalDate.of(2018, Month.DECEMBER, 30), 
                "GR001", "99999", "Emp XYZ", "2033245", "Cliente 1", "av 123", 
                "frank", 100.0, 18.0, 118.0));
        String pk = "G00001";
        Optional<CabFactura> result = instance.getEntity(pk);
        assertEquals(expResult, result);
    }

    @Test
    public void whenTest_GetListaEntidad01__ThenReturnListOfEntities() {
        CabFacturaDao instance = new CabFacturaDao();
        List<CabFactura> expResult = new ArrayList<>();
        expResult.add(new CabFactura("G00001", LocalDate.of(2018, Month.DECEMBER, 30), 
                "GR001", "99999", "Emp XYZ", "2033245", "Cliente 1", "av 123", 
                "frank", 100.0, 18.0, 118.0));
        expResult.add(new CabFactura("G00002", LocalDate.of(2019, Month.JANUARY, 31), 
                "GR002", "88888", "Emp ABC", "2033245", "Cliente 1", "av 123", 
                "robert", 1000.0, 180.0, 1180.0));
        
        Object[] valores = new Object[]{"G", "te 1"};
        List<CabFactura> result = instance.getListOfEntities01(valores);
        assertEquals(expResult, result);
    }

    @Test
    public void whenTest_Insert__ThenValidateIsInserted() {
        CabFactura entidad = null;
        CabFacturaDao instance = new CabFacturaDao();
        CabFactura expResult = new CabFactura("G00003", LocalDate.of(2020, Month.FEBRUARY, 20), 
                "GR001", "99999", "Emp XYZ", "2033245", "Cliente 1", "av 123", 
                "frank", 100.0, 18.0, 118.0);
        
        instance.insert(expResult);
        
        String pk = "G00003";
        CabFactura result = instance.getEntity(pk).get();
        assertEquals(expResult, result);
        //elimina dato
        instance.delete(pk);
    }

    @Test
    public void whenTest_Update__ThenValidateIsUpdated() {
        CabFacturaDao instance = new CabFacturaDao();
        String pk = "G00001";
        CabFactura expResult = instance.getEntity(pk).get();
        String dirIni = expResult.getDirecCliente();
        expResult.setDirecCliente("Otra av");
        instance.update(expResult);
        CabFactura result = instance.getEntity(pk).get();
        assertEquals(expResult, result);
        //corregir
        expResult.setDirecCliente(dirIni);
        instance.update(expResult);
    }

    @Test
    public void whenTest_Delete__ThenValidateIsDeleted() {
        CabFacturaDao instance = new CabFacturaDao();
        String pk = "G00002";
        if (!instance.delete(pk)){
            fail("No se pudo borrar elemento de prueba delete");
        }
        CabFactura result = instance.getEntity(pk).orElse(null);
        assertNull(result);
        //dejamos data corregida
        CabFactura cf = new CabFactura("G00002", LocalDate.of(2019, Month.JANUARY, 31), 
                "GR002", "88888", "Emp ABC", "2033245", "Cliente 1", "av 123", 
                "robert", 1000.0, 180.0, 1180.0);
        
        instance.insert(cf);
    }
    
}
