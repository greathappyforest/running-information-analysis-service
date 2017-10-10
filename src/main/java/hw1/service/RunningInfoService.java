package hw1.service;

import hw1.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInfoService {
    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);
    List<RunningInformation> saveRunningInformations(List<RunningInformation> RunningInformations);
    void deleteByrunningId(String runningId);
    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);
}
