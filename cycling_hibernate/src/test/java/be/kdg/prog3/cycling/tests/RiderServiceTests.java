package be.kdg.prog3.cycling.tests;

import be.kdg.prog3.cycling.Application;
import be.kdg.prog3.cycling.exceptions.RiderException;
import be.kdg.prog3.cycling.model.Rider;
import be.kdg.prog3.cycling.persistence.RiderRepository;
import be.kdg.prog3.cycling.services.RiderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RiderServiceTests {
    @MockBean
    private RiderRepository riderRepository;

    @Autowired
    private RiderService riderService;

    @Test
    public void testFindById() {
        Rider marcel = new Rider(999L, "Marcel Kittel", new GregorianCalendar(1988, 5, 11).getTime());
        given(this.riderRepository.findOne(marcel.getId())).willReturn(marcel);
        final Rider rider = this.riderService.findById(marcel.getId());
        assertEquals(marcel, rider);
    }

    @Test(expected = RiderException.class)
    public void testFindByIdNotFound() {
        given(this.riderRepository.findOne(999L)).willReturn(null);
        this.riderService.findById(999L);
    }
}
