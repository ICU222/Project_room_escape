package icu222.roomescape.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = testController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = testController.class)
@SpringBootTest
public class RoomescapeApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void returnHello() throws Exception {
		String test = "test";

		mvc.perform(get("/test"))
				.andExpect(status().isOk())
				.andExpect(content().string(test));
	}

}
