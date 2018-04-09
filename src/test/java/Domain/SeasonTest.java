/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.Season;
import DAO.SeasonDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Veiret
 */
public class SeasonTest {
    
    @Test
    public void testNameIsCompliant() {
        SeasonDao dao = mock(SeasonDao.class);
        when(dao.getInteger("year")).thenReturn(1989);
        when(dao.getBoolean("summer"))
                .thenReturn(Boolean.FALSE)
                .thenReturn(Boolean.TRUE);
        Season instance = new Season(dao);
        assertEquals("1989 - 1990", instance.getName());
        assertEquals("1989", instance.getName());
        
    }
}
