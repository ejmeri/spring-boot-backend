package com.curse.business.payments.control;

import java.util.Date;
import java.util.Calendar;

import com.curse.business.payments.entity.BillPayment;

import org.springframework.stereotype.Service;

@Service
public class BillPaymentService {

    public void setSevenDaysToDueDate(BillPayment billPayment, Date createdAtOrder) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(createdAtOrder);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        billPayment.setDueDate(cal.getTime());
    }
}