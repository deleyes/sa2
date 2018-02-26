package be.kdg.prog3.cycling.tests;

import be.kdg.prog3.cycling.Application;
import be.kdg.prog3.cycling.exceptions.TeamException;
import be.kdg.prog3.cycling.model.Team;
import be.kdg.prog3.cycling.persistence.TeamRepository;
import be.kdg.prog3.cycling.services.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TeamServiceTests {
    @MockBean
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @Test
    public void testFindAll() {
        final List<Team> teams = Arrays.asList(
                new Team(7777L, "A-Team", "A", (short)1997),
                new Team(8888L, "B-Team", "B", (short)1998),
                new Team(9999L, "C-Team", "C", (short)1999));
        given(this.teamRepository.findAll()).willReturn(teams);
        final List<Team> serviceTeams = this.teamService.findAll();
        assertThat(teams, is(serviceTeams));
    }

    @Test
    public void testFindByUciCode() {
        final Team aTeam = new Team(7777L, "A-Team", "A", (short)1997);
        given(this.teamRepository.findByUciCode("A")).willReturn(aTeam);
        final Team team = this.teamService.findByUciCode("A");
        assertEquals(aTeam, team);
    }

    @Test(expected = TeamException.class)
    public void testFindByUciCodeNotFound() {
        given(this.teamRepository.findByUciCode("A")).willReturn(null);
        this.teamService.findByUciCode("A");
    }
}
