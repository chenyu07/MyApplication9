package cn.edu.sdwu.android02.home.sn;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MediaService extends Service {
    private MediaPlayer mediaPlayer;
    private MyBinder myBinder;
    public MediaService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.wav);
        mediaPlayer.setLooping(false);
        myBinder=new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        //从Intent中获取用户所需要的的操作，然后进一步处理

        String state=intent.getStringExtra("PlayerState");
        if(state!=null){
            if(state.equals("START")){
                start();
            }
            if(state.equals("PAUSE")){
                pause();
            }
            if(state.equals("STOP")){
                stop();
            }
            if(state.equals("STOPSERVICE")){
                stopSelf();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
    public void start(){
        mediaPlayer.start();
    }
    public void pause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    public void stop(){
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
        } catch (Exception e) {
            Log.e(MediaService.class.toString(),e.toString());
        }
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();//释放资源
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public MediaService getMediaService(){
            return MediaService.this;
        }
    }
}
