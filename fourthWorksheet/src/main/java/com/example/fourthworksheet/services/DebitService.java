package com.example.fourthworksheet.services;

import com.example.fourthworksheet.constants.DefaultVariable;
import com.example.fourthworksheet.dao.DebitDao;
import com.example.fourthworksheet.dto.UserDebitDto;
import com.example.fourthworksheet.entity.DebitEntity;
import com.example.fourthworksheet.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class DebitService {

    @Autowired
    private DebitDao debitDao;


    public List<DebitEntity> findall()
    {
        return  debitDao.findAll();
    }

    public DebitEntity findById(Long id)
    {
        return debitDao.findById(id);
    }

    public DebitEntity save(DebitEntity debitEntity)
    {
        return debitDao.save(debitEntity);
    }

    public List<DebitEntity> findUserDebitsById(Long userId){return debitDao.findUserDebitsById(userId);}

    public List<DebitEntity> findUserDebits(UserEntity userEntity,boolean isCollected){return debitDao.findUserDebits(userEntity,isCollected);}

    public List<DebitEntity>findDebitsByStartDateAndEndDate(Date startDate, Date endDate)
    {
        return debitDao.findDebitsByStartDateAndEndDate(startDate,endDate);
    }
    public List<DebitEntity>findUserLatedDebits(Long userId)
    {
        return debitDao.findUserLatedDebits(userId);
    }

    public List<DebitEntity> findUserTotalDebits(Long userId)
    {
        return debitDao.findUserTotalDebits(userId);
    }

    public List<UserDebitDto> calculateDelayDebitAmount(List<UserDebitDto> userDebitDto)
    {
        for (UserDebitDto userDbt:userDebitDto)
        {
            DefaultVariable defaultVariable= new DefaultVariable();
            Date date =new Date( System.currentTimeMillis());
            BigDecimal debitAmount = BigDecimal.ZERO;
            if(date.before(defaultVariable.refdate))
            {
                debitAmount=(userDbt.getTotalDebitAmount().multiply(defaultVariable.dailyLatedDebitAmount));
                userDbt.setTotalLatedDebitamount(debitAmount);
            }else if(date.after(defaultVariable.refdate)) {
                debitAmount=(userDbt.getTotalDebitAmount().multiply(defaultVariable.dailyLatedDebitAfterRefrenceDate));
                userDbt.setTotalLatedDebitamount(debitAmount);
            }
            else
                userDbt.setTotalLatedDebitamount(BigDecimal.valueOf(0.00));
        }
        return userDebitDto;
    }


}
