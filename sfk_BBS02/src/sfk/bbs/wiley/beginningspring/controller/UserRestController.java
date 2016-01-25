package sfk.bbs.wiley.beginningspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sfk.bbs.wiley.beginningspring.domain.User;
import sfk.bbs.wiley.beginningspring.repository.UserRepository;

import java.util.List;

/**
 * Created by mertcaliskan
 * on 18/09/14.
 */
@RestController
@RequestMapping("/rest")
public class UserRestController
{

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method=RequestMethod.POST)
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public List<User> list() {
        System.out.println("users get");
        return userRepository.findAll();
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public User get(@PathVariable("id") int id) {
        return userRepository.find(id);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userRepository.update(id, user);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        userRepository.delete(id);
        System.out.println("123455");
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}