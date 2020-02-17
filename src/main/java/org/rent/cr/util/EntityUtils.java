package org.rent.cr.util;

import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class EntityUtils {
    //Copies properties from one object to another
    public void copyNonNullProperties(Object source, Object destination){
        org.springframework.beans.BeanUtils.copyProperties(source, destination,
                getNullPropertyNames(source));
        System.out.println();
    }

    //Returns an array of null properties of an object
    private String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        emptyNames.add("id"); //always ignore id
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

    //if one of time is null then return false - 'periods not cross'
    public boolean periodsIsCrossed(LocalDateTime startOfFirst , LocalDateTime endOfFirst, LocalDateTime startOfSecond, LocalDateTime endOfSecond) {
        if (startOfFirst == null || endOfFirst == null || startOfSecond == null || endOfSecond == null) {
            return false;
        }
        if (startOfSecond.isAfter(endOfFirst)) {
            return false;
        } else if (endOfSecond.isBefore(startOfFirst)) {
            return false;
        } else {
            return true;
        }
    }

    //if one of time is null then return false - 'period not cross current time'
    public boolean periodIsCrossCurrentTime(LocalDateTime start ,LocalDateTime end) {
        if (start == null || end == null) {
            return false;
        }
        if (start.isBefore(LocalDateTime.now()) && end.isAfter(LocalDateTime.now())) {
            return false;
        } else {
            return true;
        }
    }
}
