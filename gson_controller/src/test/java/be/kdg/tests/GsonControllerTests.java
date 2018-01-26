package be.kdg.tests;

import be.kdg.gson_controller.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class GsonControllerTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void testTextPlain() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(":)"));
    }

    @Test
    public void testApplicationJson() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is(":)")));
    }

    @Test
    public void testApplicationXml() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }

    @Test
    public void testCustomerTextPlain() throws Exception {
        this.mvc.perform(get("/customer").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Jos\nVermeulen"));
    }

    @Test
    public void testCustomerApplicationJson() throws Exception {
        this.mvc.perform(get("/customer").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jos")))
                .andExpect(jsonPath("$.lastName", is("Vermeulen")));
    }

    @Test
    public void testCustomerApplicationXml() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
}
