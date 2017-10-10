package hw1.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface RunningInfoRepository extends JpaRepository<RunningInformation,Long> {
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable );
    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);
    void deleteByrunningId(String runningId);
}
