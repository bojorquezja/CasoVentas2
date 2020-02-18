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
import pe.edu.utp.entity.CabGuiaRem;
import pe.edu.utp.entity.Cliente;
import pe.edu.utp.entity.Empresa;

/**
 *
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CabFacturaDaoTest {
    
    private static Dao<CabFactura> cfDao = new CabFacturaDao();
    private static Dao<Cliente> clDao = new ClienteDao();
    private static Dao<Empresa> emDao = new EmpresaDao();
    private static Dao<CabGuiaRem> cgDao = new CabGuiaRemDao();
    
    public CabFacturaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Empresa em = new Empresa("99999", "Emp XYZ");
        if (!emDao.insert(em)){
            fail("No se pudo crear Empresa de prueba");
        }
        Empresa em2 = new Empresa("88888", "Emp ABC");
        if (!emDao.insert(em2)){
            fail("No se pudo crear Empresa de prueba");
        }
        
        Cliente cl = new Cliente("2033245", "Cliente 1", "av 123");
        if (!clDao.insert(cl)){
            fail("No se pudo crear Cliente de prueba");
        }    
        Cliente cl2 = new Cliente("1099245", "Cliente 2", "av 444");
        if (!clDao.insert(cl2)){
            fail("No se pudo crear Cliente de prueba");
        }
        
        CabGuiaRem cg = new CabGuiaRem(null, 
                null,
                null,
                null,
                null
                ,0);
        /*if (!cgDao.insert(cg)){
            fail("No se pudo crear Cab GR de prueba");
        }*/
        CabGuiaRem cg2 = new CabGuiaRem(null, 
                null,
                null,
                null,
                null
                ,0);
        /*if (!cgDao.insert(cg2)){
            fail("No se pudo crear Cab GR de prueba");
        }*/
        
        CabFactura cf = new CabFactura("G00001", 
                LocalDate.of(2018, Month.DECEMBER, 30), 
                cg, 
                em,
                cl,
                "frank", 100.0, 18.0, 118.0);
        if (!cfDao.insert(cf)){
            fail("No se pudo crear entidades de prueba");
        }
        CabFactura cf2 = new CabFactura("G00002", 
                LocalDate.of(2019, Month.JANUARY, 31), 
                cg2, 
                em2,
                cl2,
                "robert", 1000.0, 180.0, 1180.0);
        if (!cfDao.insert(cf2)){
            fail("No se pudo crear entidades de prueba");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        String pk = "G00001";
        cfDao.getEntity(pk).ifPresent((t) -> {
            cfDao.delete(t.getCodigoFac());
        });
        pk = "G00002";
        cfDao.getEntity(pk).ifPresent((t) -> {
            cfDao.delete(t.getCodigoFac());
        });
        /*
        pk = "S0001";
        cgDao.getEntity(pk).ifPresent((t) -> {
            cgDao.delete(t.getCodGuiaRem());
        });
        pk = "S0002";
        cgDao.getEntity(pk).ifPresent((t) -> {
            cgDao.delete(t.getCodGuiaRem());
        });
        */
        pk = "2033245";
        clDao.getEntity(pk).ifPresent((t) -> {
            clDao.delete(t.getRucCliente());
        });
        pk = "1099245";
        clDao.getEntity(pk).ifPresent((t) -> {
            clDao.delete(t.getRucCliente());
        });
        pk = "99999";
        emDao.getEntity(pk).ifPresent((t) -> {
            emDao.delete(t.getRucEmpresa());
        });
        pk = "88888";
        emDao.getEntity(pk).ifPresent((t) -> {
            emDao.delete(t.getRucEmpresa());
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
        Optional<CabFactura> expResult = Optional.ofNullable(new CabFactura("G00001", 
                                            LocalDate.of(2018, Month.DECEMBER, 30), 
                                            new CabGuiaRem(null, 
                                                null,
                                                null,
                                                null,
                                                null
                                                ,0), 
                                            new Empresa("99999", "Emp XYZ"),
                                            new Cliente("2033245", "Cliente 1", "av 123"),
                                            "frank", 100.0, 18.0, 118.0));
        String pk = "G00001";
        Optional<CabFactura> result = cfDao.getEntity(pk);
        assertEquals(expResult, result);
    }

    @Test
    public void whenTest_GetListaEntidad01__ThenReturnListOfEntities() {

        List<CabFactura> expResult = new ArrayList<>();
        expResult.add(new CabFactura("G00001", 
                LocalDate.of(2018, Month.DECEMBER, 30), 
                new CabGuiaRem(null, 
                    null,
                    null,
                    null,
                    null
                    ,0), 
                new Empresa("99999", "Emp XYZ"),
                new Cliente("2033245", "Cliente 1", "av 123"),
                "frank", 100.0, 18.0, 118.0));
        expResult.add(new CabFactura("G00002", 
                LocalDate.of(2019, Month.JANUARY, 31), 
                new CabGuiaRem(null, 
                    null,
                    null,
                    null,
                    null
                    ,0), 
                new Empresa("88888", "Emp ABC"),
                new Cliente("2033245", "Cliente 1", "av 123"),
                "robert", 1000.0, 180.0, 1180.0));
        
        Object[] valores = new Object[]{"G", "te 1"};
        List<CabFactura> result = cfDao.getListOfEntities01(valores);
        assertEquals(expResult, result);
    }

    @Test
    public void whenTest_Insert__ThenValidateIsInserted() {
        CabFactura entidad = null;
        CabFactura expResult = new CabFactura("G00003", 
                LocalDate.of(2020, Month.FEBRUARY, 20), 
                new CabGuiaRem(null, null,null,null,null,0), 
                new Empresa(null, null),
                new Cliente(null, null, null),
                "frank", 100.0, 18.0, 118.0);
        
        cfDao.insert(expResult);
        
        String pk = "G00003";
        CabFactura result = cfDao.getEntity(pk).get();
        assertEquals(expResult, result);
        //elimina dato
        cfDao.delete(pk);
    }

    @Test
    public void whenTest_Update__ThenValidateIsUpdated() {
        String pk = "G00001";
        CabFactura expResult = cfDao.getEntity(pk).get();
        String CajIni = expResult.getCajero();
        expResult.setCajero("Prueba");
        cfDao.update(expResult);
        CabFactura result = cfDao.getEntity(pk).get();
        assertEquals(expResult, result);
        //corregir
        expResult.setCajero(CajIni);
        cfDao.update(expResult);
    }

    @Test
    public void whenTest_Delete__ThenValidateIsDeleted() {
        String pk = "G00002";
        if (!cfDao.delete(pk)){
            fail("No se pudo borrar elemento de prueba delete");
        }
        CabFactura result = cfDao.getEntity(pk).orElse(null);
        assertNull(result);
        //dejamos data corregida
        CabFactura cf = new CabFactura("G00002", 
                LocalDate.of(2019, Month.JANUARY, 31), 
                new CabGuiaRem(null, 
                    null,
                    null,
                    null,
                    null
                    ,0), 
                new Empresa("88888", "Emp ABC"),
                new Cliente("2033245", "Cliente 1", "av 123"),
                "robert", 1000.0, 180.0, 1180.0);
        
        cfDao.insert(cf);
    }
    
}

