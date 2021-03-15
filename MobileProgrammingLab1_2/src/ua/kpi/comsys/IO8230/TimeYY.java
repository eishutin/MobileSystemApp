package ua.kpi.comsys.IO8230;

public class TimeYY {

    public int hour;
    public int minute;
    public int second;
    public String hourFormat;

    public TimeYY() {
        hour = 0;
        minute = 0;
        second = 0;
        hourFormat = "AM";
    }

    public TimeYY(int hour, int minute, int second) throws Exception{
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
            hourFormat = (hour < 13) ? "AM" : "PM";
        } else {
            throw new Exception("Incorrect hour" + hour);
        }

        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            throw new Exception("Incorrect minute" + minute);
        }

        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            throw new Exception("Incorrect second" + second);
        }

    }

    public String get(){
        return (hour > 13)
                ? new String(hour - 12 + ":" + minute + ":" + second + " " + hourFormat)
                : new String(hour + ":" + minute + ":" + second + " " + hourFormat);
    }

    public TimeYY add(TimeYY timeToAdd) throws Exception {
        int resultSeconds;
        int resultMinutes = 0;
        int resultHours = 0;

        if (this.second + timeToAdd.second > 59){
            resultSeconds = (this.second + timeToAdd.second) - 60;
            resultMinutes++;
        } else{
            resultSeconds = this.second + timeToAdd.second;
        }

        if (this.minute + timeToAdd.minute + resultMinutes > 59){
            resultMinutes += (this.minute + timeToAdd.minute) - 60;
            resultHours++;
        } else{
            resultMinutes += this.minute + timeToAdd.minute;
        }

        if (this.hour + timeToAdd.hour + resultHours > 23){
            resultHours += (this.hour + timeToAdd.hour) - 24;
        } else{
            resultHours += this.hour + timeToAdd.hour;
        }

        return new TimeYY(resultHours, resultMinutes, resultSeconds);
    }

    public TimeYY substract(TimeYY timeToSub) throws Exception{
        int resultSeconds;
        int resultMinutes = 0;
        int resultHours = 0;

        if (this.second - timeToSub.second < 0){
            resultSeconds = (this.second - timeToSub.second) + 60;
            resultMinutes--;
        } else{
            resultSeconds = this.second - timeToSub.second;
        }

        if (this.minute - timeToSub.minute + resultMinutes < 0){
            resultMinutes += (this.minute - timeToSub.minute) + 60;
            resultHours--;
        } else{
            resultMinutes += this.minute - timeToSub.minute;
        }

        if (this.hour - timeToSub.hour + resultHours < 0){
            resultHours += (this.hour - timeToSub.hour) + 24;
        } else{
            resultHours += this.hour - timeToSub.hour;
        }

        return new TimeYY(resultHours, resultMinutes, resultSeconds);
    }

}
