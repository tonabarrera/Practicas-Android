package edu.ipn.cecyt9.practica20multimedia;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.AsyncPlayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


//public class MainActivity extends Activity implements
//        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener,
//        MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {
//
//    private MediaPlayer mediaPlayer;
//    private SurfaceView surfaceView;
//    private SurfaceHolder surfaceHolder;
//    private EditText editText;
//    private ImageButton bPlay, bPause, bStop, bLog;
//    private TextView logTextView;
//    private boolean pause;
//    private String path;
//    private int savePos = 0;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(R.layout.activity_main);
//        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(this);
//        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        editText = (EditText) findViewById(R.id.path);
//        editText.setText(
//                "http://coatl.cecyt9.ipn.mx/eoropeza/avisos/video.mp4");
//        logTextView = (TextView) findViewById(R.id.Log);
//        bPlay = (ImageButton) findViewById(R.id.play);
//        bPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                if (mediaPlayer != null)
//                {
//                    if (pause) {
//                        mediaPlayer.start();
//                    } else {
//                        playVideo();
//                    }
//                }
//            }
//        });
//        bPause = (ImageButton) findViewById(R.id.pause);
//        bPause.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view)
//            {
//                if (mediaPlayer != null)
//                {
//                    pause = true;
//                    mediaPlayer.pause();
//                }
//            }
//        });
//        bStop = (ImageButton) findViewById(R.id.stop);
//        bStop.setOnClickListener(new    View.OnClickListener() {
//            public void onClick(View view) {
//                if (mediaPlayer != null) {
//                    pause = false;
//                    mediaPlayer.stop();
//                }
//            }
//        });
//        bLog = (ImageButton) findViewById(R.id.logButton);
//        bLog.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                if (logTextView.getVisibility()==TextView.VISIBLE) {
//                    logTextView.setVisibility(TextView.INVISIBLE);
//                } else {
//                    logTextView.setVisibility(TextView.VISIBLE);
//                }
//            }
//        });
//        log("");
//    }
//
//    private void playVideo() {
//        try {
//            pause = false;
//            path = editText.getText().toString();
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setDataSource(path);
//            mediaPlayer.setDisplay(surfaceHolder);
//            mediaPlayer.prepare();
//            //mMediaPlayer.prepareAsync(); Para streaming
//            mediaPlayer.setOnBufferingUpdateListener(this);
//            mediaPlayer.setOnCompletionListener(this);
//            mediaPlayer.setOnPreparedListener(this);
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            mediaPlayer.seekTo(savePos);
//        } catch (Exception e) {
//            log("ERROR: " + e.getMessage());
//        }
//    }
//
//    public void onBufferingUpdate(MediaPlayer arg0, int percent) {
//        log("onBufferingUpdate percent:" + percent);
//    }
//
//    public void onCompletion(MediaPlayer arg0) {
//        log("onCompletion called");
//    }
//
//    public void onPrepared(MediaPlayer mediaplayer) {
//        log("onPrepared called");
//        int mVideoWidth = mediaPlayer.getVideoWidth();
//        int mVideoHeight = mediaPlayer.getVideoHeight();
//        if (mVideoWidth != 0 && mVideoHeight != 0) {
//            surfaceHolder.setFixedSize(mVideoWidth, mVideoHeight);
//            mediaPlayer.start();
//        }
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        log("surfaceCreated called");
//        playVideo();
//    }
//
//
//    public void surfaceChanged(SurfaceHolder surfaceholder,
//                               int i, int j, int k) {
//        log("surfaceChanged called");
//    }
//
//    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
//        log("surfaceDestroyed called");
//    }
//
//    @Override protected void onDestroy() {
//        super.onDestroy();
//        if (mediaPlayer != null) {
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//    }
//
//    @Override public void onPause() {
//        super.onPause();
//        if (mediaPlayer != null & !pause) {
//            mediaPlayer.pause();
//        }
//    }
//    @Override public void onResume() {
//        super.onResume();
//        if (mediaPlayer != null & !pause) {
//            mediaPlayer.start();
//        }
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle guardarEstado) {
//        super.onSaveInstanceState(guardarEstado);
//        if (mediaPlayer != null) {
//            int pos = mediaPlayer.getCurrentPosition();
//            guardarEstado.putString("ruta", path);
//            guardarEstado.putInt("posicion", pos);
//        }
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle recEstado) {
//        super.onRestoreInstanceState(recEstado);
//        if (recEstado != null) {
//            path = recEstado.getString("ruta");
//            savePos = recEstado.getInt("posicion");
//        }
//    }
//
//    private void log(String s) {
//        logTextView.append(s + "\n");
//    }
//}



public class MainActivity extends Activity {
    private VideoView mVideoView;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView =(VideoView)findViewById(R.id.surfaceView);

        Uri path = Uri.parse("android.resource://" + getPackageName() + "/raw/" + R.raw.video);
        Log.d(TAG, String.valueOf(path));
        mVideoView.setVideoURI(path);
        //permitimos que el usuario pueda controlar la reproducción del vídeo mediante el objeto MediaController.
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
    }
}
