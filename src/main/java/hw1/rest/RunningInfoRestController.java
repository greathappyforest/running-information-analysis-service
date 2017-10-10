package hw1.rest;

import hw1.domain.RunningInformation;
import hw1.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RunningInfoRestController {
    private RunningInfoService runningInfoService;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 2;

    @Autowired
    public RunningInfoRestController(RunningInfoService runningInfoService){
        this.runningInfoService=runningInfoService;
    }
    //POST
    @RequestMapping(value = "/runninginfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations){
        this.runningInfoService.saveRunningInformations(runningInformations);
    }


    //GET by id
    @RequestMapping(value = "/runninginfo/{runningId}",method = RequestMethod.GET)
    public  Page<RunningInformation> findByRunningId(@PathVariable String runningId,  @PageableDefault(page = DEFAULT_PAGE_NUMBER, size = DEFAULT_PAGE_SIZE) Pageable pageable){
        return this.runningInfoService.findByRunningId(runningId, pageable);
    }

    //GET all

    @RequestMapping(value = "/runninginfo",method = RequestMethod.GET)
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(
            @PageableDefault(page = DEFAULT_PAGE_NUMBER, size = DEFAULT_PAGE_SIZE) Pageable pageable){
        return this.runningInfoService.findAllByOrderByHeartRateDesc( pageable);
    }

    //DELETE
    @RequestMapping(value= "/runninginfo/{runningId}",method= RequestMethod.DELETE)
    public void deleteByrunningId(@PathVariable String runningId){
         this.runningInfoService.deleteByrunningId(runningId);
    }




}
