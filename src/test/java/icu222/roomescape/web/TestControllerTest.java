package icu222.roomescape.web;

import icu222.roomescape.web.dto.TestResponseDto;
import org.junit.jupiter.api.Test;

// 해당 패키지는 책의 .runner.Runwith 대신 사용
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import org.springframework.boot.test.context.SpringBootTest;
// SpringBootTest와 .servlet.WebMvcTest은 서로 중복이 된다. issue 확인
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//====================================================================

//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = testController.class)
//@SpringBootTest 중복
public class TestControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void returnHello() throws Exception {
		String test = "test";

		mvc.perform(get("/test"))
				.andExpect(status().isOk())
				.andExpect(content().string(test));
	}

	@Test
	public void lombokDto_isReturn() throws Exception {

		String name = "test";
		int amount = 1000;

		mvc.perform(
				get("/test/dto").param("name", name)
						.param("amount", String.valueOf(amount)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.amount", is(amount)));

	}

}
