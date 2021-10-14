package com.example.befit_healthandfitnessapplication;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link arm_beginner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class arm_beginner extends Fragment {

    public static final long START_TIME_IN_MILIS1 = 30000;
    public static final long START_TIME_IN_MILIS2 = 40000;
    public static final long START_TIME_IN_MILIS3 = 30000;
    public static final long START_TIME_IN_MILIS4 = 300000;
    public static final long START_TIME_IN_MILIS5 = 30000;
    public static final long START_TIME_IN_MILIS6 = 240000;
    public static final long START_TIME_IN_MILIS7 = 30000;
    public static final long START_TIME_IN_MILIS8 = 300000;
    public static final long START_TIME_IN_MILIS9 = 120000;
    public static final long START_TIME_IN_MILIS10 = 120000;


    public CountDownTimer countDownTimer;
    public  boolean mTimerRunning;

    public long mTimeLeftInMilis1 = START_TIME_IN_MILIS1;
    public long mTimeLeftInMilis2 = START_TIME_IN_MILIS2;
    public long mTimeLeftInMilis3 = START_TIME_IN_MILIS3;
    public long mTimeLeftInMilis4 = START_TIME_IN_MILIS4;
    public long mTimeLeftInMilis5 = START_TIME_IN_MILIS5;
    public long mTimeLeftInMilis6 = START_TIME_IN_MILIS6;
    public long mTimeLeftInMilis7 = START_TIME_IN_MILIS7;
    public long mTimeLeftInMilis8 = START_TIME_IN_MILIS8;
    public long mTimeLeftInMilis9 = START_TIME_IN_MILIS9;
    public long mTimeLeftInMilis10 = START_TIME_IN_MILIS10;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public arm_beginner() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment arm_beginner.
     */
    // TODO: Rename and change types and number of parameters
    public static arm_beginner newInstance(String param1, String param2) {
        arm_beginner fragment = new arm_beginner();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arm_beginner, container, false);
        ListView arm_beginner_exercises_lv = (ListView) view.findViewById(R.id.arm_beginner_exercises_lv);

        String[] arm_beginner_exercise_names = new String[] {
                "SIDE ARM RAISE \n 00:30",
                "TRICEPS DIPS \n x10",
                "ARM CIRCLE CLOCKWISE \n 00:30",
                "DIAMOND PUSH-UPS \n x6",
                "JUMPING JACKS \n 00:30",
                "DIAGONAL PLANK \n x10",
                "PUNCHES \n 00:30",
                "PUSH-UPS \n X10",
                "INCHWORMS \n X8",
                "WALL PUSH-UPS \n X12"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_view,R.id.textView1234,arm_beginner_exercise_names);
        arm_beginner_exercises_lv.setAdapter(adapter);

        arm_beginner_exercises_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String exercisename = arm_beginner_exercise_names[position];
                if(exercisename == "SIDE ARM RAISE \n 00:30")
                {
                    side_arm_raises();
                }
                else if(exercisename == "TRICEPS DIPS \n x10")
                {
                    tricep_dips();
                }
                else if(exercisename == "ARM CIRCLE CLOCKWISE \n 00:30")
                {
                    arm_circle();
                }
                else if(exercisename == "DIAMOND PUSH-UPS \n x6")
                {
                    diamond_pushups();
                }
                else if(exercisename == "JUMPING JACKS \n 00:30")
                {
                    jumping_jacks();
                }
                else if(exercisename == "DIAGONAL PLANK \n x10")
                {
                    diagonal_plank();
                }
                else if(exercisename == "PUNCHES \n 00:30")
                {
                    punches();
                }
                else if(exercisename == "PUSH-UPS \n X10")
                {
                    pushups();
                }
                else if(exercisename == "INCHWORMS \n X8")
                {
                    inchworms();
                }
                else if(exercisename == "WALL PUSH-UPS \n X12")
                {
                    wallpushups();
                }
            }
        });

        return view;
    }


    public void side_arm_raises() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("SIDE ARM RAISES");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634222167/videoplayback_oi6lnw.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis1,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis1 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis1 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis1 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                        mTimerRunning = false;
                        start.setText("Start");
                        cancel.setVisibility(View.INVISIBLE);
                        Toast.makeText(getActivity(), "'SIDE ARM RAISES' COMPLETED", Toast.LENGTH_LONG).show();
                        tricep_dips();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    public void tricep_dips() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("TRICEPS DIPS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232696/videoplayback_17_urkauy.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis2,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis2 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis2 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis2 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'TRICEPS DIPS' COMPLETED", Toast.LENGTH_LONG).show();
                            arm_circle();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }


    public void arm_circle() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("ARM CIRCLES");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634230956/videoplayback_2_zdtsxg.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis3,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis3 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis3 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis3 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'ARM CIRCLES' COMPLETED", Toast.LENGTH_LONG).show();
                            diamond_pushups();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    public void diamond_pushups() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("DIAMOND PUSH-UPS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232509/videoplayback_15_krgrpw.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis4,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis4 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis4 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis4 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'DIAMOND PUSH-UPS' COMPLETED", Toast.LENGTH_LONG).show();
                            jumping_jacks();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    public void jumping_jacks() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("JUMPING JACKS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232618/videoplayback_16_iqukfe.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis5,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis5 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis5 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis5 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'JUMPING JACKS' COMPLETED", Toast.LENGTH_LONG).show();
                            diagonal_plank();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    public void diagonal_plank() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("DIAGONAL PLANK");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634231747/videoplayback_5_nomlhv.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis6,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis6 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis6 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis6 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'DIAGONAL PLANK' COMPLETED", Toast.LENGTH_LONG).show();
                            wallpushups();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    private void wallpushups() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("WALL PUSH-UPS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232355/videoplayback_12_gxul9r.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis7,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis7 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis7 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis7 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'WALL PUSH-UPS' COMPLETED", Toast.LENGTH_LONG).show();
                            inchworms();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    private void inchworms() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("INCHWORMS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232158/videoplayback_10_nxgbhs.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis8,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis8 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis8 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis8 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'INCHWORMS' COMPLETED", Toast.LENGTH_LONG).show();
                            pushups();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    private void pushups() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("PUSH-UPS");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232291/videoplayback_11_be0p8s.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis9,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis9 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis9 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis9 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'PUSH-UPS' COMPLETED", Toast.LENGTH_LONG).show();
                            punches();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    private void punches() {
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.dialog);
        VideoView videoView =(VideoView) dialog.findViewById(R.id.videoview1);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        Button start = (Button) dialog.findViewById(R.id.start);
        TextView exercisename_tv= (TextView) dialog.findViewById(R.id.exercisename_tv);

        exercisename_tv.setText("PUNCHES");
        MediaController mediaController= new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        String videoUrl = "https://res.cloudinary.com/dne84tqma/video/upload/v1634232429/videoplayback_14_gxxuid.mp4";
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView timer_tv = (TextView) dialog.findViewById(R.id.timer_tv);
                if(mTimerRunning)
                {
                    countDownTimer.cancel();
                    mTimerRunning = false;
                    start.setText("Start");
                    cancel.setVisibility(View.VISIBLE);
                }
                else
                {
                    countDownTimer = new CountDownTimer(mTimeLeftInMilis10,1000) {
                        @Override
                        public void onTick(long milisUntilFinished) {
                            mTimeLeftInMilis10 = milisUntilFinished;
                            int minutes = (int) (mTimeLeftInMilis10 / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMilis10 / 1000) % 60;
                            String timeLeftFormattted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                            timer_tv.setText(timeLeftFormattted);
                        }

                        @Override
                        public void onFinish() {
                            mTimerRunning = false;
                            start.setText("Start");
                            cancel.setVisibility(View.INVISIBLE);
                            Toast.makeText(getActivity(), "'PUNCHES' COMPLETED", Toast.LENGTH_LONG).show();
                        }
                    }.start();
                    mTimerRunning = true;
                    start.setText("pause");
                    cancel.setVisibility(view.INVISIBLE);
                }
            }
        });
        dialog.show();
    }

    private void pauseTimer() {
    }


}
