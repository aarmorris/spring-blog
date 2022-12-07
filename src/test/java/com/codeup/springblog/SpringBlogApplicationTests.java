package com.codeup.springblog;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Users;
import com.codeup.springblog.repositories.UserRepository;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBlogApplication.class)
@AutoConfigureMockMvc
 public class SpringBlogApplicationTests {
    private Users testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    UserRepository adsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {

        testUser = userDao.findByUsername("testUser");

        // Creates the test user if not exists
        if(testUser == null){
            Users newUser = new Users();
            newUser.setUsername("testUser");
            newUser.setPassword(passwordEncoder.encode("pass"));
            newUser.setEmail("testUser@codeup.com");
            testUser = userDao.save(newUser);
        }

        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
        httpSession = this.mvc.perform(post("/login").with(csrf())
                        .param("username", "testUser")
                        .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/posts"))
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Test
    public void testEditAd() throws Exception {
        // Gets the first Ad for tests purposes
        Users user = userDao.findAll().get(0);

        // Makes a Post request to /ads/{id}/edit and expect a redirection to the Ad show page
//        this.mvc.perform(
//                        post("/ads/" + existingAd.getId() + "/edit").with(csrf())
//                                .session((MockHttpSession) httpSession)
//                                .param("title", "edited title")
//                                .param("description", "edited description"))
//                .andExpect(status().is3xxRedirection());
//
//        // Makes a GET request to /ads/{id} and expect a redirection to the Ad show page
//        this.mvc.perform(get("/ads/" + existingAd.getId()))
//                .andExpect(status().isOk())
//                // Test the dynamic content of the page
//                .andExpect(content().string(containsString("edited title")))
//                .andExpect(content().string(containsString("edited description")));
    }
}
