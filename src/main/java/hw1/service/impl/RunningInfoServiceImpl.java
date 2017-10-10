package hw1.service.impl;

import hw1.domain.RunningInfoRepository;
import hw1.domain.RunningInformation;
import hw1.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RunningInfoServiceImpl implements RunningInfoService{


    private RunningInfoRepository runningInfoRepository;
    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository runningInfoRepository){
        this.runningInfoRepository=runningInfoRepository;
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId,Pageable pageable) {
        return runningInfoRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return runningInfoRepository.findAllByOrderByHeartRateDesc(pageable);
    }

    @Override

    public List<RunningInformation> saveRunningInformations(List<RunningInformation> RunningInformations) {
        return runningInfoRepository.save(RunningInformations);
    }

    @Override
    @Transactional
    public void deleteByrunningId(String runningId) {
         runningInfoRepository.deleteByrunningId(runningId);
    }
}
