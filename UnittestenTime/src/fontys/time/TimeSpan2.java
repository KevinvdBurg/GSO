
package fontys.time;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin van der Burg
 * 
 * LET OP: De klasse TimeSpan bevat enkele fouten.
 * 
 */
public class TimeSpan2 implements ITimeSpan {
    /* class invariant: 
     * A stretch of time with a begin time and end time.
     * The end time is always later then the begin time; the length of the time span is
     * always positive
     * 
     */
    private ITime bt, et;
    
    /**
     * 
     * @param bt must be earlier than et 
     * @param duration 
     */
    public TimeSpan2(ITime bt, long duration){
        if(duration <= 0){
            try {
                throw new Exception("duration: " + duration + " is invalid, duration must be greater than 0");
            } catch (Exception ex) {
                Logger.getLogger(TimeSpan2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.bt = bt;
        this.et = bt.plus(Integer.valueOf(String.valueOf(duration)));
    }
    
    @Override
    public ITime getBeginTime(){
        return this.bt;
    }
    
    @Override
    public ITime getEndTime(){
        return this.et;
    }
    
    @Override
    public int length(){
        return this.et.difference(this.bt);
    }
    
    @Override
    public void setBeginTime(ITime bt){
        if(bt.compareTo(this.et) >= 0){
            try {
                throw new Exception("beginTime: " + bt + "is invalid, beginTime must be smaller than " + this.et);
            } catch (Exception ex) {
                Logger.getLogger(TimeSpan2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.bt = bt;
    }
    
    @Override
    public void setEndTime(ITime et){
        if(et.compareTo(this.bt) <= 0){
            try {
                throw new Exception("endTime: " + et + " is invalid, endTime must be greater than beginTime: " + this.bt);
            } catch (Exception ex) {
                Logger.getLogger(TimeSpan2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.et = et;
    }
    
    
    @Override
    public void move(int minutes){
        this.bt = this.bt.plus(minutes);
        this.et = this.et.plus(minutes);
    }
    
    @Override
    public void changeLengthWith(int minutes){
        if(this.bt.compareTo(this.et.plus(minutes)) >= 0){
            try {
                throw new Exception("minutes: " + minutes + " is invalid, beginTime: " + this.bt + " must be smaller than endTime: " + this.et);
            } catch (Exception ex) {
                Logger.getLogger(TimeSpan2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.et = this.et.plus(minutes);
    }
    
    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
    }
    
    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || et.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));
    }
    
    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));
    }

    @Override
    public boolean equals(Object object){ 
        boolean result = false;
        
        if(object != null){
            if(this.getClass() == object.getClass()){
                ITimeSpan timeSpan = (ITimeSpan)object;
            
                if(this.bt.toString().equals(timeSpan.getBeginTime().toString())){
                    if(this.et.toString().equals(timeSpan.getEndTime().toString())){
                     result = true;   
                    }
                } else{
                    System.out.print("\n");
                    System.out.print("--------------------------------");
                    System.out.print("\n");
                    System.out.print(this.bt + "\n" + timeSpan.getBeginTime());
                    System.out.print("\n");
                    System.out.print(this.et + "\n" + timeSpan.getEndTime());
                    System.out.print("\n");
                    System.out.print("--------------------------------");
                    System.out.print("\n");
                }   
            }
        }
        
        return result;
    }

    /*
    public TimeSpan2(ITime bt, long duration) {
        ITime et = bt.plus(Integer.valueOf(String.valueOf(duration)));
        //ITime et = bt.plus(duration.intValue());
        
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time " + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.et = et;
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return et;
    }

    @Override
    public int length() {
        return et.difference(bt);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (beginTime.compareTo(et) >= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.compareTo(bt) <= 0) {
            throw new IllegalArgumentException("end time "
                    + et + " must be later then begin time " + bt);
        }

        bt = endTime;
    }

    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = bt.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        
        et = et.plus(minutes);
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || et.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));

    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));
    }
    
    /**
     *
     * @param object
     * @return
     */
    /*
    @Override
    public boolean equals(Object object){ 
        boolean result = false;
        
        if(object != null){
            if(this.getClass() == object.getClass()){
                ITimeSpan timeSpan = (ITimeSpan)object;
            
                if(this.bt.toString().equals(timeSpan.getBeginTime().toString())){
                    if(this.et.toString().equals(timeSpan.getEndTime().toString())){
                     result = true;   
                    }
                } else{
                    System.out.print("\n");
                    System.out.print("--------------------------------");
                    System.out.print("\n");
                    System.out.print(this.bt + "\n" + timeSpan.getBeginTime());
                    System.out.print("\n");
                    System.out.print(this.et + "\n" + timeSpan.getEndTime());
                    System.out.print("\n");
                    System.out.print("--------------------------------");
                    System.out.print("\n");
                }   
            }
        }
        
        return result;
    }
    */
}
