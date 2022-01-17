package com.example.fourthworksheet.repositories;

import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DebitRepositories extends JpaRepository<DebitEntity,Long> {

    public List<DebitEntity> findAllByDebitDateBetween(Date startDate,Date endDate);
    @Query("select d from DebitEntity d where d.user.userId=?1 and d.totalDebitAmount>0")
    public List<DebitEntity> findUserDebits(Long userId);

    @Query("select d from DebitEntity d where d.user.userId=?1 and d.totalDebitAmount>0 and d.maturityDate<current_timestamp and d.isCollected=false")
    public List<DebitEntity>findUserLatedDebits(Long userId);
    @Query("select SUM (d.totalDebitAmount),d.user.userId from DebitEntity d where d.user.userId=?1 and d.totalDebitAmount>0 and d.maturityDate<CURRENT_TIMESTAMP and d.isCollected=false group by d.user.userId")
    public List<DebitEntity> findUserTotalDebits(Long userId);
    //public List<DebitEntity> findAllByUserAndCollected(UserEntity userEntity,boolean isCollected);
}
