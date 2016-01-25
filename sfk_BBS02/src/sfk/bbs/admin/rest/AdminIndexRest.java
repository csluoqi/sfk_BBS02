package sfk.bbs.admin.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sfk.bbs.admin.action.AdminIndexAction;
import sfk.bbs.admin.service.AdminIndexService;


@RestController
@RequestMapping("/rest")
public class AdminIndexRest
{
    private static Logger log = Logger.getLogger(AdminIndexAction.class);
    @Autowired
    private AdminIndexService adminIndexService; 
    
    @RequestMapping(value="/fatherModule/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        log.info("Delete Successfully!");
        //if()
        return new ResponseEntity<Boolean>(adminIndexService.deleteFatherModule(id),HttpStatus.OK);
    }

}
