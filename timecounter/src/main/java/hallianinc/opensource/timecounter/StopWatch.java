package hallianinc.opensource.timecounter;

import android.os.Handler;
import android.widget.TextView;

public class StopWatch {
    TextView textView;
    Handler handler = new Handler();
    boolean isRunning;// to keep track of the state of handler to avoid creating multiple threads.
    private int time = 0;

    StopWatch(TextView textView){// this textview would be updated by the stop-watch
        this.textView = textView;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private String convertTimeToText(int time){
        String timeString = time/600+":"+(time/10)%60+":"+time%10;
        return timeString;
    }
    public void start(){

        if(!isRunning) {
            time = 0;
            startTime();

        }
    }
    public void stop(){
        time = 0;
        textView.setText("0:0:0");
        handler.removeCallbacksAndMessages(null);
        isRunning = false;
    }
    public void pause(){
        handler.removeCallbacksAndMessages(null);
        isRunning = false;
    }
    public void resume(){
        startTime();
        isRunning = true;
    }

    private void startTime(){
        if(!isRunning) {
            isRunning = true;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    time += 1;
                    textView.setText(convertTimeToText(time));
                    handler.postDelayed(this, 100);
                }
            });
        }
    }
}
